package view;

import controller.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
            AnchorPane root = loader.load();
            if (LoginSceneController.currentUser != null) {
                Label label1 = new Label(LoginSceneController.currentUser.toString());
                root.getChildren().add(label1);
            }
            scene = new Scene(root);
            primaryStage.setScene(scene);
            return loader;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void showLoginScene() {//this one still works
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/loginScene.fxml"));
            Parent root = loader.load();
           // LoginSceneController controller = loader.getController();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showWelcomeScene() {
        //after login show per role a welcome scene
        switch (LoginSceneController.currentRole) {
            case "reader": {
                FXMLLoader loader = getScene("/view/fxml/welcomeReaderScreen");
                WelcomeReaderScreenController controller = loader.getController();
                //controller.setUp();
                break;
            }
            case "commenter": {
                FXMLLoader loader = getScene("/view/fxml/welcomeCommenterScreen");
                WelcomeCommenterScreenController controller = loader.getController();
                break;
            }
            case "storyteller": {
                FXMLLoader loader = getScene("/view/fxml/welcomeStorytellerScreen");
                WelcomeStorytellerScreenController controller = loader.getController();
                break;
            }
            default: {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/fxml/welcomeAdministratorScreen.fxml"));
                    Parent root = loader.load();//Fixme: location is not set => forgotten to add / begin pathway but now it doesn't show anything
                    WelcomeAdministratorScreenController controller = loader.getController();
                    controller.setup();
                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
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
