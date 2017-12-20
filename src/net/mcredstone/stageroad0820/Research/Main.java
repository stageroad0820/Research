package net.mcredstone.stageroad0820.Research;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.mcredstone.stageroad0820.Research.Commands.MainCommand;
import net.mcredstone.stageroad0820.Research.Events.Event_PlayerJoin;
import net.mcredstone.stageroad0820.Research.Events.Entities.Event_EntityDamagedByEntity;
import net.mcredstone.stageroad0820.Research.Events.GUIs.Event_GUI_Test;
import net.mcredstone.stageroad0820.Research.Events.GUIs.SelectEntities.SE_Event_Main;
import net.mcredstone.stageroad0820.Research.Events.GUIs.SelectEntities.SE_Event_Passive;
import net.mcredstone.stageroad0820.Research.Recipes.TestRecipe;

public class Main extends JavaPlugin {
	// 플러그인에 필요한 객체 선언 및 초기화
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;

	// IO 스트림
	public FileConfiguration config = YamlConfiguration.loadConfiguration(new File("config.yml"));

	// 필요한 변수 선언 및 초기화
	public int build_no = 1;
	int error_count = 0;
	boolean hasConfig = true;

	// plugin.yml 파일 받아오는 객체와 플러그인 관리자 객체
	PluginDescriptionFile pdfFile = this.getDescription();
	PluginManager pm = Bukkit.getServer().getPluginManager();

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

	public static String nts = ChatColor.GOLD + "" + ChatColor.BOLD + "[Res Notice]" + ChatColor.WHITE + " ";

	public String rel_type = "BETA";

	public String pname = pdfFile.getName() + "";
	public String pver = pdfFile.getVersion() + "";
	public String pauth = pdfFile.getAuthors() + "";

	public String fname = pdfFile.getName() + " v" + pdfFile.getVersion();

