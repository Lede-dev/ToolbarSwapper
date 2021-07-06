package me.lede.toolbarswapper.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.lede.toolbarswapper.SwapperStateLoader;
import me.lede.toolbarswapper.ToolbarSwapListener;
import me.lede.toolbarswapper.ToolbarSwapper;
import me.lede.toolbarswapper.utils.Messages;
import me.lede.toolbarswapper.utils.Permissions;
import me.lede.toolbarswapper.utils.SwapperState;

public class ScrollStateChangeCommand implements CommandExecutor {
	
	public ScrollStateChangeCommand(ToolbarSwapper plugin) {
		plugin.getCommand("swapper").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] arg) {

		if (!(sender instanceof Player)) return false;
		
		final Player player = (Player) sender;
		
		if (!player.hasPermission(Permissions.SWAPPER_USE)) {
			player.sendMessage(Messages.PermissionMessage.SWAPPER_USE_ERROR);
			return false;
		}
		
		if (arg.length != 1) {
			player.sendMessage(Messages.CommandMessage.ARGUMENTS_ERROR);
			return false;
		}
		
		if (arg[0].equalsIgnoreCase(Messages.CommandMessage.ARGUMENT_SCROLL_ENABLE)) {
			player.sendMessage(Messages.CommandMessage.USE_SCROLL_ENABLE);
			SwapperStateLoader.setData(player, SwapperState.ENABLE);
			return false;
		}
		
		if (arg[0].equalsIgnoreCase(Messages.CommandMessage.ARGUMENT_SCROLL_DISABLE)) {
			player.sendMessage(Messages.CommandMessage.USE_SCROLL_DISABLE);
			SwapperStateLoader.setData(player, SwapperState.DISABLE);
			return false;
		}
		
		if (arg[0].equalsIgnoreCase(Messages.CommandMessage.ARGUMENT_SCROLL_UP)) {
			ToolbarSwapListener.scrollUp(player);
			return false;
		}
		
		if (arg[0].equalsIgnoreCase(Messages.CommandMessage.ARGUMENT_SCROLL_DOWN)) {
			ToolbarSwapListener.scrollDown(player);
			return false;
		}
		
		return false;
	}
	
}
