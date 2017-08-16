package net.mcredstone.stageroad0820.Research.Events.GUIs.SelectEntities;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.mcredstone.stageroad0820.Research.Main;
import net.mcredstone.stageroad0820.Research.GUIs.SelectEntity.SE_GUI_Main;
import net.mcredstone.stageroad0820.Research.GUIs.SelectEntity.SE_GUI_Passive;

public class SE_Event_Passive implements Listener {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	public SE_Event_Passive(Main plugin) {
		SE_Event_Passive.res_main = plugin;
	}

	// ChatColor 간략화
	String aqua = ChatColor.AQUA + "";
	String black = ChatColor.BLACK + "";
	String blue = ChatColor.BLUE + "";
	String daqua = ChatColor.DARK_AQUA + "";
	String dblue = ChatColor.DARK_BLUE + "";
	String dgray = ChatColor.DARK_GRAY + "";
	String dgreen = ChatColor.DARK_GREEN + "";
	String dpurple = ChatColor.DARK_PURPLE + "";
	String dred = ChatColor.DARK_RED + "";
	String gold = ChatColor.GOLD + "";
	String gray = ChatColor.GRAY + "";
	String green = ChatColor.GREEN + "";
	String lpurple = ChatColor.LIGHT_PURPLE + "";
	String red = ChatColor.RED + "";
	String white = ChatColor.WHITE + "";
	String yellow = ChatColor.YELLOW + "";

	String bold = ChatColor.BOLD + "";
	String italic = ChatColor.ITALIC + "";
	String magic = ChatColor.MAGIC + "";
	String reset = ChatColor.RESET + "";
	String strth = ChatColor.STRIKETHROUGH + "";
	String under = ChatColor.UNDERLINE + "";

	// 자주 사용하는 String 값 간략화
	String debug = dgray + "[Res Debug]" + white + "";

	@EventHandler
	public static void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		if (!event.getInventory().getTitle().equalsIgnoreCase("엔티티를 선택하세요 - 친화적 몹")) {
			return;
		}

		/*
		 * 색깔이 있는 이름은 § 을 쓰고 아래의 색깔 코드 입력하기
		 * 
		 * 0 1 2 3 4 5 6 7 8 9 a b c d e f k l m n o r
		 * 
		 * [참고] https://minecraft.gamepedia.com/Formatting_codes
		 */
		switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
		case "§a상위 메뉴로 돌아가기":
			SE_GUI_Main.openInv(player);
			break;
		default:
			SE_GUI_Passive.openInv(player);
			break;
		}
	}
}
