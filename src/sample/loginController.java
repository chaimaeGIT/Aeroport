package sample;

import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.net.URL;

public class loginController implements Initializable {

    public TextField email;
    
    public Label spacetrip;
    public Label administrateurs;
    public Label invalid;
    public ImageView logo;
    public ImageView logo2;
    public Label username;
    public Label password2;
    public AnchorPane rootpane;
    public PasswordField password;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile=new File("image/e-commerce-43-512.png");
        Image brandingImage=new Image(brandingFile.toURI().toString());
        logo.setImage(brandingImage);

        File branding2File=new File("image/icon-avion (1).png");
        Image branding2Image=new Image(branding2File.toURI().toString());
        logo2.setImage(branding2Image);

    }


    public void clientBoutton(ActionEvent actionEvent) throws IOException {
        AnchorPane pane=FXMLLoader.load(getClass().getResource("userlogin.fxml"));
        rootpane.getChildren().setAll(pane);

    }


    public void signin(ActionEvent actionEvent) throws IOException {
        invalid.setText("Invalid UserName or Password, Please try again.");
        if(!email.getText().isBlank() && !password.getText().isBlank()) {
            validateLogin();

            AnchorPane pane=FXMLLoader.load(getClass().getResource("Page2.fxml"));
            rootpane.getChildren().setAll(pane);

        } else {
            invalid.setText("Please enter username and password");

        }

    }


    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }
    public void validateLogin(){
        ConnectionClass connectNow=new ConnectionClass();
        Connection connectDB=connectNow.getConnection();

        String verifylogin="SELECT count(1) FROM `user_account` WHERE username= '"+ email.getText() +"'AND password='"+ password.getText()+  "'";
   try {
       Statement statement=connectDB.createStatement();
       ResultSet queryResult = statement.executeQuery(verifylogin);

       while (queryResult.next()){
           if (queryResult.getInt(1)==1){
               invalid.setText("Welcome");


           }else {
               invalid.setText("Invalid Login,Please try again !");
           }

       }

   }catch (Exception e) {
       e.printStackTrace();
       e.getCause();
   }

    }
}

