package scalether.transaction

import cats.Id
import com.rarible.blockchain.poller.ids.implicits._
import com.rarible.rpc.domain.Word
import com.rarible.cats.implicits._
import scalether.core.IdEthereum
import scalether.domain.response.TransactionReceipt

class IdTransactionPoller(ethereum: IdEthereum) extends TransactionPoller[Id](ethereum) {
  override def waitForTransaction(txHash: Word): TransactionReceipt =
    super.waitForTransaction(txHash)
}
