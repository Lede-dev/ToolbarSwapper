package me.lede.toolbarswapper;

import org.bukkit.plugin.java.JavaPlugin;

public class ToolbarSwapper extends JavaPlugin {

	@Override
	public void onEnable() {
		new ToolbarSwapListener(this);
	}

}
