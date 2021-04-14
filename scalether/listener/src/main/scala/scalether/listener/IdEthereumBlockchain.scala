package scalether.listener

import cats.Id
import com.rarible.blockchain.IdBlockchain
import com.rarible.cats.implicits._
import scalether.core.{IdEthereum, IdParity}

class IdEthereumBlockchain(ethereum: IdEthereum, parity: IdParity)
  extends EthereumBlockchain[Id](ethereum, parity) with IdBlockchain {

}
