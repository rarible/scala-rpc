package scalether.transaction

import com.rarible.blockchain.poller.mono.implicits._
import com.rarible.rpc.domain.Word
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono
import scalether.core.MonoEthereum
import scalether.domain.response.TransactionReceipt

class MonoTransactionPoller(ethereum: MonoEthereum) extends TransactionPoller[Mono](ethereum) {
  override def waitForTransaction(txHash: Mono[Word]): Mono[TransactionReceipt] =
    super.waitForTransaction(txHash)
}
