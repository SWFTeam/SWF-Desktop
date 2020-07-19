package SWF;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class APIService {

    private static final int SUCCESS = 200;
    private URL url;

    public APIService() {}

    public APIService(String url) {
        try {
            setUrl(url);
        } catch (MalformedURLException e){
            System.err.println(e.getLocalizedMessage());
        }
    }

    public APIService(URL url) {
        this.url = url;
    }

    public void setUrl(String url) throws MalformedURLException {
        this.url = new URL(url);
    }

    public Boolean ping() {
        try {
            HttpURLConnection con = (HttpURLConnection) this.url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            return status == SUCCESS;
        } catch (IOException e){
            System.err.println(e.getLocalizedMessage());
            return false;
        }
    }

    /*public TestObject requestTest(){
        HttpURLConnection con = (HttpURLConnection) this.url.openConnection();
        con.setRequestMethod("GET");

    }*/
}
