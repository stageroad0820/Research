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
	// 클래스에 필요한 객체 생성 및 초기화
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;
	
	// 메인 클래스와 연결
	public SE_GUI_Main(Main plugin) {
		SE_GUI_Main.res_main = plugin;
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
	
	// GUI 창 생성 - 메인화면
	public static void openInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "엔티티를 선택하세요");
		
		// 엔티티 종류 : 전체 엔티티 목록 (아이콘: 책과 깃펜)
		ItemStack is_allMob = new ItemStack(Material.BOOK_AND_QUILL);
		ItemMeta im_allMob = is_allMob.getItemMeta();
		
		im_allMob.setDisplayName(gold + "전체 엔티티 목록");
		
		im_allMob.setLore(Arrays.asList(gray + "마인크래프트에서 엔티티(Entity)로 처리하는 모든 객체들의 목록을 표시합니다."));
		
		is_allMob.setItemMeta(im_allMob);
		
		// 엔티티 종류 : 친화적 몹 (아이콘: 흰색 양털)
		ItemStack is_psMob = new ItemStack(Material.WOOL);
		ItemMeta im_psMob = is_psMob.getItemMeta();
		
		im_psMob.setDisplayName(aqua + "친화적 몹");
		
		im_psMob.setLore(Arrays.asList(gray + "친화적 몹은 플레이어를 공격하지도 않고, 플레이어가 공겨하면 도망가는 몹의 종류입니다."
				, "", blue + "종류: 박쥐, 닭, 소, 무쉬룸 (버섯소), 돼지, 토끼, 양, 스켈레톤 말, 오징어, 주민"));
		
		is_psMob.setItemMeta(im_psMob);
		
		// 엔티티 종류 : 중립적 몹 (아이콘: 방패)
		ItemStack is_ntMob = new ItemStack(Material.SHIELD);
		ItemMeta im_ntMob = is_ntMob.getItemMeta();
		
		im_ntMob.setDisplayName(green + "중립적 몹");
		
		im_ntMob.setLore(Arrays.asList(gray + "중립적 몹은 플레이어가 먼저 공격하기 전까지 플레이어를 공격하지 않는 몹의 종류입니다."
				, "", blue + "종류: 거미, 동굴 거미 (지상), 엔더맨, " + red + "북극곰 (1.12) " + blue + ", 돼지 좀비"));
		
		is_ntMob.setItemMeta(im_ntMob);
		
		// 엔티티 종류: 적대적 몹 (아이콘: 다이아몬드 칼)
		ItemStack is_hsMob = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta im_hsMob = is_hsMob.getItemMeta();
		
		im_hsMob.setDisplayName(red + "적대적 몹");
		
		im_hsMob.setLore(Arrays.asList(gray + "적대적 몹은 자신의 시야에 들어온 플레이어를 먼저 공격하는 몹의 종류 입니다."
				, "", blue + "종류: 좀비, 스켈레톤, 스파이더 조키, 좀벌레, 크리퍼 외 19종"));
		
		is_hsMob.setItemMeta(im_hsMob);
		
		// 엔티티 종류: 길들이기 가능한 몹 (아이콘: 깃털)
		ItemStack is_tmMob = new ItemStack(Material.FEATHER);
		ItemMeta im_tmMob = is_tmMob.getItemMeta();
		
		im_tmMob.setDisplayName(yellow + "길들이기 가능한 몹");
		
		im_tmMob.setLore(Arrays.asList(gray + "길들이기 가능한 몹은 일정 아이템을 이용해 플레이어를 따르게 만들거나 교배를 시킬 수 있는 몹의 종류입니다."
				, "", blue + "종류: 당나귀, 말, " + red + "라마 (1.12)," + blue + " 노새, 오셀롯, " + red + "앵무새 (1.12)," + blue + " 늑대"));
		
		is_tmMob.setItemMeta(im_tmMob);
		
		// 엔티티 종류: 보스 몹 (아이콘: 엔더 드래곤의 알)
		ItemStack is_bsMob = new ItemStack(Material.DRAGON_EGG);
		ItemMeta im_bsMob = is_bsMob.getItemMeta();
		
		im_bsMob.setDisplayName(dred + bold + "보스 몹");
		
		im_bsMob.setLore(Arrays.asList(red + bold + "[ 위 험 ! ]", gray + "마인크래프트에 존재하는 보스 몹의 종류 입니다."
				, "", blue + "종류: 엔더 드래곤, 위더"));
		
		is_bsMob.setItemMeta(im_bsMob);
		
		// 엔티티 종류: 기타 몹 (아이콘: 커맨드 블럭)
		ItemStack is_cmdMob = new ItemStack(Material.COMMAND);
		ItemMeta im_cmdMob = is_cmdMob.getItemMeta();
		
		im_cmdMob.setDisplayName(white + "기타 몹");
		
		im_cmdMob.setLore(Arrays.asList(gray + "일반적인 방법으로 소환되지 않거나 직접 스폰하는 몹들의 종류 입니다."
				, "", blue + "종류: 자이언트, 살인 토끼, 좀비 말, 환술사, 철 골램, 눈사람"));
		
		is_cmdMob.setItemMeta(im_cmdMob);
		
		// 유리판
		ItemStack is_wall = new ItemStack(Material.THIN_GLASS);
		ItemMeta im_wall = is_wall.getItemMeta();
		
		im_wall.setDisplayName(" ");
		
		is_wall.setItemMeta(im_wall);
		
		/* 아이템 설치
		 * 
		 * 0 0 0 0 0 0 0 0 0
		 * 0 * * * 1 * * * 0
		 * 0 * * * * * * * 0
		 * 0 * 2 * 3 * 4 * 0
		 * 0 * 5 * 6 * 7 * 0
		 * 0 0 0 0 0 0 0 0 0
		 * 
		 * 0 : 유리판 / 1 : 전체 엔티티 / 2 : 친화 / 3 : 중립 / 4 : 적대 / 5 : 길들이기 / 6 : 보스 / 7 : 기타 / * : 빈칸
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
