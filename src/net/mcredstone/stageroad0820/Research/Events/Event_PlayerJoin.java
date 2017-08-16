package net.mcredstone.stageroad0820.Research.Events;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;

import net.mcredstone.stageroad0820.Research.Main;

public class Event_PlayerJoin implements Listener {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	public Event_PlayerJoin(Main plugin) {
		Event_PlayerJoin.res_main = plugin;
	}

	// 플러그인 매니저 객체 생성
	PluginManager pm = Bukkit.getServer().getPluginManager();
	
	// ChatColor 간략화
	static String aqua = ChatColor.AQUA + "";
	static String black = ChatColor.BLACK + "";
	static String blue = ChatColor.BLUE + "";
	static String daqua = ChatColor.DARK_AQUA + "";
	static String dblue = ChatColor.DARK_BLUE + "";
	static String dgray = ChatColor.DARK_GRAY + "";
	static String dgreen = ChatColor.DARK_GREEN + "";
	static String dpurple = ChatColor.DARK_PURPLE + "";
	static String dred = ChatColor.DARK_RED + "";
	static String gold = ChatColor.GOLD + "";
	static String gray = ChatColor.GRAY + "";
	static String green = ChatColor.GREEN + "";
	static String lpurple = ChatColor.LIGHT_PURPLE + "";
	static String red = ChatColor.RED + "";
	static String white = ChatColor.WHITE + "";
	static String yellow = ChatColor.YELLOW + "";

	static String bold = ChatColor.BOLD + "";
	static String italic = ChatColor.ITALIC + "";
	static String magic = ChatColor.MAGIC + "";
	static String reset = ChatColor.RESET + "";
	static String strth = ChatColor.STRIKETHROUGH + "";
	static String under = ChatColor.UNDERLINE + "";

	// 자주 사용하는 String 값 간략화
	static String prefix = aqua + "[Research] " + white + "";
	static String error = dred + "[Res Error] " + red + "";
	static String warning = yellow + "[Res Warning] " + white + "";

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		if (!player.hasPlayedBefore() == true) {
			event.setJoinMessage(prefix + gold + bold + player.getName() + white + " 님이 서버에 처음 접속하셨습니다!");
			player.sendMessage(
					prefix + green + "/res help 또는 /research help" + white + " 커맨드를 통해 플러그인 커맨드에 대해 알아보실 수 있습니다!");
		} else {
			event.setJoinMessage(prefix + yellow + player.getName() + white + " 님이 서버에 접속하셨습니다.");
		}
	}
}
