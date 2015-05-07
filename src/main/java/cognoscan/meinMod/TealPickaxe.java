package cognoscan.meinMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TealPickaxe extends ItemPickaxe
{
	private final String name = "tealPickaxe";
	
	public TealPickaxe(Item.ToolMaterial material)
	{
		super(material);
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
	}
	
	public String getName () {
		return name;
	}
	
}
