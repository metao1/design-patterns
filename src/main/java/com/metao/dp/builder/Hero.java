package com.metao.dp.builder;

public final class Hero {
    private final String profession;
    private final String name;
    private final String hairType;
    private final String hairColor;
    private final String armor;
    private final String weapon;

    private Hero(HeroBuilder heroBuilder) {
        this.profession = heroBuilder.profession;
        this.name = heroBuilder.name;
        this.hairColor = heroBuilder.hairColor;
        this.hairType = heroBuilder.hairType;
        this.weapon = heroBuilder.weapon;
        this.armor = heroBuilder.armor;
    }

    public static class HeroBuilder {
        private final String profession;
        private final String name;
        private String hairType;
        private String hairColor;
        private String armor;
        private String weapon;

        public HeroBuilder(String name, String profession) {
            this.name = name;
            this.profession = profession;
        }

        public HeroBuilder hairType(String hairType) {
            this.hairType = hairType;
            return this;
        }

        public HeroBuilder hairColor(String hairColor) {
            this.hairColor = hairColor;
            return this;
        }

        public HeroBuilder armor(String armor) {
            this.armor = armor;
            return this;
        }

        public HeroBuilder weapon(String weapon) {
            this.weapon = weapon;
            return this;
        }

        public static HeroBuilder builder(String name, String profession) {
            return new HeroBuilder(name, profession);
        }

        public Hero build() {
            return new Hero(this);
        }
    }

    public String getArmor() {
        return armor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getHairType() {
        return hairType;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public String getWeapon() {
        return weapon;
    }
}