	@Override
	public void onEnable() {
		console(white + "=================================================================================");
		console(prefix + "플러그인을 사용하기 위해 초기화 하고 있습니다. 잠시만 기다려 주세요...");
		console(white + "=================================================================================");

		// config.yml 불러오기
		try {
			saveDefaultConfig();
			console(prefix + "config.yml 파일의 기본 내용을 불러왔습니다.");
			
			getConfig().options().copyDefaults(true);
			console(prefix + yellow + getDataFolder().toString() + white + " 위치에 config.yml 파일을 생성하였습니다.");
		} catch (Exception e1) {
			e1.printStackTrace();
			console(error + "config.yml 파일에 문제가 있어 불러오지 못했습니다.");
			hasConfig = false;
		}

		/*
		 * 이벤트 등록: 4
		 * 
		 * 커맨드 등록: 1
		 * 
		 * 펄미션 등록: 0
		 * 
		 * 조합법 등록: 1
		 * 
		 * 다른 클래스 연결: 0
		 */

		// 메인 커맨드 등록
		try {
			getCommand("res").setExecutor(new MainCommand(this));
			getCommand("research").setExecutor(new MainCommand(this));
			console(prefix + "명령어 '/res 및  /research (MainCommand.java)' (을)를 성공적으로 등록하였습니다. ");
		} catch (Exception e) {
			e.printStackTrace();
			console(error + "위와 같은 문제로 명령어 '/res 및 /research (MainCommand.java)' (을)를 등록하지 못했습니다.");
			error_count++;
		}

		// config.yml 정상 읽기
		if (hasConfig == true) {
			console(prefix + "config.yml 파일이 정상적으로 로드 되었으므로 설정에 입력된 내용대로 초기화를 진행합니다.");
			// config.yml 의 "auto-register.enable" 항목이 true 일 경우
			if(getConfig().getBoolean("auto-register.enable") == true) {
				// 이벤트 등록: config.yml 파일의 "auto-register.event.enable" 항목이 true 일 경우
				if (getConfig().getBoolean("auto-register.events.enable") == true) {
					// PlayerJoinEvent 활성화 상태가 true 일 경우
					if (getConfig().getBoolean("auto-register.events.Event_PlayerJoin.uses") == true) {
						// 이벤트 연결: PlayerJoinEvent (Event_PlayerJoin.java)
						try {
							pm.registerEvents(new Event_PlayerJoin(this), this);
							getConfig().set("auto-register.events.Event_PlayerJoin.enabled", true);
							console(prefix + "이벤트 'PlayerJoinEvent (Event_PlayerJoin.java)' (을)를 성공적으로 등록하였습니다.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.Event_PlayerJoin.enabled", false);
							console(error + "위와 같은 문제로 이벤트 'PlayerJoinEvent (Event_PlayerJoin.java)' (을)를 등록하지 못했습니다.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.Event_PlayerJoin.enabled", false);
						console(prefix + "플러그인 설정에 따라 이벤트 PlayerJoinEvent (Event_PlayerJoin.java) (은)는 등록하지 않습니다.");
					}

					// InventoryClickEvent (SE_Event_Main.java) 활성화 상태가 true 일 경우
					if (getConfig().getBoolean("auto-register.events.SE_Event_Main.uses") == true) {
						// 이벤트 연결: InventoryClickEvent (SE_Event_Main.java)
						try {
							pm.registerEvents(new SE_Event_Main(this), this);
							getConfig().set("auto-register.events.SE_Event_Main.enabled", true);
							console(prefix + "이벤트 'InventoryClickEvent (SE_Event_Main.java)' (을)를 성공적으로 등록하였습니다.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.SE_Event_Main.enabled", false);
							console(error + "위와 같은 문제로 이벤트 'InventoryClickEvent (SE_Event_Main.java)' (을)를 등록하지 못했습니다.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.SE_Event_Main.enabled", false);
						console(prefix + "플러그인 설정에 따라 이벤트 InventoryClickEvent (SE_Event_Main.java) (은)는 등록하지 않습니다.");
					}

					// InventoryClickEvent (Event_GUI_Test.java) 활성화 상태가 true 일 경우
					if (getConfig().getBoolean("auto-register.events.Event_GUI_Test.uses") == true) {
						// 이벤트 연결: InventoryClickEvent (Event_GUI_Test.java)
						try {
							pm.registerEvents(new Event_GUI_Test(this), this);
							getConfig().set("auto-register.events.Event_GUI_Test.enabled", true);
							console(prefix + "이벤트 'InventoryClickEvent (Event_GUI_Test.java)' (을)를 성공적으로 등록하였습니다.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.Event_GUI_Test.enabled", false);
							console(error + "위와 같은 문제로 이벤트 'InventoryClickEvent (Event_GUI_Test.java)' (을)를 등록하지 못했습니다.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.Event_GUI_Test.enabled", false);
						console(prefix + "플러그인 설정에 따라 이벤트 InventoryClickEvent (Event_GUI_Test.java) (은)는 등록하지 않습니다.");
					}

					// InventoryClickEvent (SE_Event_Passive.java) 활성화 상태가 true 일 경우
					if (getConfig().getBoolean("auto-register.events.SE_Event_Passive.uses") == true) {
						// 이벤트 연결: InventoryClickEvent (SE_Event_Passive.java)
						try {
							pm.registerEvents(new SE_Event_Passive(this), this);
							getConfig().set("auto-register.events.SE_Event_Passive.enabled", true);
							console(prefix + "이벤트 'InventoryClickEvent (SE_Event_Passive.java)' (을)를 성공적으로 등록하였습니다.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.SE_Event_Passive.enabled", false);
							console(error + "위와 같은 문제로 이벤트 'InventoryClickEvent (SE_Event_Passive.java)' (을)를 등록하지 못했습니다.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.SE_Event_Passive.enabled", false);
						console(prefix + "플러그인 설정에 따라 이벤트 InventoryClickEvent (SE_Event_Passive.java) (은)는 등록하지 않습니다.");
					}
					
					// EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java) 활성화 상태가 true 일 경우
					if (getConfig().getBoolean("auto-register.events.Event_EntityDamagedByEntity.uses") == true) {
						// 이벤트 연결: EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)
						try {
							pm.registerEvents(new Event_EntityDamagedByEntity(this), this);
							getConfig().set("auto-register.events.Event_EntityDamagedByEntity.enabled", true);
							console(prefix + "이벤트 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' (을)를 성공적으로 등록하였습니다.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.Event_EntityDamagedByEnity.enabled", false);
							console(error + "위와 같은 문제로 이벤트 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' (을)를 등록하지 못했습니다.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.Event_EntityDamagedByEnity.enabled", false);
						console(prefix + "플러그인 설정에 따라 이벤트 EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java) (은)는 등록하지 않습니다.");
					}
				}

				// 이벤트 등록: config.yml 파일의 "auto-register.event.enable" 항목이 false 일 경우
				else if (getConfig().getBoolean("auto-register.events.enable") == false) {
					console(error + "config.yml 파일 설정 중 'auto-enable.enable' 의 항목이 false 로 되어 있습니다.");
					console(error + "플러그인 활성화 중 모든 이벤트를 불러오지 않습니다. 명령어를 통해 활성화 하세요.");
				}

				// 조합법 등록: config.yml 파일의 "auto-register.recipes.enable" 항목이 true 일 경우
				else if (getConfig().getBoolean("auto-register.recipes.enable") == true) {
					// COMMAND (TestRecipe.java) 의 활성화 상태가 true 일 경우
					if (getConfig().getBoolean("auto-register.recipes.TestRecipe.uses") == true) {
						// 조합법 등록: COMMAND 조합법 (TestRecipe.java)
						try {
							TestRecipe.createRecipe();
							getConfig().set("auto-register.recipes.TestRecipe.enabled", true);
							console(prefix + "조합법 'COMMAND (TestRecipe.java)' (을)를 성공적으로 등록하였습니다.");
						} catch (Exception e) {
							e.printStackTrace();
							console(error + "위와 같은 문제로 조합법 'COMMAND (TestRecipe.java)' (을)를 등록하지 못했습니다.");
							error_count++;
						}
					} else {
						console(prefix + "플러그인 설정에 따라 조합법 COMMAND (TestReipce.java) (은)는 등록하지 않습니다.");
					}
				}
			}
			else {
				console(prefix + "config.yml 파일의 'auto-register.enable' 의 값이 false 이기 때문에 활성화시 아무것도 등록하지 않습니다.");
			}
		}

		// config.yml 파일 에러 시
		else {
			console(prefix + "config.yml 파일이 로드되지 않은 관계로 기본 상태로 초기화를 진행합니다.");
			// 이벤트 연결: PlayerJoinEvent (Event_PlayerJoin.java)
			try {
				pm.registerEvents(new Event_PlayerJoin(this), this);
				console(prefix + "이벤트 'PlayerJoinEvent (Event_PlayerJoin.java)' (을)를 성공적으로 등록하였습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "위와 같은 문제로 이벤트 'PlayerJoinEvent (Event_PlayerJoin.java)' (을)를 등록하지 못했습니다.");
				error_count++;
			}

			// 이벤트 연결: InventoryClickEvent (SE_Event_Main.java)
			try {
				pm.registerEvents(new SE_Event_Main(this), this);
				console(prefix + "이벤트 'InventoryClickEvent (SE_Event_Main.java)' (을)를 성공적으로 등록하였습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "위와 같은 문제로 이벤트 'InventoryClickEvent (SE_Event_Main.java)' (을)를 등록하지 못했습니다.");
				error_count++;
			}

			// 이벤트 연결: InventoryClickEvent (Event_GUI_Test.java)
			try {
				pm.registerEvents(new Event_GUI_Test(this), this);
				console(prefix + "이벤트 'InventoryClickEvent (Event_GUI_Test.java)' (을)를 성공적으로 등록하였습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "위와 같은 문제로 이벤트 'InventoryClickEvent (Event_GUI_Test.java)' (을)를 등록하지 못했습니다.");
				error_count++;
			}

			// 이벤트 연결: InventoryClickEvent (SE_Event_Passive.java)
			try {
				pm.registerEvents(new SE_Event_Passive(this), this);
				console(prefix + "이벤트 'InventoryClickEvent (SE_Event_Passive.java)' (을)를 성공적으로 등록하였습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "위와 같은 문제로 이벤트 'InventoryClickEvent (SE_Event_Passive.java)' (을)를 등록하지 못했습니다.");
				error_count++;
			}

			// 조합법 등록: COMMAND 조합법 (TestRecipe.java)
			try {
				TestRecipe.createRecipe();
				console(prefix + "조합법 'COMMAND (TestRecipe.java)' (을)를 성공적으로 등록하였습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "위와 같은 문제로 조합법 'COMMAND (TestRecipe.java)' (을)를 등록하지 못했습니다.");
				error_count++;
			}
		}

		// 에러가 없을 경우
		if (error_count == 0) {
			console(white + "=================================================================================");
			console(prefix + yellow + fname + white + " (이)가 성공적으로 활성화 되었습니다!");
			console(prefix + "활성화 도중 오류가 발생하지 않았습니다.");
			console(white + "=================================================================================");
		}

		// 에러가 발생했을 경우
		else if (error_count > 0) {
			console(white + "=================================================================================");
			console(prefix + yellow + fname + white + " (이)가 활성화 되었습니다! 활성화 도중");
			console(prefix + red + "활성화 도중 " + yellow + error_count + red + " 개의 클래스에서 오류가 발생하였습니다.");
			console(white + "=================================================================================");
		}

		// 발생할 수 없는 이벤트 (혹시 모르니까..)
		else {
			console(white + "=================================================================================");
			console(prefix + yellow + fname + white + " (이)가 활성화 되었습니다!" + red + " 알 수 없는 오류가 발생하였습니다.");
			console(white + "=================================================================================");
		}

		super.onEnable();
	}

	@Override
	public void onDisable() {
		console(white + "=================================================================================");
		console(prefix + "플러그인 비활성화를 준비하는 중 입니다...");
		console(white + "=================================================================================");

		/*
		 * 펄미션 해제: 0
		 * 
		 * 조합법 제거: 1
		 * 
		 * 다른 클래스 연결 해제: 0
		 * 
		 * config.yml 저장
		 */
		
		// COMMAND 조합법 해제
		try {
			Bukkit.clearRecipes();
			console(prefix + "조합법 'COMMAND (TestRecipe.java)' (이)가 성공적으로 해제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			console(error + "특정 조합법 'COMMAND (TestRecipe.java)' (을)를 해제하지 못했습니다. 모든 조합법을 강제로 해제합니다.");
			Bukkit.clearRecipes();
			console(warning + "기본 조합법을 제외한 플러그인으로 생성된 모든 조합법이 강제로 해제되었습니다.");
		}
		
		try {
			saveConfig();
			console(prefix + "config.yml 파일이 정상적으로 저장되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			console(error + "위와 같은 이유로 인해 config.yml 파일이 저장되지 못했습니다.");
		}

		// 종료 메세지 출력
		console(white + "=================================================================================");
		console(prefix + yellow + fname + white + " (이)가 성공적으로 비활성화 되었습니다!");
		console(prefix + "이 플러그인을 사용해 주셔서 감사합니다!");
		console(prefix + "현재 " + rel_type + " 버전이므로 GitHub 에서 소스코드를 확인하실 수 있습니다!");
		console(prefix + "링크: " + aqua + "https://github.com/stageroad0820/Research");
		console(white + "=================================================================================");
		console(prefix + "저작권: Copyright (C) stageroad0820. All right reserved.");
		console(prefix + "라이선스: GNU GPLv3 License");
		console(white + "=================================================================================\n\n");

		super.onDisable();
	}

	// 콘솔 메세지 출력 메소드
	public static void console(String msg) {
		Bukkit.getConsoleSender().sendMessage(msg);
	}

	// 전 서버 공지 메세지 출력 메소드
	public static void notice(String args) {
		Bukkit.broadcastMessage(nts + args);
	}
}
