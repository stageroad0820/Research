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

	// 변수 선언 및 초기화
	static int now_page = 1;
	static int max_page = 1;
	
	// GUI 창 생성 - 친화적 몹
	public static void openInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "엔티티를 선택하세요 - 친화적 몹");

		// 엔티티: 박쥐 (아이콘: 박쥐 스폰 알)
		ItemStack is_bat = new ItemStack(Material.MONSTER_EGG);
		SpawnEggMeta sm_bat = (SpawnEggMeta) is_bat.getItemMeta();

		sm_bat.setDisplayName(aqua + "소환: 박쥐");

		sm_bat.setLore(Arrays.asList(gray + "'엔티티 소환용 블레이즈 막대' 에 '박쥐' 소환 명령을 입력합니다.",
				"블레이즈 막대를 소환하고 싶은 곳을 바라보고 좌클릭 하면 소환됩니다.", "", blue + "종류: 친화적 몹", blue + "제한: 없음"));

		sm_bat.setSpawnedType(EntityType.BAT);

		is_bat.setItemMeta(sm_bat);

		// 엔티티: 닭 (아이콘: 닭 스폰 알)
		ItemStack is_chicken = new ItemStack(Material.MONSTER_EGG);
		SpawnEggMeta sm_chicken = (SpawnEggMeta) is_chicken.getItemMeta();

		sm_chicken.setDisplayName(aqua + "소환: 닭");

		sm_chicken.setLore(Arrays.asList(gray + "'엔티티 소환용 블레이즈 막대' 에 '닭' 소환 명령을 입력합니다.",
				"블레이즈 막대를 소환하고 싶은 곳을 바라보고 좌클릭하면 소환됩니다.", "", blue + "종류: 친화적 몹", blue + "제한: 없음"));

		sm_chicken.setSpawnedType(EntityType.CHICKEN);

		is_chicken.setItemMeta(sm_chicken);

		// 엔티티: 소 (아이콘: 소 스폰 알)
		ItemStack is_cow = new ItemStack(Material.MONSTER_EGG);
		SpawnEggMeta sm_cow = (SpawnEggMeta) is_cow.getItemMeta();

		sm_cow.setDisplayName(aqua + "소환: 소");

		sm_cow.setLore(Arrays.asList(gray + "'엔티티 소환용 블레이즈 막대' 에 '소' 소환 명령을 입력합니다.",
				"블레이즈 막대를 소환하고 싶은 곳을 바라보고 좌클릭하면 소환 됩니다.", "", blue + "종류: 친화적 몹", blue + "제한: 없음"));

		sm_cow.setSpawnedType(EntityType.COW);

		is_cow.setItemMeta(sm_cow);

		/* 설치할 아이템 종류
		 * 
		 * v 박쥐
		 * v 닭
		 * v 소
		 * 무쉬룸
		 * 토끼
		 * 돼지
		 * 양
		 * 스켈레톤 말
		 * 오징어
		 * 주민
		 * 
		 * v 유리판
		 * v 이전 페이지
		 * v 현재 페이지
		 * v 다음 페이지
		 * v 상위 메뉴로 돌아가기
		 */
		
		// 유리판
		ItemStack is_wall = new ItemStack(Material.THIN_GLASS);
		ItemMeta im_wall = is_wall.getItemMeta();

		im_wall.setDisplayName(" ");

		is_wall.setItemMeta(im_wall);

		// 다음 페이지
		ItemStack is_nextp = new ItemStack(Material.RAILS);
		ItemMeta im_nextp = is_nextp.getItemMeta();

		im_nextp.setDisplayName(white + "다음 페이지");

		im_nextp.setLore(Arrays.asList(gray + "다음 페이지로 이동합니다."));

		is_nextp.setItemMeta(im_nextp);

		// 이전 페이지
		ItemStack is_prevp = new ItemStack(Material.LADDER);
		ItemMeta im_prevp = is_nextp.getItemMeta();

		im_prevp.setDisplayName(white + "이전 페이지");

		im_prevp.setLore(Arrays.asList(gray + "이전 페이지로 이동합니다."));

		is_prevp.setItemMeta(im_prevp);

		// 현재 페이지
		ItemStack is_page = new ItemStack(Material.BOOK);
		ItemMeta im_page = is_page.getItemMeta();

		im_page.setDisplayName(white + "현재 페이지: " + now_page + " 중 " + max_page + " 페이지");

		is_page.setItemMeta(im_page);
		
		// 상위 메뉴로 돌아가기
		ItemStack is_return = new ItemStack(Material.SIGN);
		ItemMeta im_return = is_return.getItemMeta();
		
		im_return.setDisplayName(green + "상위 메뉴로 돌아가기");
		
		im_return.setLore(Arrays.asList(gray + "엔티티 종류 선택화면으로 돌아갑니다."));
		
		is_return.setItemMeta(im_return);

		/* 아이템 설치
		 * 
		 * 0 0 0 0 0 0 0 0 0
		 * 0 1 2 3 4 5 6 7 0
		 * 0 8 9 & * * * * 0
		 * 0 * * * * * * * 0
		 * 0 * * * * * * * 0
		 * 0 0 0 < | > 0 0 E
		 * 
		 * 0: 유리판 / 1: 박쥐 / 2: 닭 / 3: 소 / 4: 무쉬룸 / 5: 토끼 / 6: 돼지 / 7: 양
		 * 8: 스켈레톤 말 / 9: 오징어 / &: 주민 / *: 빈칸 / <: 이전 페이지 / |: 현재 페이지 / >: 다음 페이지 / E: 상위 메뉴로 돌아가기
		 */
		
		inv.setItem(53, is_return);
		
		player.openInventory(inv);
	}
}
