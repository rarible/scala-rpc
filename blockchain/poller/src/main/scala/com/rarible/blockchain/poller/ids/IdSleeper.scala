package com.rarible.blockchain.poller.ids

import cats.Id
import com.rarible.blockchain.poller.Sleeper

class IdSleeper extends Sleeper[Id] {
  def sleep(sleep: Long): Unit =
    Thread.sleep(sleep)
}
