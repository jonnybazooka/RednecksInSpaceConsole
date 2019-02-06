package aplicationCore;

public class ClearScreen {

    public static void clearConsoleScreen() {
        for (int i = 0; i < 70; i++) {
            System.out.println();
        }
    }
}
