package net.mcredstone.stageroad0820.Research.Events.GUIs;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.mcredstone.stageroad0820.Research.Main;
import net.mcredstone.stageroad0820.Research.Commands.MainCommand;
import net.mcredstone.stageroad0820.Research.GUIs.GUI_Test;
import net.mcredstone.stageroad0820.Research.GUIs.SelectEntity.SE_GUI_Main;

public class Event_GUI_Test implements Listener {
	// 플러그인에 필요한 객체 생성 및 선언
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	// 클래스 연결
	public Event_GUI_Test(Main plugin) {
		Event_GUI_Test.res_main = plugin;
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
	String prefix = aqua + "[Research] " + white + "";
	String error = dred + "[Res Error] " + red + "";
	String warning = yellow + "[Res Warning] " + white + "";

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		// 인벤토리의 제목이 "엔티티를 선택하세요" 가 아닌 경우 이벤트 작동 취소
		if (!event.getInventory().getTitle().equalsIgnoreCase("Research 플러그인 - GUI 기능 테스트")) {
			return;
		}
		
		switch (event.getCurrentItem().getType()) {
		case WOOD_DOOR:
			// 테스드 모드 종료
			MainCommand.isTest = false;
			player.closeInventory();
			player.sendMessage(prefix + "테스트 모드가 종료되었습니다. 다시 테스트 모드로 진입하시려면 " + yellow + "/res test gui"
					+ white + " 커맨드를 입력해 주세요.");
			break;
		case WOOL:
			// 테스트 없음
			break;
		case BLAZE_ROD:
			// 엔티티 소환 GUI - 테스트
			SE_GUI_Main.openInv(player);
			break;
		case RAILS:
			// 다음 페이지
			break;
		case LADDER:
			// 이전 페이지
			break;
		case BOOK:
			// 현재 페이지
			break;
		default:
			// 위와 관련 없는 아이템 클릭시 GUI 새로 고침
			GUI_Test.openInv(player);
			break;
		}
	}

}
