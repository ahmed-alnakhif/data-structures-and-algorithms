package Problems.priorityQueue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a list of servers and tasks which all have weights associated with
 * them. You must assign the next task to the server with the lowest current
 * weight.
 * 
 * Example:
 * list of servers: [x, y, z] - at the start all have 0 tasks
 * 
 * loadBalancer.assign(2) # returns server x (x now has task weighted 2)
 * loadBalancer.assign(1) # returns server y
 * loadBalancer.assign(1) # returns server z
 * loadBalancer.assign(1) # returns server y (y now has task weighted 2)
 */

class Server {
    private String name;
    private int capacity;
    private PriorityQueue<Task> tasks;

    public Server(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.tasks = new PriorityQueue<>((a, b) -> a.getTtl() - b.getTtl());
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

class Task {
    private int weight;
    private int ttl;

    public Task(int weight, int ttl) {
        this.weight = weight;
        this.ttl = ttl;
    }

    public int getWeight() {
        return weight;
    }

    public int getTtl() {
        return ttl;
    }
}

public class LoadBalancer {

    private PriorityQueue<Server> serversByWeight;

    public LoadBalancer(List<Server> servers) {
        serversByWeight = new PriorityQueue<>(
                (s1, s2) -> s1.getCapacity() != s2.getCapacity() ? s1.getCapacity() - s2.getCapacity()
                        : s1.getName().compareTo(s2.getName()));

        servers.forEach(server -> serversByWeight.add(server));
    }

    public Server assign(int taskWeight) {
        Server server = serversByWeight.poll();
        server.setCapacity(server.getCapacity() + taskWeight);
        serversByWeight.add(server);
        return server;
    }

    public static void main(String[] args) {
        List<Server> servers = Arrays.asList(new Server("x", 0), new Server("y", 0), new Server("z", 0));
        LoadBalancer loadBalancer = new LoadBalancer(servers);
        System.out.println(loadBalancer.assign(2).getName());
        System.out.println(loadBalancer.assign(1).getName());
        System.out.println(loadBalancer.assign(1).getName());
        System.out.println(loadBalancer.assign(1).getName());
    }
}
