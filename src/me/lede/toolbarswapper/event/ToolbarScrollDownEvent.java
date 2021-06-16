package me.lede.toolbarswapper.event;

import org.bukkit.entity.Player;

public class ToolbarScrollDownEvent extends ToolbarScrollEvent {

	public ToolbarScrollDownEvent(Player player, int prevSlot, int newSlot) {
		super(player, prevSlot, newSlot);
	}
	
}
