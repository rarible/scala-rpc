package scalether.abi

import java.nio.charset.StandardCharsets

import com.rarible.rpc.domain.{Binary, Bytes}
import org.slf4j.{Logger, LoggerFactory}
import scalether.abi.tuple.TupleType
import scalether.util.Hash

case class Signature[I, O](name: String, in: TupleType[I], out: TupleType[O]) {
  def id: Binary = {
    val bytes = toString.getBytes(StandardCharsets.US_ASCII)
    Binary(Hash.sha3(bytes)).slice(0, 4)
  }

  def encode(in: I): Binary =
    id ++ this.in.encode(in)

  def decode(out: Bytes): O =
    this.out.decode(out, 0).value

  override def toString: String = name + in.string
}

object Signature {
  val logger: Logger = LoggerFactory.getLogger(Signature.getClass)
}
