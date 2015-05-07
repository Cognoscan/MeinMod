package cognoscan.meinMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid=MeinMod.MODID, name=MeinMod.MODNAME, version=MeinMod.MODVER) // Tell forge this is a mod to load
public class MeinMod {
	public static final String MODID = "MeinMod";
	public static final String MODNAME = "This ist Mein Mod";
	public static final String MODVER = "0.01";
	
	public static Block dumbBlock;
	public static Block tealOre;
	
	public static Item dumbThing;
	public static Item key;
	public static Item berry;
	public static Item tealDust;
	public static Item tealIngot;
	
	public static Item tealPickaxe;
	public static Item tealAxe;
	public static Item tealHoe;
	public static Item tealShovel;
	public static Item tealSword;
	public static Item tealPaxel;
	
	public static Item tealHelmet;
	public static Item tealChestplate;
	public static Item tealLeggings;
	public static Item tealBoots;

	ToolMaterial tealium = EnumHelper.addToolMaterial("tealium", 2, 3000, 12.0F, 3.5F, 5);
	
	ArmorMaterial tealArmor = EnumHelper.addArmorMaterial("tealArmor", MeinMod.MODID+":"+"tealArmor", 20, new int[] {3, 7, 6, 3}, 5);
	
	@Instance(value = MeinMod.MODID) // Tell Forge what instance to use
	public static MeinMod instance;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		// blocks
		dumbBlock = new DumbBlock();
		tealOre = new TealOre();
		
		// items
		dumbThing = new DumbThing();
		key = new ItemKey();
		berry = new ItemBerry(3, 0.3f, true);
		tealDust = new TealDust();
		tealIngot = new TealIngot();
		
		// Tools
		tealPickaxe = new TealPickaxe(tealium);
		tealAxe     = new TealAxe(tealium);
		tealHoe     = new TealHoe(tealium);
		tealShovel  = new TealShovel(tealium);
		tealSword   = new TealSword(tealium);
		tealPaxel   = new TealPaxel(tealium);
		
		// Armor
		tealHelmet     = new TealArmor(tealArmor, 0, "tealHelmet");
		tealChestplate = new TealArmor(tealArmor, 1, "tealChestplate");
		tealLeggings   = new TealArmor(tealArmor, 2, "tealLeggings");
		tealBoots      = new TealArmor(tealArmor, 3, "tealBoots");
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ItemStack enchantedSwordStack = new ItemStack(Items.iron_sword);
		enchantedSwordStack.addEnchantment(Enchantment.knockback, 1);
		GameRegistry.addShapelessRecipe(enchantedSwordStack, Items.iron_sword, Items.iron_ingot);
		
    	GameRegistry.addShapedRecipe(new ItemStack(dumbBlock),
			"AA ",
			"A A",
			"AA ",
			'A', Blocks.dirt);
    	
    	GameRegistry.addShapedRecipe(new ItemStack(dumbThing),
    			"AAA",
    			" A ",
    			"AAA",
    			'A', Blocks.dirt);
    	
    	// Tool recipes
    	GameRegistry.addShapedRecipe(new ItemStack(tealPickaxe), 
    			"AAA",
    			" B ",
    			" B ",
    			'A', tealIngot,
    			'B', Items.stick);
    	GameRegistry.addShapedRecipe(new ItemStack(tealAxe), 
    			"AA ",
    			"AB ",
    			" B ",
    			'A', tealIngot,
    			'B', Items.stick);
    	GameRegistry.addShapedRecipe(new ItemStack(tealHoe), 
    			" AA",
    			" B ",
    			" B ",
    			'A', tealIngot,
    			'B', Items.stick);
    	GameRegistry.addShapedRecipe(new ItemStack(tealShovel), 
    			" A ",
    			" B ",
    			" B ",
    			'A', tealIngot,
    			'B', Items.stick);
    	GameRegistry.addShapedRecipe(new ItemStack(tealSword), 
    			" A ",
    			" A ",
    			" B ",
    			'A', tealIngot,
    			'B', Items.stick);    	
    	GameRegistry.addShapelessRecipe(new ItemStack(tealPaxel), tealPickaxe, tealAxe, tealShovel);
    	
