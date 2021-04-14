package com.rarible.bitcoin.rpc

import com.rarible.bitcoin.rpc.core.{MonoBitcoind, MonoRestBitcoind}
import com.rarible.rpc.mono.WebClientTransport

trait IntegrationSpec {
  val transport: WebClientTransport = WebClientTransport.createWithBasicAuth("http://btc:8332", "user", "pass")
  val bitcoind = new MonoBitcoind(transport)
  val restBitcoind = new MonoRestBitcoind(transport)
}
