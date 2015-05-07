package cognoscan.meinMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TealDust extends Item
{
	private final String name = "tealDust";
	
	public TealDust()
	{
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabMaterials);
	}
	
	public String getName () {
		return name;
	}
	
}
