package view;

import controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    private Stage primaryStage;

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public FXMLLoader getScene(String fxml) {
        Scene scene;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            scene = new Scene(root);
            primaryStage.setScene(scene);
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void showLoginScene() {
        try {
            FXMLLoader loader = new FXMLLoader((getClass().getResource("/view/fxml/loginScene.fxml")));
            Parent root = loader.load();
            LoginSceneController controller = loader.getController();
            //controller.setup(); //er is nog geen setup() methode in de LoginController but I do not need this?
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showWelcomeScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/welcomeScene.fxml"));
            Parent root = loader.load();
            WelcomeSceneController controller = loader.getController();
            controller.setup();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStoryListScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/manageStory.fxml"));
            Parent root = loader.load();
            WelcomeSceneController controller = loader.getController();
            controller.setup();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAddStoryScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/createUpdateStory.fxml"));
            Parent root = loader.load();
            WelcomeSceneController controller = loader.getController();
            controller.setup();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRetrievePasswordScene() {
        /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/retrievePasswordScene.fxml"));
        RetrievePasswordSceneController controller = loader.getController();*/
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/retrievePasswordScene.fxml"));
            Parent root = loader.load();
            RetrievePasswordSceneController controller = loader.getController();
            //controller.setup();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLinkHasBeenSent() {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/linkHasBeenSentScene.fxml"));
            Parent root = loader.load();
            LinkHasBeenSentSceneController controller = loader.getController();
            //controller.setup();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegisterScene() {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/registerScene.fxml"));
            Parent root = loader.load();
            RegisterSceneController controller = loader.getController();
            //controller.setup();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
