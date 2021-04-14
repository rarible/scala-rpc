package com.rarible.blockchain.transaction

import java.math.BigInteger

import com.rarible.blockchain.MonoBlockchain
import com.rarible.blockchain.poller.mono.implicits._
import com.rarible.blockchain.state.{MonoState, MonoStateAdapter}
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono

class MonoTransactionListenService(blockchain: MonoBlockchain, confidence: Int, listener: MonoTransactionListener, state: MonoState[BigInteger]) {
  private val scala = new TransactionListenService[Mono](blockchain, confidence, new MonoTransactionListenerAdapter(listener), new MonoStateAdapter[BigInteger](state))

  def check(block: BigInteger): Mono[Void] =
    scala.check(block).`then`()
}
