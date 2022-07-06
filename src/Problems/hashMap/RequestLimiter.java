package Problems.hashMap;

import java.util.HashMap;
import java.util.Map;

class Request {
    String ip;
    int timestamp;
}

//not complete 

public class RequestLimiter {
    private Map<String, Integer> requestCountMap;
    private int maxRequestLimit;
    private int windowSize;
    private int currentWindowSize;
    
    public RequestLimiter(){
        requestCountMap = new HashMap<>();
        maxRequestLimit = 1000;
        windowSize = 5;
        currentWindowSize = 0;
    }
    
    public boolean isRequestAllowed(Request request){
        requestCountMap.put(request.ip, requestCountMap.getOrDefault(request.ip, 0) + 1);
        
        if(requestCountMap.get(request.ip) > maxRequestLimit){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        
    }
}

