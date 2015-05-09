package cognoscan.meinMod;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TealOre extends Block
{
	public static final PropertyEnum PROPERTYTYPE = PropertyEnum.create("type", EnumType.class);
	private final String name = "tealOre";
	
	public TealOre ()
	{
		super(Material.rock);
		setUnlocalizedName(MeinMod.MODID + "_" + name);
		setHarvestLevel("pickaxe",2);
		setHardness(2.0f);
		setResistance(5.0f);
		setStepSound(soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
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
	
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
    	for (int i = 0; i < 2; i++) {
    		list.add(new ItemStack(itemIn, 1, i));
    	}
    }
    
    // getStateFromMeta, getMetaFromState are used to interconvert between the block's property values and
    // the stored metadata (which must be an integer in the range 0 - 15 inclusive)
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
    	EnumType type = EnumType.getType(meta);
    	return this.getDefaultState().withProperty(PROPERTYTYPE, type);
    }
    @Override
    public int getMetaFromState(IBlockState state)
    {
    	EnumType type = (EnumType)state.getValue(PROPERTYTYPE);
    	return type.getMetadata();
    }
    
    // necessary to define which properties your blocks use
    // will also affect the variants listed in the blockstates model file
    @Override
    protected BlockState createBlockState()
    {
    	return new BlockState(this, new IProperty[] {PROPERTYTYPE});
    }
    
    public static enum EnumType implements IStringSerializable
    {
        ORE(0, "ore"),
        STONE(1, "stone");
        private static final TealOre.EnumType[] META_LOOKUP = new TealOre.EnumType[values().length];
        private final int metadata;
        private final String name;

        private EnumType(int meta, String name)
        {
            this.metadata = meta;
            this.name = name;
        }

        public int getMetadata()
        {
            return this.metadata;
        }

        public String toString()
        {
            return this.name;
        }

        /**
         * Returns the matching EnumType for the given metadata.
         */
        public static TealOre.EnumType getType(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.name;
        }

        static
        {
            TealOre.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
                TealOre.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }

}
