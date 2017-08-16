package net.mcredstone.stageroad0820.Research.Events.Entities;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.PluginManager;

import net.mcredstone.stageroad0820.Research.Main;

public class Event_EntityDamagedByEntity implements Listener {
	// Ŭ������ �ʿ��� ��ü ���� �� ����
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	// Ŭ���� ����
	public Event_EntityDamagedByEntity(Main plugin) {
		Event_EntityDamagedByEntity.res_main = plugin;
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
	static String debug = dgray + "[Res Debug]" + white + "";

	// �̺�Ʈ �ڵ鷯 ����: EntityDamagedByEntityEvent
	@EventHandler
	public static void onEntityDamaged(EntityDamageByEntityEvent event) {
		// ��ƼƼ ��ü ����
		Entity entity = event.getEntity();
		Entity enemy = event.getDamager();

		// ���� �������� �� �������� ����
		double dm_give = ((LivingEntity) entity).getLastDamage();
		double dm_take = event.getDamage();

		// ��ƼƼ�� ���� �� �÷��̾� �� ���
		if (entity instanceof Player) {
			// �÷��̾� ����
			Player player = (Player) entity;

			// ��ƼƼ �̸� ����
			String damager = entity.getName();
			String attacker = enemy.getName();

			player.sendMessage(prefix + yellow + damager + white + " (��)�� " + yellow + attacker + white + " ���� " 
					+ red + dm_give + white + " ��ŭ�� �������� �޾ҽ��ϴ�!" + gray + " {debug 1}");
		}
		// �ٸ� ���� �� ���
		else {
			// ��ƼƼ �̸� ����
			String damager = entity.getName();
			String attacker = enemy.getName();

			((Player) enemy).sendMessage(prefix + yellow + attacker + white + " (��)�� " + yellow + damager + white + " ���� " + red
					+ dm_take + white + " ��ŭ�� �������� �־����ϴ�!" + gray + " {debug 2}");
		}
	}
}
