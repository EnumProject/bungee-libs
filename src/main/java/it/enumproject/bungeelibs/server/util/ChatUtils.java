package it.enumproject.bungeelibs.server.util;

import net.md_5.bungee.api.ChatColor;

import java.util.List;

public class ChatUtils {

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> color(List<String> lines) {
        for(String line : lines) {
            ChatColor.translateAlternateColorCodes('&', line);
        }
        return lines;
    }

}