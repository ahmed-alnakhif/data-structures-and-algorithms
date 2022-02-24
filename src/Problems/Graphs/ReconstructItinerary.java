package Problems.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * return the number of nodes in the largest connected component in a graph
 */

public class ReconstructItinerary {
    Map<String, LinkedList<String>> flightsMap = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        constructFlightMap(tickets);
        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    void constructFlightMap(List<List<String>> tickets) {
        for (List<String> flight : tickets) {
            if (flightsMap.containsKey(flight.get(0))) {
                flightsMap.get(flight.get(0)).add(flight.get(1));
                Collections.sort(flightsMap.get(flight.get(0)));
            } else {
                flightsMap.put(flight.get(0), new LinkedList<>(Arrays.asList(flight.get(1))));
            }
        }
    }

    public void dfs(String source) {
        if (flightsMap.containsKey(source)) {
            LinkedList<String> destList = flightsMap.get(source);
            while (!destList.isEmpty()) {
                String dest = destList.pop();
                dfs(dest);
            }
        }

        result.add(source);
    }

    public void run() {
        List<String> flight1 = new ArrayList<>(List.of("JFK", "SFO"));
        List<String> flight2 = new ArrayList<>(List.of("JFK", "ATL"));
        List<String> flight3 = new ArrayList<>(List.of("SFO", "ATL"));
        List<String> flight4 = new ArrayList<>(List.of("ATL", "JFK"));
        List<String> flight5 = new ArrayList<>(List.of("ATL", "SFO"));
        List<List<String>> tickets = new ArrayList<>(List.of(flight1, flight2, flight3, flight4, flight5));

        System.out.println(findItinerary(tickets));
    }
}
