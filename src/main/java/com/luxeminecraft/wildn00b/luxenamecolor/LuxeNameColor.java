package com.luxeminecraft.wildn00b.luxenamecolor;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.plugin.java.JavaPlugin;

public class LuxeNameColor extends JavaPlugin {

	public static final Logger log = Logger.getLogger("Minecraft");
	public Permissions permissions;

	@Override
	public void onEnable() {
		permissions = new Permissions(this);

		getServer().getPluginManager().registerEvents(new Listener() {
			@SuppressWarnings("unused")
			@EventHandler(priority = EventPriority.MONITOR)
			public void OnLogin(PlayerLoginEvent event) {
				if (event.getResult() == Result.ALLOWED) {
					event.getPlayer().setDisplayName(getColor(event.getPlayer()) + event.getPlayer().getDisplayName());
				}
			}

			private String getColor(Player player) {
				if (permissions.HasPermissions(player, "luxenamecolor.black"))
					return "\u00A70";
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_blue"))
					return "\u00A71";
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_green"))
					return "\u00A72";
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_cyan"))
					return "\u00A73";
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_red"))
					return "\u00A74";
				else if (permissions.HasPermissions(player, "luxenamecolor.purple"))
					return "\u00A75";
				else if (permissions.HasPermissions(player, "luxenamecolor.gold"))
					return "\u00A76";
				else if (permissions.HasPermissions(player, "luxenamecolor.gray"))
					return "\u00A77";
				else if (permissions.HasPermissions(player, "luxenamecolor.dark_gray"))
					return "\u00A78";
				else if (permissions.HasPermissions(player, "luxenamecolor.blue"))
					return "\u00A79";
				else if (permissions.HasPermissions(player, "luxenamecolor.bright_green"))
					return "\u00A7a";
				else if (permissions.HasPermissions(player, "luxenamecolor.cyan"))
					return "\u00A7b";
				else if (permissions.HasPermissions(player, "luxenamecolor.red"))
					return "\u00A7c";
				else if (permissions.HasPermissions(player, "luxenamecolor.pink"))
					return "\u00A7d";
				else if (permissions.HasPermissions(player, "luxenamecolor.yellow"))
					return "\u00A7e";
				else if (permissions.HasPermissions(player, "luxenamecolor.white"))
					return "\u00A7f";
				else
					return "";
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
