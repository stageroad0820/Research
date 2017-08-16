package net.mcredstone.stageroad0820.Research.Recipes;

import java.util.Arrays;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import net.mcredstone.stageroad0820.Research.Main;

public class TestRecipe {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main res_main;
	
	public TestRecipe(Main plugin) {
		TestRecipe.res_main = plugin;
	}
	
	public static void createRecipe() {
		ItemStack is_rcp = new ItemStack(Material.COMMAND);
		ItemMeta im_rcp = is_rcp.getItemMeta();
		
		im_rcp.setDisplayName(ChatColor.AQUA + "�׽�Ʈ ������ �����");
		
		im_rcp.setLore(Arrays.asList(ChatColor.GRAY + "����� ���� ���չ��� �ٸ� Ŭ������ �̵���Ű�µ� �����Ͽ����ϴ�!"));
		
		is_rcp.setItemMeta(im_rcp);
		
		ShapedRecipe rcp = new ShapedRecipe(new ItemStack(is_rcp)).shape("!@!", "@#@", "!$!")
				.setIngredient('!', Material.WOOD)
				.setIngredient('@', Material.STONE_BUTTON)
				.setIngredient('#', Material.BEACON)
				.setIngredient('$', Material.REDSTONE);
		
		Bukkit.addRecipe(rcp);
	}
	
	public static void removeRecipe() {
		Bukkit.clearRecipes();
	}
}
