package com.metao.dp.lazyloading;

public class HolderNaive {

    private Heavy heavy;

    public HolderNaive() {
        System.out.println("HolderNaive created");
    }

    /**
     * Get heavy object.
     */
    public Heavy getHeavy() {
        if (heavy == null) {
            heavy = new Heavy();
        }
        return heavy;
    }
}