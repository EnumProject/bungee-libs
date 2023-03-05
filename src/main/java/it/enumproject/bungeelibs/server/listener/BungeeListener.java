package it.enumproject.bungeelibs.server.listener;

import it.enumproject.bungeelibs.server.BungeePlugin;
import it.enumproject.bungeelibs.server.player.BungeePlayer;
import it.enumproject.bungeelibs.server.util.ChatUtils;
import net.md_5.bungee.api.plugin.Listener;

public abstract class BungeeListener implements Listener {

    protected final BungeePlugin plugin;

    public BungeeListener(BungeePlugin plugin) {
        this.plugin = plugin;
        plugin.getProxy().getPluginManager().registerListener(plugin, this);
    }

    protected void sendMessage(BungeePlayer player, String message) {
        player.connect("");
        player.sendMessage(ChatUtils.color(message));
    }

}