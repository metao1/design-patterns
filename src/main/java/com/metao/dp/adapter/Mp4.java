package com.metao.dp.adapter;

public class Mp4 implements Music{

    private String filePath;

    public Mp4(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void play() {
        System.out.println("Playing video mp4 at: "+ this.filePath);
    }
}
