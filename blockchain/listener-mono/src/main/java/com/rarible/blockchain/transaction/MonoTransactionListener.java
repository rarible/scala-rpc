package com.rarible.blockchain.transaction;

import com.rarible.rpc.domain.Bytes;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

public interface MonoTransactionListener {
    Mono<Void> onTransaction(Bytes transactionHash, BigInteger blockNumber, int confirmations, boolean confirmed);
}
