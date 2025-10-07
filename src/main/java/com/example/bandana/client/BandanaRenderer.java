package com.example.bandana.client;

import com.natanfudge.objloader.ObjModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.MinecraftClient;

public class BandanaRenderer {
    private static final Identifier BANDANA_TEXTURE = new Identifier("bandana", "textures/bandana.png");
    private static final Identifier BANDANA_OBJ = new Identifier("bandana", "models/bandana.obj");
    private static ObjModel bandanaModel = null;

    public static void renderBandana(MatrixStack matrices, VertexConsumerProvider vertexConsumers,
                                    PlayerEntity player, PlayerEntityModel<?> entityModel, float tickDelta) {
        if (bandanaModel == null) {
            bandanaModel = ObjModel.loadObjModel(BANDANA_OBJ, BANDANA_TEXTURE);
        }

        matrices.push();
        // 頭の位置・回転に追従
        entityModel.head.rotate(matrices);

        // 頭の位置調整 (必要に応じて調整)
        matrices.translate(0.0, -0.25, 0.0);

        // モデル描画
        bandanaModel.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(BANDANA_TEXTURE)));

        matrices.pop();
    }
}