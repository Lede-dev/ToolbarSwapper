package me.lede.toolbarswapper;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import me.lede.toolbarswapper.event.ToolbarScrollDownEvent;
import me.lede.toolbarswapper.event.ToolbarScrollUpEvent;

public class ToolbarSwapListener implements Listener {
	
	private static final String PERMISSION_USE = "toolbarswapper.use";

	public ToolbarSwapListener(ToolbarSwapper plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	private boolean isScroll(final int prev, final int next) {
		int count = Math.abs(prev-next);
		if (count == 1 || count == 8) return true;
		return false;
	}
	
	private boolean isDownScroll(final int prev, final int next) {
		if (prev == 8 && next == 0) return true;
		if (prev == 0 && next == 8) return false;
		if (next > prev) return true;
		return false;
	}
	
	private boolean isUpScroll(final int prev, final int next) {
		if (prev == 0 && next == 8) return true;
		if (prev == 8 && next == 0) return false;
		if (next < prev) return true;
		return false;
	}
	
	private void playScrollSound(final Player player) {
		player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_CHAIN, 1.0f, 1.0f);
	}
	
	@EventHandler
	public void onToolChange(final PlayerItemHeldEvent event) {
		Player player = event.getPlayer();
		int prev = event.getPreviousSlot();
		int next = event.getNewSlot();
		
		if (isScroll(prev, next)) {
			if (isDownScroll(prev, next)) {
				ToolbarScrollDownEvent scrollDownEvent = new ToolbarScrollDownEvent(player, prev, next);
				Bukkit.getPluginManager().callEvent(scrollDownEvent);
			}
			else if (isUpScroll(prev, next)) {
				ToolbarScrollUpEvent scrollUpEvent = new ToolbarScrollUpEvent(player, prev, next);
				Bukkit.getPluginManager().callEvent(scrollUpEvent);
			}
		}
		
	}
	
	@EventHandler
	public void onScrollUp(final ToolbarScrollUpEvent event) {
		Player player = event.getPlayer();
		if (player.isSneaking()) {
			if (player.hasPermission(PERMISSION_USE)) {
				InventorySwapper.pushItemsUp(player);
				playScrollSound(player);
			}
		}		
	}
	
	@EventHandler
	public void onScrollDown(final ToolbarScrollDownEvent event) {
		Player player = event.getPlayer();
		if (player.isSneaking()) {
			if (player.hasPermission(PERMISSION_USE)) {
				InventorySwapper.pushItemsDown(player);
				playScrollSound(player);
			}
		}		
	}
	
	
}
