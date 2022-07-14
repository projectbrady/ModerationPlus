package com.projectbrady.moderationplus;

import com.projectbrady.moderationplus.listeners.ChatFilter;
import com.projectbrady.moderationplus.util.FilteredWordManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    public static Plugin plugin;
    public static FileConfiguration config;
    private PluginManager pluginManager;

    private final FilteredWordManager filteredWordManager = new FilteredWordManager();

    @Override
    public void onEnable() {
        plugin = this;
        config = getConfig();

        // Plugin startup logic
        System.out.println("[ModerationPlus] has been enabled!");

        //register events
        pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(this, this);
        pluginManager.registerEvents(new ChatFilter(filteredWordManager), this);

        //register commands

        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
        filteredWordManager.reloadFromConfig();

    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[ModerationPlus] has been shutdown");
    }


}
