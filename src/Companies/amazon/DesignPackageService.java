package Companies.amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        if (seen.contains(head.id)) return;
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
