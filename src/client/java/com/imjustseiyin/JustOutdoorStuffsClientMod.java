package com.imjustseiyin;

import com.imjustseiyin.block.ModBlocks;
import com.imjustseiyin.sit.SitEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class JustOutdoorStuffsClientMod implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(JustOutdoorStuffsMod.SIT_ENTITY_TYPE, JustOutdoorStuffsClientMod.EmptyRenderer::new);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),
				ModBlocks.GARDEN_CHAIR,
				ModBlocks.GARDEN_STOOL,
				ModBlocks.GARDEN_BENCH,
				ModBlocks.GARDEN_TABLE_SMALL,
				ModBlocks.GARDEN_TABLE_WIDE,
				ModBlocks.GARDEN_TABLE_LARGE,
				ModBlocks.PATIO_IRON_CHAIR,
				ModBlocks.PATIO_IRON_STOOL,
				ModBlocks.PATIO_IRON_BENCH,
				ModBlocks.PATIO_IRON_TABLE_SMALL,
				ModBlocks.PATIO_IRON_TABLE_WIDE,
				ModBlocks.PATIO_IRON_TABLE_LARGE,
				ModBlocks.PATIO_IRON_ROCKING_CHAIR,
				ModBlocks.PATIO_BBQ_GRILL,
				ModBlocks.PATIO_COFFEE_TABLE_GLASS
				);

	}
	private static class EmptyRenderer extends EntityRenderer<SitEntity> {
		protected EmptyRenderer(EntityRendererFactory.Context ctx) {
			super(ctx);
		}

		@Override
		public boolean shouldRender(SitEntity entity, Frustum frustum, double d, double e, double f) {
			return false;
		}

		@Override
		public Identifier getTexture(SitEntity entity) {
			return null;
		}
	}
}