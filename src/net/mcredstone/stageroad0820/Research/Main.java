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
	// �÷����ο� �ʿ��� ��ü ���� �� �ʱ�ȭ
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;

	// IO ��Ʈ��
	public FileConfiguration config = YamlConfiguration.loadConfiguration(new File("config.yml"));

	// �ʿ��� ���� ���� �� �ʱ�ȭ
	public int build_no = 1;
	int error_count = 0;
	boolean hasConfig = true;

	// plugin.yml ���� �޾ƿ��� ��ü�� �÷����� ������ ��ü
	PluginDescriptionFile pdfFile = this.getDescription();
	PluginManager pm = Bukkit.getServer().getPluginManager();

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

	public static String nts = ChatColor.GOLD + "" + ChatColor.BOLD + "[Res Notice]" + ChatColor.WHITE + " ";

	public String rel_type = "BETA";

	public String pname = pdfFile.getName() + "";
	public String pver = pdfFile.getVersion() + "";
	public String pauth = pdfFile.getAuthors() + "";

	public String fname = pdfFile.getName() + " v" + pdfFile.getVersion();

	@Override
	public void onEnable() {
		console(white + "=================================================================================");
		console(prefix + "�÷������� ����ϱ� ���� �ʱ�ȭ �ϰ� �ֽ��ϴ�. ��ø� ��ٷ� �ּ���...");
		console(white + "=================================================================================");

		// config.yml �ҷ�����
		try {
			saveDefaultConfig();
			console(prefix + "config.yml ������ �⺻ ������ �ҷ��Խ��ϴ�.");
			
			getConfig().options().copyDefaults(true);
			console(prefix + yellow + getDataFolder().toString() + white + " ��ġ�� config.yml ������ �����Ͽ����ϴ�.");
		} catch (Exception e1) {
			e1.printStackTrace();
			console(error + "config.yml ���Ͽ� ������ �־� �ҷ����� ���߽��ϴ�.");
			hasConfig = false;
		}

		/*
		 * �̺�Ʈ ���: 4
		 * 
		 * Ŀ�ǵ� ���: 1
		 * 
		 * �޹̼� ���: 0
		 * 
		 * ���չ� ���: 1
		 * 
		 * �ٸ� Ŭ���� ����: 0
		 */

		// ���� Ŀ�ǵ� ���
		try {
			getCommand("res").setExecutor(new MainCommand(this));
			getCommand("research").setExecutor(new MainCommand(this));
			console(prefix + "��ɾ� '/res ��  /research (MainCommand.java)' (��)�� ���������� ����Ͽ����ϴ�. ");
		} catch (Exception e) {
			e.printStackTrace();
			console(error + "���� ���� ������ ��ɾ� '/res �� /research (MainCommand.java)' (��)�� ������� ���߽��ϴ�.");
			error_count++;
		}

		// config.yml ���� �б�
		if (hasConfig == true) {
			console(prefix + "config.yml ������ ���������� �ε� �Ǿ����Ƿ� ������ �Էµ� ������ �ʱ�ȭ�� �����մϴ�.");
			// config.yml �� "auto-register.enable" �׸��� true �� ���
			if(getConfig().getBoolean("auto-register.enable") == true) {
				// �̺�Ʈ ���: config.yml ������ "auto-register.event.enable" �׸��� true �� ���
				if (getConfig().getBoolean("auto-register.events.enable") == true) {
					// PlayerJoinEvent Ȱ��ȭ ���°� true �� ���
					if (getConfig().getBoolean("auto-register.events.Event_PlayerJoin.uses") == true) {
						// �̺�Ʈ ����: PlayerJoinEvent (Event_PlayerJoin.java)
						try {
							pm.registerEvents(new Event_PlayerJoin(this), this);
							getConfig().set("auto-register.events.Event_PlayerJoin.enabled", true);
							console(prefix + "�̺�Ʈ 'PlayerJoinEvent (Event_PlayerJoin.java)' (��)�� ���������� ����Ͽ����ϴ�.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.Event_PlayerJoin.enabled", false);
							console(error + "���� ���� ������ �̺�Ʈ 'PlayerJoinEvent (Event_PlayerJoin.java)' (��)�� ������� ���߽��ϴ�.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.Event_PlayerJoin.enabled", false);
						console(prefix + "�÷����� ������ ���� �̺�Ʈ PlayerJoinEvent (Event_PlayerJoin.java) (��)�� ������� �ʽ��ϴ�.");
					}

					// InventoryClickEvent (SE_Event_Main.java) Ȱ��ȭ ���°� true �� ���
					if (getConfig().getBoolean("auto-register.events.SE_Event_Main.uses") == true) {
						// �̺�Ʈ ����: InventoryClickEvent (SE_Event_Main.java)
						try {
							pm.registerEvents(new SE_Event_Main(this), this);
							getConfig().set("auto-register.events.SE_Event_Main.enabled", true);
							console(prefix + "�̺�Ʈ 'InventoryClickEvent (SE_Event_Main.java)' (��)�� ���������� ����Ͽ����ϴ�.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.SE_Event_Main.enabled", false);
							console(error + "���� ���� ������ �̺�Ʈ 'InventoryClickEvent (SE_Event_Main.java)' (��)�� ������� ���߽��ϴ�.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.SE_Event_Main.enabled", false);
						console(prefix + "�÷����� ������ ���� �̺�Ʈ InventoryClickEvent (SE_Event_Main.java) (��)�� ������� �ʽ��ϴ�.");
					}

					// InventoryClickEvent (Event_GUI_Test.java) Ȱ��ȭ ���°� true �� ���
					if (getConfig().getBoolean("auto-register.events.Event_GUI_Test.uses") == true) {
						// �̺�Ʈ ����: InventoryClickEvent (Event_GUI_Test.java)
						try {
							pm.registerEvents(new Event_GUI_Test(this), this);
							getConfig().set("auto-register.events.Event_GUI_Test.enabled", true);
							console(prefix + "�̺�Ʈ 'InventoryClickEvent (Event_GUI_Test.java)' (��)�� ���������� ����Ͽ����ϴ�.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.Event_GUI_Test.enabled", false);
							console(error + "���� ���� ������ �̺�Ʈ 'InventoryClickEvent (Event_GUI_Test.java)' (��)�� ������� ���߽��ϴ�.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.Event_GUI_Test.enabled", false);
						console(prefix + "�÷����� ������ ���� �̺�Ʈ InventoryClickEvent (Event_GUI_Test.java) (��)�� ������� �ʽ��ϴ�.");
					}

					// InventoryClickEvent (SE_Event_Passive.java) Ȱ��ȭ ���°� true �� ���
					if (getConfig().getBoolean("auto-register.events.SE_Event_Passive.uses") == true) {
						// �̺�Ʈ ����: InventoryClickEvent (SE_Event_Passive.java)
						try {
							pm.registerEvents(new SE_Event_Passive(this), this);
							getConfig().set("auto-register.events.SE_Event_Passive.enabled", true);
							console(prefix + "�̺�Ʈ 'InventoryClickEvent (SE_Event_Passive.java)' (��)�� ���������� ����Ͽ����ϴ�.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.SE_Event_Passive.enabled", false);
							console(error + "���� ���� ������ �̺�Ʈ 'InventoryClickEvent (SE_Event_Passive.java)' (��)�� ������� ���߽��ϴ�.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.SE_Event_Passive.enabled", false);
						console(prefix + "�÷����� ������ ���� �̺�Ʈ InventoryClickEvent (SE_Event_Passive.java) (��)�� ������� �ʽ��ϴ�.");
					}
					
					// EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java) Ȱ��ȭ ���°� true �� ���
					if (getConfig().getBoolean("auto-register.events.Event_EntityDamagedByEntity.uses") == true) {
						// �̺�Ʈ ����: EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)
						try {
							pm.registerEvents(new Event_EntityDamagedByEntity(this), this);
							getConfig().set("auto-register.events.Event_EntityDamagedByEntity.enabled", true);
							console(prefix + "�̺�Ʈ 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' (��)�� ���������� ����Ͽ����ϴ�.");
						} catch (Exception e) {
							e.printStackTrace();
							getConfig().set("auto-register.events.Event_EntityDamagedByEnity.enabled", false);
							console(error + "���� ���� ������ �̺�Ʈ 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' (��)�� ������� ���߽��ϴ�.");
							error_count++;
						}
					} else {
						getConfig().set("auto-register.events.Event_EntityDamagedByEnity.enabled", false);
						console(prefix + "�÷����� ������ ���� �̺�Ʈ EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java) (��)�� ������� �ʽ��ϴ�.");
					}
				}

				// �̺�Ʈ ���: config.yml ������ "auto-register.event.enable" �׸��� false �� ���
				else if (getConfig().getBoolean("auto-register.events.enable") == false) {
					console(error + "config.yml ���� ���� �� 'auto-enable.enable' �� �׸��� false �� �Ǿ� �ֽ��ϴ�.");
					console(error + "�÷����� Ȱ��ȭ �� ��� �̺�Ʈ�� �ҷ����� �ʽ��ϴ�. ��ɾ ���� Ȱ��ȭ �ϼ���.");
				}

				// ���չ� ���: config.yml ������ "auto-register.recipes.enable" �׸��� true �� ���
				else if (getConfig().getBoolean("auto-register.recipes.enable") == true) {
					// COMMAND (TestRecipe.java) �� Ȱ��ȭ ���°� true �� ���
					if (getConfig().getBoolean("auto-register.recipes.TestRecipe.uses") == true) {
						// ���չ� ���: COMMAND ���չ� (TestRecipe.java)
						try {
							TestRecipe.createRecipe();
							getConfig().set("auto-register.recipes.TestRecipe.enabled", true);
							console(prefix + "���չ� 'COMMAND (TestRecipe.java)' (��)�� ���������� ����Ͽ����ϴ�.");
						} catch (Exception e) {
							e.printStackTrace();
							console(error + "���� ���� ������ ���չ� 'COMMAND (TestRecipe.java)' (��)�� ������� ���߽��ϴ�.");
							error_count++;
						}
					} else {
						console(prefix + "�÷����� ������ ���� ���չ� COMMAND (TestReipce.java) (��)�� ������� �ʽ��ϴ�.");
					}
				}
			}
			else {
				console(prefix + "config.yml ������ 'auto-register.enable' �� ���� false �̱� ������ Ȱ��ȭ�� �ƹ��͵� ������� �ʽ��ϴ�.");
			}
		}

		// config.yml ���� ���� ��
		else {
			console(prefix + "config.yml ������ �ε���� ���� ����� �⺻ ���·� �ʱ�ȭ�� �����մϴ�.");
			// �̺�Ʈ ����: PlayerJoinEvent (Event_PlayerJoin.java)
			try {
				pm.registerEvents(new Event_PlayerJoin(this), this);
				console(prefix + "�̺�Ʈ 'PlayerJoinEvent (Event_PlayerJoin.java)' (��)�� ���������� ����Ͽ����ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "���� ���� ������ �̺�Ʈ 'PlayerJoinEvent (Event_PlayerJoin.java)' (��)�� ������� ���߽��ϴ�.");
				error_count++;
			}

			// �̺�Ʈ ����: InventoryClickEvent (SE_Event_Main.java)
			try {
				pm.registerEvents(new SE_Event_Main(this), this);
				console(prefix + "�̺�Ʈ 'InventoryClickEvent (SE_Event_Main.java)' (��)�� ���������� ����Ͽ����ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "���� ���� ������ �̺�Ʈ 'InventoryClickEvent (SE_Event_Main.java)' (��)�� ������� ���߽��ϴ�.");
				error_count++;
			}

			// �̺�Ʈ ����: InventoryClickEvent (Event_GUI_Test.java)
			try {
				pm.registerEvents(new Event_GUI_Test(this), this);
				console(prefix + "�̺�Ʈ 'InventoryClickEvent (Event_GUI_Test.java)' (��)�� ���������� ����Ͽ����ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "���� ���� ������ �̺�Ʈ 'InventoryClickEvent (Event_GUI_Test.java)' (��)�� ������� ���߽��ϴ�.");
				error_count++;
			}

			// �̺�Ʈ ����: InventoryClickEvent (SE_Event_Passive.java)
			try {
				pm.registerEvents(new SE_Event_Passive(this), this);
				console(prefix + "�̺�Ʈ 'InventoryClickEvent (SE_Event_Passive.java)' (��)�� ���������� ����Ͽ����ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "���� ���� ������ �̺�Ʈ 'InventoryClickEvent (SE_Event_Passive.java)' (��)�� ������� ���߽��ϴ�.");
				error_count++;
			}

			// ���չ� ���: COMMAND ���չ� (TestRecipe.java)
			try {
				TestRecipe.createRecipe();
				console(prefix + "���չ� 'COMMAND (TestRecipe.java)' (��)�� ���������� ����Ͽ����ϴ�.");
			} catch (Exception e) {
				e.printStackTrace();
				console(error + "���� ���� ������ ���չ� 'COMMAND (TestRecipe.java)' (��)�� ������� ���߽��ϴ�.");
				error_count++;
			}
		}

		// ������ ���� ���
		if (error_count == 0) {
			console(white + "=================================================================================");
			console(prefix + yellow + fname + white + " (��)�� ���������� Ȱ��ȭ �Ǿ����ϴ�!");
			console(prefix + "Ȱ��ȭ ���� ������ �߻����� �ʾҽ��ϴ�.");
			console(white + "=================================================================================");
		}

		// ������ �߻����� ���
		else if (error_count > 0) {
			console(white + "=================================================================================");
			console(prefix + yellow + fname + white + " (��)�� Ȱ��ȭ �Ǿ����ϴ�! Ȱ��ȭ ����");
			console(prefix + red + "Ȱ��ȭ ���� " + yellow + error_count + red + " ���� Ŭ�������� ������ �߻��Ͽ����ϴ�.");
			console(white + "=================================================================================");
		}

		// �߻��� �� ���� �̺�Ʈ (Ȥ�� �𸣴ϱ�..)
		else {
			console(white + "=================================================================================");
			console(prefix + yellow + fname + white + " (��)�� Ȱ��ȭ �Ǿ����ϴ�!" + red + " �� �� ���� ������ �߻��Ͽ����ϴ�.");
			console(white + "=================================================================================");
		}

		super.onEnable();
	}

	@Override
	public void onDisable() {
		console(white + "=================================================================================");
		console(prefix + "�÷����� ��Ȱ��ȭ�� �غ��ϴ� �� �Դϴ�...");
		console(white + "=================================================================================");

		/*
		 * �޹̼� ����: 0
		 * 
		 * ���չ� ����: 1
		 * 
		 * �ٸ� Ŭ���� ���� ����: 0
		 * 
		 * config.yml ����
		 */
		
		// COMMAND ���չ� ����
		try {
			Bukkit.clearRecipes();
			console(prefix + "���չ� 'COMMAND (TestRecipe.java)' (��)�� ���������� �����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
			console(error + "Ư�� ���չ� 'COMMAND (TestRecipe.java)' (��)�� �������� ���߽��ϴ�. ��� ���չ��� ������ �����մϴ�.");
			Bukkit.clearRecipes();
			console(warning + "�⺻ ���չ��� ������ �÷��������� ������ ��� ���չ��� ������ �����Ǿ����ϴ�.");
		}
		
		try {
			saveConfig();
			console(prefix + "config.yml ������ ���������� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
			console(error + "���� ���� ������ ���� config.yml ������ ������� ���߽��ϴ�.");
		}

		// ���� �޼��� ���
		console(white + "=================================================================================");
		console(prefix + yellow + fname + white + " (��)�� ���������� ��Ȱ��ȭ �Ǿ����ϴ�!");
		console(prefix + "�� �÷������� ����� �ּż� �����մϴ�!");
		console(prefix + "���� " + rel_type + " �����̹Ƿ� GitHub ���� �ҽ��ڵ带 Ȯ���Ͻ� �� �ֽ��ϴ�!");
		console(prefix + "��ũ: " + aqua + "https://github.com/stageroad0820/Research");
		console(white + "=================================================================================");
		console(prefix + "���۱�: Copyright (C) stageroad0820. All right reserved.");
		console(prefix + "���̼���: GNU GPLv3 License");
		console(white + "=================================================================================\n\n");

		super.onDisable();
	}

	// �ܼ� �޼��� ��� �޼ҵ�
	public static void console(String msg) {
		Bukkit.getConsoleSender().sendMessage(msg);
	}

	// �� ���� ���� �޼��� ��� �޼ҵ�
	public static void notice(String args) {
		Bukkit.broadcastMessage(nts + args);
	}
}
