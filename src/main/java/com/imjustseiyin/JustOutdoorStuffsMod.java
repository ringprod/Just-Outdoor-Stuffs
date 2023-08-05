package com.imjustseiyin;

import com.imjustseiyin.block.ModBlocks;
import com.imjustseiyin.item.ModItems;
import com.imjustseiyin.sit.SitEntity;
import com.imjustseiyin.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JustOutdoorStuffsMod implements ModInitializer {

	public static final String MOD_ID = "justoutdoorstuffs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final EntityType<SitEntity> SIT_ENTITY_TYPE = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier("justoutdoorstuffs", "entity_sit"),
			FabricEntityTypeBuilder.<SitEntity>create(SpawnGroup.MISC, SitEntity::new).dimensions(EntityDimensions.fixed(0.001F, 0.001F)).build()
	);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		FabricDefaultAttributeRegistry.register(SIT_ENTITY_TYPE, SitEntity.createMobAttributes());
	}
}