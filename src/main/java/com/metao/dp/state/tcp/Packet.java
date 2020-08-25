package com.metao.dp.state.tcp;

public class Packet {

    private final long id;
    private final String message;

    public Packet(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "id:" + id +
                ", message:'" + message + '\'' +
                '}';
    }
}
