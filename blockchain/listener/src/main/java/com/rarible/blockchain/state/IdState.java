package com.rarible.blockchain.state;

public interface IdState<T> {
    T get();
    void set(T value);
}
