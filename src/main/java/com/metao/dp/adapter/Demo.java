package com.metao.dp.adapter;

public class Demo {

    public static void main(String[] args) {
        Mp3 mp3 = new Mp3("/tmp/file.mp3");
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.play(mp3);
        Mp4 mp4 = new Mp4("/tmp/file.mp4");
        musicPlayer.play(mp4);
    }
}
