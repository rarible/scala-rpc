package com.rarible.blockchain.transfer

import java.math.BigInteger

import cats.implicits._
import com.rarible.blockchain.{BalanceChange, Blockchain, Transaction}
import com.rarible.blockchain.common.AbstractListenService
import com.rarible.blockchain.poller.Notifier
import com.rarible.blockchain.state.State
import com.rarible.cats.MonadThrowable

class TransferListenService[F[_]](blockchain: Blockchain[F], confidence: Int, listener: TransferListener[F], state: State[BigInteger, F])
                                 (implicit m: MonadThrowable[F], n: Notifier[F])
  extends AbstractListenService[F](confidence, state) {

  def fetchAndNotify(latestBlock: BigInteger)(block: BigInteger): F[Unit] =
    blockchain.getTransactionsByBlock(block).flatMap(notifyListenerAboutTransfers(latestBlock, block))

  private def notifyListenerAboutTransfers(latestBlock: BigInteger, block: BigInteger)(transactions: List[Transaction]): F[Unit] = {
    n.notify(transactions)(notifyTransaction(latestBlock, block))
  }

  private def notifyTransaction(latestBlock: BigInteger, block: BigInteger)(tx: Transaction): F[Unit] = {
    val confirmations = latestBlock.subtract(block).intValue() + 1
    n.notify(tx.outputs.zipWithIndex)(notifyTransactionOutput(tx, confirmations, TransferDirection.IN))
  }

  private def notifyTransactionOutput(transaction: Transaction, confirmations: Int, direction: TransferDirection)(pair: (BalanceChange, Int)): F[Unit] = {
    val (change, idx) = pair
    listener.onTransfer(Transfer(transaction.id, idx, direction, change.address, change.value), confirmations, confirmations >= confidence)
  }
}