package Problems.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Log {
    String ip;
    int timestamp;

    Log(int timestamp, String ip) {
        this.ip = ip;
        this.timestamp = timestamp;
    }
}

public class BotIps {

    public List<String> getBotIps(Log[] logs, int count, int window) {
        Set<String> result = new HashSet<>();
        if (logs.length * count * window == 0) {
            return new ArrayList<>(result);
        }

        Map<String, Integer> map = new HashMap<>();
        int left = 0, right = 0;

        int currWindow = 0;

        while (right < logs.length) {
            String ip = logs[right].ip;
            int rightTimeStamp = logs[right++].timestamp;
            int leftTimeStamp = logs[left].timestamp;

            map.put(ip, map.getOrDefault(ip, 0) + 1);

            if(map.get(ip) >= count) {
                result.add(ip);
            }

            currWindow = rightTimeStamp - leftTimeStamp;

            while (currWindow > window) {
                String leftIp = logs[left].ip;
                map.put(leftIp, map.get(leftIp) - 1);
                if (map.get(leftIp) == 0) {
                    map.remove(leftIp);
                }
                leftTimeStamp = logs[left++].timestamp;
                currWindow = rightTimeStamp - leftTimeStamp;
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        BotIps botIps = new BotIps();
        Log[] logs = {
                new Log(20, "10.2.3.4"),
                new Log(40, "9.9.9.9"),
                new Log(45, "9.9.9.9"),
                new Log(60, "10.2.3.4"),
                new Log(65, "10.4.4.4"),
                new Log(75, "10.4.4.4"),
        };
        int count = 2;
        int window = 20;
        System.out.println(botIps.getBotIps(logs, count, window));
    }
}
