package net.mcredstone.stageroad0820.Research.GUIs;

import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.mcredstone.stageroad0820.Research.Main;

public class GUI_Test {
	// �÷����ο� �ʿ��� ��ü ���� �� ����
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	// Ŭ���� ����
	public GUI_Test(Main plugin) {
		GUI_Test.res_main = plugin;
	}

	// ChatColor ����ȭ
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

	// ���� ����ϴ� String �� ����ȭ
	static String prefix = aqua + "[Research] " + white + "";
	static String error = dred + "[Res Error] " + red + "";
	static String warning = yellow + "[Res Warning] " + white + "";
	
	// ���� ����
	static int now_page = 1;
	static int max_page = 1;
	
	// GUI â ���� - ��� �׽�Ʈ
	public static void openInv(Player player) {
		 Inventory inv = Bukkit.createInventory(null, 54, "Research �÷����� - GUI ��� �׽�Ʈ");
		 
		 // ���: �׽�Ʈ ������ (������: ���� ��)
		 ItemStack is_exit = new ItemStack(Material.WOOD_DOOR);
		 ItemMeta im_exit = is_exit.getItemMeta();
		 
		 im_exit.setDisplayName(red + "GUI ��� �׽�Ʈ ������");
		 
		 im_exit.setLore(Arrays.asList(gray + "GUI ��� �׽�Ʈ�� ������ �����մϴ�.",
				 gray + "�ٽ� �����Ͻñ� ���ؼ��� " + yellow + "/res test gui" + gray + " Ŀ�ǵ带 �ٽ� �Է��ϼž� �մϴ�.",
				 "", blue + "���: �׽�Ʈ ������"));
		 
		 is_exit.setItemMeta(im_exit);
		 
		 // ���: ��ƼƼ ��ȯ GUI - ����ȭ�� (������: �������� ����)
		 ItemStack is_entity1 = new ItemStack(Material.BLAZE_ROD);
		 ItemMeta im_entity1 = is_entity1.getItemMeta();
		 
		 im_entity1.setDisplayName(aqua + "��ƼƼ ��ȯ GUI - ����ȭ��");
		 
		 im_entity1.setLore(Arrays.asList(gray + "Ŭ���ϸ� �ش� â�� �����ϴ�. ���� ��ɵ� ���� �̿��� �� �ֽ��ϴ�.",
				 "", blue + "���: SE_GUI_Main.openInv(" + player.getName() + ") ����"));
		 
		 is_entity1.setItemMeta(im_entity1);
		 
		 // ���: �׽�Ʈ ���� (������: ����)
		 ItemStack is_nothing = new ItemStack(Material.WOOL);
		 ItemMeta im_nothing = is_nothing.getItemMeta();
		 
		 im_nothing.setDisplayName(dgray + "�׽�Ʈ �� ����� �����ϴ�.");
		 
		 im_nothing.setLore(Arrays.asList(gray + "���� �׽�Ʈ�� ����� ���ų� ��ϵ��� �ʾҽ��ϴ�.", "", blue + "���: ����"));
		 
		 is_nothing.setItemMeta(im_nothing);
		 
		 // ������
		 ItemStack is_wall = new ItemStack(Material.THIN_GLASS);
		 ItemMeta im_wall = is_wall.getItemMeta();
		 
		 im_wall.setDisplayName(" ");
		 
		 is_wall.setItemMeta(im_wall);
		 
		 // ���� ������
		 ItemStack is_nextp = new ItemStack(Material.RAILS);
		 ItemMeta im_nextp = is_nextp.getItemMeta();
		 
		 im_nextp.setDisplayName(white + "���� ������");
		 
		 im_nextp.setLore(Arrays.asList(gray + "���� �������� �̵��մϴ�."));
		 
		 is_nextp.setItemMeta(im_nextp);
		 
		 // ���� ������
		 ItemStack is_prevp = new ItemStack(Material.LADDER);
		 ItemMeta im_prevp = is_nextp.getItemMeta();
		 
		 im_prevp.setDisplayName(white + "���� ������");
		 
		 im_prevp.setLore(Arrays.asList(gray + "���� �������� �̵��մϴ�."));
		 
		 is_prevp.setItemMeta(im_prevp);
		 
		 // ���� ������
		 ItemStack is_page = new ItemStack(Material.BOOK);
		 ItemMeta im_page = is_page.getItemMeta();
		 
		 im_page.setDisplayName(white + "���� ������: " + now_page + " �� " + max_page + " ������");
		 
		 is_page.setItemMeta(im_page);
		 
		 // ������ ��ġ
		 
		 /*
		  * 0 0 0 0 0 0 0 0 0
		  * 0 1 2 2 2 2 2 2 0
		  * 0 2 2 2 2 2 2 2 0
		  * 0 2 2 2 2 2 2 2 0
		  * 0 * * * * * * * 0
		  * 0 0 0 3 4 5 0 0 -
		  * 
		  * 0 : ������ / 1 : ��ƼƼ GUI / 2 : �׽�Ʈ ���� / 3 : ���� ������ / 4 : ���� ������ / 5 : ���� ������ / * : ��ĭ / - : �׽�Ʈ ������
		  */
		 
		 inv.setItem(0, is_wall);
		 inv.setItem(1, is_wall);
		 inv.setItem(2, is_wall);
		 inv.setItem(3, is_wall);
		 inv.setItem(4, is_wall);
		 inv.setItem(5, is_wall);
		 inv.setItem(6, is_wall);
		 inv.setItem(7, is_wall);
		 inv.setItem(8, is_wall);
		 
		 inv.setItem(9, is_wall);
		 inv.setItem(10, is_entity1);
		 inv.setItem(11, is_nothing);
		 inv.setItem(12, is_nothing);
		 inv.setItem(13, is_nothing);
		 inv.setItem(14, is_nothing);
		 inv.setItem(15, is_nothing);
		 inv.setItem(16, is_nothing);
		 inv.setItem(17, is_wall);
		 
		 inv.setItem(18, is_wall);
		 inv.setItem(19, is_nothing);
		 inv.setItem(20, is_nothing);
		 inv.setItem(21, is_nothing);
		 inv.setItem(22, is_nothing);
		 inv.setItem(23, is_nothing);
		 inv.setItem(24, is_nothing);
		 inv.setItem(25, is_nothing);
		 inv.setItem(26, is_wall);
		 
		 inv.setItem(27, is_wall);
		 inv.setItem(28, is_nothing);
		 inv.setItem(29, is_nothing);
		 inv.setItem(30, is_nothing);
		 inv.setItem(31, is_nothing);
		 inv.setItem(32, is_nothing);
		 inv.setItem(33, is_nothing);
		 inv.setItem(34, is_nothing);
		 inv.setItem(35, is_wall);
		 
		 inv.setItem(36, is_wall);
		 inv.setItem(37, is_nothing);
		 inv.setItem(38, is_nothing);
		 inv.setItem(39, is_nothing);
		 inv.setItem(40, is_nothing);
		 inv.setItem(41, is_nothing);
		 inv.setItem(42, is_nothing);
		 inv.setItem(43, is_nothing);
		 inv.setItem(44, is_wall);
		 
		 inv.setItem(45, is_wall);
		 inv.setItem(46, is_wall);
		 inv.setItem(47, is_wall);
		 inv.setItem(48, is_prevp);
		 inv.setItem(49, is_page);
		 inv.setItem(50, is_nextp);
		 inv.setItem(51, is_wall);
		 inv.setItem(52, is_wall);
		 inv.setItem(53, is_exit);
		 
		 player.openInventory(inv);
	}
}
