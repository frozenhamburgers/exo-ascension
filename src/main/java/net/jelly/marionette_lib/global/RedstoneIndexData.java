package net.jelly.marionette_lib.global;

import net.jelly.marionette_lib.MarionetteMod;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.saveddata.SavedData;

public class RedstoneIndexData extends SavedData {
    private int redstoneIndex = 0;

    public static RedstoneIndexData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                RedstoneIndexData::load,
                RedstoneIndexData::new,
                "redstone_index"
        );
    }

    public void add(int value) {
        redstoneIndex += value;
        setDirty();
    }

    public void subtract(int value) {
        redstoneIndex = Math.max(0, redstoneIndex - value);
        setDirty();
    }

    public int get() {
        return redstoneIndex;
    }

    public static RedstoneIndexData load(CompoundTag nbt) {
        RedstoneIndexData data = new RedstoneIndexData();
        data.redstoneIndex = nbt.getInt("redstone_index");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag nbt) {
        nbt.putInt("redstone_index", redstoneIndex);
        return nbt;
    }

    // TECH BLOCKS
    public static final TagKey<Block> TECH_BLOCKS = BlockTags.create(
            new ResourceLocation(MarionetteMod.MODID, "tech_blocks")
    );

    public static boolean isTechBlock(Block block) {
        return block.builtInRegistryHolder().is(TECH_BLOCKS);
    }
}
