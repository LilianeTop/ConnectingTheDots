package main;

import database.mySQL.DBAccess;
import javafx.application.Application;
import javafx.stage.Stage;
import view.SceneManager;

public class Main extends Application {
    private static SceneManager sceneManager = null;
    private static Stage primaryStage;
    private static DBAccess database = null;

    //singleton design pattern je kan maar 1 object creëren van een sceneManager
    public static SceneManager getSceneManager() {
        if (sceneManager == null) {
            //als er geen is maak dan een nieuwe
            sceneManager = new SceneManager(primaryStage);
        }//anders return the sceneManager als er wel al een is
        return sceneManager;
    }

    //dit is ook een singleton design er kan er maar 1 dbAccess zijn
    public static DBAccess getDBAccess() {
        if (database == null) {
            database = new DBAccess();
        }
        return database;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void run() {
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        getSceneManager().showLoginScene();
    }
}
