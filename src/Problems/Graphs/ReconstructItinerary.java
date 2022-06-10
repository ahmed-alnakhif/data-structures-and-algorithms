package Problems.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi]
 * represent the departure and the arrival airports of one flight. Reconstruct
 * the itinerary in order and return it.
 * 
 * All of the tickets belong to a man who departs from "JFK", thus, the
 * itinerary must begin with "JFK". If there are multiple valid itineraries, you
 * should return the itinerary that has the smallest lexical order when read as
 * a single string.
 * 
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use
 * all the tickets once and only once
 * 
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * 
 * Input: tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 */

public class ReconstructItinerary {
    Map<String, LinkedList<String>> flightsMap = new HashMap<>();
    LinkedList<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        constructFlightMap(tickets);
        dfs("JFK");
        return result;
    }

    private void dfs(String src) {
        if (flightsMap.containsKey(src)) {
            LinkedList<String> destList = flightsMap.get(src);
            
            while (!destList.isEmpty()) {
                dfs(destList.pollFirst());
            }
        }

        result.addFirst(src);
    }

    private void constructFlightMap(List<List<String>> tickets) {
        for (List<String> flight : tickets) {
            if (!flightsMap.containsKey(flight.get(0))) {
                flightsMap.put(flight.get(0), new LinkedList<>());
            }
            flightsMap.get(flight.get(0)).add(flight.get(1));
        }

        for (List<String> list : flightsMap.values()) {
            Collections.sort(list);
        }
    }

    public static void main(String[] args) {
        ReconstructItinerary ri = new ReconstructItinerary();

        List<String> flight1 = new ArrayList<>(List.of("JFK", "SFO"));
        List<String> flight2 = new ArrayList<>(List.of("JFK", "ATL"));
        List<String> flight3 = new ArrayList<>(List.of("SFO", "ATL"));
        List<String> flight4 = new ArrayList<>(List.of("ATL", "JFK"));
        List<String> flight5 = new ArrayList<>(List.of("ATL", "SFO"));
        List<List<String>> tickets = new ArrayList<>(List.of(flight1, flight2, flight3, flight4, flight5));

        System.out.println(ri.findItinerary(tickets));
    }
}
