package net.jelly.exo_ascension.global.invasion.music;

import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;

public class MusicController {
    private static MusicController instance;
    private MusicSoundInstance currentMusic;
    public SoundEvent currentTrack;
    private float volume = 0f;
    private boolean fadingOut = false;
    public boolean active = false;

    public static MusicController get() {
        if (instance == null) instance = new MusicController();
        return instance;
    }

    public void startMusic(SoundEvent track) {
        currentTrack = track;
        Minecraft mc = Minecraft.getInstance();
        SoundManager sm = mc.getSoundManager();
        sm.stop();
        currentMusic = new MusicSoundInstance(track);
        sm.play(currentMusic);
        active = true;
        fadingOut = false;
    }

    public void fadeOut() {
        fadingOut = true;
    }

    public void tick() {
        if(!Minecraft.getInstance().getSoundManager().isActive(currentMusic)) active = false;
        if (!active || currentMusic == null) return;
        else Minecraft.getInstance().getMusicManager().stopPlaying();
        if (fadingOut) {
            volume -= 0.01f;
            if (volume <= 0f) {
                stopMusic();
                fadingOut = false;
            }
        } else if (volume < 1f) {
            volume += 0.01f;
        }
        if(currentMusic != null) currentMusic.setVolume(volume);
    }

    public void stopMusic() {
        if (currentMusic != null) {
            Minecraft.getInstance().getSoundManager().stop(currentMusic);
            currentMusic = null;
        }
        active = false;
    }
}
