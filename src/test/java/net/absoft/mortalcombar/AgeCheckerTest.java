package net.absoft.mortalcombar;

import net.absoft.mortalcombat.AgeChecker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AgeCheckerTest {

    @Test

    public void testAgeUserCanPlay() {
        AgeChecker ageChecker = new AgeChecker();
        Assert.assertTrue(ageChecker.canPlayGame(19), "Age user can`t play game");
    }


    @Test

    public void testThatTooYoungUsersCanNotPlay() {
        AgeChecker ageChecker =  new AgeChecker();
        Assert.assertTrue(ageChecker.canPlayGame(17), "Age user can`t play game");
    }

}


