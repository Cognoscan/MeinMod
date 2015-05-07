package cognoscan.meinMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TealOre extends Block
{
	private final String name = "tealOre";
	
	public TealOre ()
	{
		super(Material.rock);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(MeinMod.MODID + "_" + name);
		setHarvestLevel("pickaxe",2);
		setHardness(2.0f);
		setResistance(5.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public String getName () {
		return name;
	}
	
	// Set to drop tealDust, smeltable into tealIngot
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return MeinMod.tealDust;
		
	}
	
	// Set to drop 2 dusts with chance for bonus based on fortune
	@Override
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
		if (fortune == 0) {
			return 2;
		} else {
			int rand = random.nextInt(fortune + 2) - 1;
			return (rand < 0) ? 2 : 2 * (rand+1);
		}
    }
}
