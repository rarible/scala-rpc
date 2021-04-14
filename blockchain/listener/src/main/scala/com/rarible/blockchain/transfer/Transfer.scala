package com.rarible.blockchain.transfer

import java.math.BigInteger

case class Transfer(txId: String, index: Int, direction: TransferDirection, address: String, value: BigInteger)
