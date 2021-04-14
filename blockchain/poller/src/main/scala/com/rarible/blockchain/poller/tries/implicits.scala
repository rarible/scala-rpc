package com.rarible.blockchain.poller.tries

import cats.implicits._
import com.rarible.blockchain.poller.{Notifier, Poller}

import scala.util.Try

object implicits {
  implicit val trySleeper: TrySleeper = new TrySleeper
  implicit val tryPoller: Poller[Try] = new Poller[Try](trySleeper)
  implicit val tryNotifier: Notifier[Try] = new TryNotifier
}
