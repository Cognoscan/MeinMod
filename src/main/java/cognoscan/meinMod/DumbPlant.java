package cognoscan.meinMod;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DumbPlant extends BlockCrops {
	
	private final String name = "dumbPlant";

    public DumbPlant()
    {
    	super();
    	GameRegistry.registerBlock(this, null, name);
		setUnlocalizedName(MeinMod.MODID + "_" + name);
    }
    
	public String getName () {
		return name;
	}

    @Override
    protected Item getSeed()
    {
    	return MeinMod.dumbSeed;
    }

    @Override
    protected Item getCrop()
    {
    	return MeinMod.tealDust;
    }
    
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
    {
    	if (rand.nextInt(3) == 2) {
    		return true;
    	} else {
    		return false;
    	}
    }
	
}
