package com.metao.dp.builder;

public class Main {
    public static void main(String[] args) {
        Hero crazyFrog = Hero.HeroBuilder
                .builder("Crazy Frog", "fighter")
                .hairColor("Black")
                .armor("Knife")
                .hairType("Blond")
                .weapon("DAGGER")
                .build();

        System.out.println(crazyFrog.getName() + " is a " + crazyFrog.getProfession());
    }
}
