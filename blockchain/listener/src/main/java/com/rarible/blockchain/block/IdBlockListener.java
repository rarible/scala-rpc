package com.rarible.blockchain.block;

import java.math.BigInteger;

public interface IdBlockListener {
    void onBlock(BigInteger blockNumber);
}
