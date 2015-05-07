package cognoscan.meinMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemBerry extends ItemFood
{
	private final String name = "berry";
	
	private int secondPotionId;
	private int secondPotionDuration;
	private int secondPotionAmplifier;
	private float secondPotionProbability;
	
	public ItemBerry(int amount, float saturation, boolean isWolfFood)
	{
		super(amount, saturation, isWolfFood);
		GameRegistry.registerItem(this, name);
		this.setUnlocalizedName(MeinMod.MODID + "_" + name);
		setCreativeTab(CreativeTabs.tabFood);
		setAlwaysEdible();
		setPotionEffect(Potion.moveSpeed.id, 30, 1, 1.0f);
		setSecondPotionEffect(Potion.nightVision.id, 30, 1, 1.0f);
	}
	
	@Override
	protected void onFoodEaten (ItemStack item, World world, EntityPlayer player)
	{
		super.onFoodEaten(item, world, player);
		if (!world.isRemote && 
			this.secondPotionId > 0 && 
			world.rand.nextFloat() < this.secondPotionProbability)
		{
			player.addPotionEffect(new PotionEffect(
					this.secondPotionId,
					this.secondPotionDuration * 20,
					this.secondPotionAmplifier));
		}
	}
	
    /**
     * sets a secondary potion effect on the item. Args: int potionId, int duration (will be multiplied by 20), int amplifier,
     * float probability of effect happening
     */
    public ItemFood setSecondPotionEffect(int id, int duration, int amplifier, float probability)
    {
        this.secondPotionId = id;
        this.secondPotionDuration = duration;
        this.secondPotionAmplifier = amplifier;
        this.secondPotionProbability = probability;
        return this;
    }
	
	
	public String getName () {
		return name;
	}
}
