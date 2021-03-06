package cognoscan.meinMod;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DumbSeed extends Item implements IPlantable
{
	private final String name = "dumbSeed";
	private Block plant;
	
	public DumbSeed(Block plant)
	{
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMaterials);
		this.plant = plant;
	}
	
	public String getName () {
		return name;
	}
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (side != EnumFacing.UP)
        {
            return false;
        }
        else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
        {
            return false;
        }
        else if (worldIn.getBlockState(pos).getBlock().canSustainPlant(worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
        {
            worldIn.setBlockState(pos.up(), this.plant.getDefaultState());
            --stack.stackSize;
            return true;
        }
        else
        {
            return false;
        }
    }

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		// TODO Auto-generated method stub
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return this.plant.getDefaultState();
	}
	
}
