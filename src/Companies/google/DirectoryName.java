package Companies.google;

import java.util.List;

/**
 * convert list of folders to list of gmail labels 
 */

class Folder {
    int id;
    int parentId;
    String name;

    Folder(int id, int parentId, String name) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
    }
}

public class DirectoryName {
    
    public void getDirectoryName(List<Folder> folders) {
       
    }

    public static void main(String[] args) {
        DirectoryName dn = new DirectoryName();
        List<Folder> folders = List.of(
            new Folder(1, 0, "A"),
            new Folder(2, 1, "B"),
            new Folder(3, 1, "C"),
            new Folder(4, 0, "D"),
            new Folder(5, 4, "E"),
            new Folder(6, 4, "F"),
            new Folder(7, 6, "G"),
            new Folder(8, 6, "H"),
            new Folder(9, 8, "I"),
            new Folder(10, 8, "J")
        );
        
        dn.getDirectoryName(folders);
    }
}
