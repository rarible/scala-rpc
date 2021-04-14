package com.rarible.blockchain.poller.tries

import com.rarible.blockchain.poller.Sleeper

import scala.util.Try

class TrySleeper extends Sleeper[Try] {
  def sleep(sleep: Long): Try[Unit] = Try {
    Thread.sleep(sleep)
  }
}
