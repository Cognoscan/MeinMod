package cognoscan.meinMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DumbBlock extends Block
{
	private final String name = "dumbBlock";
	
	public DumbBlock ()
	{
		super(Material.ground);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(MeinMod.MODID + "_" + name);
		setHarvestLevel("shovel",0);
		setHardness(0.5f);
		setStepSound(Block.soundTypeGravel);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public String getName () {
		return name;
	}
}
