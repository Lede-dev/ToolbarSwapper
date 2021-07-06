package me.lede.toolbarswapper;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SwapperStateLoadListener implements Listener {

	public SwapperStateLoadListener(ToolbarSwapper plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		SwapperStateLoader.loadStateFromJson(event.getPlayer());
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		SwapperStateLoader.saveStateToJson(event.getPlayer());
		SwapperStateLoader.unloadState(event.getPlayer());
	}
	
}
