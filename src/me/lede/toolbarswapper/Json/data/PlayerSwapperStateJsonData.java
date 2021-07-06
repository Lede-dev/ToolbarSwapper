package me.lede.toolbarswapper.Json.data;

import me.lede.toolbarswapper.Json.JsonData;
import me.lede.toolbarswapper.utils.SwapperState;

public class PlayerSwapperStateJsonData extends JsonData {

	private SwapperState state;
	
	public PlayerSwapperStateJsonData() {
		init();
	}
	
	public PlayerSwapperStateJsonData(SwapperState state) {
		this.state = state;
	}
	
	private void init() {
		this.state = SwapperState.ENABLE;
	}
	
	public SwapperState getState() {
		return state;
	}
	
}
