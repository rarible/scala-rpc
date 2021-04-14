package com.rarible.bitcoin.rpc.core

import java.math.BigInteger

import cats.implicits._
import com.rarible.bitcoin.rpc.domain.Transaction
import com.rarible.cats.MonadThrowable
import com.rarible.rpc.{RpcClient, RpcTransport}

class Bitcoind[F[_]](transport: RpcTransport[F])
                    (implicit me: MonadThrowable[F])
  extends RpcClient[F](transport) {

  def help(what: String*): F[String] =
    exec("help", what: _*)

  def getBlockCount: F[BigInteger] =
    exec("getblockcount")

  def getNewAddress: F[String] =
    exec("getnewaddress")

  def generate(amount: Int): F[List[String]] =
    exec("generate", amount)

  def sendToAddress(to: String, amount: Double): F[String] =
    exec("sendtoaddress", to, amount)

  def getRawTransaction(txid: String, verbose: Boolean = false): F[Transaction] =
    exec("getrawtransaction", txid, verbose)

  def importAddress(address: String, label: String = "", rescan: Boolean = false, p2sh: Boolean = false): F[Unit] =
    execOption[String]("importaddress", address, label, rescan, p2sh).map(_ => ())

  def getBlockHash(blockNumber: BigInteger): F[String] =
    exec("getblockhash", blockNumber)
}
