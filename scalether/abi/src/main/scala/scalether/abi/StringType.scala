package scalether.abi

import java.nio.charset.StandardCharsets

import com.rarible.rpc.domain.{Binary, Bytes}

object StringType extends Type[String] {
  def string = "string"

  override def size: Option[Int] = None

  def encode(value: String): Binary = {
    val bytes = value.getBytes(StandardCharsets.UTF_8)
    BytesType.encode(bytes)
  }

  def decode(data: Bytes, offset: Int): Decoded[String] = {
    val decoded = BytesType.decode(data, offset)
    Decoded(new String(decoded.value.filter(it => it != 0), StandardCharsets.UTF_8), decoded.offset)
  }
}
