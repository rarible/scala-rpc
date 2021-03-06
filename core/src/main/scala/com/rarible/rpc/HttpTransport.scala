package com.rarible.rpc

import scala.language.higherKinds

trait HttpTransport[F[_]] {
  def get[T: Manifest](url: String): F[T]
}
