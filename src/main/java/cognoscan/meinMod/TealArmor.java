package cognoscan.meinMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TealArmor extends ItemArmor
{
	private String name = "tealArmor";
	
	public TealArmor(ItemArmor.ArmorMaterial material, int armorType, String newName)
	{
		super(material, 0, armorType);
		name = newName;
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
	}
	
	public String getName () {
		return name;
	}
	
	@Override
	public void onArmorTick (World world, EntityPlayer player, ItemStack stack)
	{
		if (stack.getItem() == MeinMod.tealHelmet)
		{
			if (player.isInWater())
			{
				player.setAir(200);
			}
		}
		
	}
	
}
