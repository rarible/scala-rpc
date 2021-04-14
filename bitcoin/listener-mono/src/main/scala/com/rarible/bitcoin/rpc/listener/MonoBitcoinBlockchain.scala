package com.rarible.bitcoin.rpc.listener

import com.rarible.bitcoin.rpc.core.{MonoBitcoind, MonoRestBitcoind}
import com.rarible.blockchain.MonoBlockchain
import com.rarible.cats.mono.implicits._
import reactor.core.publisher.Mono

class MonoBitcoinBlockchain(bitcoind: MonoBitcoind, restBitcoind: MonoRestBitcoind)
  extends BitcoinBlockchain[Mono](bitcoind, restBitcoind) with MonoBlockchain {

}
