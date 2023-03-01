package it.axiid.bungeelibs.server.listener;

import it.axiid.bungeelibs.server.BungeePlugin;
import it.axiid.bungeelibs.server.player.BungeePlayer;
import it.axiid.bungeelibs.server.util.ChatUtils;
import net.md_5.bungee.api.plugin.Listener;

public abstract class ListenerAdapter implements Listener {

    protected final BungeePlugin plugin;

    public ListenerAdapter(BungeePlugin plugin) {
        this.plugin = plugin;
        plugin.getProxy().getPluginManager().registerListener(plugin, this);
    }

    protected void sendMessage(BungeePlayer player, String message) {
        player.sendMessage(ChatUtils.color(message));
    }

}