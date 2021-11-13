package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Page2 implements Initializable {
    public ImageView sendpaper1;
    public ImageView sendpaper2;
    public ImageView sendpaper3;
    public ImageView sendpaper4;
    public ImageView sendpaper5;
    public ImageView logo2;
    public ImageView logo;
    public Label spacetrip;
    public Label espaceadm;
    public ImageView icon;
    public AnchorPane rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File send1File=new File("image/send_paper_plane-512.png");
        Image send1Image=new Image(send1File.toURI().toString());
        sendpaper1.setImage(send1Image);

        File send2File=new File("image/send_paper_plane-512.png");
        Image send2Image=new Image(send2File.toURI().toString());
        sendpaper2.setImage(send2Image);

        File send3File=new File("image/send_paper_plane-512.png");
        Image send3Image=new Image(send3File.toURI().toString());
        sendpaper3.setImage(send3Image);

        File send4File=new File("image/send_paper_plane-512.png");
        Image send4Image=new Image(send4File.toURI().toString());
        sendpaper4.setImage(send4Image);

        File send5File=new File("image/send_paper_plane-512.png");
        Image send5Image=new Image(send5File.toURI().toString());
        sendpaper5.setImage(send5Image);

        File logoFile=new File("image/e-commerce-43-512.png");
        Image logoImage=new Image(logoFile.toURI().toString());
        logo.setImage(logoImage);


    }


    public void ville(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("tabVille.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void pilotes(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("tabPilote.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void reservations(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("tabReservation.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void vol(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("tabVol.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void client(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("tabClients.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("sample.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
