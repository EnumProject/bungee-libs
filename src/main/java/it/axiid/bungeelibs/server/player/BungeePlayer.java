package it.axiid.bungeelibs.server.player;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public abstract class BungeePlayer implements ProxiedPlayer {

    private final ProxiedPlayer player;

    public BungeePlayer(ProxiedPlayer player) {
        this.player = player;
    }

    public void connect(String name) {
        player.connect(ProxyServer.getInstance().getServerInfo(name));
    }

}