package com.imjustseiyin.justoutdoorstuffs;

import com.imjustseiyin.justoutdoorstuffs.block.ModBlocks;
import com.imjustseiyin.justoutdoorstuffs.item.ModItemGroups;
import com.imjustseiyin.justoutdoorstuffs.item.ModItems;
import com.imjustseiyin.justoutdoorstuffs.sit.SitEntity;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(JustOutdoorStuffsMod.MOD_ID)
public class JustOutdoorStuffsMod {
    public static final String MOD_ID = "justoutdoorstuffs";
    private static final Logger LOGGER = LogUtils.getLogger();
    /*public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, JustOutdoorStuffsMod.MOD_ID);

    public static final RegistryObject<EntityType<SitEntity>> SIT_ENTITY_TYPE =
            ENTITY_TYPES.register("sit", () -> EntityType.Builder.<SitEntity>of(SitEntity::new, MobCategory.MISC).sized(0.001F, 0.001F).setTrackingRange(256)
                    .setUpdateInterval(20).build(MOD_ID + ":sit"));*/
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);
    public static final RegistryObject<EntityType<SitEntity>> SIT_ENTITY_TYPE = ENTITY_TYPES.register("entity_sit", () -> EntityType.Builder.<SitEntity>of(SitEntity::new, MobCategory.MISC)
            .setTrackingRange(256)
            .setUpdateInterval(20)
            .sized(0.0001F, 0.0001F)
            .build(MOD_ID + ":entity_sit"));

    public JustOutdoorStuffsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItemGroups.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(SIT_ENTITY_TYPE.get(), EmptyRenderer::new);
        }

        private static class EmptyRenderer extends EntityRenderer<SitEntity> {
            protected EmptyRenderer(EntityRendererProvider.Context ctx) {
                super(ctx);
            }

            @Override
            public boolean shouldRender(SitEntity entity, Frustum camera, double camX, double camY, double camZ) {
                return false;
            }

            @Override
            public ResourceLocation getTextureLocation(SitEntity entity) {
                return null;
            }
        }
    }
}
