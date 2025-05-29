package com.example.controller;
import com.example.model.Game;

import javafx.scene.media.AudioClip;

public class SoundController implements Controller {

    private final Game game;
    private AudioClip currentAudioClip;
    
    public SoundController(Game game) {
        this.game = game;
        this.currentAudioClip = new AudioClip(getClass().getResource("/com/example/sound/pacman_chomp.wav").toExternalForm());
    }
    @Override
    public void update(long nanoTime) {
        this.playChompSound();
    }

    public void playDeathSound() {
        this.currentAudioClip.stop();
       this.playSound("/com/example/sound/pacman_death.wav");
    }

    public void playChompSound(){
        this.playSound("/com/example/sound/pacman_chomp.wav");
    }

    public void playEatGhostSound(){
        this.currentAudioClip.stop();
        this.playSound("/com/example/sound/pacman_eatghost.wav");
    }

    public void playSound(String path){
        AudioClip newAudioClip = new AudioClip(getClass().getResource(path).toExternalForm());
        if (currentAudioClip != null && !currentAudioClip.isPlaying()) {
            currentAudioClip.stop();
            currentAudioClip = newAudioClip;
            newAudioClip.play();
        }
    }
}

