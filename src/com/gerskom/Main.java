package com.gerskom;

public class Main {

    public static void main(String[] args) {

        try {
            new MyFrame(new ImageData("src/xD_input.jpg"));
        }
        catch (Exception exc) {
            System.out.println("Interrupted: " + exc.getMessage());
        }
    }
}
