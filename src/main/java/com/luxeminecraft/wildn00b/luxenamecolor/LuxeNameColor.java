package com.luxeminecraft.wildn00b.luxenamecolor;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;
import org.kitteh.tag.PlayerReceiveNameTagEvent;

public class LuxeNameColor extends JavaPlugin {

	public static final Logger log = Logger.getLogger("Minecraft");
	public Permissions permissions;

	@Override
	public void onEnable() {
		permissions = new Permissions(this);

		getServer().getPluginManager().registerEvents(new Listener() {
			@EventHandler(priority = EventPriority.LOW)
			public void onNameTag(PlayerReceiveNameTagEvent event) {
				event.setTag(getColor(event.getPlayer()) + event.getNamedPlayer().getName());
			}
			
			private ChatColor getColor(Player player) {
				if (permissions.HasPermissions(player, "luxenamecolor.black"))
					return ChatColor.BLACK;
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_blue"))
					return ChatColor.DARK_BLUE;
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_green"))
					return ChatColor.DARK_GREEN;
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_aqua"))
					return ChatColor.DARK_AQUA;
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_red"))
					return ChatColor.DARK_RED;
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_purple"))
					return ChatColor.DARK_PURPLE;
				else if (permissions.HasPermissions(player, "luxenamecolor.gold"))
					return ChatColor.GOLD;
				else if (permissions.HasPermissions(player, "luxenamecolor.gray"))
					return ChatColor.GRAY;
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_gray"))
					return ChatColor.DARK_GRAY;
				else if (permissions.HasPermissions(player, "luxenamecolor.blue"))
					return ChatColor.BLUE;
				else if (permissions.HasPermissions(player, "luxenamecolor.green"))
					return ChatColor.GREEN;
				else if (permissions.HasPermissions(player, "luxenamecolor.cyan"))
					return ChatColor.AQUA;
				else if (permissions.HasPermissions(player, "luxenamecolor.red"))
					return ChatColor.RED;
				else if (permissions.HasPermissions(player, "luxenamecolor.light_purple"))
					return ChatColor.LIGHT_PURPLE;
				else if (permissions.HasPermissions(player, "luxenamecolor.yellow"))
					return ChatColor.YELLOW;
				else if (permissions.HasPermissions(player, "luxenamecolor.white"))
					return ChatColor.WHITE;
				else
					return ChatColor.RESET;
			}
		}, this);
		log.log(Level.INFO, "[LuxeNameColor] Initialized successfully.");
	}

	@Override
	public void onDisable() {
		permissions = null;
		log.log(Level.INFO, "[LuxeNameColor] Disabled successfully");
	}

}
