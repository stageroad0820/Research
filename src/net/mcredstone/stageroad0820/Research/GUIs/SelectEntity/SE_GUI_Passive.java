package net.mcredstone.stageroad0820.Research.GUIs.SelectEntity;

import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SpawnEggMeta;
import org.bukkit.plugin.PluginManager;

import net.mcredstone.stageroad0820.Research.Main;

public class SE_GUI_Passive {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	public SE_GUI_Passive(Main plugin) {
		SE_GUI_Passive.res_main = plugin;
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

	// ���� ���� �� �ʱ�ȭ
	static int now_page = 1;
	static int max_page = 1;
	
	// GUI â ���� - ģȭ�� ��
	public static void openInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "��ƼƼ�� �����ϼ��� - ģȭ�� ��");

		// ��ƼƼ: ���� (������: ���� ���� ��)
		ItemStack is_bat = new ItemStack(Material.MONSTER_EGG);
		SpawnEggMeta sm_bat = (SpawnEggMeta) is_bat.getItemMeta();

		sm_bat.setDisplayName(aqua + "��ȯ: ����");

		sm_bat.setLore(Arrays.asList(gray + "'��ƼƼ ��ȯ�� ������ ����' �� '����' ��ȯ ����� �Է��մϴ�.",
				"������ ���븦 ��ȯ�ϰ� ���� ���� �ٶ󺸰� ��Ŭ�� �ϸ� ��ȯ�˴ϴ�.", "", blue + "����: ģȭ�� ��", blue + "����: ����"));

		sm_bat.setSpawnedType(EntityType.BAT);

		is_bat.setItemMeta(sm_bat);

		// ��ƼƼ: �� (������: �� ���� ��)
		ItemStack is_chicken = new ItemStack(Material.MONSTER_EGG);
		SpawnEggMeta sm_chicken = (SpawnEggMeta) is_chicken.getItemMeta();

		sm_chicken.setDisplayName(aqua + "��ȯ: ��");

		sm_chicken.setLore(Arrays.asList(gray + "'��ƼƼ ��ȯ�� ������ ����' �� '��' ��ȯ ����� �Է��մϴ�.",
				"������ ���븦 ��ȯ�ϰ� ���� ���� �ٶ󺸰� ��Ŭ���ϸ� ��ȯ�˴ϴ�.", "", blue + "����: ģȭ�� ��", blue + "����: ����"));

		sm_chicken.setSpawnedType(EntityType.CHICKEN);

		is_chicken.setItemMeta(sm_chicken);

		// ��ƼƼ: �� (������: �� ���� ��)
		ItemStack is_cow = new ItemStack(Material.MONSTER_EGG);
		SpawnEggMeta sm_cow = (SpawnEggMeta) is_cow.getItemMeta();

		sm_cow.setDisplayName(aqua + "��ȯ: ��");

		sm_cow.setLore(Arrays.asList(gray + "'��ƼƼ ��ȯ�� ������ ����' �� '��' ��ȯ ����� �Է��մϴ�.",
				"������ ���븦 ��ȯ�ϰ� ���� ���� �ٶ󺸰� ��Ŭ���ϸ� ��ȯ �˴ϴ�.", "", blue + "����: ģȭ�� ��", blue + "����: ����"));

		sm_cow.setSpawnedType(EntityType.COW);

		is_cow.setItemMeta(sm_cow);

		/* ��ġ�� ������ ����
		 * 
		 * v ����
		 * v ��
		 * v ��
		 * ������
		 * �䳢
		 * ����
		 * ��
		 * ���̷��� ��
		 * ��¡��
		 * �ֹ�
		 * 
		 * v ������
		 * v ���� ������
		 * v ���� ������
		 * v ���� ������
		 * v ���� �޴��� ���ư���
		 */
		
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
		
		// ���� �޴��� ���ư���
		ItemStack is_return = new ItemStack(Material.SIGN);
		ItemMeta im_return = is_return.getItemMeta();
		
		im_return.setDisplayName(green + "���� �޴��� ���ư���");
		
		im_return.setLore(Arrays.asList(gray + "��ƼƼ ���� ����ȭ������ ���ư��ϴ�."));
		
		is_return.setItemMeta(im_return);

		/* ������ ��ġ
		 * 
		 * 0 0 0 0 0 0 0 0 0
		 * 0 1 2 3 4 5 6 7 0
		 * 0 8 9 & * * * * 0
		 * 0 * * * * * * * 0
		 * 0 * * * * * * * 0
		 * 0 0 0 < | > 0 0 E
		 * 
		 * 0: ������ / 1: ���� / 2: �� / 3: �� / 4: ������ / 5: �䳢 / 6: ���� / 7: ��
		 * 8: ���̷��� �� / 9: ��¡�� / &: �ֹ� / *: ��ĭ / <: ���� ������ / |: ���� ������ / >: ���� ������ / E: ���� �޴��� ���ư���
		 */
		
		inv.setItem(53, is_return);
		
		player.openInventory(inv);
	}
}
