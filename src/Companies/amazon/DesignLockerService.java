package Companies.amazon;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Location {
    int id;
    String zipCode;
}

class Size {
    double height;
    double width;
    double depth;

    int getVolume() {
        return (int) (height * width * depth);
    }
}

class Locker {
    int id;
    Location location;
    Size size;
    boolean isAvailable;
}

class Pkg {
    int id;
    Size size;
}

public class DesignLockerService {

    Map<Integer, List<Locker>> lockerMap;

    public DesignLockerService() {
        lockerMap = new HashMap<>();
    }

    public Integer getLocker(Location location, Pkg pkg) {
        List<Locker> lockers = lockerMap.get(location.id);
        Collections.sort(lockers, (a, b) -> a.size.getVolume() - b.size.getVolume());

        for (Locker locker : lockers) {
            if (locker.isAvailable && canFit(pkg.size, locker.size)) {
                locker.isAvailable = false;
                return locker.id;
            }
        }

        return -1;
    }

    private boolean canFit(Size size1, Size size2) {
        return size1.height <= size2.height && size1.width <= size2.width && size1.depth <= size2.depth;
    }

    public static void main(String[] args) {
        
    }
}
