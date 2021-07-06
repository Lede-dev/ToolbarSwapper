package me.lede.toolbarswapper.Json;

import me.lede.toolbarswapper.utils.Messages;

public enum JsonPath {

	SWAPPER_STATE(Messages.FilePath.USER_DATABASE_FOLDER);
	
	String path;
	
	JsonPath(String path){
		this.path = path;
	}
	
	public String getPath() {
		return path;
	}
	
	public String getPath(String filename) {
		return new StringBuilder(path).append(filename).append(".json").toString();
	}
}
