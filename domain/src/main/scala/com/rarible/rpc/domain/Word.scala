package com.rarible.rpc.domain

import com.fasterxml.jackson.databind.annotation.{JsonDeserialize, JsonSerialize}
import com.rarible.rpc.domain.jackson.{WordDeserializer, WordSerializer}
import scalether.util.Hex

@JsonSerialize(using = classOf[WordSerializer])
@JsonDeserialize(using = classOf[WordDeserializer])
case class Word(bytes: Array[Byte]) extends Bytes {
  assert(bytes.length == 32)

  def toBinary: Binary = Binary(bytes)
}

object Word {
  def apply(hex: String): Word =
    Word(Hex.toBytes(hex))

  def apply(bytes: Bytes): Word =
    Word(bytes.bytes)
}
