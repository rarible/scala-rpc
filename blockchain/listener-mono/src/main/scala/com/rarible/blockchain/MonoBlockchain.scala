package com.rarible.blockchain

import java.math.BigInteger

import com.rarible.rpc.domain.Bytes
import reactor.core.publisher.Mono

trait MonoBlockchain extends Blockchain[Mono] {
  override def blockNumber: Mono[BigInteger]

  override def getTransactionIdsByBlock(block: BigInteger): Mono[List[Bytes]]

  override def getTransactionsByBlock(block: BigInteger): Mono[List[Transaction]]
}
