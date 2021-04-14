package com.rarible.blockchain.poller.mono

import com.rarible.blockchain.poller.{Notifier, Poller}
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono

object implicits {
  implicit val monoSleeper: MonoSleeper = new MonoSleeper
  implicit val monoPoller: Poller[Mono] = new Poller[Mono](monoSleeper)
  implicit val monoNotifier: Notifier[Mono] = new MonoNotifier()
}
