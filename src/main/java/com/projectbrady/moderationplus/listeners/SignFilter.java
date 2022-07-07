package com.projectbrady.moderationplus.listeners;

import com.projectbrady.moderationplus.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import java.util.List;

public class SignFilter implements Listener {

    FileConfiguration config = Main.plugin.getConfig();
    private List<String> banned = Main.plugin.getConfig().getStringList("Blacklisted");

    @EventHandler
    public void onSignEdit(SignChangeEvent e){

        String[] msg = e.getLines();
        Player p = e.getPlayer();

        for(String bWord : banned) {
            if(msg.equals(bWord)) {
                p.sendMessage(Main.plugin.getConfig().getString("Messages.FilterTrigger"));
                e.setCancelled(true);
            }
        }

    }

}

