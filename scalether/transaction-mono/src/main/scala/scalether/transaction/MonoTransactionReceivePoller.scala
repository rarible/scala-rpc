package scalether.transaction

import com.rarible.blockchain.poller.mono.implicits._
import com.rarible.rpc.domain.Word
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono
import scalether.core.MonoEthereum
import scalether.domain.response.Transaction

class MonoTransactionReceivePoller(ethereum: MonoEthereum) extends TransactionReceivePoller[Mono](ethereum) {
  override def receiveTransaction(txHash: Word): Mono[Transaction] = super.receiveTransaction(txHash)
}
