package com.rarible.blockchain.common

import java.math.BigInteger

import scala.language.higherKinds

trait ListenService[F[_]] {
  def check(blockNumber: BigInteger): F[Unit]
}
