package com.metao.dp.state.tcp;

public class Connection {
    private State state = State.CLOSED;

    public void open() {
        this.state = State.OPENED;
    }

    public void close() {
        this.state = State.CLOSED;
    }

    public boolean isOpen() {
        return this.state == State.OPENED;
    }

    public void send(final Packet packet) {
        System.out.printf("packet= %s sent.%n", packet.toString());
    }

    public State getState() {
        return state;
    }
}