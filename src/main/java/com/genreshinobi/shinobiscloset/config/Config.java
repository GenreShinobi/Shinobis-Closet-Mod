package com.genreshinobi.shinobiscloset.config;

import com.genreshinobi.shinobiscloset.ShinobisCloset;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = ShinobisCloset.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    // TODO: Add SimpleRecipe Configs

        public static final ClientConfig CLIENT;
        public static final ForgeConfigSpec CLIENT_SPEC;
        static {
            final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
            CLIENT_SPEC = specPair.getRight();
            CLIENT = specPair.getLeft();
        }

        // Bake the config values
        private static int shroudDurability;
        private static boolean consumeClothes;

        public static void bakeConfig() {
            shroudDurability = CLIENT.shroudDurability.get();
            consumeClothes = CLIENT.consumeClothes.get();
        }

        public static int getShroudDurability() {
            return shroudDurability;
        }

        public static boolean getConsumeClothes() {
            return consumeClothes;
        }

        // Doesn't need to be an inner class
        public static class ClientConfig {

            public final IntValue shroudDurability;
            public final BooleanValue consumeClothes;

            public ClientConfig(ForgeConfigSpec.Builder builder) {
                builder.push("gameplay");
                shroudDurability = builder
                        .comment("Modifies the durability of Shinobi's Fabulous Shroud. Infinite: 0")
                        .translation(ShinobisCloset.MOD_ID + ".config." + "shroudDurability")
                        .defineInRange("shroudDurability", 0, 0, 100);

                consumeClothes = builder
                        .comment("Modifies if individual clothes are consumed on use. True: Clothes will be consumed on use. False: Clothes will have an unlimited number of uses. Default: true")
                        .translation(ShinobisCloset.MOD_ID + ".config." + "consumeClothes")
                        .define("consumeClothes", true);

                builder.pop();

            }
        }
}
