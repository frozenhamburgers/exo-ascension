package net.jelly.exo_ascension.render;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.jelly.exo_ascension.event.ClientEvents;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

public class ModRenderTypes {
//    public static RenderType getCustomEntityRenderType(ResourceLocation resourcelocation) {
//        RenderType.CompositeState state = RenderType.CompositeState.builder()
//                .setShaderState(new RenderStateShard.ShaderStateShard(() -> ClientEvents.CUSTOM_SKY_SHADER))
//                .setTextureState(new RenderStateShard.TextureStateShard(resourcelocation, false, false))
//                .setTransparencyState(RenderType.NO_TRANSPARENCY)
//                .setCullState(RenderType.NO_CULL)
//                .setLightmapState(RenderType.LIGHTMAP)
//                .setOverlayState(RenderType.OVERLAY)
//                .createCompositeState(true);
//
//        return RenderType.create("custom_entity_rendertype", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, false, state);
//    }

    // kinda a cool effect, projects onto screenspace weird play with it later
//    public static final Function<ResourceLocation, RenderType> CHARGED_EYES = Util.memoize((p_286170_) -> {
//        RenderStateShard.TextureStateShard renderstateshard$texturestateshard = new RenderStateShard.TextureStateShard(p_286170_, false, false);
//        return RenderType.create("eyes", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true,
//                RenderType.CompositeState.builder()
//                        .setShaderState(new RenderStateShard.ShaderStateShard(() -> ClientEvents.CUSTOM_SKY_SHADER))
//                        .setTextureState(renderstateshard$texturestateshard)
//                        .setTransparencyState(RenderStateShard.ADDITIVE_TRANSPARENCY)
//                        .setWriteMaskState(RenderStateShard.COLOR_WRITE)
//                        .createCompositeState(false));
//    });

    public static final Function<ResourceLocation, RenderType> CHARGED_EYES = Util.memoize((p_286170_) -> {
        RenderStateShard.TextureStateShard renderstateshard$texturestateshard = new RenderStateShard.TextureStateShard(p_286170_, false, false);
        return RenderType.create("eyes", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, false, true,
                RenderType.CompositeState.builder()
                        .setShaderState(new RenderStateShard.ShaderStateShard(() -> ClientEvents.CUSTOM_SKY_SHADER))
                        .setTextureState(renderstateshard$texturestateshard)
                        .setTransparencyState(RenderStateShard.ADDITIVE_TRANSPARENCY)
                        .setWriteMaskState(RenderStateShard.COLOR_WRITE)
                        .createCompositeState(false));
    });
}

