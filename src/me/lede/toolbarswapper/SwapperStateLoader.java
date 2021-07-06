package me.lede.toolbarswapper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.lede.toolbarswapper.Json.JsonDataLoader;
import me.lede.toolbarswapper.Json.data.PlayerSwapperStateJsonData;
import me.lede.toolbarswapper.utils.SwapperState;

public class SwapperStateLoader {

	private static Map<UUID,SwapperState> STATE = new HashMap<>();
	
	public static void loadStateFromJson(Player player) {
		SwapperState state = JsonDataLoader.getSwapperStateJson(player).read().getData().getState();
		STATE.put(player.getUniqueId(), state);
	}
	
	public static void saveStateToJson(Player player) {
		if (!hasData(player)) {
			loadStateFromJson(player);
		}
		JsonDataLoader.getSwapperStateJson(player).update(new PlayerSwapperStateJsonData(getData(player))).create().write();
	}
	
	public static void unloadState(Player player) {
		if (hasData(player)) STATE.remove(player.getUniqueId());
	}
	
	public static boolean hasData(Player player) {
		if (STATE.get(player.getUniqueId()) == null) return false;
		return true;
	}
	
	public static SwapperState getData(Player player) {
		return STATE.get(player.getUniqueId());
	}
	
	public static void setData(Player player, SwapperState state) {
		STATE.put(player.getUniqueId(), state);
	}
	
	public static SwapperState getSwapperState(Player player) {
		if (!hasData(player)) {
			loadStateFromJson(player);
		}
		return getData(player);
	}
	
	
}
