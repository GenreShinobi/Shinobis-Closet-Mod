package com.genreshinobi.shinobiscloset.events;

import com.genreshinobi.shinobiscloset.ShinobisCloset;
import com.genreshinobi.shinobiscloset.items.ClothesItem;
import com.genreshinobi.shinobiscloset.lists.ItemList;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    public static final Logger LOGGER = ShinobisCloset.LOGGER;
    public static final String MOD_ID = ShinobisCloset.MOD_ID;

    public ResourceLocation Location (String name) { return new ResourceLocation(MOD_ID, name); }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
            ItemList.CLOTHES_DESERT = new ClothesItem("clothes_desert", IVillagerType.DESERT, new Item.Properties().group(ItemGroup.MISC)),
            ItemList.CLOTHES_JUNGLE = new ClothesItem("clothes_jungle", IVillagerType.JUNGLE, new Item.Properties().group(ItemGroup.MISC)),
            ItemList.CLOTHES_PLAINS = new ClothesItem("clothes_plains", IVillagerType.PLAINS, new Item.Properties().group(ItemGroup.MISC)),
            ItemList.CLOTHES_SAVANNA = new ClothesItem("clothes_savanna", IVillagerType.SAVANNA, new Item.Properties().group(ItemGroup.MISC)),
            ItemList.CLOTHES_SNOW = new ClothesItem("clothes_snow", IVillagerType.SNOW, new Item.Properties().group(ItemGroup.MISC)),
            ItemList.CLOTHES_SWAMP = new ClothesItem("clothes_swamp", IVillagerType.SWAMP, new Item.Properties().group(ItemGroup.MISC)),
            ItemList.CLOTHES_TAIGA = new ClothesItem("clothes_taiga", IVillagerType.TAIGA, new Item.Properties().group(ItemGroup.MISC))
        );
    }
}
