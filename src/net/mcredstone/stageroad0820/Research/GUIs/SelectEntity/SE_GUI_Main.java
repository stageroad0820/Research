package net.mcredstone.stageroad0820.Research.GUIs.SelectEntity;

import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;

import net.mcredstone.stageroad0820.Research.Main;

public class SE_GUI_Main {
	// Ŭ������ �ʿ��� ��ü ���� �� �ʱ�ȭ
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;
	
	// ���� Ŭ������ ����
	public SE_GUI_Main(Main plugin) {
		SE_GUI_Main.res_main = plugin;
	}
	
	// �÷����� ������ ��ü
	PluginManager pm = Bukkit.getServer().getPluginManager();
	
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
	
	// GUI â ���� - ����ȭ��
	public static void openInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "��ƼƼ�� �����ϼ���");
		
		// ��ƼƼ ���� : ��ü ��ƼƼ ��� (������: å�� ����)
		ItemStack is_allMob = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta im_allMob = is_allMob.getItemMeta();
		
		im_allMob.setDisplayName(gold + "��ü ��ƼƼ ���");
		
		im_allMob.setLore(Arrays.asList(gray + "����ũ����Ʈ���� ��ƼƼ(Entity)�� ó���ϴ� ��� ��ü���� ����� ǥ���մϴ�."));
		
		is_allMob.setItemMeta(im_allMob);
		
		// ��ƼƼ ���� : ģȭ�� �� (������: ��� ����)
		ItemStack is_psMob = new ItemStack(Material.WOOL);
		ItemMeta im_psMob = is_psMob.getItemMeta();
		
		im_psMob.setDisplayName(aqua + "ģȭ�� ��");
		
		im_psMob.setLore(Arrays.asList(gray + "ģȭ�� ���� �÷��̾ ���������� �ʰ�, �÷��̾ �����ϸ� �������� ���� �����Դϴ�."
				, "", blue + "����: ����, ��, ��, ������ (������), ����, �䳢, ��, ���̷��� ��, ��¡��, �ֹ�"));
		
		is_psMob.setItemMeta(im_psMob);
		
		// ��ƼƼ ���� : �߸��� �� (������: ����)
		ItemStack is_ntMob = new ItemStack(Material.SHIELD);
		ItemMeta im_ntMob = is_ntMob.getItemMeta();
		
		im_ntMob.setDisplayName(green + "�߸��� ��");
		
		im_ntMob.setLore(Arrays.asList(gray + "�߸��� ���� �÷��̾ ���� �����ϱ� ������ �÷��̾ �������� �ʴ� ���� �����Դϴ�."
				, "", blue + "����: �Ź�, ���� �Ź� (����), ������, " + red + "�ϱذ� (1.12) " + blue + ", ���� ����"));
		
		is_ntMob.setItemMeta(im_ntMob);
		
		// ��ƼƼ ����: ������ �� (������: ���̾Ƹ�� Į)
		ItemStack is_hsMob = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta im_hsMob = is_hsMob.getItemMeta();
		
		im_hsMob.setDisplayName(red + "������ ��");
		
		im_hsMob.setLore(Arrays.asList(gray + "������ ���� �ڽ��� �þ߿� ���� �÷��̾ ���� �����ϴ� ���� ���� �Դϴ�."
				, "", blue + "����: ����, ���̷���, �����̴� ��Ű, ������, ũ���� �� 19��"));
		
		is_hsMob.setItemMeta(im_hsMob);
		
		// ��ƼƼ ����: ����̱� ������ �� (������: ����)
		ItemStack is_tmMob = new ItemStack(Material.FEATHER);
		ItemMeta im_tmMob = is_tmMob.getItemMeta();
		
		im_tmMob.setDisplayName(yellow + "����̱� ������ ��");
		
		im_tmMob.setLore(Arrays.asList(gray + "����̱� ������ ���� ���� �������� �̿��� �÷��̾ ������ ����ų� ���踦 ��ų �� �ִ� ���� �����Դϴ�."
				, "", blue + "����: �糪��, ��, " + red + "�� (1.12)," + blue + " ���, ������, " + red + "�޹��� (1.12)," + blue + " ����"));
		
		is_tmMob.setItemMeta(im_tmMob);
		
		// ��ƼƼ ����: ���� �� (������: ���� �巡���� ��)
		ItemStack is_bsMob = new ItemStack(Material.DRAGON_EGG);
		ItemMeta im_bsMob = is_bsMob.getItemMeta();
		
		im_bsMob.setDisplayName(dred + bold + "���� ��");
		
		im_bsMob.setLore(Arrays.asList(red + bold + "[ �� �� ! ]", gray + "����ũ����Ʈ�� �����ϴ� ���� ���� ���� �Դϴ�."
				, "", blue + "����: ���� �巡��, ����"));
		
		is_bsMob.setItemMeta(im_bsMob);
		
		// ��ƼƼ ����: ��Ÿ �� (������: Ŀ�ǵ� ��)
		ItemStack is_cmdMob = new ItemStack(Material.COMMAND);
		ItemMeta im_cmdMob = is_cmdMob.getItemMeta();
		
		im_cmdMob.setDisplayName(white + "��Ÿ ��");
		
		im_cmdMob.setLore(Arrays.asList(gray + "�Ϲ����� ������� ��ȯ���� �ʰų� ���� �����ϴ� ������ ���� �Դϴ�."
				, "", blue + "����: ���̾�Ʈ, ���� �䳢, ���� ��, ȯ����, ö ��, �����"));
		
		is_cmdMob.setItemMeta(im_cmdMob);
		
		// ������
		ItemStack is_wall = new ItemStack(Material.THIN_GLASS);
		ItemMeta im_wall = is_wall.getItemMeta();
		
		im_wall.setDisplayName(" ");
		
		is_wall.setItemMeta(im_wall);
		
		/* ������ ��ġ
		 * 
		 * 0 0 0 0 0 0 0 0 0
		 * 0 * * * 1 * * * 0
		 * 0 * * * * * * * 0
		 * 0 * 2 * 3 * 4 * 0
		 * 0 * 5 * 6 * 7 * 0
		 * 0 0 0 0 0 0 0 0 0
		 * 
		 * 0 : ������ / 1 : ��ü ��ƼƼ / 2 : ģȭ / 3 : �߸� / 4 : ���� / 5 : ����̱� / 6 : ���� / 7 : ��Ÿ / * : ��ĭ
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
		inv.setItem(13, is_allMob);
		inv.setItem(17, is_wall);
		
		inv.setItem(18, is_wall);
		inv.setItem(26, is_wall);
		
		inv.setItem(27, is_wall);
		inv.setItem(29, is_psMob);
		inv.setItem(31, is_ntMob);
		inv.setItem(33, is_hsMob);
		inv.setItem(35, is_wall);
		
		inv.setItem(36, is_wall);
		inv.setItem(38, is_tmMob);
		inv.setItem(40, is_bsMob);
		inv.setItem(42, is_cmdMob);
		inv.setItem(44, is_wall);
		
		inv.setItem(45, is_wall);
		inv.setItem(46, is_wall);
		inv.setItem(47, is_wall);
		inv.setItem(48, is_wall);
		inv.setItem(49, is_wall);
		inv.setItem(50, is_wall);
		inv.setItem(51, is_wall);
		inv.setItem(52, is_wall);
		inv.setItem(53, is_wall);
		
		player.openInventory(inv);
	}
}
