package cognoscan.meinMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TealHoe extends ItemHoe
{
	private final String name = "tealHoe";
	
	public TealHoe(Item.ToolMaterial material)
	{
		super(material);
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
	}
	
	public String getName () {
		return name;
	}
	
}
