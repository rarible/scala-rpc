package com.rarible.blockchain.poller.tries

import com.rarible.blockchain.poller.Notifier

import scala.util.Try

class TryNotifier extends Notifier[Try] {
  override def notify[T](list: Seq[T])(f: T => Try[Unit]): Try[Unit] =
    list.foldLeft(Try())((monad, next) => monad.flatMap(_ => f(next)))
}
