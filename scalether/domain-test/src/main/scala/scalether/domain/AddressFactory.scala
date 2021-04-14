package scalether.domain

import com.rarible.rpc.domain.BinaryFactory

object AddressFactory {
  def create() = Address(BinaryFactory.createByteArray(20))
}
