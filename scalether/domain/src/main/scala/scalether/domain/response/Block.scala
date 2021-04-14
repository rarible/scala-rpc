package scalether.domain.response

import java.math.BigInteger

import com.rarible.rpc.domain.{Binary, Bytes, Word}
import scalether.domain.Address

case class Block[T](number: BigInteger,
                    hash: Word,
                    parentHash: Word,
                    nonce: String,
                    sha3Uncles: String,
                    logsBloom: String,
                    transactionsRoot: String,
                    stateRoot: String,
                    miner: Address,
                    difficulty: BigInteger,
                    totalDifficulty: BigInteger,
                    extraData: Binary,
                    size: BigInteger,
                    gasLimit: BigInteger,
                    gasUsed: BigInteger,
                    transactions: List[T],
                    timestamp: BigInteger) extends com.rarible.rpc.domain.Block {

  override def getBlockNumber: BigInteger = number

  override def getBlockHash: Bytes = hash
}
