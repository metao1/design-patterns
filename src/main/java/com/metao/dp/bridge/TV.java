package com.metao.dp.bridge;

public class TV implements Device {
    private boolean on = false;
    private int volume = 30;
    
    public boolean isEnabled() {
        return on;
    }
  
    public void enable() {
        on = true;
    }

    public void disable() {
        on = false;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }
}