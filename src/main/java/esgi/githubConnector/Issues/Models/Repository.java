package esgi.githubConnector.Issues.Models;

public class Repository {
    private String name;
    private String description;
    private Boolean isPrivate;
    private Boolean hasIssues;
    private Boolean hasProjects;

    public Repository( String name){
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHasIssues(Boolean hasIssues) {
        this.hasIssues = hasIssues;
    }

    public Boolean getHasIssues() {
        return hasIssues;
    }

    public void setHasProjects(Boolean hasProjects) {
        this.hasProjects = hasProjects;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String toJSONString(){
        return "{" +
                "\n\"name\":\""+name+"\"," +
                "\n\"description\":\""+description+"\"," +
                "\n\"has_issues\":"+hasIssues+"," +
                "\n\"has_projects\":"+hasProjects+"," +
                "\n\"private\":"+isPrivate+""+
                "}";
    };
}
