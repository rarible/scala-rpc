package com.rarible.blockchain.transfer;

public interface IdTransferListener {
    void onTransfer(Transfer transfer, int confirmations, boolean confirmed);
}
