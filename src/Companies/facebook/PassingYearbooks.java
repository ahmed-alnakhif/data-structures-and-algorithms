package Companies.facebook;

import java.util.Arrays;

/**
 * There are n students, numbered from 1 to n, each with their own yearbook.
 * They would like to pass their yearbooks around and get them signed by other
 * students.
 * You're given a list of n integers arr[1..n], which is guaranteed to be a
 * permutation of 1..n (in other words, it includes the integers from 1 to n
 * exactly once each, in some order). The meaning of this list is described
 * below.
 * Initially, each student is holding their own yearbook. The students will then
 * repeat the following two steps each minute: Each student i will first sign
 * the yearbook that they're currently holding (which may either belong to
 * themselves or to another student), and then they'll pass it to student
 * arr[i-1]. It's possible that arr[i-1] = i for any given i, in which case
 * student i will pass their yearbook back to themselves. Once a student has
 * received their own yearbook back, they will hold on to it and no longer
 * participate in the passing process.
 * It's guaranteed that, for any possible valid input, each student will
 * eventually receive their own yearbook back and will never end up holding more
 * than one yearbook at a time.
 * You must compute a list of n integers output, whose element at i-1 is equal
 * to the number of signatures that will be present in student i's yearbook once
 * they receive it back.
 * 
 * 
 * Example 1
 * 
 * n = 2
 * arr = [2, 1]
 * output = [2, 2]
 * Pass 1:
 * Student 1 signs their own yearbook. Then they pass the book to the student at
 * arr[0], which is Student 2.
 * Student 2 signs their own yearbook. Then they pass the book to the student at
 * arr[1], which is Student 1.
 * 
 * Pass 2:
 * Student 1 signs Student 2's yearbook. Then they pass it to the student at
 * arr[0], which is Student 2.
 * Student 2 signs Student 1's yearbook. Then they pass it to the student at
 * arr[1], which is Student 1.
 * 
 * Pass 3:
 * Both students now hold their own yearbook, so the process is complete.
 * Each student received 2 signatures.
 */

public class PassingYearbooks {

    int[] findSignatureCounts(int[] students) {
        int[] output = new int[students.length];

        for (int student = 1; student <= students.length; student++) {
            int bookOwner = student;
            int currentHolder = student;

            do {
                // sign by prev student
                output[student - 1] += 1;

                // pass to the prev student
                currentHolder = students[currentHolder - 1];
            } while (currentHolder != bookOwner);

        }

        return output;
    }

    public static void main(String[] args) {
        PassingYearbooks pYearbooks = new PassingYearbooks();
        System.out.println(pYearbooks.findSignatureCounts(new int[] { 2, 1 }));
        System.out.println(pYearbooks.findSignatureCounts(new int[] { 1, 2 }));
    }
}
