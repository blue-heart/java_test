package com.bittech;

public class Message<T  > {
    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    private T message;
}
