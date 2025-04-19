package com.example;

import java.util.Hashtable;

public class Color {
    
    private String name;
    private int red;
    private int blue;
    private int green;

    public Color(String color) {
        this.name = color;
        this.red = availableColors().get(color)[0];
        this.green = availableColors().get(color)[1];
        this.blue = availableColors().get(color)[2];
    }

    /**
     * Get all available colors.
     * Here is the available list:
     * red, green, blue, yellow, cyan, magenta, black, white, gray
     * @return Hashtable<String, int[]> with the color name as key and the RGB values as value
     */
    public static Hashtable<String,int[]> availableColors() {
        Hashtable<String, int[]> colors = new Hashtable<String,int[]>();
        colors.put("red", new int[]{255,0,0}); // https://stackoverflow.com/questions/6081670/initialize-array-in-method-argument
        colors.put("green", new int[]{0,255,0});
        colors.put("blue", new int[]{0,0,255});
        colors.put("yellow", new int[]{255,255,0});
        colors.put("cyan", new int[]{0,255,255});
        colors.put("magenta", new int[]{255,0,255});
        colors.put("black", new int[]{0,0,0});
        colors.put("white", new int[]{255,255,255});
        colors.put("gray", new int[]{128,128,128});
        return colors;
    }

    public String getName() {
        return name;
    }

    public void setColor(String color) {
        this.name = color;
        this.red = availableColors().get(color)[0];
        this.green = availableColors().get(color)[1];
        this.blue = availableColors().get(color)[2];
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }


}
