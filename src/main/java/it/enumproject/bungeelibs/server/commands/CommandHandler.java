package it.enumproject.bungeelibs.server.commands;

import it.enumproject.bungeelibs.server.BungeePlugin;
import it.enumproject.bungeelibs.server.player.BungeePlayer;
import it.enumproject.bungeelibs.server.util.ChatUtils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public abstract class CommandHandler extends Command {

    protected final String command;
    protected final String permission;
    protected final boolean canConsoleUse;

    protected final BungeePlugin plugin;

    public CommandHandler(BungeePlugin plugin, String command, String permission, boolean canConsoleUse, String... aliases) {
        super(command, permission, aliases);

        this.plugin = plugin;
        this.command = command;
        this.permission = permission;
        this.canConsoleUse = canConsoleUse;

        plugin.getProxy().getPluginManager().registerCommand(plugin, this);
    }

    public void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(ChatUtils.color(message));
    }

    public abstract void run(CommandSender sender, String[] args);

    public abstract String getNoConsoleMessage();

    public abstract String getNoPermissionMessage();

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!canConsoleUse && !(sender instanceof BungeePlayer)) {
            sendMessage(sender, getNoConsoleMessage());
            return;
        }

        if(permission != null && !sender.hasPermission(permission)) {
            sendMessage(sender, getNoPermissionMessage());
            return;
        }

        run(sender, args);
    }

}