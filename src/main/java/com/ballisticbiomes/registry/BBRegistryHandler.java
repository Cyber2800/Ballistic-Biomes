package com.ballisticbiomes.registry;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import com.ballisticbiomes.BallisticBiomes;
import com.ballisticbiomes.block.BBBlocks;
import com.ballisticbiomes.entity.BBEntityType;
import com.ballisticbiomes.item.BBItems;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(BallisticBiomes.MODID)
@Mod.EventBusSubscriber(modid = BallisticBiomes.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class BBRegistryHandler {
	
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		
		final IForgeRegistry<Item> registry = event.getRegistry();
		AtomicInteger blockItemCount = new AtomicInteger();
		
		BBBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).filter(BBBlocks::shouldRegisterItemBlock).forEach(block -> {
			
			final Item.Properties properties = new Item.Properties().group(ItemGroup.DECORATIONS);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(Objects.requireNonNull(block.getRegistryName()));
			registry.register(blockItem);
			blockItemCount.getAndIncrement();
			
		});
		
	}
	
	public static void registerDeferred(IEventBus iEventBus) {

		BBBlocks.BLOCKS.register(iEventBus);
		BBItems.ITEMS.register(iEventBus);
		BBEntityType.ENTITIES.register(iEventBus);
		
	}
	
}