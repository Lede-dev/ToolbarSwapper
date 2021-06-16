package me.lede.toolbarswapper.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ToolbarScrollEvent extends Event {

	private final Player player;
	private final int prevSlot;
	private final int newSlot;

	public ToolbarScrollEvent(Player player, int prevSlot, int newSlot) {
		this.player = player;
		this.prevSlot = prevSlot;
		this.newSlot = newSlot;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getPrevSlot() {
		return prevSlot;
	}
	
	public int getNewSlot() {
		return newSlot;
	}

	private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
	
}
