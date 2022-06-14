package Problems.topologicalSort;

/* 
Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum. There may be more than one track that includes the same course, but each student follows a single linear track from a "root" node to a "leaf" node. In the graph below, their path always moves left to right.

Write a function that takes a list of (source, destination) pairs, and returns the name of all of the courses that the students could be taking when they are halfway through their track of courses.

Sample input 1:
pairs1 = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Graphics", "Networking"],
    ["Networking", "Algorithms"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]

Sample output 1 (in any order):
          ["Data Structures", "Networking", "Creative Writing", "Databases"]

All paths through the curriculum (midpoint *highlighted*):

Intro to C.S. -> Graphics -> *Networking* -> Algorithms -> Cobol
Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> Compiler
Creative Writing -> *Databases* -> System Administration
Creative Writing -> System Administration
Creative Writing -> *Data Structures* -> Algorithms -> COBOL
Creative Writing -> *Data Structures* -> Logic -> COBOL
Creative Writing -> *Data Structures* -> Logic -> Compilers

Visual representation:

                    ____________    ______________
                    |          |    |            |
                    | Graphics |    | Networking |
               ---->|__________|--->|____________|
               |                       |       
               |                       |       
               |                       |  ______________
____________   |                       |  |            |
|          |   |    ______________     >->| Algorithms |--\     _____________
| Intro to |   |    |            |    /   |____________|   \    |           |
| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
|__________|    \   | Structures |--+     ______________   /    |___________|
                 >->|____________|   \    |            |  /
____________    /                     \-->| Logic      |-+      _____________
|          |   /    ______________        |____________|  \     |           |
| Creative |  /     |            |                         \--->| Compilers |
| Writing  |-+----->| Databases  |                              |___________|
|__________|  \     |____________|-\     _________________________
               \                    \    |                       |
                \--------------------+-->| System Administration |
                                         |_______________________|

Sample input 2:
    pairs2 = [
        ["Course_3", "Course_7"],
        ["Course_0", "Course_1"],
        ["Course_1", "Course_2"],
        ["Course_2", "Course_3"],
        ["Course_3", "Course_4"],
        ["Course_4", "Course_5"],
        ["Course_5", "Course_6"],
    ]

Sample output 2 (in any order):
["Course_2", "Course_3"]

All Test Cases:
halfway_courses(pairs1) => ["Data Structures", "Networking", "Creative Writing", "Databases"]
halfway_courses(pairs2) => ["Course_2", "Course_3"]

Complexity analysis variables:

n: number of pairs in the input
c: number of courses in the input
 */
import java.io.*;
import java.util.*;

public class MiddleCourse {

    public String halfway_course(String[][] pairs) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegreeMap = new HashMap<>();
        List<String> courses = getAllCourses(pairs);

        for (String course : courses) {
            graph.put(course, new ArrayList<>());
            inDegreeMap.put(course, 0);
        }

        for (String[] pair : pairs) {
            String parent = pair[0], child = pair[1];
            graph.get(parent).add(child);
            inDegreeMap.put(child, inDegreeMap.get(child) + 1);
        }

        Queue<String> sourceQ = new LinkedList<>();
        inDegreeMap.forEach((key, val) -> {
            if (val == 0) {
                sourceQ.add(key);
            }
        });

        List<String> courseOrdering = new ArrayList<>();
        while (!sourceQ.isEmpty()) {
            String course = sourceQ.poll();

            courseOrdering.add(course);

            for (String child : graph.get(course)) {
                inDegreeMap.put(child, inDegreeMap.get(child) - 1);
                if (inDegreeMap.get(child) == 0) {
                    sourceQ.add(child);
                }
            }
        }

        if (courseOrdering.size() % 2 == 0) {
            return courseOrdering.get(courseOrdering.size() / 2 - 1);
        }

        return courseOrdering.get(courseOrdering.size() / 2);
    }

    private List<String> getAllCourses(String[][] pairs) {
        Set<String> courses = new HashSet<>();
        for (String[] pair : pairs) {
            courses.add(pair[0]);
            courses.add(pair[1]);
        }
        return new ArrayList<>(courses);
    }

    public static void main(String[] argv) {
        MiddleCourse solution = new MiddleCourse();

        String[][] pairs1 = {
                { "Foundations of Computer Science", "Operating Systems" },
                { "Data Structures", "Algorithms" },
                { "Computer Networks", "Computer Architecture" },
                { "Algorithms", "Foundations of Computer Science" },
                { "Computer Architecture", "Data Structures" },
                { "Software Design", "Computer Networks" }
        };

        String[][] pairs2 = {
                { "Algorithms", "Foundations of Computer Science" },
                { "Data Structures", "Algorithms" },
                { "Foundations of Computer Science", "Logic" },
                { "Logic", "Compilers" },
                { "Compilers", "Distributed Systems" },
        };

        String[][] pairs3 = {
                { "Data Structures", "Algorithms" }
        };

        System.out.println(solution.halfway_course(pairs1));
        System.out.println(solution.halfway_course(pairs2));
        System.out.println(solution.halfway_course(pairs3));
    }
}
