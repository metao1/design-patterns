package com.metao.dp.facade;

public class OggCompressionCodec implements Codec {
    public String type = "ogg";

    @Override
    public String getType() {
        return type;
    }
}
