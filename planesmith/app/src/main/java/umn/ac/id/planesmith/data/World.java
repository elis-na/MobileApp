package umn.ac.id.planesmith.data;

public class World {

    private String world_name, world_content, folder;
    int id;

    public World(String world_name, String world_content, String folder) {
        this.world_name = world_name;
        this.world_content = world_content;
        this.folder = folder;
    }

    public World(int id, String world_name, String world_content, String folder) {
        this.id = id;
        this.world_name = world_name;
        this.world_content = world_content;
        this.folder = folder;
    }

    public String getWorld_name() {
        return world_name;
    }

    public void setWorld_name(String world_name) {
        this.world_name = world_name;
    }

    public String getWorld_content() {
        return world_content;
    }

    public void setWorld_content(String world_content) {
        this.world_content = world_content;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
