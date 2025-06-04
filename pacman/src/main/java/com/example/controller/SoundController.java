package com.example.controller;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.AudioClip;

/**
 * SoundController which is responsible for managing and playing audio clips
 */
public class SoundController implements Controller {

    private final AudioClip chomp;
    private final AudioClip death;
    private final AudioClip eatGhost;
    private final AudioClip wompWomp;
    private AudioClip currentClip;
    private final List<AudioClip> priorityList;
    
    /**
     * Creates a new SoundController
     */
    public SoundController() {
        this.chomp = this.loadClip("/com/example/sound/pacman_chomp.wav");
        this.death = this.loadClip("/com/example/sound/pacman_death.wav");
        this.eatGhost = this.loadClip("/com/example/sound/pacman_eatghost.wav");
        this.wompWomp = this.loadClip("/com/example/sound/gg.wav");
        this.startPlaying();
        this.priorityList = new ArrayList<>();
        this.priorityList.add(this.chomp);
        this.priorityList.add(this.eatGhost);
        this.priorityList.add(this.death);
        this.priorityList.add(this.wompWomp);
    }

    @Override
    public void update(long nanoTime) {
        this.playChompSound();
    }

    /**
     * Attempts to play the death sound
     */
    public void playDeathSound() {
        this.playSound(this.death);
    }

    /**
     * Attempts to play the chomp sound
     */
    public void playChompSound(){
        this.playSound(this.chomp);
    }

    /**
     * Attempts to play the ghost eating sound
     */
    public void playEatGhostSound(){
        this.playSound(this.eatGhost);
    }

    /**
     * Attempts to play the end-game sound.
     */
    public void playWompWompSound(){
        this.playSound(this.wompWomp);
    }

    /**
     * Plays the given audioclip, but only if it has a higher priority than the one already playing, or there is norting else playing.
     * 
     * @param audioClip
     */
    public void playSound(AudioClip audioClip){
        int newClipPriority = this.priorityList.indexOf(audioClip);
        int currentClipPriority = this.priorityList.indexOf(currentClip);
        if (newClipPriority > currentClipPriority) {
            if (this.currentClip == null) {
                return;
            }
            this.currentClip.stop();
            this.currentClip = audioClip;
            this.currentClip.play();
        }
        else if (!this.currentClip.isPlaying()) {
            this.currentClip = audioClip;
            this.currentClip.play();
        }
    }

    /**
     * Loads an audioclip from the given path
     * @param path
     * @return Audioclip of path
     */
    private AudioClip loadClip(String path) {
        return new AudioClip(getClass().getResource(path).toExternalForm());
    }

    /**
     * Initializes the soundcontoller to play the chomp sound by default.
     */
    public void startPlaying() {
        if (this.currentClip != null && this.currentClip.isPlaying()) {
            this.currentClip.stop();
        } 
        this.currentClip = this.chomp;
        this.currentClip.play();
    }
}