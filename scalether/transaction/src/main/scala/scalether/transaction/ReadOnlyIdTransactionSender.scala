package scalether.transaction

import cats.Id
import com.rarible.cats.implicits._
import scalether.core.IdEthereum
import scalether.domain.Address

import scala.language.higherKinds

class ReadOnlyIdTransactionSender(override val ethereum: IdEthereum, from: Address)
  extends ReadOnlyTransactionSender[Id](ethereum, from) with IdTransactionSender {
}
