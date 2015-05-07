package cognoscan.meinMod;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TealPaxel extends ItemTool
{
	private final String name = "tealPaxel";
	
	private static final Set EFFECTIVE_ON = Sets.newHashSet(new Block[] {
			// Pickaxe
			Blocks.activator_rail,
			Blocks.coal_ore,
			Blocks.cobblestone,
			Blocks.detector_rail,
			Blocks.diamond_block,
			Blocks.diamond_ore,
			Blocks.double_stone_slab,
			Blocks.golden_rail,
			Blocks.gold_block,
			Blocks.gold_ore,
			Blocks.ice,
			Blocks.iron_block,
			Blocks.iron_ore,
			Blocks.lapis_block,
			Blocks.lapis_ore,
			Blocks.lit_redstone_ore,
			Blocks.mossy_cobblestone,
			Blocks.netherrack,
			Blocks.packed_ice,
			Blocks.rail,
			Blocks.redstone_ore,
			Blocks.sandstone,
			Blocks.red_sandstone,
			Blocks.stone,
			Blocks.stone_slab,
			// Axe
			Blocks.planks,
			Blocks.bookshelf,
			Blocks.log,
			Blocks.log2,
			Blocks.chest,
			Blocks.pumpkin,
			Blocks.lit_pumpkin, 
			Blocks.melon_block,
			Blocks.ladder,
			// Shovel
			Blocks.clay, 
			Blocks.dirt,
			Blocks.farmland,
			Blocks.grass,
			Blocks.gravel, 
			Blocks.mycelium, 
			Blocks.sand, 
			Blocks.snow, 
			Blocks.snow_layer, 
			Blocks.soul_sand
			});
	
    protected TealPaxel(Item.ToolMaterial material)
    {
        super(2.0F, material, EFFECTIVE_ON);
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
	}
	
	public String getName () {
		return name;
	}
	
    /**
     * Check whether this Item can harvest the given Block
     */
	@Override
    public boolean canHarvestBlock(Block blockIn)
    {
    	if (blockIn == Blocks.obsidian) {
    		return this.toolMaterial.getHarvestLevel() >= 3; 
    	} else if (blockIn == Blocks.diamond_block || blockIn == Blocks.diamond_ore
    			|| blockIn == Blocks.emerald_block || blockIn == Blocks.emerald_ore
    			|| blockIn == Blocks.gold_block    || blockIn == Blocks.gold_ore
    			|| blockIn == Blocks.redstone_ore  || blockIn == Blocks.lit_redstone_ore) {
    		return this.toolMaterial.getHarvestLevel() >= 2;
    	} else if (blockIn == Blocks.iron_block  || blockIn == Blocks.iron_ore
    			|| blockIn == Blocks.lapis_block || blockIn == Blocks.lapis_ore) {
    		return this.toolMaterial.getHarvestLevel() >= 1;
    	} else if (blockIn == Blocks.snow_layer) {
    		return true;
    	} else if (blockIn == Blocks.snow) {
    		return true;
    	} else {
    		Material mat = blockIn.getMaterial();
    		if (mat == Material.rock || mat == Material.iron || mat == Material.anvil) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    }

	@Override
    public float getStrVsBlock(ItemStack stack, Block block)
    {
    	Material mat = block.getMaterial();
    	if (mat == Material.wood || mat == Material.plants || mat == Material.vine ||
    	    mat == Material.iron || mat == Material.anvil  || mat == Material.rock) { 
    		return this.efficiencyOnProperMaterial;
    	} else {
    		return super.getStrVsBlock(stack, block);
    	}
    }
	
}
