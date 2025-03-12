package net.mechanira.xpstorage.entity.custom;

import net.mechanira.xpstorage.item.ModItems;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

public class SuperXPBottleEntity extends ThrownItemEntity {
    public SuperXPBottleEntity(EntityType<? extends SuperXPBottleEntity> entityType, World world) {
        super(entityType, world);
    }

    public SuperXPBottleEntity(World world, LivingEntity owner, ItemStack stack) {
        super(EntityType.EXPERIENCE_BOTTLE, owner, world, stack);
    }

    public SuperXPBottleEntity(World world, double x, double y, double z, ItemStack stack) {
        super(EntityType.EXPERIENCE_BOTTLE, x, y, z, world, stack);
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
            this.getWorld().syncWorldEvent(WorldEvents.SPLASH_POTION_SPLASHED, this.getBlockPos(), -13083194);
            int i = 85 + this.getWorld().random.nextInt(85) + this.getWorld().random.nextInt(85);
            ExperienceOrbEntity.spawn((ServerWorld)this.getWorld(), this.getPos(), i);
            this.discard();
        }
    }
}

