package com.metao.dp.bridge;

public class Demo {
    public static void main(String[] args) {
        testRadioDevice(new TV());
        testTvDevice(new Radio());
    }

    public static void testRadioDevice(Device device) {
        Remote remote = new RadioRemoteController(device);
        /* Power on the device */
        remote.power();
        /* Volume up and down the device */
        remote.volumeUp();
        remote.volumeUp();
        remote.volumeDown();
        remote.volumeDown();
    }
    
    public static void testTvDevice(Device device) {
        Remote remote = new TvRemoteController(device);
        /* Power on the device */
        remote.power();
        /* Volume up and down the device */
        remote.volumeUp();
        remote.volumeUp();
        remote.volumeDown();
        remote.volumeDown();
    }            
}