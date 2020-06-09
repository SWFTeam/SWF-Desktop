package esgi.githubConnector.Issues.Services;

import okhttp3.*;

import java.io.IOException;

public class UserServices {
    private  String token;
    private OkHttpClient client;
    private String userAgent;

    public UserServices(String Token) throws IOException {
        client  = new OkHttpClient();
        this.token = Token;
        this.userAgent = "Harlequin98";
    }

    public ResponseBody getUser() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .method("GET", null)
                .addHeader("Accept", "v3")
                .addHeader("User-Agent", "Salayna")
                .addHeader("Authorization", "token a3850615c97c9a4ed5367cfdbaaeb0c1e1e89082")
                .build();
        Response response = client.newCall(request).execute();
        return response.body();
    }

    public ResponseBody patchUser(String field, String value) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\""+field+"\":\""+value+"\"\n}");
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .method("PATCH", body)
                .addHeader("User-Agent", "Salayna")
                .addHeader("Accept", "v3")
                .addHeader("Authorization", "token a3850615c97c9a4ed5367cfdbaaeb0c1e1e89082")
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response.body();
    };

}
