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
	// 클래스에 필요한 객체 선언 및 생성
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	// 클래스 연결
	public Event_EntityDamagedByEntity(Main plugin) {
		Event_EntityDamagedByEntity.res_main = plugin;
	}

	// 플러그인 관리자 객체
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
	static String debug = dgray + "[Res Debug]" + white + "";

	// 이벤트 핸들러 생성: EntityDamagedByEntityEvent
	@EventHandler
	public static void onEntityDamaged(EntityDamageByEntityEvent event) {
		// 엔티티 객체 생성
		Entity entity = event.getEntity();
		Entity enemy = event.getDamager();

		// 받은 데미지와 준 데미지를 설정
		double dm_give = ((LivingEntity) entity).getLastDamage();
		double dm_take = event.getDamage();

		// 엔티티의 종류 중 플레이어 일 경우
		if (entity instanceof Player) {
			// 플레이어 설정
			Player player = (Player) entity;

			// 엔티티 이름 설정
			String damager = entity.getName();
			String attacker = enemy.getName();

			player.sendMessage(prefix + yellow + damager + white + " (이)가 " + yellow + attacker + white + " 에게 " 
					+ red + dm_give + white + " 만큼의 데미지를 받았습니다!" + gray + " {debug 1}");
		}
		// 다른 종류 일 경우
		else {
			// 엔티티 이름 설정
			String damager = entity.getName();
			String attacker = enemy.getName();

			((Player) enemy).sendMessage(prefix + yellow + attacker + white + " (이)가 " + yellow + damager + white + " 에게 " + red
					+ dm_take + white + " 만큼의 데미지를 주었습니다!" + gray + " {debug 2}");
		}
	}
}
