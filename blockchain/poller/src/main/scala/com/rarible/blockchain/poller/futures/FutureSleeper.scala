package com.rarible.blockchain.poller.futures

import java.util.concurrent.{Executors, TimeUnit}

import com.rarible.blockchain.poller.Sleeper

import scala.concurrent.{Future, Promise}

class FutureSleeper extends Sleeper[Future] {
  private val executor = Executors.newScheduledThreadPool(1)

  def sleep(sleep: Long): Future[Unit] = {
    val promise = Promise[Unit]()
    executor.schedule(new CompletePromiseRunnable(promise, ()), sleep, TimeUnit.MILLISECONDS)
    promise.future
  }
}
