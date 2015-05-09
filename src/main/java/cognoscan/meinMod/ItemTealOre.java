package cognoscan.meinMod;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTealOre extends ItemBlock {

	private static final String[] subName = {"tealOre", "tealStone"};
	private final String name = "tealOre";
	
	 // you must use Block in the constructor, not BlockVariants, otherwise you won't be able to register the block properly.
	// i.e. using GameRegistry.registerBlock(block, ItemBlockVariants.class, name)
	public ItemTealOre(Block block)
	{
		super(block);
		setHasSubtypes(true);
		setUnlocalizedName(name);
	}
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getName(int meta)
	{
		meta = (meta >= subName.length) ? 0 : meta;
		return subName[meta];
	}
	
	// create a unique unlocalised name for each block, so that we can give each one a unique name
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		int meta = stack.getMetadata();
		meta = (meta >= subName.length) ? 0 : meta;
		return MeinMod.MODID + "_" + subName[meta];
	}
}
