package esgi.githubConnector.Issues.Services;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;

public class RepositoryService
{
    private  String token;
    private OkHttpClient client;
    private String userAgent;

    public RepositoryService (String Token) throws IOException {
        client  = new OkHttpClient();
        this.token = Token;
        this.userAgent = "Harlequin98";
    }

    public ResponseBody getRepository(String RepositoryName) throws IOException {
        Request request = new Request.Builder()
                .header("Authorization","token "+this.token)
                .header("Accept","v3")
                .header("User-Agent",this.userAgent)
                .url("https://api.github.com/repos/Salayna/")
                .build();

        Response response = this.client.newCall(request).execute();
        return response.body();
    }
}
