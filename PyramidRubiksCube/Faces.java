package org.example;

public class Faces {
    //Color of the face
    private String color;
    //Number of tiles on the face
    private int tiles = 9;
    //Array to store the tiles
    private String[] face = new String[tiles];

    //Constructor to initialize the face with an inputted color
    public Faces (String color) {
        this.color = color;
        for (int i = 0; i < tiles; i++) {
            face[i] = color;
        }
    }

    //Returns the faces color
    public String getColor() {
        return color;
    }

    //Returns the tiles of the face
    public String[] getTiles() {
        return face;
    }

    //Return a string representation of the face
    public String toString() {
        return color;
    }

    //Prints face in a pyramid structure
    public void printFace() {
        int index = 0;
        int[] rowPattern = {1, 3, 5};
        for (int row: rowPattern) {
            for (int i = 0; i < row; i++) {
                if (index < tiles) {
                    System.out.print(face[index] + " ");
                    index++;
                }
            }
            System.out.println();
        }
    }
}
