package scalether.transaction

import java.math.BigInteger

import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono

class MonoValGasPriceProvider(value: BigInteger) extends ValGasPriceProvider[Mono](value) with MonoGasPriceProvider
