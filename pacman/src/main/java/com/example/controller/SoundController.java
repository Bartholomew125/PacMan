package com.example.controller;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.media.AudioClip;

public class SoundController implements Controller {

    private final AudioClip pacManChomp;
    private final AudioClip pacManDeath;
    private final AudioClip pacManEatGhost;
    private AudioClip currentClip;
    private final List<AudioClip> priorityList;
    
    public SoundController() {
        this.pacManChomp = this.loadClip("/com/example/sound/pacman_chomp.wav");
        this.pacManDeath = this.loadClip("/com/example/sound/pacman_death.wav");
        this.pacManEatGhost = this.loadClip("/com/example/sound/pacman_eatghost.wav");
        this.currentClip = this.pacManChomp;
        this.currentClip.play();

        this.priorityList = new ArrayList<>();
        this.priorityList.add(this.pacManChomp);
        this.priorityList.add(this.pacManEatGhost);
        this.priorityList.add(this.pacManDeath);
    }

    @Override
    public void update(long nanoTime) {
        this.playChompSound();
    }

    public void playDeathSound() {
        this.playSound(this.pacManDeath);
    }

    public void playChompSound(){
        this.playSound(this.pacManChomp);
    }

    public void playEatGhostSound(){
        this.playSound(this.pacManEatGhost);
    }

    public void playSound(AudioClip audioClip){
        int newClipPriority = this.priorityList.indexOf(audioClip);
        int currentClipPriority = this.priorityList.indexOf(currentClip);
        if (newClipPriority > currentClipPriority) {
            this.currentClip.stop();
            this.currentClip = audioClip;
            this.currentClip.play();
        }
        else if (!this.currentClip.isPlaying()) {
            this.currentClip = audioClip;
            this.currentClip.play();
        }
    }

    private AudioClip loadClip(String path) {
        return new AudioClip(getClass().getResource(path).toExternalForm());
    }
}

