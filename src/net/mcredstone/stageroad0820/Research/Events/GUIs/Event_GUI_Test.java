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
	// �÷����ο� �ʿ��� ��ü ���� �� ����
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	// Ŭ���� ����
	public Event_GUI_Test(Main plugin) {
		Event_GUI_Test.res_main = plugin;
	}

	// ChatColor ����ȭ
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

	// ���� ����ϴ� String �� ����ȭ
	String prefix = aqua + "[Research] " + white + "";
	String error = dred + "[Res Error] " + red + "";
	String warning = yellow + "[Res Warning] " + white + "";

	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		// �κ��丮�� ������ "��ƼƼ�� �����ϼ���" �� �ƴ� ��� �̺�Ʈ �۵� ���
		if (!event.getInventory().getTitle().equalsIgnoreCase("Research �÷����� - GUI ��� �׽�Ʈ")) {
			return;
		}
		
		switch (event.getCurrentItem().getType()) {
		case WOOD_DOOR:
			// �׽��� ��� ����
			MainCommand.isTest = false;
			player.closeInventory();
			player.sendMessage(prefix + "�׽�Ʈ ��尡 ����Ǿ����ϴ�. �ٽ� �׽�Ʈ ���� �����Ͻ÷��� " + yellow + "/res test gui"
					+ white + " Ŀ�ǵ带 �Է��� �ּ���.");
			break;
		case WOOL:
			// �׽�Ʈ ����
			break;
		case BLAZE_ROD:
			// ��ƼƼ ��ȯ GUI - �׽�Ʈ
			SE_GUI_Main.openInv(player);
			break;
		case RAILS:
			// ���� ������
			break;
		case LADDER:
			// ���� ������
			break;
		case BOOK:
			// ���� ������
			break;
		default:
			// ���� ���� ���� ������ Ŭ���� GUI ���� ��ħ
			GUI_Test.openInv(player);
			break;
		}
	}

}
