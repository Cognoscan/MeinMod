package cognoscan.meinMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TealIngot extends Item
{
	private final String name = "tealIngot";
	
	public TealIngot()
	{
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public String getName () {
		return name;
	}
	
}
