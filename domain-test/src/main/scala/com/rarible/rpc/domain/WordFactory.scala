package com.rarible.rpc.domain

object WordFactory {
  def create(): Word = Word.apply(BinaryFactory.createByteArray(32))
}
