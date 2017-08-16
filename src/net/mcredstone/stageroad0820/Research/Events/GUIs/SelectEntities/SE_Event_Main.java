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

public class SE_Event_Main implements Listener {
	// 플러그인에 필요한 객체 생성 및 선언
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	public SE_Event_Main(Main plugin) {
		SE_Event_Main.res_main = plugin;
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
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		// 인벤토리의 제목이 "엔티티를 선택하세요" 가 아닌 경우 이벤트 작동 취소
		if (!event.getInventory().getTitle().equalsIgnoreCase("엔티티를 선택하세요")) {
			return;
		}

		switch (event.getCurrentItem().getType()) {
		case BOOK_AND_QUILL:
			// 전체 엔티티 목록

			break;

		case WOOL:
			// 친화적 몹
			SE_GUI_Passive.openInv(player);
			break;

		case SHIELD:
			// 중립적 몹
			break;

		case DIAMOND_SWORD:
			// 적대적 몹
			SE_GUI_Main.openInv(player);
			break;

		case FEATHER:
			// 길들이기 가능한 몹
			SE_GUI_Main.openInv(player);
			break;

		case DRAGON_EGG:
			// 보스 몹
			SE_GUI_Main.openInv(player);
			break;

		case COMMAND:
			// 기타 몹
			SE_GUI_Main.openInv(player);
			break;

		default:
			// 플레이어가 위의 아이템 외 다른 아이템을 클릭했을 경우
			SE_GUI_Main.openInv(player);
			break;
		}
	}
}
