package com.ballisticbiomes.entity;

import com.ballisticbiomes.BallisticBiomes;
import com.ballisticbiomes.entity.projectile.DustedDesertRoseEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BBEntityType {
	
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, BallisticBiomes.MODID);
	
	public static final RegistryObject<EntityType<DustedDesertRoseEntity>> DUSTED_DESERT_ROSE = ENTITIES.register("dusted_desert_rose", () -> EntityType.Builder.<DustedDesertRoseEntity>create(DustedDesertRoseEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).build(BallisticBiomes.MODID + ":dusted_desert_rose"));
	
}