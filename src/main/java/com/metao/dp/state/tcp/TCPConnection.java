package com.metao.dp.state.tcp;

public class TCPConnection {

    private TCPState tcpState;
    private final Connection connection = new Connection();
    private final TCPEstablish tcpEstablish = new TCPEstablish(connection);
    private final TCPListen tcpListen = new TCPListen(connection);
    private final TCPClose tcpClose = new TCPClose(connection);

    public void openConnection() {
        this.tcpState = tcpEstablish;
        this.tcpState.send(new Packet(0, "SYN"));
        this.tcpState.open();
        this.tcpState = tcpListen;
    }

    public void closeConnection() {
        this.tcpState = tcpClose;
        this.tcpState.close();
        this.tcpState.send(new Packet(0, "CLOSE"));
    }

    public void sendPacket(final Packet packet) {
        this.tcpState.send(packet);
    }

    public State getTCPState() {
        return connection.getState();
    }

}
