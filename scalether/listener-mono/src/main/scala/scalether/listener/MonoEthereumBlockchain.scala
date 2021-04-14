package scalether.listener

import com.rarible.blockchain.MonoBlockchain
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono
import scalether.core.{MonoEthereum, MonoParity}

class MonoEthereumBlockchain(ethereum: MonoEthereum, parity: MonoParity)
  extends EthereumBlockchain[Mono](ethereum, parity) with MonoBlockchain {

}
