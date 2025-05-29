package com.example.controller;
import com.example.model.Game;

import javafx.scene.media.AudioClip;

public class SoundController implements Controller {

    private final Game game;
    private AudioClip currentAudioClip = null;
    
    public SoundController(Game game) {
        this.game = game;
    }
    @Override
    public void update(long nanoTime) {
    }

    public void playDeathSound() {
       playSound("/com/example/sound/pacman_death.wav");
    }

    public void playChompSound(){

        if (currentAudioClip == null) {
            AudioClip chompSound = new AudioClip(getClass().getResource("/com/example/sound/pacman_chomp.wav").toExternalForm());
            chompSound.setCycleCount(AudioClip.INDEFINITE);
            chompSound.play();
            currentAudioClip = chompSound;
        }
    }

    public void playEatGhostSound(){
        playSound("/com/example/sound/pacman_eatghost.wav");
    }

    public void playSound(String path){
        if (currentAudioClip.isPlaying()) {
            currentAudioClip.stop();
        }
        currentAudioClip = new AudioClip(getClass().getResource(path).toExternalForm());
        currentAudioClip.play();
    }
}

