package com.ballisticbiomes.block;

import java.util.Set;

import com.ballisticbiomes.BallisticBiomes;
import com.google.common.base.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BBBlocks {
	
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BallisticBiomes.MODID);
	public static final Set<RegistryObject<Block>> PURE_BLOCKS = new java.util.HashSet<>();
	
	public static final RegistryObject<Block> DESERT_ROSE = register("desert_rose_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.SAND).func_235861_h_().hardnessAndResistance(0.8F)));
	
	private static RegistryObject<Block> register(String name, Supplier<? extends Block> sup, boolean hasItem) {
		
		RegistryObject<Block> registryObject = BLOCKS.register(name, sup);
		
		if (!hasItem) {
			
			PURE_BLOCKS.add(registryObject);
		
		}
		
		return registryObject;
		
	}
	
	private static RegistryObject<Block> register(String name, Supplier<? extends Block> sup) {
		
		return register(name, sup, true);
		
	}
	
	public static boolean shouldRegisterItemBlock(Block block) {
		
		for (RegistryObject<Block> pureBlock : PURE_BLOCKS) {
			
			if (pureBlock.get() == block) {
				
				return false;
				
			}
		}
		
		return true;
		
	}
	
}