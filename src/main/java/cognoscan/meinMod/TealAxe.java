package cognoscan.meinMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TealAxe extends ItemAxe
{
	private final String name = "tealAxe";
	
	public TealAxe(Item.ToolMaterial material)
	{
		super(material);
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
	}
	
	public String getName () {
		return name;
	}
	
}
