package net.mcredstone.stageroad0820.Research.Commands;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;

import com.mojang.authlib.GameProfile;

import net.mcredstone.stageroad0820.Research.Main;
import net.mcredstone.stageroad0820.Research.Enums.EnumTest;
import net.mcredstone.stageroad0820.Research.Events.Event_PlayerJoin;
import net.mcredstone.stageroad0820.Research.Events.Entities.Event_EntityDamagedByEntity;
import net.mcredstone.stageroad0820.Research.GUIs.GUI_Test;
import net.mcredstone.stageroad0820.Research.GUIs.SelectEntity.SE_GUI_Main;
import net.mcredstone.stageroad0820.Research.GUIs.SelectEntity.SE_GUI_Passive;
import net.minecraft.server.v1_11_R1.EntityPlayer;
import net.minecraft.server.v1_11_R1.PacketPlayOutNamedEntitySpawn;

@SuppressWarnings({ "static-access", "unused" })
public class MainCommand implements CommandExecutor {
	// Ŭ������ �ʿ��� ��ü ���� �� �ʱ�ȭ
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	// ���� Ŭ������ ����
	public MainCommand(Main plugin) {
		MainCommand.res_main = plugin;
	}

	// �÷����� ������ ��ü
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
	String debug = dgray + "[Res Debug]" + white + " ";

	String cleft = yellow + " : " + white + "";
	String vleft = green +" | " + aqua + "";

	// ���� ���� �� �ʱ�ȭ
	public static boolean isTest = false;
	public static boolean isDebug = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		// ��ɾ� �����ڰ� "�÷��̾�" �� ���
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Location loc = player.getLocation();

