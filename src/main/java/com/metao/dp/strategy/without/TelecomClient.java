package com.metao.dp.strategy.without;

public class TelecomClient {
    private static final TelecomOperator operator = new TelecomOperator();

    public static void main(String[] args) {
        int freeSMS = 0;
        int freeMinute = 0;
        //On Rs. 250 recharge get the free SMS and Free Talk time offer.
        freeSMS = operator.getFreeSMS(250);
        freeMinute = operator.getFreeMinute(250);
        System.out.println("You have " + freeSMS + "  SMS and " + freeMinute + " Minute free talk time");
        //On Rs. 500 recharge get the free SMS and Free Talk time offer.
        freeSMS = operator.getFreeSMS(500);
        freeMinute = operator.getFreeMinute(500);
        System.out.println("You have " + freeSMS + "  SMS and " + freeMinute + " Minute free talk time");
    }
}