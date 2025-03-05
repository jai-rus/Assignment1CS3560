package org.example;
import java.util.HashMap;
import java.util.Map;

public class PyramidRubik {

    //Create Tip
    //Create Edges
    //Create Faces

    //Solution 1: Hashmap
    //Solution 2: Heap / Nodes (Trees)
    //Solution 3: Matrix (3)

    //Number of faces
    private static final int numFaces = 4;
    //Colors for the 4 faces
    private static final String[] color = {"Red", "Green", "Blue", "Yellow"};

    //Stores the faces of the pyraminx
    private Map<String, Faces> faces;
    //Stores the edges of the pyraminx
    private Map<String, String[]> Edges;

    //Constructor to initialize the Pyraminx
    public PyramidRubik() {
        faces = new HashMap<>();
        Edges = new HashMap<>();
        initializeFace();
        initializeEdges();
    }

    //Initializes the faces of the Pyraminx with their colors
    private void initializeFace() {
        faces.put("front", new Faces("Red"));
        faces.put("left", new Faces("Green"));
        faces.put("right", new Faces("Blue"));
        faces.put("bottom", new Faces("Yellow"));
    }

    //Initializes the relationships between the faces
    private void initializeEdges() {
        Edges.put("front", new String[] {"left", "right", "bottom"});
        Edges.put("left", new String[] {"front", "right", "bottom"});
        Edges.put("right", new String[] {"front", "left", "bottom"});
        Edges.put("bottom", new String[] {"front", "right", "left"});
    }

    //Prints color of each face
    public void printFaces() {
        for (Map.Entry<String, Faces> entry : faces.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    //Prints relationships between each face
    public void printEdges() {
        for (Map.Entry<String, String[]> entry : Edges.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            System.out.println(String.join(", ", entry.getValue()));
        }
    }


    //Validates Pyraminx by checking if each face has 9 tiles and all the tiles on face are the correct color
    public void validateCube() {
        boolean isValid = true;

        //Check that each face has 9 tiles
        for (Map.Entry<String, Faces> entry : faces.entrySet()) {
            String faceKey = entry.getKey();
            Faces face = entry.getValue();
            if (face.getTiles().length != 9) {
                System.out.println("Invalid number of tiles on face: " + faceKey);
                isValid = false;
            }
        }

        // Check that each face has valid color distribution
        for (Map.Entry<String, Faces> entry : faces.entrySet()) {
            String faceKey = entry.getKey();
            Faces face = entry.getValue();
            String expectedColor = face.getColor(); // Expected color for this face
            String[] tiles = face.getTiles(); // Tiles on this face

            // Verify each tile's color
            for (String tile : tiles) {
                if (!tile.equals(expectedColor)) {
                    System.out.println("Wrong Color on Face: " + faceKey);
                    System.out.println("Found: " + faceKey + " Expected: " + expectedColor);
                    isValid = false;
                }
            }
        }

        if (isValid) {
            System.out.println("The Pyraminx is valid.");
        } else {
            System.out.println("The Pyraminx is invalid.");
        }
    }
}
