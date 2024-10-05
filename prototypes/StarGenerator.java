package prototypes;

import java.util.Random;
import java.awt.Color;

class StarGenerator {
    public static Star[] generateRandomStars(int count, int width, int height) {
        Star[] stars = new Star[count];
        Random random = new Random();

        for (int i = 0; i < stars.length; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            double distance = random.nextDouble() * 100;
            Color color = Color.WHITE;
            stars[i] = new Star(x, y, color, distance);
        }

        return stars;
    }
}