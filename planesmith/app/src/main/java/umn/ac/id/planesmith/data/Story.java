package umn.ac.id.planesmith.data;

public class Story {

    private String chapter_name, chapter_content, arc;
    int id;

    public Story(String chapter_name, String chapter_content, String arc) {
        this.chapter_name = chapter_name;
        this.chapter_content = chapter_content;
        this.arc = arc;
    }

    public Story(int id, String chapter_name, String chapter_content, String arc) {
        this.id = id;
        this.chapter_name = chapter_name;
        this.chapter_content = chapter_content;
        this.arc = arc;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getChapter_content() {
        return chapter_content;
    }

    public void setChapter_content(String chapter_content) {
        this.chapter_content = chapter_content;
    }

    public String getArc() {
        return arc;
    }

    public void setArc(String arc) {
        this.arc = arc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
