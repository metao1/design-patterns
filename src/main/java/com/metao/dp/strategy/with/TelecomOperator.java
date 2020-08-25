package com.metao.dp.strategy.with;

public class TelecomOperator {
    private PlanStrategy plan;

    public void activatePlan (PlanStrategy strategy) {
        this.plan = strategy;
    }

    public int getFreeSMS() {
        return plan.getFreeSMS();
    }

    public int getFreeTalkTime() {
        return plan.getTalkTime();
    }
}