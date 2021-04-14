package com.rarible.bitcoin.rpc.core

import com.rarible.bitcoin.rpc.domain.{Block, Transaction}
import com.rarible.rpc.MonoHttpTransport
import com.rarible.rpc.domain.Binary
import reactor.core.publisher.Mono

class MonoRestBitcoind(transport: MonoHttpTransport) extends RestBitcoind[Mono](transport) {
  override def getBlockSimple(hash: String): Mono[Block[Binary]] =
    super.getBlockSimple(hash)

  override def getBlockFull(hash: String): Mono[Block[Transaction]] =
    super.getBlockFull(hash)
}
