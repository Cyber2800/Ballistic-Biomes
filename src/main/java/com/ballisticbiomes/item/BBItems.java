package com.ballisticbiomes.item;

import com.ballisticbiomes.BallisticBiomes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BBItems {
	
	public static final Item.Properties PROPERTIES = new Item.Properties().group(ItemGroup.MISC);
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BallisticBiomes.MODID);
	
	public static final RegistryObject<Item> DESERT_ROSE = ITEMS.register("desert_rose", () -> new Item(PROPERTIES));
	public static final RegistryObject<Item> DUSTED_DESERT_ROSE = ITEMS.register("dusted_desert_rose", () -> new DustedDesertRoseItem(PROPERTIES));
	
}