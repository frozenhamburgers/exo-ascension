package net.jelly.exo_ascension.networking;

import net.jelly.exo_ascension.entity.invasion.aetherion.AetherionBoss;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class AetherionArmMessage {
    public int parentId;
    public int playerId;
    public int type;
    public double damage;
    public int armIndex;

    public AetherionArmMessage(int parentId, int playerId, int type, double damage, int armIndex) {
        this.parentId = parentId;
        this.playerId = playerId;
        this.type = type;
        this.damage = damage;
        this.armIndex = armIndex;
    }

    public static AetherionArmMessage read(FriendlyByteBuf buf) {
        return new AetherionArmMessage(buf.readInt(), buf.readInt(), buf.readInt(), buf.readDouble(), buf.readInt());
    }

    public static void write(AetherionArmMessage message, FriendlyByteBuf buf) {
        buf.writeInt(message.parentId);
        buf.writeInt(message.playerId);
        buf.writeInt(message.type);
        buf.writeDouble(message.damage);
        buf.writeInt(message.armIndex);
    }

    public static void handle(AetherionArmMessage message, Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            Player playerSided = context.get().getSender();
            if (context.get().getDirection().getReceptionSide() == LogicalSide.CLIENT) {
                playerSided = Minecraft.getInstance().player;
            }
            Entity parent = playerSided.level().getEntity(message.parentId);
            Entity interacter = playerSided.level().getEntity(message.playerId);
            if (interacter != null && parent != null && parent.isMultipartEntity() && interacter.distanceTo(parent) < 16) {
                if (message.type == 0) {
                    if (interacter instanceof Player player) {
                        parent.interact(player, player.getUsedItemHand());
                    }
                } else if (message.type == 1) {
                    if (interacter instanceof Player player && parent instanceof AetherionBoss livingParent) {
                        // simulate normal player attack
                        livingParent.hurtArm(message.armIndex, (float)message.damage);
                        livingParent.hurt(player.level().damageSources().playerAttack(player), 0);
                    }
                    else parent.hurt(parent.damageSources().generic(), (float) message.damage);
                }
            }
        });
        context.get().setPacketHandled(true);
    }
}
