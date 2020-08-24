package com.metao.dp.prototype;

public class Main {
    public static void main(String[] args) {
        var original = new Sheep("Jolly");
        System.out.println(original.getName()); // Jolly

        // Clone and modify what is required
        var cloned = original.clone();
        cloned.setName("Dolly");
        System.out.println(cloned.getName()); // Dolly
    }
}
