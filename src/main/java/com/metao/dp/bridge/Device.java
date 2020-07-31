package com.metao.dp.bridge;

public interface Device {
     boolean isEnabled();
 
     void enable();
 
     void disable();
 
     int getVolume();
 
     void setVolume(int percent);
}