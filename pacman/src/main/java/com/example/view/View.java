package com.example.view;

import javafx.scene.Group;

public interface View {
    public void clear();
    public void addView(View view);
    public void render(double nanoTime);
    public Group getSurface();
}