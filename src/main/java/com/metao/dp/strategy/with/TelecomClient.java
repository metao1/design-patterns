package com.metao.dp.strategy.with;

public class TelecomClient {

    private static final TelecomOperator operator = new TelecomOperator();

    public static void main(String args[]) {
        int freeSMS = 0;
        int freeMinute = 0;
        // On recharge of Rs. 250 set the Strategy for BasicPlan
        operator.activatePlan(new BasicPlan());
        freeSMS = operator.getFreeSMS();
        freeMinute = operator.getFreeTalkTime();
        System.out.println("You have " + freeSMS + "  SMS and " + freeMinute + " Minute free talk time");

        // On recharge of Rs. 500 set the Strategy for SuperPlan
        operator.activatePlan(new SuperPlan());
        freeSMS = operator.getFreeSMS();
        freeMinute = operator.getFreeTalkTime();
        System.out.println("You have " + freeSMS + "  SMS and " + freeMinute + " Minute free talk time");
    }
}