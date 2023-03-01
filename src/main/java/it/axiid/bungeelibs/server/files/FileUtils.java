package it.axiid.bungeelibs.server.files;

import it.axiid.bungeelibs.server.BungeeLibs;
import it.axiid.bungeelibs.server.BungeePlugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;

public class FileUtils {

    private final BungeePlugin plugin = BungeeLibs.getInstance();

    private File file;
    private Configuration config;

    public void loadFile(String fileName) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        if (!(file = new File(plugin.getDataFolder(), fileName)).exists()) {
            try {
                Files.copy(plugin.getResourceAsStream(fileName), file.toPath(), new CopyOption[0]);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(plugin.getDataFolder(), fileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadFile(String fileName) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }
        if (!(file = new File(plugin.getDataFolder(), fileName)).exists()) {
            try {
                Files.copy(plugin.getResourceAsStream(fileName), file.toPath(), new CopyOption[0]);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(plugin.getDataFolder(), fileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String fileName) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
            final File file = new File(plugin.getDataFolder(), fileName);
            if (!file.exists()) {
                try (final InputStream in = plugin.getResourceAsStream(fileName)) {
                    Files.copy(in, file.toPath(), new CopyOption[0]);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(plugin.getDataFolder(), fileName));
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }

}