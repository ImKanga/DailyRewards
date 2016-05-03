package me.kanga.dailyrewards.storage;

import me.kanga.dailyrewards.Main;

public class Config {

    public static Long getCooldownRemaining(String name) {
        return Main.getCooldowns().getLong("users." + name + ".cooldown-end-millis") - Main.getCooldowns().getLong("users." + name + ".cooldown-start-millis");
    }

    public static void addCooldown(String name) {
        if (!Main.getCooldowns().getConfigurationSection("users").contains(name)) {
            Main.getCooldowns().set("users." + name + ".cooldown-start-millis", );
        }
    }

    public static void removeCooldown(String name) {

    }
}
