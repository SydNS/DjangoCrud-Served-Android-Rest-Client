package com.example.djangopro;

public class ForRest {
    String title, post, author, creationdate;


    int id;

    public ForRest(String title, String post, String author, String creationdate, int id) {
        this.title = title;
        this.post = post;
        this.author = author;
        this.creationdate = creationdate;
        this.id = id;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
