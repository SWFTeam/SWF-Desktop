import esgi.githubConnector.Issues.Models.Issue;
import esgi.githubConnector.Issues.Services.IssueService;
import io.github.cdimascio.dotenv.*;
import java.io.IOException;
import org.json.*;
/**
 *Change teh used package for Github Interactions: deprecated !!!
 *TO DO
 * Abstraction: The code isn't "Passe partout" Yet
 * */

public class Main {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
    try {
        IssueService issueService = new IssueService(dotenv.get("TOKEN"));
        issueService.createIssue("Issue","Body");
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
