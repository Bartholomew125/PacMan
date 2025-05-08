package com.example.view;

import java.util.List;

import com.example.model.Pill;

import javafx.scene.image.Image;

public class PillView extends AbstractView{

    private List<Pill> smallPills;
    private List<Pill> largePills;
    private Image smallPillImage; 
    private Image largePillImage;

    public PillView(int width, int height,  double positionScaler, List<Pill> smallPills, List<Pill> largePills) {
        super(width, height, positionScaler);

        this.smallPills = smallPills;
        this.largePills = largePills;

        this.smallPillImage = new Image("file:src/main/resources/com/example/smallPill.png", this.getPositionScaler(),this.getPositionScaler(), false, false);
        this.largePillImage = new Image("file:src/main/resources/com/example/largePill.png", this.getPositionScaler(), this.getPositionScaler(), false, false);
    }

    @Override
    public void render(double nanoTime) {
        this.clear();
        for (Pill pill : this.smallPills){ 
            this.addImageToSurface(smallPillImage, pill.getX(), pill.getY(), 0);
        }
        for (Pill pill : this.largePills) {
            this.addImageToSurface(largePillImage, pill.getX(), pill.getY(), 0);
        }
    }
    
}
