package esgi.githubConnector.Issues.Models;

public class User {
    private String name;
    private String email;
    private String blog;
    private String Company;
    private String location;
    private Boolean hireable;
    private String Bio;
    private String twitterUserName;

    public User(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHireable(Boolean hireable) {
        this.hireable = hireable;
    }
}
