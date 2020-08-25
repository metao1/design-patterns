package com.metao.dp.state.tcp;

public class TCPClose implements com.metao.dp.state.tcp.TCPState {
    private final Connection connection;

    public TCPClose(final Connection connection) {
        this.connection = connection;
    }

    @Override
    public void open() {
        this.connection.open();
        System.out.println("opens connection");
    }

    @Override
    public void close() {
        if (this.connection.isOpen()) {
            this.connection.close();
            System.out.println("closes connection");
            this.connection.close();
        }
    }

    @Override
    public void acknowledge(long packetId) {
        System.out.println("sends acknowledge of packet id=" + packetId);
    }

    @Override
    public void send(Packet packet) {
        if (packet.getId() == 0) {
            System.out.printf("packet %s sent. %n" , packet.toString());
        } else {
            System.out.println("can't send packet to a closed connection.");
        }
    }
}
