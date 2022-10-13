package net.absoft.mortalcombat;

public class AgeChecker {
    private final int MIN_AGE = 18;

    public boolean canPlayGame(int age) {
        return age >= MIN_AGE;
    }
}
