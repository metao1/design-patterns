package com.metao.dp.bridge;

public class TvRemoteController implements Remote {
    protected Device device;

    public TvRemoteController() {}

    public TvRemoteController(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("TV Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("TV Remote: volume down");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("TV Remote: volume up");
        device.setVolume(device.getVolume() + 10);
    }

}