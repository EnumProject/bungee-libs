package it.enumproject.bungeelibs.server;

import it.enumproject.bungeelibs.server.files.FileUtils;
import net.md_5.bungee.api.plugin.Plugin;

public abstract class BungeePlugin extends Plugin {

    private final FileUtils fileUtils = new FileUtils();

    protected void createConfiguration(String fileName) {
        fileUtils.createFile(fileName);
    }

    protected void reloadConfiguration(String fileName) {
        fileUtils.reloadFile(fileName);
    }

    protected void saveConfiguration(String fileName) {
        fileUtils.loadFile(fileName);
    }

    public abstract void onLoad();

    public abstract void onUnload();

}