package com.metao.dp.strategy.without;

public class TelecomOperator {
    public int getFreeSMS(int amount) {
        int freeSMS = 0;
        if (amount == 250) {
            freeSMS = 25;
        } else if (amount == 500) {
            freeSMS = 50;
        }
        return freeSMS;
    }

    public int getFreeMinute(int amount) {
        int freeMinute = 0;
        if (amount == 250) {
            freeMinute = 20;
        } else if (amount == 500) {
            freeMinute = 60;
        }
        return freeMinute;
    }
}