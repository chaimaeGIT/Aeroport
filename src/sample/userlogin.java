package sample;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import connectivity.ConnectionClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class userlogin implements Initializable {
    public AnchorPane base;
    public ImageView background;
    public ImageView logo;
    public Label spacetrip;
    public TextField t1;
    public TextField t2;
    public TextField t3;
    public TextField t4;
    public Label cin;
    public Label nom;
    public Label prenom;
    public Label adress;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile=new File("image/e-commerce-43-512.png");
        Image brandingImage=new Image(brandingFile.toURI().toString());
        logo.setImage(brandingImage);
        File backgroundFile=new File("image/background.jpg");
        Image backgroundImage=new Image(backgroundFile.toURI().toString());
        background.setImage(backgroundImage);}

    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void back(ActionEvent actionEvent) throws IOException {AnchorPane pane= FXMLLoader.load(getClass().getResource("sample.fxml"));
        base.getChildren().setAll(pane);
    }

    public void signin(ActionEvent actionEvent) throws SQLException, IOException {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection= (Connection) connectionClass.getConnection();

        String sql="INSERT INTO CLIENT VALUES ('"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"') ";
        Statement statement= (Statement) connection.createStatement();
        statement.executeUpdate(sql);

        AnchorPane pane= FXMLLoader.load(getClass().getResource("USER.fxml"));
        base.getChildren().setAll(pane);

    }
}
