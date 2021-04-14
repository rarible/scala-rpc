package com.rarible.blockchain.block

import java.math.BigInteger

import com.rarible.blockchain.MonoBlockchain
import com.rarible.blockchain.state.{MonoState, MonoStateAdapter}
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono

class MonoBlockListenService(blockchain: MonoBlockchain, listener: MonoBlockListener, state: MonoState[BigInteger]) {
  private val scala = new BlockListenService[Mono](blockchain, new MonoBlockListenerAdapter(listener), new MonoStateAdapter[BigInteger](state))

  def check(): Mono[BigInteger] =
    scala.check()
}
