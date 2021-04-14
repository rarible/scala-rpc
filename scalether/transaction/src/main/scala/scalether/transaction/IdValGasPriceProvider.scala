package scalether.transaction

import java.math.BigInteger

import cats.Id
import com.rarible.cats.implicits._

class IdValGasPriceProvider(value: BigInteger) extends ValGasPriceProvider[Id](value) with IdGasPriceProvider
