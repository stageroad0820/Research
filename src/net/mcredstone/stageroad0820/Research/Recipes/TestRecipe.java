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
		
		im_rcp.setDisplayName(ChatColor.AQUA + "테스트 레시피 결과물");
		
		im_rcp.setLore(Arrays.asList(ChatColor.GRAY + "사용자 지정 조합법을 다른 클래스로 이동시키는데 성공하였습니다!"));
		
		is_rcp.setItemMeta(im_rcp);
		
		@SuppressWarnings("deprecation")
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
