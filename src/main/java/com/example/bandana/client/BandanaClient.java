package com.example.bandana.client;

import com.example.bandana.BandanaMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.PlayerEntityRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.player.PlayerEntity;

public class BandanaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PlayerEntityRenderEvents.AFTER.register((renderer, context, matrices, vertexConsumers, player, entityModel, tickDelta) -> {
            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.player != null && player == mc.player) {
                BandanaRenderer.renderBandana(matrices, vertexConsumers, player, (PlayerEntityModel<?>) entityModel, tickDelta);
            }
        });
    }
}