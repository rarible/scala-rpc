package com.rarible.bitcoin.rpc.core

import com.rarible.bitcoin.rpc.domain.{Block, Transaction}
import com.rarible.rpc.HttpTransport
import com.rarible.rpc.domain.Binary

class RestBitcoind[F[_]](transport: HttpTransport[F]) {
  def getBlockSimple(hash: String): F[Block[Binary]] =
    transport.get(s"/rest/block/notxdetails/$hash.json")

  def getBlockFull(hash: String): F[Block[Transaction]] =
    transport.get(s"/rest/block/$hash.json")
}
