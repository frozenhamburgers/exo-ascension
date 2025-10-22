package net.jelly.exo_ascension.global.invasion.music;

import net.minecraft.client.resources.sounds.AbstractSoundInstance;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

// tickable sound instances update their volume/pitch dynamically
public class MusicSoundInstance extends AbstractTickableSoundInstance {
    public MusicSoundInstance(SoundEvent sound) {
        super(sound, SoundSource.MUSIC, SoundInstance.createUnseededRandom());
    }

    public void setVolume(float v) {
        this.volume = v;
    }

    @Override
    public float getVolume() {
        return this.volume;
    }

    @Override
    public void tick() {

    }
}