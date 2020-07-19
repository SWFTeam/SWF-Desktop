package SWF;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        try {
            final URL url = getClass().getResource("dashboard.fxml");
            final FXMLLoader fxmlLoader = new FXMLLoader(url);
            final Parent root = fxmlLoader.load();
            primaryStage.setScene(new Scene(root, 900, 500));
        } catch(IOException e){
            System.err.println(e);
        }
        primaryStage.setTitle("SWF Desktop");
        primaryStage.show();
        initApi();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void initApi() {
        APIService api = new APIService("http://localhost:3000");
        System.out.println(api.ping());
    }
}
