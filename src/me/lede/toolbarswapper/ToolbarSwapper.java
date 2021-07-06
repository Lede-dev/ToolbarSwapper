package me.lede.toolbarswapper;

import org.bukkit.plugin.java.JavaPlugin;

import me.lede.toolbarswapper.command.ScrollStateChangeCommand;

public class ToolbarSwapper extends JavaPlugin {

	public static ToolbarSwapper instance;
	
	@Override
	public void onEnable() {		
		instance = this;
		
		new ToolbarSwapListener(this);
		new SwapperStateLoadListener(this);
		
		new ScrollStateChangeCommand(this);
	}

}
