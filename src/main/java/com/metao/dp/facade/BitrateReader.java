package com.metao.dp.facade;

public class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: codec type:" + codec.getType() + ", reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: codec type:" + codec.getType() + ", writing file...");
        return buffer;
    }
}
