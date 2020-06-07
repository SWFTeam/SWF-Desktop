package esgi.githubConnector.Issues.Services;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * TO DO
 * Code To rework  and seee Integration with Signature verification Object
 */
public class CommitService {
    private  String token;
    private OkHttpClient client;
    private String userAgent;

    public CommitService(String Token) throws IOException {
        client  = new OkHttpClient();
        this.token = Token;
        this.userAgent = "Harlequin98";
    }

    public ResponseBody createCommit(){

        return null;
    }
}
