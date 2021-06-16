package me.lede.toolbarswapper.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ToolbarScrollEvent extends Event implements Cancellable {

	private final Player player;
	private final int prevSlot;
	private final int newSlot;
	
	private boolean cancelled;

	public ToolbarScrollEvent(Player player, int prevSlot, int newSlot) {
		this.player = player;
		this.prevSlot = prevSlot;
		this.newSlot = newSlot;
		this.cancelled = false;
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

	@Override
	public boolean isCancelled() {
		return cancelled;
	}
	
	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
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
