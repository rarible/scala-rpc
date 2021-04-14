package com.rarible.rpc

import com.rarible.rpc.domain.{Request, Response}

trait RpcTransport[F[_]] {
  def send[T: Manifest](request: Request): F[Response[T]]
}
