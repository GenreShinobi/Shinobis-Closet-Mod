package com.genreshinobi.shinobiscloset.config;

import com.genreshinobi.shinobiscloset.ShinobisCloset;
import net.minecraftforge.common.ForgeConfig.Client;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber
public class Config {

        public static final ClientConfig CLIENT;
        public static final ForgeConfigSpec CLIENT_SPEC;
        static {
            final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
            CLIENT_SPEC = specPair.getRight();
            CLIENT = specPair.getLeft();
        }

        // Bake the config values
        private static boolean aBoolean;
        private static int anInt;

        public static void bakeConfig() {
            aBoolean = CLIENT.aBoolean.get();
            anInt = CLIENT.anInt.get();
        }

        // Doesn't need to be an inner class
        public static class ClientConfig {

            public final BooleanValue aBoolean;
            public final IntValue anInt;

            public ClientConfig(ForgeConfigSpec.Builder builder) {
                aBoolean = builder
                        .comment("aBoolean usage description")
                        .translation(ShinobisCloset.MOD_ID + ".config." + "aBoolean")
                        .define("aBoolean", false);

                builder.push("category");
                anInt = builder
                        .comment("anInt usage description")
                        .translation(ShinobisCloset.MOD_ID + ".config." + "anInt")
                        .defineInRange("anInt", 10, 0, 100);

                builder.pop();

            }
        }
}