			// Ŀ�ǵ带 "/research" �� "/res" �� ��� �����ϰ� ����
			if (commandLabel.equalsIgnoreCase("research") || commandLabel.equalsIgnoreCase("res")) {
				// ���� Ŀ�ǵ� ���� ���� Ŀ�ǵ常 �Է����� ���
				if (args.length == 0) {
					player.sendMessage(error + "�Է��Ͻ� ��ɾ��� ���� ���� �ʹ� ���ų� �����ϴ�!" + yellow + " /res help �Ǵ� /research help "
							+ red + " �� ���� Research �÷������� �� ���� ��ɾ �˾ƺ�����!");
				}
				// ���� Ŀ�ǵ嵵 ���� �Է��� ���
				else {
					// Ŀ�ǵ� "/res help"
					if (args[0].equalsIgnoreCase("help")) {
						player.sendMessage(prefix + "��ɾ� ������: " + yellow + "�÷��̾�");
						player.sendMessage(green + "=-=-=-=-=-=-=-=-=-= Research �÷����� ��ɾ� : �÷��̾� =-=-=-=-=-=-=-=-=-=");
						player.sendMessage(gold + "< /res �� /research �� �Ʒ��� Ŀ�ǵ���� ����� �� �ֽ��ϴ�! >");
						player.sendMessage(green + "/res help" + cleft + "��ɾ� �����ڿ� ���� Research �÷������� ��ɾ� ������ ����մϴ�.");
						player.sendMessage(green + "/res enum <enum>" + cleft + "������(Enumation) �� �׽�Ʈ�� �����մϴ�.");
						player.sendMessage(
								green + "/res spawn <help/gui/entity>" + cleft + "��ƼƼ�� �÷��̾ �ٶ󺸴� ���⿡ ��ȯ�մϴ�.");
						player.sendMessage(green + "/res info" + cleft + "�÷������� ������ Ȯ���մϴ�.");
						player.sendMessage(
								green + "/res nickname <name/reset>" + cleft + "�÷��̾��� �̸��� �����մϴ�. reset ���� �ʱ�ȭ �մϴ�.");
						player.sendMessage(
								red + "/res nametag <name/reset>" + cleft + "�÷��̾��� �̸�ǥ�� �����մϴ�. reset ���� �ʱ�ȭ �մϴ�.");
						player.sendMessage(green + "/res test <help/...>" + cleft + "���� �ϼ����� ���� ��ɵ��� �׽�Ʈ �մϴ�.");
						player.sendMessage(
								green + "/res event <enable/disable> <class>" + cleft + "�÷������� �̺�Ʈ�� Ȱ��ȭ �ϰų� ��Ȱ��ȭ �մϴ�.");
						player.sendMessage(
								green + "=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}

					// Ŀ�ǵ� "/res enum <list>"
					else if (args[0].equalsIgnoreCase("enum")) {
						// <list> �κ��� �Է����� �ʾ��� ���
						if (args.length == 1) {
							player.sendMessage(error + "������ ����� �Էµ��� �ʾҽ��ϴ�! �Ʒ��� ������ ����� �����Ͽ� ��ɾ �ٽ� �Է��� �ּ���!");
							player.sendMessage(error + "APPLE, CHOCOLATE, RAMEN, RICE, CORN, SUGAR_CUBE");
						}
						// <list> �κ��� �Է����� ���
						else {
							for (EnumTest e : EnumTest.getFoods()) {
								if (args[1].equalsIgnoreCase(e.foodName)) {
									String str = e.healthy ? "�ǰ��� �����Դϴ�!" : "�ǰ����� ���� �����Դϴ�!";
									String fdName = "";

									switch (e.foodName) {
									case "apple":
										fdName = "���";
										break;
									case "chocolate":
										fdName = "���ݸ�";
										break;
									case "ramen":
										fdName = "���";
										break;
									case "rice":
										fdName = "��";
										break;
									case "corn":
										fdName = "������";
										break;
									case "sugar_cube":
										fdName = "������";
										break;
									default:
										break;
									}

									player.sendMessage(prefix + "EnumTest.class �� �׽�Ʈ�� ���������� ����Ǿ����ϴ�! ���: ");
									player.sendMessage(prefix + fdName + " (��)�� " + str);
									break;
								}
							}
						}
					}

					// Ŀ�ǵ� "/res spawn"
					else if (args[0].equalsIgnoreCase("spawn")) {
						// �߰� ��ɾ �Է����� ���� ���
						if (args.length == 1) {
							player.sendMessage(error + "�߰� ��ɾ �Էµ��� �ʾҽ��ϴ�. �߰� ��ɾ Ȯ���Ͻ÷���" + yellow + "/res spawn help"
									+ red + " �� �Է��ϼ���.");
						}
						// �Է��� ���
						else {
							// ����
							if (args[1].equalsIgnoreCase("help")) {
								player.sendMessage(
										green + "=-=-=-=-=-=-=-=-=- Research �÷����� - ��ƼƼ ��ɾ� ��� =-=-=-=-=-=-=-=-=-");
								player.sendMessage(green + "help" + cleft + "/res spawn �� �߰� ��ɾ Ȯ���մϴ�.");
								player.sendMessage(green + "entity <list [page]/[entity name]>" + cleft
										+ "�÷��̾ �ִ� ��ġ�� ��ƼƼ�� ���� ��ȯ�մϴ�.");
								player.sendMessage(
										green + "gui" + cleft + "GUI �� ���� ��ƼƼ�� ��ȯ�ϸ�, ���ϴ� ��ġ�� ��ȯ�� �� �ִ� ����⸦ �޽��ϴ�.");
								player.sendMessage(green
										+ "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
							}
							// ��ƼƼ ���� ��ȯ
							else if (args[1].equalsIgnoreCase("entity")) {
								// ��ƼƼ �̸��� �Է����� �ʾ��� ���
								if (args.length == 2) {
									player.sendMessage(error + "��ƼƼ �̸��� �Էµ��� �ʾҽ��ϴ�. ��ƼƼ ����� list �� �˾ƺ��� �� �ֽ��ϴ�.");
								}
								// �Է����� ���
								else {

								}
							}
							// GUI �� ���� ��ȯ
							else if (args[1].equalsIgnoreCase("gui")) {

							}
						}
					}

					// Ŀ�ǵ� "/res nickname <String>"
					else if (args[0].equalsIgnoreCase("nickname")) {
						// <String> �κ��� �Էµ��� �ʾ��� ���
						if (args.length == 1) {
							player.sendMessage(error + "������ �г����� �Էµ��� �ʾҽ��ϴ�. ������ �г����� Ŀ�ǵ�� ���� �Է��� �ּ���!");
						}

						// <String> �κ��� �Է����� ���
						else {
							// �÷��̾��� ���� �̸��� ����
							String realName = player.getName();

							// <String> �κ��� reset �� ���
							if (args[1].equals("reset")) {
								// �÷��̾��� �̸��� ������� �����ϰ� �ȳ��޼��� ���
								player.setDisplayName(realName);
								player.setPlayerListName(realName);
								player.sendMessage(prefix + "�÷��̾��� �̸��� ������� �����Ͽ����ϴ�.");
							}

							// <String> �κ��� reset �� �ƴ� ���
							else {
								// �÷��̾ �Է��� ���ڿ��� �÷��̾��� �г������� �����ϰ� �ȳ��޼��� ���
								player.setDisplayName(args[1]);
								player.setPlayerListName(args[1]);
								player.sendMessage(prefix + "�÷��̾��� �̸��� " + yellow + realName + white + " ���� " + yellow
										+ args[1] + white + " (��)�� ����Ǿ����ϴ�.");
							}
						}
					}

					// Ŀ�ǵ� "/res nametag <String>" - ��ɾ� ��Ȱ��ȭ
					else if (args[0].equalsIgnoreCase("nametag")) {
						player.sendMessage(error + "���� ���� �� ������ �߻��Ͽ� ��Ȱ��ȭ �� ��ɾ� �Դϴ�. �ٸ� ��ɾ �Է��� �ּ���!");

						// // <String> �κ��� �Էµ��� �ʾ��� ���
						// if (args.length == 1) {
						// player.sendMessage(error + "������ �г����� �Էµ��� �ʾҽ��ϴ�. ������ �г����� Ŀ�ǵ�� ���� �Է��� �ּ���!");
						// }
						//
						// // <String> �κ��� �Է����� ���
						// else {
						// String realName = player.getName();
						//
						// // <String> �κ��� reset �� ���
						// if (args[1].equals("reset")) {
						// player.setDisplayName(realName);
						// player.setPlayerListName(realName);
						//
						// EntityPlayer ep = ((CraftPlayer) player).getHandle();
						// ep.setCustomName(realName);
						// ep.setCustomNameVisible(true);
						//
						// player.setCustomName(realName);
						// player.setCustomNameVisible(true);
						//
						// GameProfile profile = ep.getProfile();
						//
						// try {
						// Field nome = profile.getClass().getDeclaredField("name");
						// nome.setAccessible(true);
						// nome.set(profile, realName);
						// } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						// | IllegalAccessException e) {
						// e.printStackTrace();
						// }
						//
						// player.sendMessage(prefix + "�÷��̾��� �̸��� ������� �����Ͽ����ϴ�.");
						// }
						//
						// else {
						// player.setDisplayName(args[1]);
						// player.setPlayerListName(args[1]);
						//
						// EntityPlayer ep = ((CraftPlayer) player).getHandle();
						// ep.setCustomName(args[1]);
						// ep.setCustomNameVisible(true);
						//
						// player.setCustomName(args[1]);
						// player.setCustomNameVisible(true);
						//
						// GameProfile profile = ep.getProfile();
						//
						// try {
						// Field nome = profile.getClass().getDeclaredField("name");
						// nome.setAccessible(true);
						// nome.set(profile, args[1]);
						// } catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						// | IllegalAccessException e) {
						// e.printStackTrace();
						// }
						//
						// player.sendMessage(prefix + "�÷��̾��� �̸��� " + yellow + realName + white + " ���� "
						// + yellow
						// + args[1] + white + " (��)�� ����Ǿ����ϴ�.");
						// }
						// }
					}

					// Ŀ�ǵ� "/res test <help/...>
					else if (args[0].equalsIgnoreCase("test")) {
						if (args.length == 1) {
							player.sendMessage(error + "Ŀ�ǵ尡 ����� �Էµ��� �ʾҽ��ϴ�!" + yellow + " /res test help " + red
									+ "�� ���� �׽�Ʈ �� ����� Ȯ���Ͻ� �� �ֽ��ϴ�.");
						}

						else {
							// �׽�Ʈ ��� ����
							if (args[1].equalsIgnoreCase("help")) {
								player.sendMessage(prefix + "���� ���� ���� ����� �׽�Ʈ �� �� �ִ� ��� �Դϴ�. /res test �� ���� ����ؾ� �մϴ�.");
								player.sendMessage(
										green + "=-=-=-=-=-=-=-=-=- Research �÷����� - �׽�Ʈ ��� =-=-=-=-=-=-=-=-=-");
								player.sendMessage(green + "gui" + cleft + "������ GUI �� �׽�Ʈ�մϴ�. (GUI â ����)");
								player.sendMessage(
										green + "cmd <cmds...>" + cleft + "GUI ���� �̺�Ʈ�� �۵��� ���� ���� �� Ŀ�ǵ�� �׽�Ʈ �մϴ�.");
								player.sendMessage(green + "exit" + cleft + "�׽�Ʈ�� �����ϴ�.");
								player.sendMessage(green
										+ "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
							}
							// GUI �׽�Ʈ ���
							else if (args[1].equalsIgnoreCase("gui")) {
								isTest = true;
								player.sendMessage(
										prefix + "GUI â �׽�Ʈ�� �����մϴ�. �׽�Ʈ�� �����Ͻ÷��� GUI â ���� ȭ�鿡�� '���� ��' �� Ŭ���ϼ���.");
								GUI_Test.openInv(player);
							}
							// ��ɾ� �׽�Ʈ ���
							else if (args[1].equalsIgnoreCase("cmd")) {
								if (args.length == 2) {
									player.sendMessage(
											green + "=-=-=-=-=-=-=-=- Research �÷����� - �׽�Ʈ ��� [��ɾ�] =-=-=-=-=-=-=-=-");
									player.sendMessage(green + "�⺻ ��ɾ�" + cleft + "��ɾ �׽�Ʈ �մϴ�.");
									player.sendMessage(green + "gui_test_main" + cleft + "GUI �׽�Ʈ ���� ȭ���� �����մϴ�.");
									player.sendMessage(green + "gui_entity_main" + cleft + "��ƼƼ ��ȯ GUI ���� ȭ���� �����մϴ�.");
									player.sendMessage(
											green + "gui_entity_passive" + cleft + "��ƼƼ ��ȯ GUI ģȭ�� �� ȭ���� �����մϴ�.");
									player.sendMessage(green
											+ "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
								} else {
									// GUI ���� ��ɾ� - GUI �׽�Ʈ
									if (args[2].equalsIgnoreCase("gui_test_main")) {
										GUI_Test.openInv(player);
										player.sendMessage(prefix
												+ "'Reseach �÷����� - GUI ��� �׽�Ʈ' ȭ���� �����մϴ�. ������ ���� ���� ��� �ܼ� â�� Ȯ���� �ּ���.");
									}
									// GUI ���� ��ɾ� - ��ƼƼ ��ȯ ���� ȭ��
									else if (args[2].equalsIgnoreCase("gui_entity_main")) {
										SE_GUI_Main.openInv(player);
										player.sendMessage(
												prefix + "'��ƼƼ�� �����ϼ���' ȭ���� �����մϴ�. ������ ���� ���� ��� �ܼ� â�� Ȯ���� �ּ���.");
									}
									// GUI ���� ��ɾ� - ��ƼƼ ��ȯ ���� ȭ�� _ ģȭ�� ��
									else if (args[2].equalsIgnoreCase("gui_entity_passive")) {
										SE_GUI_Passive.openInv(player);
										player.sendMessage(
												prefix + "'��ƼƼ�� �����ϼ��� - ģȭ�� ��' ȭ���� �����մϴ�. ������ ���� ���� ��� �ܼ� â�� Ȯ���� �ּ���.");
									}
									// �� �� ���� �׽�Ʈ
									else {
										player.sendMessage(error + "�� �� ���� �׽�Ʈ �̸� �Դϴ�. " + yellow + "/res test cmd"
												+ red + " �� �Է��� Ȯ���� ������.");
									}
								}
							}
						}
					}

					// Ŀ�ǵ� "/res debug <on/off>"
					else if (args[0].equalsIgnoreCase("debug")) {
						if (args.length == 1) {
							player.sendMessage(
									error + "����� ���� " + yellow + "/res debug <on/off>" + red + " �� �� �����մϴ�.");
							player.sendMessage(error + "���� ����� ��� ���´� " + green + "'" + isDebug + "'" + red + " �Դϴ�.");
						} else {
							// ����� ��� Ȱ��ȭ
							if (args[1].equalsIgnoreCase("on")) {
								// �̹� ����� ��尡 Ȱ��ȭ �Ǿ� �ִ� ��� ���� �޼��� ���
								if (isDebug == true) {
									player.sendMessage(error + "�̹� ����� ��尡 Ȱ��ȭ �� �����Դϴ�. ����� ��� ����� " + yellow + "off"
											+ red + " �� �� �� �ֽ��ϴ�.");
								}
								// ����� ��� Ȱ��ȭ
								else {
									isDebug = true;
									player.sendMessage(prefix + "����� ��尡 Ȱ��ȭ �Ǿ����ϴ�. �÷����ο��� �߻��ϴ� ��� �̺�Ʈ�� ä��â���� ��µ˴ϴ�.");
								}

							} else if (args[1].equalsIgnoreCase("off")) {
								// �̹� ����� ��尡 ��Ȱ��ȭ �Ǿ� �ִ� ��� ���� �޼��� ���
								if (isDebug == false) {
									player.sendMessage(error + "�̹� ����� ��尡 ��Ȱ��ȭ �� �����Դϴ�. ����� ��� Ȱ��ȭ�� " + yellow + "on"
											+ red + " ���� �� �� �ֽ��ϴ�.");
								}
								// ����� ��� ��Ȱ��ȭ
								else {
									isDebug = false;
									player.sendMessage(prefix + "����� ��尡 ��Ȱ��ȭ �Ǿ����ϴ�. �÷����ο��� �߻��ϴ� �Ϻ� �̺�Ʈ�� ä��â���� ��µ˴ϴ�.");
								}
							} else {
								player.sendMessage(
										error + "����� ���� " + yellow + "/res debug <on/off>" + red + " �� �� �����մϴ�.");
							}
						}
					}

					// Ŀ�ǵ� "/res event <enable/disable> <class>"
					else if (args[0].equalsIgnoreCase("event")) {
						// �߰� ��ɾ� �Է� �ȳ�
						if (args.length == 1) {
							player.sendMessage(error + "�̺�Ʈ Ȱ��ȭ ���� ���� ��ɾ�� �Ʒ��� ���� ��ɾ�� �̿��Ͻ� �� �ֽ��ϴ�.");
							player.sendMessage(error + yellow + "/res event <enable/disable/show [class]> <class>");
						} else {
							// �̺�Ʈ Ȱ��ȭ
							if (args[1].equalsIgnoreCase("enable")) {
								if (args.length == 2) {
									player.sendMessage(
											error + "�̺�Ʈ Ȱ��ȭ ���� ��ɾ ����ϱ� ���ؼ��� Ŭ���� �̸��� �ʿ��մϴ�. Ŭ���� �̸��� �Է��� �ּ���.");
								} else {
									if (args[2].equalsIgnoreCase("Event_PlayerJoin")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.Event_PlayerJoin.enabled") == true) {
											player.sendMessage(error + "�̹� Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {
											try {
												pm.registerEvents(new Event_PlayerJoin(res_main), res_main);
												res_main.notice(
														"�÷��̾� " + yellow + player.getName() + white + " �� ���� �̺�Ʈ"
																+ green + " 'PlayerJoinEvent (Event_PlayerJoin.java)' "
																+ white + "(��)�� Ȱ��ȭ �Ǿ����ϴ�.");
												res_main.getConfig()
														.set("auto-register.events.Event_PlayerJoin.enabled", true);
												try {
													res_main.saveConfig();
													res_main.console(debug + "config.yml ������ ��������� ����Ǿ����ϴ�.");
												} catch (Exception e) {
													e.printStackTrace();
													res_main.console(error + "config.yml ������ ��������� �����ϴ� ���� ������ �߻��Ͽ����ϴ�. Ȯ���� �ּ���.");
												}
											} catch (Exception e) {
												e.printStackTrace();
												res_main.notice("�÷��̾� " + yellow + player.getName() + white
														+ " (��)�� �̺�Ʈ" + green
														+ " 'PlayerJoinEvent (Event_PlayerJoin.java)' " + white
														+ " (��)�� Ȱ��ȭ ��Ű�� ������," + " ���ܰ� �߻��Ͽ� �������� ���߽��ϴ�.");
											}
										}
									}

									else if (args[2].equalsIgnoreCase("Event_GUI_Test")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.Event_GUI_Test.enabled") == true) {
											player.sendMessage(error + "�̹� Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("Event_EntityDamagedByEntity")) {
										if (res_main.getConfig().getBoolean(
												"auto-register.events.Event_EntityDamagedByEntity.enabled") == true) {
											player.sendMessage(error + "�̹� Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {
											try {
												pm.registerEvents(new Event_EntityDamagedByEntity(res_main), res_main);
												res_main.notice("�÷��̾� " + yellow + player.getName() + white
														+ " �� ���� �̺�Ʈ" + green
														+ " 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' "
														+ white + "(��)�� Ȱ��ȭ �Ǿ����ϴ�.");
												res_main.getConfig().set(
														"auto-register.events.Event_EntityDamagedByEntity.enabled",
														true);
												try {
													res_main.saveConfig();
													res_main.console(debug + "config.yml ������ ��������� ����Ǿ����ϴ�.");
												} catch (Exception e) {
													e.printStackTrace();
													res_main.console(error + "config.yml ������ ��������� �����ϴ� ���� ������ �߻��Ͽ����ϴ�. Ȯ���� �ּ���.");
												}
											} catch (Exception e) {
												e.printStackTrace();
												res_main.notice("�÷��̾� " + yellow + player.getName() + white
														+ " (��)�� �̺�Ʈ" + green
														+ " 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' "
														+ white + " (��)�� Ȱ��ȭ ��Ű�� ������, ���ܰ� �߻��Ͽ� �������� ���߽��ϴ�.");
											}
										}
									}

									else if (args[2].equalsIgnoreCase("SE_Event_Main")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.SE_Event_Main.enabled") == true) {
											player.sendMessage(error + "�̹� Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("SE_Event_Passive")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.SE_Event_Passive.enabled") == true) {
											player.sendMessage(error + "�̹� Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {

										}
									}

									else {
										player.sendMessage(error + "�߸��� Ŭ���� �̸��Դϴ�. Ŭ���� �̸��� Ȯ���� �� �ٽ� �õ��ϼ���!");
									}
								}
							}

							// �̺�Ʈ ��Ȱ��ȭ
							else if (args[1].equalsIgnoreCase("disable")) {
								if (args.length == 2) {
									player.sendMessage(
											error + "�̺�Ʈ Ȱ��ȭ ���� ��ɾ ����ϱ� ���ؼ��� Ŭ���� �̸��� �ʿ��մϴ�. Ŭ���� �̸��� �Է��� �ּ���.");
								} else {
									if (args[2].equalsIgnoreCase("Event_PlayerJoin")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.Event_PlayerJoin.enabled") == false) {
											player.sendMessage(error + "�̹� ��Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("Event_GUI_Test")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.Event_GUI_Test.enabled") == false) {
											player.sendMessage(error + "�̹� ��Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("Event_EntityDamagedByEntity")) {
										if (res_main.getConfig().getBoolean(
												"auto-register.events.Event_EntityDamagedByEntity.enabled") == false) {
											player.sendMessage(error + "�̹� ��Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {
											try {
												res_main.notice("�÷��̾� " + yellow + player.getName() + white
														+ " �� ���� �̺�Ʈ" + green
														+ " 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' " + white
														+ "(��)�� ��Ȱ��ȭ �Ǿ����ϴ�.");
												res_main.getConfig()
														.set("auto-register.events.Event_EntityDamagedByEntity.enabled", false);
												
												try {
													res_main.saveConfig();
													res_main.console(debug + "config.yml ������ ��������� ����Ǿ����ϴ�.");
												} catch (Exception e) {
													e.printStackTrace();
													res_main.console(error + "config.yml ������ ��������� �����ϴ� ���� ������ �߻��Ͽ����ϴ�. Ȯ���� �ּ���.");
												}
											} catch (Exception e) {
												e.printStackTrace();
												res_main.notice("�÷��̾� " + yellow + player.getName() + white
														+ " (��)�� �̺�Ʈ" + green
														+ " 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' " + white
														+ " (��)�� ��Ȱ��ȭ ��Ű�� ������, ���ܰ� �߻��Ͽ� �������� ���߽��ϴ�.");
											}
										}
									}

									else if (args[2].equalsIgnoreCase("SE_Event_Main")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.SE_Event_Main.enabled") == false) {
											player.sendMessage(error + "�̹� ��Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("SE_Event_Passive")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.SE_Event_Passive.enabled") == false) {
											player.sendMessage(error + "�̹� ��Ȱ��ȭ�� �̺�Ʈ�̱� ������ ����� ������ �� �����ϴ�.");
										} else {

										}
									}

									else {
										player.sendMessage(error + "�߸��� Ŭ���� �̸��Դϴ�. Ŭ���� �̸��� Ȯ���� �� �ٽ� �õ��ϼ���!");
									}
								}
							}
							
							else if (args[1].equalsIgnoreCase("show")) {
								player.sendMessage(prefix + "���� �̺�Ʈ���� ������ �����Ͽ� ���� �۵� ������ �ƴ���, config.yml �� ��� ��ϵǾ� �ִ��� ����մϴ�.");
								player.sendMessage(green + "=-=-=-=-=-=-=-=-=-=-= Research �÷����� - �̺�Ʈ ��� =-=-=-=-=-=-=-=-=-=-=");
								player.sendMessage(green + "[ �̺�Ʈ ��� ���� �� > " + yellow + "config.yml Ȱ��ȭ ����" + green + " | "
										+ aqua + "config.yml �ڵ� ���� ���� " + green + "]");
								player.sendMessage(green + "Event_PlayerJoin: "
										+ yellow + res_main.getConfig().getBoolean("auto-register.events.Event_PlayerJoin.enabled") + vleft
										+ res_main.getConfig().getBoolean("auto-register.events.Event_PlayerJoin.uses"));
								player.sendMessage(green + "Event_GUI_Test: "
										+ yellow + res_main.getConfig().getBoolean("auto-register.events.Event_GUI_Test.enabled") + vleft
										+ res_main.getConfig().getBoolean("auto-register.events.Event_GUI_Test.uses"));
								player.sendMessage(green + "SE_Event_Main: "
										+ yellow + res_main.getConfig().getBoolean("auto-register.events.SE_Event_Main.enabled") + vleft
										+ res_main.getConfig().getBoolean("auto-register.events.SE_Event_Main.uses"));
								player.sendMessage(green + "SE_Event_Passive: "
										+ yellow + res_main.getConfig().getBoolean("auto-register.events.SE_Event_Passive.enabled") + vleft
										+ res_main.getConfig().getBoolean("auto-register.events.SE_Event_Passive.uses"));
								player.sendMessage(green + "Event_EntityDamagedByEntity: "
										+ yellow + res_main.getConfig().getBoolean("auto-register.events.Event_EntityDamagedByEntity.enabled") + vleft
										+ res_main.getConfig().getBoolean("auto-register.events.Event_EntityDamagedByEntity.uses"));
								player.sendMessage(green + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
							}

							// �߸��� ��ɾ� �Է�
							else {
								player.sendMessage(error + "�Էµ� ��ɾ� �� �߸��� ��ɾ �ֽ��ϴ�. �Ʒ��� ��ɾ ������ �ּ���.");
								player.sendMessage(error + yellow + "/res event <enable/disable/show [class]> <class>");
							}
						}
					}

					// Ŀ�ǵ� "/res info"
					else if (args[0].equalsIgnoreCase("info")) {
						player.sendMessage(prefix + "Research �÷������� ������ ǥ���մϴ�.");
						player.sendMessage(
								green + "=-=-=-=-=-=-=-=-=-=-=-=-= Research �÷����� ���� =-=-=-=-=-=-=-=-=-=-=-=-=");
						player.sendMessage(green + "- �̸�: " + yellow + res_main.pname);
						player.sendMessage(green + "- ����: " + yellow + res_main.pver + " (" + res_main.rel_type + ")");
						player.sendMessage(green + "- ����: " + yellow + res_main.build_no);
						player.sendMessage(green + "- ����: " + yellow + res_main.pauth);
						player.sendMessage(yellow + "Copyright (C) stageroad0820. All rights reserved.");
						player.sendMessage(
								green + "=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}
				}
			}
		}

		// ��ɾ� �����ڰ� "�ܼ� Ŀ�ǵ� ������" �� ���
		else if (sender instanceof ConsoleCommandSender) {
			// Ŀ�ǵ带 "/research" �� "/res" �� ��� �����ϰ� ����
			if (commandLabel.equalsIgnoreCase("research") || commandLabel.equalsIgnoreCase("res")) {
				// ���� Ŀ�ǵ� ���� ���� Ŀ�ǵ常 �Է����� ���
				if (args.length == 0) {
					sender.sendMessage(error + "�Է��Ͻ� ��ɾ��� ���� ���� �ʹ� ���ų� �����ϴ�!" + yellow + " /res help �Ǵ� /research help "
							+ red + " �� ���� Research �÷������� �� ���� ��ɾ �˾ƺ�����!");
				}
				// ���� Ŀ�ǵ嵵 �Է����� ���
				else {
					// Ŀ�ǵ� "res help"
					if (args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(prefix + "��ɾ� ������: " + yellow + "�÷��̾�");
						sender.sendMessage(
								green + "=-=-=-=-=-=-=-=-=-=-= Research �÷����� ��ɾ� : �ܼ� =-=-=-=-=-=-=-=-=-=-=");
						sender.sendMessage(gold + "< /res �� /research �� �Ʒ��� Ŀ�ǵ���� ����� �� �ֽ��ϴ�! >");
						sender.sendMessage(green + "/res help" + cleft + "��ɾ� �����ڿ� ���� Research �÷������� ��ɾ� ������ ����մϴ�.");
						sender.sendMessage(green + "/res notice <message>" + cleft
								+ "������ ������ �ִ� ��� �÷��̾�鿡�� ���� �޼����� �����մϴ�. (�ִ� 512��)");
						sender.sendMessage(green + "/res info" + cleft + "�÷������� ������ Ȯ���մϴ�.");
						sender.sendMessage(
								green + "=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}

					// Ŀ�ǵ� "res notice <String>"
					else if (args[0].equalsIgnoreCase("notice")) {
						String message = "";
						// ���� ���� ���� Ŀ�ǵ常 �Է����� ���
						if (args.length == 1) {
							sender.sendMessage(error + "�޼����� �Է����� �ʾҽ��ϴ�! ��ɾ�� �޼����� ���� �Է��ϼ���!");
						}
						// ���� ���뵵 ���� �Է����� ���
						else if (args.length > 1) {
							StringBuilder str = new StringBuilder();

							for (int i = 1; i < args.length; i++) {
								str.append(args[i] + " ");
							}

							res_main.notice(res_main.nts + str.toString().trim());
						}
					}

					// Ŀ�ǵ� "res info"
					else if (args[0].equalsIgnoreCase("info")) {
						sender.sendMessage(prefix + "Research �÷������� ������ ǥ���մϴ�.");
						sender.sendMessage(
								green + "=-=-=-=-=-=-=-=-=-=-=-=-= Research �÷����� ���� =-=-=-=-=-=-=-=-=-=-=-=-=");
						sender.sendMessage(green + "- �̸�: " + yellow + res_main.pname);
						sender.sendMessage(green + "- ����: " + yellow + res_main.pver + " (" + res_main.rel_type + ")");
						sender.sendMessage(green + "- ����: " + yellow + res_main.build_no);
						sender.sendMessage(green + "- ����: " + yellow + res_main.pauth);
						sender.sendMessage(yellow + "Copyright (C) stageroad0820. All rights reserved.");
						sender.sendMessage(
								green + "=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}
				}
			}
		}
		return false;
	}
}
