package com.metao.dp.state.tcp;

public class Demo {

    public static void main(String[] args) {
        TCPConnection tcpConnection = new TCPConnection();
        System.out.println("TCP Status " + tcpConnection.getTCPState());
        tcpConnection.openConnection();

        System.out.println("TCP Status " + tcpConnection.getTCPState());

        tcpConnection.sendPacket(new Packet(1, "s"));
        tcpConnection.sendPacket(new Packet(2, "a"));
        tcpConnection.sendPacket(new Packet(3, "l"));
        tcpConnection.sendPacket(new Packet(4, "a"));
        tcpConnection.sendPacket(new Packet(5, "m"));

        tcpConnection.closeConnection();

        System.out.println("TCP Status " + tcpConnection.getTCPState());

        tcpConnection.sendPacket(new Packet(6, "can you send me?"));

    }
}
