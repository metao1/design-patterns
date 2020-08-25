package com.metao.dp.state.tcp;

public interface TCPState {
    public void open();

    public void close();

    public void acknowledge(final long packetId);

    public void send(final Packet packet);
}