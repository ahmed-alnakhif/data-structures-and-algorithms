package Companies.amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Payload {
    String data;
}

class Package {
    String id;
    Payload payload;

    List<Package> getDependencies() {
        return null;
    }

    Payload getPayload() {
        return null;
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
