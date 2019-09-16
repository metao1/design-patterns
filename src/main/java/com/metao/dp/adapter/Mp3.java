package com.metao.dp.adapter;

public class Mp3  implements Music{

    private String filePath;

    public Mp3(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public void play() {
        System.out.println("Playing mp3 in the path:"+  this.getFilePath());
    }
}
