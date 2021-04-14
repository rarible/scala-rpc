package com.rarible.cats

object implicits {
  implicit lazy val tryInstance: TryInstance = new TryInstance

  implicit lazy val idInstance: IdInstance = new IdInstance
}
