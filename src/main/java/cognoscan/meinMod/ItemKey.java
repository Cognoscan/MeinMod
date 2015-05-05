package cognoscan.meinMod;

import java.awt.Color;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKey extends Item
{
	private final String name = "key";
	
	public ItemKey()
	{
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
		this.setHasSubtypes(true);
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	 @Override
	 public int getMetadata(int damage) {
	 return damage;
	 }

	 @Override
	 // Make a unique name for each key color so we can name them individually
	 public String getUnlocalizedName(ItemStack stack)
	 {
		 return super.getUnlocalizedName() + "." + EnumKeys.byMetadata(stack.getMetadata()).getName();
	 }
	
	 @SideOnly(Side.CLIENT)
	 public void getSubItems(Item itemIn, CreativeTabs tab, List subItems)
	 {
		 for (EnumKeys subKey : EnumKeys.values())
		 {
			 subItems.add(new ItemStack(itemIn, 1, subKey.getMetadata()));
		 }
	 }
	 
	 @SideOnly(Side.CLIENT)
	 public int getColorFromItemStack(ItemStack stack, int renderLayer)
	 {
		 return EnumKeys.byMetadata(stack.getMetadata()).getRenderColour().getRGB();
	 }
	
	public String getName () {
		return name;
	}
	
	////////////////////////////////////////////////////////
	// Enumeration of Keys
	////////////////////////////////////////////////////////
	
	 public static enum EnumKeys implements IStringSerializable
	 {
		 WHITE(0, "white", Color.WHITE),
		 RED(1, "red", Color.RED),
		 ORANGE(2,"orange", Color.ORANGE);
		 
		 public int getMetadata()
		 {
			 return this.meta;
		 }
	 
		 @Override
		 public String toString()
		 {
			 return this.name;
		 }
		 
		 public static EnumKeys byMetadata(int meta)
		 {
			 if (meta < 0 || meta >= META_LOOKUP.length)
				 meta = 0;
			 return META_LOOKUP[meta];
		 }

		 public String getName()
		 {
			 return this.name;
		 }
		 public Color getRenderColour() {return renderColour;}
		 
		 private final int meta;
		 private final String name;
		 private final Color renderColour;
		 private static final EnumKeys[] META_LOOKUP = new EnumKeys[values().length];
		 
		 private EnumKeys(int i_meta, String i_name, Color i_renderColour)
		 {
			 this.meta = i_meta;
			 this.name = i_name;
			 this.renderColour = i_renderColour;
		 }
		 static
		 {
			 for (EnumKeys value : values()) {
				 META_LOOKUP[value.getMetadata()] = value;
			 }
		 }
	 }
	
}
