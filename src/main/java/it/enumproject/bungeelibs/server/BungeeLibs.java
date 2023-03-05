package it.enumproject.bungeelibs.server;

import lombok.Getter;

public class BungeeLibs extends BungeePlugin {

    @Getter
    private static BungeeLibs instance;

    @Override
    public void onLoad() {
        super.onEnable();
    }

    @Override
    public void onUnload() {
        super.onDisable();
    }

}