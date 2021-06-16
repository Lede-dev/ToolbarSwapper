package me.lede.toolbarswapper;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventorySwapper {

	public static final void pushItemsUp(Player player) {
		Inventory inv = player.getInventory();
		List<ItemStack> contents = new ArrayList<>();
		for (int i=9; i<36; i++) {
			contents.add(inv.getItem(i));
		}
		for (int j=0; j<9; j++) {
			contents.add(inv.getItem(j));
		}
		int count = 0;
		for (ItemStack item : contents) {
			inv.setItem(count++, item);
		}
	}
	
	public static final void pushItemsDown(Player player) {
		Inventory inv = player.getInventory();
		List<ItemStack> contents = new ArrayList<>();
		for (int i=27; i<36; i++) {
			contents.add(inv.getItem(i));
		}
		for (int n=0; n<27; n++) {
			contents.add(inv.getItem(n));
		}
		int count = 0;
		for (ItemStack item : contents) {
			inv.setItem(count++, item);
		}
	}
	
}
