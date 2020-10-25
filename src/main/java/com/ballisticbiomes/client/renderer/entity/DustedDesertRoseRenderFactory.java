package com.ballisticbiomes.client.renderer.entity;

import com.ballisticbiomes.entity.projectile.DustedDesertRoseEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class DustedDesertRoseRenderFactory implements IRenderFactory<DustedDesertRoseEntity> {
	
	@Override
	public EntityRenderer<? super DustedDesertRoseEntity> createRenderFor(EntityRendererManager manager) {
		
		return new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer());
		
	}
	
}