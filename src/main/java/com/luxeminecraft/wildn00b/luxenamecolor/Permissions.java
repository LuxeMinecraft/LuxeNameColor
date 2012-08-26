package com.luxeminecraft.wildn00b.luxenamecolor;

import java.util.logging.Level;

import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.permission.Permission;

public class Permissions {

	private Permission vault;
	private boolean isVaultEnabled;

	public Permissions(LuxeNameColor luxenamecolor) {
		if (luxenamecolor.getServer().getPluginManager().getPlugin("Vault") == null) {
			LuxeNameColor.log.log(Level.INFO, "[LuxeNameColor] Vault not found, reverting to superperms");
			isVaultEnabled = false;
		} else {
			RegisteredServiceProvider<Permission> rsp = luxenamecolor.getServer().getServicesManager().getRegistration(Permission.class);
			vault = rsp.getProvider();
		}
	}

	public boolean HasPermissions(Player player, String permission) {
		if (isVaultEnabled)
			return vault.has(player, permission);
		else
			return player.hasPermission(permission);
	}

}