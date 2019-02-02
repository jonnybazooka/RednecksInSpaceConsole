package aplicationCore;

import java.util.Scanner;

class Difficulty {



    static Resources selectDifficultyLevel() {

            Resources resources;
            System.out.println("Select difficulty level: 1 - Easy, 2 - Medium, 3 - Hard");
            int difficultySelection = new Scanner(System.in).nextInt();
            if (difficultySelection == 1) {
                resources = new Resources(30, 30, 30, 1,
                        1, 2, false);
                return resources;
            } else if (difficultySelection == 2) {
                resources = new Resources(30, 30, 30, 1,
                        1, 2, false);
                return resources;
            } else if (difficultySelection == 3) {
                resources = new Resources(30, 30, 30, 1,
                        1, 2, false);
                return resources;
            } else {
                System.out.println("You must enter 1, 2 or 3. Please try again.");
                return null;
            }
    }
}
