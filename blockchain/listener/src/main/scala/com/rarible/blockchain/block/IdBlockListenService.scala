package com.rarible.blockchain.block

import java.math.BigInteger

import cats.Id
import com.rarible.blockchain.IdBlockchain
import com.rarible.blockchain.state.{IdState, IdStateAdapter}
import com.rarible.cats.implicits._

class IdBlockListenService(blockchain: IdBlockchain, listener: IdBlockListener, state: IdState[BigInteger]) {
  private val scala = new BlockListenService[Id](blockchain, new IdBlockListenerAdapter(listener), new IdStateAdapter[BigInteger](state))

  def check(): BigInteger =
    scala.check()
}
