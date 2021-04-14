package com.rarible.rpc

import java.util.concurrent.atomic.AtomicInteger

import cats.implicits._
import com.fasterxml.jackson.databind.JsonNode
import com.rarible.cats.MonadThrowable
import com.rarible.rpc.domain.{Request, Response}

import scala.language.higherKinds
import scala.reflect.Manifest

class RpcClient[F[_]](transport: RpcTransport[F])
                     (implicit me: MonadThrowable[F]) {

  def exec[T](method: String, params: Any*)
             (implicit mf: Manifest[T]): F[T] = {
    execOption[T](method, params: _*).flatMap {
      case Some(v) if v != null => me.pure(v)
      case Some(_) => me.raiseError(new RpcCodeException(s"no result provided, method: $method params: $params", domain.Error.default))
      case None => me.raiseError(new RpcCodeException(s"no result provided, method: $method params: $params", domain.Error.default))
    }
  }

  def execOption[T](method: String, params: Any*)
                   (implicit mf: Manifest[T]): F[Option[T]] = {
    transport.send[T](Request(RpcClient.id.incrementAndGet(), method, params: _*)).flatMap {
      response =>
        response.error match {
          case Some(r) => me.raiseError(new RpcCodeException(s"error caught. method: $method params: $params", r))
          case None =>
            response.result match {
              case Some(null) => me.pure(None)
              case other => me.pure(other)
            }
        }
    }
  }

  def executeRaw(request: Request): F[Response[JsonNode]] = {
    transport.send[JsonNode](request)
  }
}

object RpcClient {
  val id = new AtomicInteger()
}
