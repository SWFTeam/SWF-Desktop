package esgi.githubConnector.Issues.Models;

import java.util.Arrays;

public class Issue {
    private int id;
    private String title;
    private String body;
   // private String[] labels;

    public Issue(int id, String title, String body){
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Issue(String title, String body){
    this.body = body;
    this.title = title;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public String toJSOnString(){
        return  "{" +
                "\n\"title\": \""+title+"\"," +
                "\n\"body\": \""+body+"\"" +
                "}";
    }
}
