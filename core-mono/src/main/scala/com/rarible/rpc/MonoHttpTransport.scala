package com.rarible.rpc

import reactor.core.publisher.Mono

trait MonoHttpTransport extends HttpTransport[Mono] {
  def get[T: Manifest](url: String): Mono[T]
}
