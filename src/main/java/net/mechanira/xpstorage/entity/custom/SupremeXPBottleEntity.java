package net.mechanira.xpstorage.entity.custom;

import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class SupremeXPBottleEntity extends ThrownItemEntity {
    public SupremeXPBottleEntity(EntityType<? extends SupremeXPBottleEntity> entityType, World world) {
        super(entityType, world);
    }

    public SupremeXPBottleEntity(World world, LivingEntity owner) {
        super(EntityType.EXPERIENCE_BOTTLE, owner, world);
    }

    public SupremeXPBottleEntity(World world, double x, double y, double z) {
        super(EntityType.EXPERIENCE_BOTTLE, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.EXPERIENCE_BOTTLE;
    }

    @Override
    protected double getGravity() {
        return 0.07;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (this.getWorld() instanceof ServerWorld) {
            this.getWorld().syncWorldEvent(WorldEvents.SPLASH_POTION_SPLASHED, this.getBlockPos(), PotionContentsComponent.getColor(Potions.WATER));
            int i = 255 + this.getWorld().random.nextInt(412) + this.getWorld().random.nextInt(413);
            ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), i);
            this.discard();
        }
    }
}

