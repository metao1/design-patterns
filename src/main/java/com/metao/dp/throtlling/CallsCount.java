package com.metao.dp.throtlling;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public final class CallsCount {

    private final Map<String, AtomicLong> tenantCallsCount = new ConcurrentHashMap<>();

    public void addTenant(String tenantName) {
        tenantCallsCount.putIfAbsent(tenantName, new AtomicLong(0));
    }

    public void incrementCount(String tenantName) {
        tenantCallsCount.get(tenantName).incrementAndGet();
    }

    public long getCount(String tenantName) {
        return tenantCallsCount.get(tenantName).get();
    }

    public void reset() {
        System.out.println("Resetting the map.");
        tenantCallsCount.replaceAll((k, v) -> new AtomicLong(0));
    }
}