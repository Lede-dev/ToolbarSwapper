package me.lede.toolbarswapper.utils;

import me.lede.toolbarswapper.ToolbarSwapper;
import net.md_5.bungee.api.ChatColor;

public class Messages {

	public static String colored(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}
	
	public class CommandMessage {
		public static final String ARGUMENT_SCROLL_ENABLE = "enable";
		public static final String ARGUMENT_SCROLL_DISABLE = "disable";
		public static final String ARGUMENT_SCROLL_UP = "up";
		public static final String ARGUMENT_SCROLL_DOWN = "down";
		public static final String ARGUMENTS_ERROR = Messages.colored(new StringBuilder("&c/swapper [")
				.append(ARGUMENT_SCROLL_ENABLE)
				.append("/")
				.append(ARGUMENT_SCROLL_DISABLE)
				.append("/")
				.append(ARGUMENT_SCROLL_UP)
				.append("/")
				.append(ARGUMENT_SCROLL_DOWN)
				.append("]").toString());
		
		
		public static final String USE_SCROLL_ENABLE = Messages.colored("&aEnable Toolbar Swapper.");
		public static final String USE_SCROLL_DISABLE = Messages.colored("&cDisable Toolbar Swapper.");
	}
	
	public class PermissionMessage {
		public static final String SWAPPER_USE_ERROR = Messages.colored("&cYou do not have permission to use the command.");
		
		
	}
	
	public class FilePath {
		public static final String PLUGIN_FOLDER = ToolbarSwapper.instance.getDataFolder().getPath();
		public static final String USER_DATABASE_FOLDER = PLUGIN_FOLDER + "/user/";
	}
}
