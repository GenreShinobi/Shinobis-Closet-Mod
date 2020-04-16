package com.genreshinobi.shinobiscloset.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

public class ClothesItem extends Item {

    protected IVillagerType villagerType;

    public ClothesItem(String nameIn, IVillagerType typeIn, Item.Properties builder) {
        super(builder);
        setRegistryName(nameIn);
        villagerType = typeIn;
    }

    public boolean itemInteractionForEntity(ItemStack stackIn, PlayerEntity playerIn, LivingEntity targetIn, Hand handIn){
        if (targetIn instanceof VillagerEntity) {
            VillagerEntity villagerEntity = (VillagerEntity)targetIn;
            if (villagerEntity.isAlive()) {
                villagerEntity.setVillagerData(villagerEntity.getVillagerData().withType(this.villagerType));
            }
            return true;
        } else {
            return false;
        }
    }

}
