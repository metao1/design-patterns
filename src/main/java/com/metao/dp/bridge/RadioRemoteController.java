package com.metao.dp.bridge;

public class RadioRemoteController implements Remote {

    protected Device device;

    public RadioRemoteController() {}

    public RadioRemoteController(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    @Override
    public void volumeDown() {
        System.out.println("Radio Remote: volume down");
        device.setVolume(device.getVolume() - 2);
    }

    @Override
    public void volumeUp() {
        System.out.println("Radio Remote: volume up");
        device.setVolume(device.getVolume() + 2);
    }

}