package com.imjustseiyin.entity;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import com.imjustseiyin.sit.SitEntity;

public class EmptyRenderer extends EntityRenderer<SitEntity> {
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