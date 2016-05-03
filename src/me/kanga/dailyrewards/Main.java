package me.kanga.dailyrewards;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    private static File cooldownsFile;
    private static YamlConfiguration cooldowns;

    @Override
    public void onEnable() {
        // DATA FILE
        cooldownsFile = new File(getDataFolder(), "users.yml");
        cooldowns = YamlConfiguration.loadConfiguration(cooldownsFile);
        if (cooldownsFile.exists()) {
            try {
                cooldownsFile.createNewFile();
            } catch (IOException e) {
                Bukkit.getLogger().severe("CANNOT CREATE DATA FILE!");
            }
        }
        try {
            cooldowns.load(cooldownsFile);
        } catch (IOException e) {
            Bukkit.getLogger().severe("CANNOT LOAD DATA FILE!");
        } catch (InvalidConfigurationException e) {
            Bukkit.getLogger().severe("ERROR IN DATA FILE!");
        }
        saveUsersConfig();
    }

    @Override
    public void onDisable() {
        saveUsersConfig();
    }

    public static File getCooldownsFile() {
        return cooldownsFile;
    }

    public static YamlConfiguration getCooldowns() {
        return cooldowns;
    }

    public static void saveUsersConfig() {
        try {
            getCooldowns().save(cooldownsFile);
        } catch (IOException e) {

        }
    }
}
