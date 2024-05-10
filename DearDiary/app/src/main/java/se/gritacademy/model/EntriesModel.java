package se.gritacademy.model;

public class EntriesModel {

    private int id;
    private String title;
    private String entry;

    public EntriesModel() {
    }

    public EntriesModel(String titleText, String diaryText) {
        this.title = titleText;
        this.entry = diaryText;
    }


    public EntriesModel(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public EntriesModel(int id, String title, String entry) {
        this.id = id;
        this.title = title;
        this.entry = entry;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntry() {
        return entry;
    }
    public void setEntry(String string) {this.entry = string;}


}
