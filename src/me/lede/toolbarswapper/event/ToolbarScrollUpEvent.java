package me.lede.toolbarswapper.event;

import org.bukkit.entity.Player;

public class ToolbarScrollUpEvent extends ToolbarScrollEvent {

	public ToolbarScrollUpEvent(Player player, int prevSlot, int newSlot) {
		super(player, prevSlot, newSlot);
	}
	
}
