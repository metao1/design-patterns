package com.metao.dp.state.tcp;

public class TCPEstablish implements TCPState {
    private final Connection connection;

    public TCPEstablish(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void open() {
        this.connection.open();
        System.out.println("opens connection");
    }

    @Override
    public void close() {
        if (!this.connection.isOpen()) {
            this.connection.close();
            System.out.println("closes connection");
            this.connection.close();
        }
    }

    @Override
    public void acknowledge(final long packetId) {
        if (this.connection.isOpen()) {
            System.out.println("sends acknowledge of packet id=" + packetId);
        } else {
            System.out.println("can't send acknowledge to a closed connection.");
        }
    }

    @Override
    public void send(Packet packet) {
        System.out.printf("packet %s sent. %n" , packet.toString());
    }
}