    	// Armor Recipes
    	GameRegistry.addShapedRecipe(new ItemStack(tealHelmet), 
    			"AAA",
    			"A A",
    			'A', tealIngot);
    	GameRegistry.addShapedRecipe(new ItemStack(tealChestplate), 
    			"A A",
    			"AAA",
    			"AAA",
    			'A', tealIngot);
    	GameRegistry.addShapedRecipe(new ItemStack(tealLeggings), 
    			"AAA",
    			"A A",
    			"A A",
    			'A', tealIngot);
    	GameRegistry.addShapedRecipe(new ItemStack(tealBoots), 
    			"A A",
    			"A A",
    			'A', tealIngot);
    	GameRegistry.addSmelting(tealDust, new ItemStack(tealIngot), 1.0f);
		
    	DungeonHooks.removeDungeonMob("Spider");
    	DungeonHooks.addDungeonMob("Enderman", 50);
    	ChestGenHooks.removeItem(ChestGenHooks.DUNGEON_CHEST, new ItemStack(Items.saddle));
    	ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, 
    			new WeightedRandomChestContent(new ItemStack(Items.ender_pearl), 1, 8, 3));
    	
		if (event.getSide() == Side.CLIENT)
		{
			ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
			
			// Block Rendering
			mesher.register(Item.getItemFromBlock(dumbBlock), 0,
					new ModelResourceLocation(MeinMod.MODID + ":" + ((DumbBlock) dumbBlock).getName(), "inventory"));
			mesher.register(Item.getItemFromBlock(tealOre), 0,
					new ModelResourceLocation(MeinMod.MODID + ":" + ((TealOre) tealOre).getName(), "inventory"));
			
			// Item Rendering
			mesher.register(tealPickaxe,    0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealPickaxe) tealPickaxe).getName(), "inventory"));
			mesher.register(tealAxe,        0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealAxe) tealAxe).getName(), "inventory"));
			mesher.register(tealHoe,        0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealHoe) tealHoe).getName(), "inventory"));
			mesher.register(tealShovel,     0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealShovel) tealShovel).getName(), "inventory"));
			mesher.register(tealSword,      0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealSword) tealSword).getName(), "inventory"));
			mesher.register(tealPaxel,      0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealPaxel) tealPaxel).getName(), "inventory"));
			
			mesher.register(tealHelmet,     0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealArmor) tealHelmet).getName(), "inventory"));
			mesher.register(tealChestplate, 0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealArmor) tealChestplate).getName(), "inventory"));
			mesher.register(tealLeggings,   0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealArmor) tealLeggings).getName(), "inventory"));
			mesher.register(tealBoots,      0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealArmor) tealBoots).getName(), "inventory"));
			
			mesher.register(dumbThing,      0, new ModelResourceLocation(MeinMod.MODID+":" + ((DumbThing) dumbThing).getName(), "inventory"));
			mesher.register(berry,          0, new ModelResourceLocation(MeinMod.MODID+":" + ((ItemBerry) berry).getName(), "inventory"));
			mesher.register(tealDust,       0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealDust) tealDust).getName(), "inventory"));
			mesher.register(tealIngot,      0, new ModelResourceLocation(MeinMod.MODID+":" + ((TealIngot) tealIngot).getName(), "inventory"));
			// Key should render the same for all metadata values
			mesher.register(key, 
					new ItemMeshDefinition(){
						public ModelResourceLocation getModelLocation(ItemStack stack) {
						return new ModelResourceLocation(MeinMod.MODID + ":" + ((ItemKey) key).getName(), "inventory");
					}});
			
		}
	}
}
