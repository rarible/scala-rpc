package com.rarible.blockchain.transfer

import java.math.BigInteger

import com.rarible.blockchain.MonoBlockchain
import com.rarible.blockchain.poller.mono.implicits._
import com.rarible.blockchain.state.{MonoState, MonoStateAdapter}
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono

class MonoTransferListenService(blockchain: MonoBlockchain, confidence: Int, listener: MonoTransferListener, state: MonoState[BigInteger]) {
  private val scala = new TransferListenService[Mono](blockchain, confidence, new MonoTransferListenerAdapter(listener), new MonoStateAdapter[BigInteger](state))

  def check(block: BigInteger): Mono[Void] =
    scala.check(block).`then`()
}
