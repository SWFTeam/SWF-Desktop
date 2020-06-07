package esgi.githubConnector.Issues.Services;
import com.sun.net.httpserver.Headers;
import esgi.githubConnector.Issues.Models.Issue;
import okhttp3.*;
import okhttp3.internal.http2.Header;

import java.io.IOException;

public class IssueService {
    private  String token;
    private OkHttpClient client;
    private String userAgent;

    public IssueService(String Token) throws IOException {
       client  = new OkHttpClient();
       this.token = Token;
       this.userAgent = "Harlequin98";
    }

    public ResponseBody getIssues () throws IOException {

        Request request = new Request.Builder()
                .header("Authorization","token "+this.token)
                .header("Accept","v3")
                .header("User-Agent",this.userAgent)
                .url("https://api.github.com/user/issues")
                .build();

        Response response = this.client.newCall(request).execute();
        return response.body();
    }

    public ResponseBody createIssue (String title, String body) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        Issue issue = new Issue(title,body);
        String JSONIssue = issue.toJSOnString();
        System.out.print(JSONIssue);
        RequestBody requestBody = RequestBody.create(mediaType, JSONIssue);
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/Harlequin98/Github-App-Connector-Java/issues")
                .method("POST", requestBody)
                .addHeader("User-Agent", this.userAgent)
                .addHeader("Authorization", "token "+this.token)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = this.client.newCall(request).execute();
        System.out.println(response.toString());
        return response.body();
    }


    /***/
    public ResponseBody closeIssue () throws IOException {
        return null;
    }

    public ResponseBody lockIssueNoBody (int issueId) throws IOException {
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/Harlequin98/Github-App-Connector-Java/issues/"+issueId+"/lock")
                .method("PUT", body)
                .addHeader("User-Agent", this.userAgent)
                .addHeader("Content-Length", "0")
                .addHeader("Authorization", "token "+this.token)
                .build();
        Response response = this.client.newCall(request).execute();
        return response.body();
    }

    public ResponseBody unlockIssueNoBody (int issueId) throws IOException {
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/Harlequin98/Github-App-Connector-Java/issues/"+issueId+"/lock")
                .method("DELETE", body)
                .addHeader("User-Agent", this.userAgent)
                .addHeader("Content-Length", "0")
                .addHeader("Authorization", "token "+this.token)
                .build();
        Response response = this.client.newCall(request).execute();
        return response.body();
    }

    public ResponseBody GetAnIssue(int isssueId) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/Harlequin98/Github-App-Connector-Java/issues/5")
                .method("GET",null)
                .addHeader("User-Agent", this.userAgent)
                .addHeader("Authorization", "token "+this.token)
                .build();
        Response response = this.client.newCall(request).execute();
        return response.body();
    }

    /**
     * Ici les fonctions pour editer jsut des champs spécifiques (assignees, body, title etc...)
     */

    /**
     *UPDATE Issue Title
     */

    public ResponseBody updateIssueTitle (int issueId, String title) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, "{\n\t\"title\": \""+title+"\"}");
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/Harlequin98/Github-App-Connector-Java/issues/"+issueId)
                .method("PATCH", requestBody)
                .addHeader("User-Agent", this.userAgent)
                .addHeader("Authorization", "token "+this.token)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = this.client.newCall(request).execute();
        return response.body();
    }

    /**
     * UPDATE Issue Body
     * */

    public ResponseBody updateIssueBody (int issueId,String body) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, "{\t\"body\": \""+body+"\"}");
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/Harlequin98/Github-App-Connector-Java/issues/"+issueId)
                .method("PATCH", requestBody)
                .addHeader("User-Agent", this.userAgent)
                .addHeader("Authorization", "token "+this.token)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = this.client.newCall(request).execute();
        return response.body();
    }

}
