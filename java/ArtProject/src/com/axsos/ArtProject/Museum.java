package com.axsos.ArtProject;

import java.util.ArrayList;
import java.util.Collections;

public class Museum {

    public static void main(String[] args) {

        Painting painting1 = new Painting(
                "Starry Night",
                "Vincent van Gogh",
                "A famous night landscape.",
                "Oil");

        Painting painting2 = new Painting(
                "Mona Lisa",
                "Leonardo da Vinci",
                "A portrait of Lisa Gherardini.",
                "Oil");

        Painting painting3 = new Painting(
                "Water Lilies",
                "Claude Monet",
                "A beautiful garden scene.",
                "Watercolor");

        Sculpture sculpture1 = new Sculpture(
                "David",
                "Michelangelo",
                "Renaissance masterpiece.",
                "Marble");

        Sculpture sculpture2 = new Sculpture(
                "The Thinker",
                "Auguste Rodin",
                "A man deep in thought.",
                "Bronze");

        ArrayList<Art> museum = new ArrayList<>();

        museum.add(painting1);
        museum.add(painting2);
        museum.add(painting3);
        museum.add(sculpture1);
        museum.add(sculpture2);

        Collections.shuffle(museum);

        for (Art art : museum) {
            art.viewArt();
        }
    }
}
