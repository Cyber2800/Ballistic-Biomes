package com.ballisticbiomes.entity.projectile;

import com.ballisticbiomes.entity.BBEntityType;
import com.ballisticbiomes.item.BBItems;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DustedDesertRoseEntity extends ProjectileItemEntity implements IRendersAsItem {
	
	public DustedDesertRoseEntity(EntityType<? extends DustedDesertRoseEntity> entityType, World world) {
		super(entityType, world);
		
	}
	
	public DustedDesertRoseEntity(World worldIn, LivingEntity throwerIn) {
		super(BBEntityType.DUSTED_DESERT_ROSE.get(), throwerIn, worldIn);
		
	}
	
	public DustedDesertRoseEntity(World worldIn, double x, double y, double z) {
		super(BBEntityType.DUSTED_DESERT_ROSE.get(), x, y, z, worldIn);
		
	}
	
	@Override
	protected Item getDefaultItem() {
		
		return BBItems.DUSTED_DESERT_ROSE.get();
		
	}
	
	@OnlyIn(Dist.CLIENT)
	private IParticleData makeParticle() {
		
		ItemStack itemstack = this.func_213882_k();
		return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, itemstack));
		
	}
	
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		
		if (id == 3) {
			
			IParticleData iparticledata = this.makeParticle();
			
			for (int i = 0; i < 8; ++i) {
				
				this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
				
			}
			
		}
		
	}
	
	protected void onImpact(RayTraceResult result) {
		super.onImpact(result);
		
		if (!this.world.isRemote) {
			
			this.world.setEntityState(this, (byte)3);
			this.world.createExplosion(this, this.getPosX(), this.getPosY(), this.getPosZ(), 1.0F, Explosion.Mode.BREAK);
			this.remove();
			
		}
		
	}
	
	@Override
	public IPacket<?> createSpawnPacket() {
		
		return new SSpawnObjectPacket(this);
		
	}
	
}