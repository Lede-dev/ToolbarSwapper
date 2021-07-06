package me.lede.toolbarswapper.Json;

import org.bukkit.entity.Player;

import me.lede.toolbarswapper.Json.data.PlayerSwapperStateJsonData;

public class JsonDataLoader {

	public static class SwapperStateJson extends JsonFormat<PlayerSwapperStateJsonData> {	
		public SwapperStateJson(Player player) {
			init(JsonPath.SWAPPER_STATE.getPath(player.getUniqueId().toString()), new PlayerSwapperStateJsonData());
			create();
		}
	}

	public static SwapperStateJson getSwapperStateJson(Player player) {
		return new SwapperStateJson(player);
	}
	
}
