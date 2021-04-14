package com.rarible.bitcoin.rpc.domain

import java.math.BigInteger

import com.rarible.rpc.domain.{Binary, Bytes}

case class Block[+T](hash: Binary,
                     confirmations: Long,
                     strippedsize: Long,
                     size: Long,
                     weight: Long,
                     height: Long,
                     version: Long,
                     versionHex: String,
                     merkleroot: Binary,
                     tx: List[T],
                     time: Long,
                     mediantime: Long,
                     nonce: Long,
                     bits: Binary,
                     difficulty: Double,
                     chainwork: Binary,
                     previousblockhash: Binary,
                     nextblockhash: Binary) extends com.rarible.rpc.domain.Block {

  override def getBlockNumber: BigInteger = BigInteger.valueOf(height)

  override def getBlockHash: Bytes = hash
}
