package main;

import database.couchDB.CouchDBAccess;
import database.couchDB.CouchDBStoryDAO;
import database.mySQL.DBAccess;
import database.mySQL.UserDAO;
import javafx.application.Application;
import javafx.stage.Stage;
import view.SceneManager;

public class Main extends Application {
    private static SceneManager sceneManager = null;
    private static Stage primaryStage;
    private static DBAccess database = null;

    private static CouchDBAccess couchDBAccess;
    public static CouchDBStoryDAO couchDBStoryDAO;
    public static UserDAO userDAO;

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
        run();
        launch(args);
    }

    //Handles connection to CouchDB
    public static void run() {
        couchDBAccess = new CouchDBAccess();
        couchDBStoryDAO = new CouchDBStoryDAO(couchDBAccess);

        try {
            couchDBAccess.setUpConnection();
            System.out.println("Connection open to CouchDB");
        } catch (Exception error) {
            System.out.println("\n Something went wrong\n");
            error.getMessage();
            error.printStackTrace();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        getSceneManager().showLoginScene();
    }
}
