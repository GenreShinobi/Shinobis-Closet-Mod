package com.genreshinobi.shinobiscloset.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.lwjgl.system.NonnullDefault;

public class ClothesItem extends Item {

    protected IVillagerType villagerType;
    protected Boolean consumedOnUse = true;
    protected Boolean isShroud = false;

    public ClothesItem(String nameIn, IVillagerType typeIn, Item.Properties builder) {
        super(builder);
        setRegistryName(nameIn);
        this.villagerType = typeIn;
    }

    public ClothesItem(String nameIn, Item.Properties builder, Boolean isShroudIn) {
        this(nameIn, IVillagerType.PLAINS, builder);
        this.consumedOnUse = !isShroudIn;
        this.isShroud = isShroudIn;
    }

    @NonnullDefault
    public boolean itemInteractionForEntity(ItemStack stackIn, PlayerEntity playerIn, LivingEntity targetIn, Hand handIn){
        if (targetIn instanceof VillagerEntity) {
            VillagerEntity villagerEntity = (VillagerEntity)targetIn;
            IVillagerType thisVillagerType = villagerEntity.getVillagerData().getType();
            if (villagerEntity.isAlive()) {
                if(isShroud){
                    if (IVillagerType.DESERT.equals(thisVillagerType)) {
                        this.villagerType = IVillagerType.JUNGLE;
                    } else if (IVillagerType.JUNGLE.equals(thisVillagerType)) {
                        this.villagerType = IVillagerType.PLAINS;
                    } else if (IVillagerType.PLAINS.equals(thisVillagerType)) {
                        this.villagerType = IVillagerType.SAVANNA;
                    } else if (IVillagerType.SAVANNA.equals(thisVillagerType)) {
                        this.villagerType = IVillagerType.SNOW;
                    } else if (IVillagerType.SNOW.equals(thisVillagerType)) {
                        this.villagerType = IVillagerType.SWAMP;
                    } else if (IVillagerType.SWAMP.equals(thisVillagerType)) {
                        this.villagerType = IVillagerType.TAIGA;
                    } else if (IVillagerType.TAIGA.equals(thisVillagerType)) {
                        this.villagerType = IVillagerType.DESERT;
                    } else {
                        this.villagerType = IVillagerType.PLAINS;
                    }
                }
                villagerEntity.setVillagerData(villagerEntity.getVillagerData().withType(this.villagerType));
            }
            if(consumedOnUse) {
                stackIn.shrink(1);
            }
            return true;
        } else {
            return false;
        }
    }

}
