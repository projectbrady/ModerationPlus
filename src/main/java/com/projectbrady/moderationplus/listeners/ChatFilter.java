package com.projectbrady.moderationplus.listeners;

import com.projectbrady.moderationplus.Main;
import com.projectbrady.moderationplus.util.FilteredWordManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

public class ChatFilter implements Listener {

    private final FilteredWordManager wordManager;

    public ChatFilter(FilteredWordManager wordManager) {
        this.wordManager = wordManager;
    }

    @EventHandler
    public void onMessageFilter(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = ChatColor.stripColor(e.getMessage());

        if(this.wordManager.isBanned(msg)) {
            p.sendMessage(Main.plugin.getConfig().getString("Messages.FilterTrigger").replace("&", "§"));
            e.setCancelled(true);
        }

    }
}
