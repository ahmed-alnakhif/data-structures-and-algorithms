package Problems.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
// import org.junit.Test;
// import org.junit.runner.JUnitCore;
// import org.junit.runner.Result;
// import org.junit.internal.RealSystem;
// import org.junit.internal.TextListener;
// import static org.junit.Assert.*;

/*
 *  Tenpin Rules
    1) There are 10 frames, each frame has 10 pins and up to 2 rolls to knock
    down the pins
    2) The total score is the sum of all the pins that have been knocked down in
    each frame
    3) If during a frame the player knock down all of the pins using the first
    and second ball it is called a spare
    4) If the player gets a spare the frame gets a bonus score of the pins
    knocked down by the very next roll
    [1 2] [3 7] [5 2] [0 0]....
    [1 + 2] [3 + 7 + 5] [5 + 2] [0]
    5) If the player knocks down all the pins on the first roll it's called a
    strike
    6) If the player gets a strike the frame is over, and the frame score gets a
    bonus of the next two rolls
    [1 2] [10 0] [5 2] [0 0], ..
    [1 + 2] [10 + 5 + 2] [5 + 2] [0]...
    [1 + 2] [10 + 10 + 10] [10 + 10] [10 + 6] [6]
 */

class Frame {
    int firstRoll;
    int secondRoll;
    int bonus;

    public Frame(int firstRoll, int secondRoll, int bonus) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.bonus = bonus;
    }

    public int getTotal() {
        return firstRoll + secondRoll + bonus;
    }
}

public class Bowling {
    /// ***************************
    /// IMPLEMENTATION
    public static class Tenpin {
        private LinkedList<Frame> scoreList;
        private int totalScore;
        private final int MAX_PINS = 10;
        private final int MAX_ROLLS = 2;
        private int currRolls;
        private int firstRoll, secondRoll, bonus;
        private boolean strike;

        // [1 2] [3 7] [5 2] [0 0]....
        // [1 + 2] [3 + 7 + 5] [5 + 2] [0]

        // [1 2] [10] [5 2] [0 0], ..
        // [1 + 2] [10 + 5 + 2] [5 + 2] [0]...
        // [1 + 2] [10 + 10 + 10] [10 + 10] [10 + 6] [6]

        public Tenpin() {
            scoreList = new LinkedList<>();
            totalScore = 0;
            currRolls = 1;
            firstRoll = 0;
            secondRoll = 0;
            bonus = 0;
            strike = false;
        }

        public void roll(int score) {
            if (currRolls == 1) {
                firstRoll = score;
                currRolls++;

                if (isStrike(score)) {
                    strike = true;
                    scoreList.add(new Frame(firstRoll, secondRoll, bonus));
                    currRolls = 1;
                }

                if (isBonusAvailable()) {
                    scoreList.getLast().bonus = score;
                }
            } else {
                secondRoll = score;
                scoreList.add(new Frame(firstRoll, secondRoll, bonus));
                currRolls = 1;

                if (isBonusAvailable() & strike) {
                    scoreList.getLast().bonus = score;
                }
            }

        }

        private boolean isBonusAvailable() {
            return !scoreList.isEmpty() && scoreList.getLast().getTotal() >= MAX_PINS;
        }

        private boolean isStrike(int score) {
            return score == MAX_PINS;
        }

        public int score() {
            int total = 0;
            for (Frame frame : scoreList) {
                total = total + frame.firstRoll + frame.secondRoll + frame.bonus;
            }
            return total;
        }
    }

    /// TESTS
    // public static class TenpinTest {
    //     @Test
    //     public void testGameOfAllZeros() {
    //         Tenpin tenpin = new Tenpin();
    //         IntStream.rangeClosed(1, 20).forEach(i -> tenpin.roll(0)); // <- Repeat 20 times
    //         assertEquals(0, tenpin.score());
    //     }

    //     @Test
    //     public void testGameOfAllTwos() {
    //         Tenpin tenpin = new Tenpin();
    //         IntStream.rangeClosed(1, 20).forEach(i -> tenpin.roll(2)); // <- Repeat 20 times
    //         assertEquals(40, tenpin.score());
    //     }

    //     @Test
    //     public void testGameOfRandomNums() {
    //         Tenpin tenpin = new Tenpin();

    //         tenpin.roll(3);
    //         tenpin.roll(6);
    //         tenpin.roll(2);
    //         tenpin.roll(1);
    //         tenpin.roll(8);
    //         tenpin.roll(1);

    //         IntStream.rangeClosed(1, 14).forEach(i -> tenpin.roll(0)); // <- Repeat 20 times
    //         assertEquals(21, tenpin.score());
    //     }

    //     @Test
    //     public void testGameWithASpare() {
    //         Tenpin tenpin = new Tenpin();

    //         tenpin.roll(1);
    //         tenpin.roll(2);
    //         tenpin.roll(3);
    //         tenpin.roll(7);
    //         tenpin.roll(5);
    //         tenpin.roll(2);

    //         IntStream.rangeClosed(1, 14).forEach(i -> tenpin.roll(0)); // <- Repeat 20 times
    //         assertEquals(25, tenpin.score());
    //     }

    //     @Test
    //     public void testGameWithTwoSpares() {
    //         Tenpin tenpin = new Tenpin();

    //         tenpin.roll(1);
    //         tenpin.roll(9); // 13
    //         tenpin.roll(3);
    //         tenpin.roll(7); // 15
    //         tenpin.roll(5);
    //         tenpin.roll(2); // 7

    //         IntStream.rangeClosed(1, 14).forEach(i -> tenpin.roll(0)); // <- Repeat 20 times
    //         assertEquals(35, tenpin.score());
    //     }

    //     @Test
    //     public void testGameWithAStrike() {
    //         Tenpin tenpin = new Tenpin();

    //         tenpin.roll(1);
    //         tenpin.roll(2); // 3
    //         tenpin.roll(10); // 17
    //         tenpin.roll(5);
    //         tenpin.roll(2); // 7

    //         IntStream.rangeClosed(1, 14).forEach(i -> tenpin.roll(0)); // <- Repeat 20 times
    //         assertEquals(27, tenpin.score());
    //     }

    //     @Test
    //     public void testGameWithThreeStrikes() {
    //         Tenpin tenpin = new Tenpin();

    //         tenpin.roll(1);
    //         tenpin.roll(2); // 3
    //         tenpin.roll(10); // 30
    //         tenpin.roll(10); // 22
    //         tenpin.roll(10); // 16
    //         tenpin.roll(2);
    //         tenpin.roll(4); // 4

    //         IntStream.rangeClosed(1, 10).forEach(i -> tenpin.roll(0)); // <- Repeat 20 times
    //         assertEquals(75, tenpin.score());
    //     }

    // }

    /// ***************************
    /// SETUP
    public static void main(String[] args) {
        // JunitCore runner = new JUnitCore();
        // runner.addListener(new TextListener(new RealSystem()));
        // Result result = runner.run(TenpinTest.class);
        // System.exit(result.wasSuccessful() ? 0 : 1);
    }
}