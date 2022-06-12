package Companies.amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * We are in charge of designing a system to install packages. We are required
 * to support the installation
 * of a package and all of its dependent packages.
 * 
 * Here is an example of a package structure that we would need to install:
 * 
 * A depends on B, C
 * B depends on D, E, F
 * C depends on F
 * F depends on G
 * 
 * Define what a package looks like and code a solution to this problem.
 * 
 * private installPayload(Payload payload); // does not need to be implemented
 *
 */

class Payload {
    String data;
}

class Package {
    String id;
    private Payload payload;
    private List<Package> dependencies;

    public Package(String id, Payload payload, List<Package> dependencies) {
        this.id = id;
        this.payload = payload;
        this.dependencies = dependencies;
    }

    List<Package> getDependencies() {
        return this.dependencies;
    }

    Payload getPayload() {
        return this.payload;
    }
}

public class DesignPackageService {
    private Set<String> seen;

    public DesignPackageService() {
        seen = new HashSet<>();
    }

    void installPackage(Package head) {
        dfs(head);
    }

    void dfs(Package head) {
        if (seen.contains(head.id))
            return;
        if (head.getDependencies().isEmpty()) {
            installPayload(head.getPayload());
            return;
        }

        seen.add(head.id);

        for (Package dependency : head.getDependencies()) {
            dfs(dependency);
        }
    }

    void installPayload(Payload payload) {
        // TODO
    }

}
