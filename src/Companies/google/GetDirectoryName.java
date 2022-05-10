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

public class GetDirectoryName {
    
    public void getDirectoryName(List<Folder> folders) {
       
    }

    public static void main(String[] args) {
        
    }
}
