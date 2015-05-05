package cognoscan.meinMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
	
	public static Item dumbThing;
	
	public static World world;
	
	@Instance(value = MeinMod.MODID) // Tell Forge what instance to use
	public static MeinMod instance;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		// blocks
		dumbBlock = new DumbBlock();
		dumbThing = new DumbThing();
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
    	//recipes
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
		
		if (event.getSide() == Side.CLIENT)
		{
			RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
			
			renderItem.getItemModelMesher().register(Item.getItemFromBlock(dumbBlock), 0,
					new ModelResourceLocation(MeinMod.MODID + ":" + ((DumbBlock) dumbBlock).getName(), "inventory"));
			renderItem.getItemModelMesher().register(dumbThing, 0,
					new ModelResourceLocation(MeinMod.MODID + ":" + ((DumbThing) dumbThing).getName(), "inventory"));
			
		}
	}
}
