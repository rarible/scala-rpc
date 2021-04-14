package scalether.listener

import com.rarible.blockchain.MonoBlockchain
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono
import scalether.core.MonoEthereum

class MonoSimpleEthereumBlockchain(ethereum: MonoEthereum)
  extends SimpleEthereumBlockchain[Mono](ethereum) with MonoBlockchain {

}
