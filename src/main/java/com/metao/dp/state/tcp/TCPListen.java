package com.metao.dp.state.tcp;

public class TCPListen implements TCPState {
    private final Connection connection;

    public TCPListen(final Connection connection) {
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
    public void acknowledge(long packetId) {
        if (this.connection.isOpen()) {
            System.out.println("sends acknowledge of packet id=" + packetId);
        } else {
            System.out.println("can't send acknowledge to a closed connection.");
        }
    }

    public Packet receive(Packet packet) {
        if (this.connection.isOpen()) {
            this.acknowledge(packet.getId());
        }
        return packet;
    }

    public void send(Packet packet) {
        if (this.connection.isOpen()) {
            System.out.println("sends packet= " + packet.toString());
            this.connection.send(packet);
        } else {
            System.out.println("can't send packet to a closed connection.");
        }
    }
}
