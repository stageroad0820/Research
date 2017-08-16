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
	// 클래스에 필요한 객체 생성 및 초기화
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;

	// 메인 클래스와 연결
	public MainCommand(Main plugin) {
		MainCommand.res_main = plugin;
	}

	// 플러그인 관리자 객체
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
	String debug = dgray + "[Res Debug]" + white + " ";

	String cleft = yellow + " : " + white + "";
	String vleft = green +" | " + aqua + "";

	// 변수 선언 및 초기화
	public static boolean isTest = false;
	public static boolean isDebug = false;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		// 명령어 전송자가 "플레이어" 일 경우
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Location loc = player.getLocation();

			// 커맨드를 "/research" 와 "/res" 로 사용 가능하게 설정
			if (commandLabel.equalsIgnoreCase("research") || commandLabel.equalsIgnoreCase("res")) {
				// 하위 커맨드 없이 메인 커맨드만 입력했을 경우
				if (args.length == 0) {
					player.sendMessage(error + "입력하신 명령어의 인자 값이 너무 적거나 없습니다!" + yellow + " /res help 또는 /research help "
							+ red + " 를 통해 Research 플러그인의 더 많은 명령어를 알아보세요!");
				}
				// 하위 커맨드도 같이 입력할 경우
				else {
					// 커맨드 "/res help"
					if (args[0].equalsIgnoreCase("help")) {
						player.sendMessage(prefix + "명령어 전송자: " + yellow + "플레이어");
						player.sendMessage(green + "=-=-=-=-=-=-=-=-=-= Research 플러그인 명령어 : 플레이어 =-=-=-=-=-=-=-=-=-=");
						player.sendMessage(gold + "< /res 와 /research 로 아래의 커맨드들을 사용할 수 있습니다! >");
						player.sendMessage(green + "/res help" + cleft + "명령어 전송자에 따라 Research 플러그인의 명령어 도움말을 출력합니다.");
						player.sendMessage(green + "/res enum <enum>" + cleft + "열거형(Enumation) 의 테스트를 진행합니다.");
						player.sendMessage(
								green + "/res spawn <help/gui/entity>" + cleft + "엔티티를 플레이어가 바라보는 방향에 소환합니다.");
						player.sendMessage(green + "/res info" + cleft + "플러그인의 정보를 확인합니다.");
						player.sendMessage(
								green + "/res nickname <name/reset>" + cleft + "플레이어의 이름을 변경합니다. reset 으로 초기화 합니다.");
						player.sendMessage(
								red + "/res nametag <name/reset>" + cleft + "플레이어의 이름표를 변경합니다. reset 으로 초기화 합니다.");
						player.sendMessage(green + "/res test <help/...>" + cleft + "아직 완성되지 않은 기능들을 테스트 합니다.");
						player.sendMessage(
								green + "/res event <enable/disable> <class>" + cleft + "플러그인의 이벤트를 활성화 하거나 비활성화 합니다.");
						player.sendMessage(
								green + "=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}

					// 커맨드 "/res enum <list>"
					else if (args[0].equalsIgnoreCase("enum")) {
						// <list> 부분을 입력하지 않았을 경우
						if (args.length == 1) {
							player.sendMessage(error + "열거형 목록이 입력되지 않았습니다! 아래의 열거형 목록을 참고하여 명령어를 다시 입력해 주세요!");
							player.sendMessage(error + "APPLE, CHOCOLATE, RAMEN, RICE, CORN, SUGAR_CUBE");
						}
						// <list> 부분을 입력했을 경우
						else {
							for (EnumTest e : EnumTest.getFoods()) {
								if (args[1].equalsIgnoreCase(e.foodName)) {
									String str = e.healthy ? "건강한 음식입니다!" : "건강하지 않은 음식입니다!";
									String fdName = "";

									switch (e.foodName) {
									case "apple":
										fdName = "사과";
										break;
									case "chocolate":
										fdName = "초콜릿";
										break;
									case "ramen":
										fdName = "라면";
										break;
									case "rice":
										fdName = "밥";
										break;
									case "corn":
										fdName = "옥수수";
										break;
									case "sugar_cube":
										fdName = "각설탕";
										break;
									default:
										break;
									}

									player.sendMessage(prefix + "EnumTest.class 의 테스트가 성공적으로 종료되었습니다! 결과: ");
									player.sendMessage(prefix + fdName + " (은)는 " + str);
									break;
								}
							}
						}
					}

					// 커맨드 "/res spawn"
					else if (args[0].equalsIgnoreCase("spawn")) {
						// 추가 명령어를 입력하지 않은 경우
						if (args.length == 1) {
							player.sendMessage(error + "추가 명령어가 입력되지 않았습니다. 추가 명령어를 확인하시려면" + yellow + "/res spawn help"
									+ red + " 를 입력하세요.");
						}
						// 입력한 경우
						else {
							// 도움말
							if (args[1].equalsIgnoreCase("help")) {
								player.sendMessage(
										green + "=-=-=-=-=-=-=-=-=- Research 플러그인 - 엔티티 명령어 목록 =-=-=-=-=-=-=-=-=-");
								player.sendMessage(green + "help" + cleft + "/res spawn 의 추가 명령어를 확인합니다.");
								player.sendMessage(green + "entity <list [page]/[entity name]>" + cleft
										+ "플레이어가 있는 위치에 엔티티를 직접 소환합니다.");
								player.sendMessage(
										green + "gui" + cleft + "GUI 를 통해 엔티티를 소환하며, 원하는 위치에 소환할 수 있는 막대기를 받습니다.");
								player.sendMessage(green
										+ "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
							}
							// 엔티티 직접 소환
							else if (args[1].equalsIgnoreCase("entity")) {
								// 엔티티 이름을 입력하지 않았을 경우
								if (args.length == 2) {
									player.sendMessage(error + "엔티티 이름이 입력되지 않았습니다. 엔티티 목록은 list 로 알아보실 수 있습니다.");
								}
								// 입력했을 경우
								else {

								}
							}
							// GUI 를 통해 소환
							else if (args[1].equalsIgnoreCase("gui")) {

							}
						}
					}

					// 커맨드 "/res nickname <String>"
					else if (args[0].equalsIgnoreCase("nickname")) {
						// <String> 부분이 입력되지 않았을 경우
						if (args.length == 1) {
							player.sendMessage(error + "변경할 닉네임이 입력되지 않았습니다. 변경할 닉네임을 커맨드와 같이 입력해 주세요!");
						}

						// <String> 부분을 입력했을 경우
						else {
							// 플레이어의 원래 이름을 저장
							String realName = player.getName();

							// <String> 부분이 reset 일 경우
							if (args[1].equals("reset")) {
								// 플레이어의 이름을 원래대로 변경하고 안내메세지 출력
								player.setDisplayName(realName);
								player.setPlayerListName(realName);
								player.sendMessage(prefix + "플레이어의 이름을 원래대로 변경하였습니다.");
							}

							// <String> 부분이 reset 이 아닐 경우
							else {
								// 플레이어가 입력한 문자열을 플레이어의 닉네임으로 설정하고 안내메세지 출력
								player.setDisplayName(args[1]);
								player.setPlayerListName(args[1]);
								player.sendMessage(prefix + "플레이어의 이름이 " + yellow + realName + white + " 에서 " + yellow
										+ args[1] + white + " (으)로 변경되었습니다.");
							}
						}
					}

					// 커맨드 "/res nametag <String>" - 명령어 비활성화
					else if (args[0].equalsIgnoreCase("nametag")) {
						player.sendMessage(error + "현재 개발 중 문제가 발생하여 비활성화 된 명령어 입니다. 다른 명령어를 입력해 주세요!");

						// // <String> 부분이 입력되지 않았을 경우
						// if (args.length == 1) {
						// player.sendMessage(error + "변경할 닉네임이 입력되지 않았습니다. 변경할 닉네임을 커맨드와 같이 입력해 주세요!");
						// }
						//
						// // <String> 부분을 입력했을 경우
						// else {
						// String realName = player.getName();
						//
						// // <String> 부분이 reset 일 경우
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
						// player.sendMessage(prefix + "플레이어의 이름을 원래대로 변경하였습니다.");
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
						// player.sendMessage(prefix + "플레이어의 이름이 " + yellow + realName + white + " 에서 "
						// + yellow
						// + args[1] + white + " (으)로 변경되었습니다.");
						// }
						// }
					}

					// 커맨드 "/res test <help/...>
					else if (args[0].equalsIgnoreCase("test")) {
						if (args.length == 1) {
							player.sendMessage(error + "커맨드가 제대로 입력되지 않았습니다!" + yellow + " /res test help " + red
									+ "를 통해 테스트 할 목록을 확인하실 수 있습니다.");
						}

						else {
							// 테스트 모드 도움말
							if (args[1].equalsIgnoreCase("help")) {
								player.sendMessage(prefix + "아직 개발 중인 기능을 테스트 할 수 있는 목록 입니다. /res test 와 같이 사용해야 합니다.");
								player.sendMessage(
										green + "=-=-=-=-=-=-=-=-=- Research 플러그인 - 테스트 목록 =-=-=-=-=-=-=-=-=-");
								player.sendMessage(green + "gui" + cleft + "생성된 GUI 를 테스트합니다. (GUI 창 실행)");
								player.sendMessage(
										green + "cmd <cmds...>" + cleft + "GUI 같은 이벤트가 작동을 하지 않을 때 커맨드로 테스트 합니다.");
								player.sendMessage(green + "exit" + cleft + "테스트를 끝냅니다.");
								player.sendMessage(green
										+ "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
							}
							// GUI 테스트 모드
							else if (args[1].equalsIgnoreCase("gui")) {
								isTest = true;
								player.sendMessage(
										prefix + "GUI 창 테스트를 시작합니다. 테스트를 종료하시려면 GUI 창 메인 화면에서 '나무 문' 을 클릭하세요.");
								GUI_Test.openInv(player);
							}
							// 명령어 테스트 모드
							else if (args[1].equalsIgnoreCase("cmd")) {
								if (args.length == 2) {
									player.sendMessage(
											green + "=-=-=-=-=-=-=-=- Research 플러그인 - 테스트 목록 [명령어] =-=-=-=-=-=-=-=-");
									player.sendMessage(green + "기본 명령어" + cleft + "명령어를 테스트 합니다.");
									player.sendMessage(green + "gui_test_main" + cleft + "GUI 테스트 메인 화면을 실행합니다.");
									player.sendMessage(green + "gui_entity_main" + cleft + "엔티티 소환 GUI 메인 화면을 실행합니다.");
									player.sendMessage(
											green + "gui_entity_passive" + cleft + "엔티티 소환 GUI 친화적 몹 화면을 실행합니다.");
									player.sendMessage(green
											+ "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
								} else {
									// GUI 실행 명령어 - GUI 테스트
									if (args[2].equalsIgnoreCase("gui_test_main")) {
										GUI_Test.openInv(player);
										player.sendMessage(prefix
												+ "'Reseach 플러그인 - GUI 기능 테스트' 화면을 실행합니다. 실행이 되지 않을 경우 콘솔 창을 확인해 주세요.");
									}
									// GUI 실행 명령어 - 엔티티 소환 선택 화면
									else if (args[2].equalsIgnoreCase("gui_entity_main")) {
										SE_GUI_Main.openInv(player);
										player.sendMessage(
												prefix + "'엔티티를 선택하세요' 화면을 실행합니다. 실행이 되지 않을 경우 콘솔 창을 확인해 주세요.");
									}
									// GUI 실행 명령어 - 엔티티 소환 선택 화면 _ 친화적 몹
									else if (args[2].equalsIgnoreCase("gui_entity_passive")) {
										SE_GUI_Passive.openInv(player);
										player.sendMessage(
												prefix + "'엔티티를 선택하세요 - 친화적 몹' 화면을 실행합니다. 실행이 되지 않을 경우 콘솔 창을 확인해 주세요.");
									}
									// 알 수 없는 테스트
									else {
										player.sendMessage(error + "알 수 없는 테스트 이름 입니다. " + yellow + "/res test cmd"
												+ red + " 를 입력해 확인해 보세요.");
									}
								}
							}
						}
					}

					// 커맨드 "/res debug <on/off>"
					else if (args[0].equalsIgnoreCase("debug")) {
						if (args.length == 1) {
							player.sendMessage(
									error + "디버그 모드는 " + yellow + "/res debug <on/off>" + red + " 로 만 가능합니다.");
							player.sendMessage(error + "현재 디버그 모드 상태는 " + green + "'" + isDebug + "'" + red + " 입니다.");
						} else {
							// 디버그 모드 활성화
							if (args[1].equalsIgnoreCase("on")) {
								// 이미 디버그 모드가 활성화 되어 있는 경우 에러 메세지 출력
								if (isDebug == true) {
									player.sendMessage(error + "이미 디버그 모드가 활성화 된 상태입니다. 디버그 모드 종료는 " + yellow + "off"
											+ red + " 로 할 수 있습니다.");
								}
								// 디버그 모드 활성화
								else {
									isDebug = true;
									player.sendMessage(prefix + "디버그 모드가 활성화 되었습니다. 플러그인에서 발생하는 모든 이벤트가 채팅창으로 출력됩니다.");
								}

							} else if (args[1].equalsIgnoreCase("off")) {
								// 이미 디버그 모드가 비활성화 되어 있는 경우 에러 메세지 출력
								if (isDebug == false) {
									player.sendMessage(error + "이미 디버그 모드가 비활성화 된 상태입니다. 디버그 모드 활성화는 " + yellow + "on"
											+ red + " 으로 할 수 있습니다.");
								}
								// 디버그 모드 비활성화
								else {
									isDebug = false;
									player.sendMessage(prefix + "디버그 모드가 비활성화 되었습니다. 플러그인에서 발생하는 일부 이벤트만 채팅창으로 출력됩니다.");
								}
							} else {
								player.sendMessage(
										error + "디버그 모드는 " + yellow + "/res debug <on/off>" + red + " 로 만 가능합니다.");
							}
						}
					}

					// 커맨드 "/res event <enable/disable> <class>"
					else if (args[0].equalsIgnoreCase("event")) {
						// 추가 명령어 입력 안내
						if (args.length == 1) {
							player.sendMessage(error + "이벤트 활성화 상태 관리 명령어는 아래와 같은 명령어로 이용하실 수 있습니다.");
							player.sendMessage(error + yellow + "/res event <enable/disable/show [class]> <class>");
						} else {
							// 이벤트 활성화
							if (args[1].equalsIgnoreCase("enable")) {
								if (args.length == 2) {
									player.sendMessage(
											error + "이벤트 활성화 관리 명령어를 사용하기 위해서는 클래스 이름이 필요합니다. 클래스 이름을 입력해 주세요.");
								} else {
									if (args[2].equalsIgnoreCase("Event_PlayerJoin")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.Event_PlayerJoin.enabled") == true) {
											player.sendMessage(error + "이미 활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {
											try {
												pm.registerEvents(new Event_PlayerJoin(res_main), res_main);
												res_main.notice(
														"플레이어 " + yellow + player.getName() + white + " 에 의해 이벤트"
																+ green + " 'PlayerJoinEvent (Event_PlayerJoin.java)' "
																+ white + "(이)가 활성화 되었습니다.");
												res_main.getConfig()
														.set("auto-register.events.Event_PlayerJoin.enabled", true);
												try {
													res_main.saveConfig();
													res_main.console(debug + "config.yml 파일의 변경사항이 저장되었습니다.");
												} catch (Exception e) {
													e.printStackTrace();
													res_main.console(error + "config.yml 파일의 변경사항을 저장하는 동안 문제가 발생하였습니다. 확인해 주세요.");
												}
											} catch (Exception e) {
												e.printStackTrace();
												res_main.notice("플레이어 " + yellow + player.getName() + white
														+ " (이)가 이벤트" + green
														+ " 'PlayerJoinEvent (Event_PlayerJoin.java)' " + white
														+ " (을)를 활성화 시키려 했지만," + " 예외가 발생하여 실행하지 못했습니다.");
											}
										}
									}

									else if (args[2].equalsIgnoreCase("Event_GUI_Test")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.Event_GUI_Test.enabled") == true) {
											player.sendMessage(error + "이미 활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("Event_EntityDamagedByEntity")) {
										if (res_main.getConfig().getBoolean(
												"auto-register.events.Event_EntityDamagedByEntity.enabled") == true) {
											player.sendMessage(error + "이미 활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {
											try {
												pm.registerEvents(new Event_EntityDamagedByEntity(res_main), res_main);
												res_main.notice("플레이어 " + yellow + player.getName() + white
														+ " 에 의해 이벤트" + green
														+ " 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' "
														+ white + "(이)가 활성화 되었습니다.");
												res_main.getConfig().set(
														"auto-register.events.Event_EntityDamagedByEntity.enabled",
														true);
												try {
													res_main.saveConfig();
													res_main.console(debug + "config.yml 파일의 변경사항이 저장되었습니다.");
												} catch (Exception e) {
													e.printStackTrace();
													res_main.console(error + "config.yml 파일의 변경사항을 저장하는 동안 문제가 발생하였습니다. 확인해 주세요.");
												}
											} catch (Exception e) {
												e.printStackTrace();
												res_main.notice("플레이어 " + yellow + player.getName() + white
														+ " (이)가 이벤트" + green
														+ " 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' "
														+ white + " (을)를 활성화 시키려 했지만, 예외가 발생하여 실행하지 못했습니다.");
											}
										}
									}

									else if (args[2].equalsIgnoreCase("SE_Event_Main")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.SE_Event_Main.enabled") == true) {
											player.sendMessage(error + "이미 활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("SE_Event_Passive")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.SE_Event_Passive.enabled") == true) {
											player.sendMessage(error + "이미 활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {

										}
									}

									else {
										player.sendMessage(error + "잘못된 클래스 이름입니다. 클래스 이름을 확인한 후 다시 시도하세요!");
									}
								}
							}

							// 이벤트 비활성화
							else if (args[1].equalsIgnoreCase("disable")) {
								if (args.length == 2) {
									player.sendMessage(
											error + "이벤트 활성화 관리 명령어를 사용하기 위해서는 클래스 이름이 필요합니다. 클래스 이름을 입력해 주세요.");
								} else {
									if (args[2].equalsIgnoreCase("Event_PlayerJoin")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.Event_PlayerJoin.enabled") == false) {
											player.sendMessage(error + "이미 비활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("Event_GUI_Test")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.Event_GUI_Test.enabled") == false) {
											player.sendMessage(error + "이미 비활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("Event_EntityDamagedByEntity")) {
										if (res_main.getConfig().getBoolean(
												"auto-register.events.Event_EntityDamagedByEntity.enabled") == false) {
											player.sendMessage(error + "이미 비활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {
											try {
												res_main.notice("플레이어 " + yellow + player.getName() + white
														+ " 에 의해 이벤트" + green
														+ " 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' " + white
														+ "(이)가 비활성화 되었습니다.");
												res_main.getConfig()
														.set("auto-register.events.Event_EntityDamagedByEntity.enabled", false);
												
												try {
													res_main.saveConfig();
													res_main.console(debug + "config.yml 파일의 변경사항이 저장되었습니다.");
												} catch (Exception e) {
													e.printStackTrace();
													res_main.console(error + "config.yml 파일의 변경사항을 저장하는 동안 문제가 발생하였습니다. 확인해 주세요.");
												}
											} catch (Exception e) {
												e.printStackTrace();
												res_main.notice("플레이어 " + yellow + player.getName() + white
														+ " (이)가 이벤트" + green
														+ " 'EntityDamagedByEntityEvent (Event_EntityDamagedByEntity.java)' " + white
														+ " (을)를 비활성화 시키려 했지만, 예외가 발생하여 실행하지 못했습니다.");
											}
										}
									}

									else if (args[2].equalsIgnoreCase("SE_Event_Main")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.SE_Event_Main.enabled") == false) {
											player.sendMessage(error + "이미 비활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {

										}
									}

									else if (args[2].equalsIgnoreCase("SE_Event_Passive")) {
										if (res_main.getConfig()
												.getBoolean("auto-register.events.SE_Event_Passive.enabled") == false) {
											player.sendMessage(error + "이미 비활성화된 이벤트이기 때문에 명령을 실행할 수 없습니다.");
										} else {

										}
									}

									else {
										player.sendMessage(error + "잘못된 클래스 이름입니다. 클래스 이름을 확인한 후 다시 시도하세요!");
									}
								}
							}
							
							else if (args[1].equalsIgnoreCase("show")) {
								player.sendMessage(prefix + "현재 이벤트들의 정보를 수집하여 현재 작동 중인지 아닌지, config.yml 에 어떻게 등록되어 있는지 출력합니다.");
								player.sendMessage(green + "=-=-=-=-=-=-=-=-=-=-= Research 플러그인 - 이벤트 뷰어 =-=-=-=-=-=-=-=-=-=-=");
								player.sendMessage(green + "[ 이벤트 뷰어 보는 법 > " + yellow + "config.yml 활성화 상태" + green + " | "
										+ aqua + "config.yml 자동 실행 상태 " + green + "]");
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

							// 잘못된 명령어 입력
							else {
								player.sendMessage(error + "입력된 명령어 중 잘못된 명령어가 있습니다. 아래의 명령어를 참고해 주세요.");
								player.sendMessage(error + yellow + "/res event <enable/disable/show [class]> <class>");
							}
						}
					}

					// 커맨드 "/res info"
					else if (args[0].equalsIgnoreCase("info")) {
						player.sendMessage(prefix + "Research 플러그인의 정보를 표시합니다.");
						player.sendMessage(
								green + "=-=-=-=-=-=-=-=-=-=-=-=-= Research 플러그인 정보 =-=-=-=-=-=-=-=-=-=-=-=-=");
						player.sendMessage(green + "- 이름: " + yellow + res_main.pname);
						player.sendMessage(green + "- 버전: " + yellow + res_main.pver + " (" + res_main.rel_type + ")");
						player.sendMessage(green + "- 빌드: " + yellow + res_main.build_no);
						player.sendMessage(green + "- 제작: " + yellow + res_main.pauth);
						player.sendMessage(yellow + "Copyright (C) stageroad0820. All rights reserved.");
						player.sendMessage(
								green + "=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}
				}
			}
		}

		// 명령어 전송자가 "콘솔 커맨드 전송자" 일 경우
		else if (sender instanceof ConsoleCommandSender) {
			// 커맨드를 "/research" 와 "/res" 로 사용 가능하게 설정
			if (commandLabel.equalsIgnoreCase("research") || commandLabel.equalsIgnoreCase("res")) {
				// 하위 커맨드 없이 메인 커맨드만 입력했을 경우
				if (args.length == 0) {
					sender.sendMessage(error + "입력하신 명령어의 인자 값이 너무 적거나 없습니다!" + yellow + " /res help 또는 /research help "
							+ red + " 를 통해 Research 플러그인의 더 많은 명령어를 알아보세요!");
				}
				// 하위 커맨드도 입력했을 경우
				else {
					// 커맨드 "res help"
					if (args[0].equalsIgnoreCase("help")) {
						sender.sendMessage(prefix + "명령어 전송자: " + yellow + "플레이어");
						sender.sendMessage(
								green + "=-=-=-=-=-=-=-=-=-=-= Research 플러그인 명령어 : 콘솔 =-=-=-=-=-=-=-=-=-=-=");
						sender.sendMessage(gold + "< /res 와 /research 로 아래의 커맨드들을 사용할 수 있습니다! >");
						sender.sendMessage(green + "/res help" + cleft + "명령어 전송자에 따라 Research 플러그인의 명령어 도움말을 출력합니다.");
						sender.sendMessage(green + "/res notice <message>" + cleft
								+ "서버에 접속해 있는 모든 플레이어들에게 공지 메세지를 전달합니다. (최대 512자)");
						sender.sendMessage(green + "/res info" + cleft + "플러그인의 정보를 확인합니다.");
						sender.sendMessage(
								green + "=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
					}

					// 커맨드 "res notice <String>"
					else if (args[0].equalsIgnoreCase("notice")) {
						String message = "";
						// 공지 내용 없이 커맨드만 입력했을 경우
						if (args.length == 1) {
							sender.sendMessage(error + "메세지를 입력하지 않았습니다! 명령어와 메세지를 같이 입력하세요!");
						}
						// 공지 내용도 같이 입력했을 경우
						else if (args.length > 1) {
							StringBuilder str = new StringBuilder();

							for (int i = 1; i < args.length; i++) {
								str.append(args[i] + " ");
							}

							res_main.notice(res_main.nts + str.toString().trim());
						}
					}

					// 커맨드 "res info"
					else if (args[0].equalsIgnoreCase("info")) {
						sender.sendMessage(prefix + "Research 플러그인의 정보를 표시합니다.");
						sender.sendMessage(
								green + "=-=-=-=-=-=-=-=-=-=-=-=-= Research 플러그인 정보 =-=-=-=-=-=-=-=-=-=-=-=-=");
						sender.sendMessage(green + "- 이름: " + yellow + res_main.pname);
						sender.sendMessage(green + "- 버전: " + yellow + res_main.pver + " (" + res_main.rel_type + ")");
						sender.sendMessage(green + "- 빌드: " + yellow + res_main.build_no);
						sender.sendMessage(green + "- 제작: " + yellow + res_main.pauth);
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
