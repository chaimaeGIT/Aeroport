package sample;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import connectivity.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class tabReservation implements Initializable {
    public AnchorPane base;
    public TextField date;
    public TextField cinclient;
    public Label datereserv;
    public Label cin;
    public TextField chercher;
    public ImageView recherche;
    public Label numero;
    public TextField numérovol;
    public ImageView icon;
    public Label liste;
    public TableView table;
    public TableColumn dateres;
    public TableColumn cinclie;
    public TableColumn numerovo;
    ;
    ObservableList<unereservation> List= FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File brandingFile=new File("image/icon-avion (1).png");
        Image brandingImage=new Image(brandingFile.toURI().toString());
        icon.setImage(brandingImage);

        File rechFile=new File("image/rech.png");
        Image rechImage=new Image(rechFile.toURI().toString());
        recherche.setImage(rechImage);

        ConnectionClass connection  = new ConnectionClass();
        villetableview();

    }
    private void villetableview(){
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();

            String sql="SELECT * FROM RESERVATION";
            Statement statement= (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                List.add(new unereservation(rs.getString("datereservation"),Integer.parseInt(rs.getString("cinclient")),Integer.parseInt(rs.getString("numdevol"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dateres.setCellValueFactory(new PropertyValueFactory<>("reservation"));
        cinclie.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        numerovo.setCellValueFactory(new PropertyValueFactory<>("numv"));

        // creation de cell factory to insert b

        table.setItems(List);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Page2.fxml"));
        base.getChildren().setAll(pane);
    }

    public void Modifier(ActionEvent actionEvent) {
        String date1 = dateres.getText();
        String cin1 = cinclie.getText();
        String num1 = numerovo.getText();
        String date = dateres.getText();
        String cin = cinclie.getText();
        String num=numerovo.getText();

        if(date1.trim().isEmpty()){

        }
        else{
            if(date.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VILLE SET datereservation='"+date+"' cinclient='"+cin+"' numdevol='"+num+"' WHERE datereservation='"+date1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    dateres.setText(" ");
                    cinclie.setText(" ");
                    numerovo.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

            if(cin.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE DATERESERVATION SET cin='"+cin+"' WHERE datereservation='"+date1+"'' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    dateres.setText(" ");
                    cinclie.setText(" ");
                    numerovo.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(num.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE DATERESERVATION SET numdevol='"+num+"' WHERE datereservation='"+date1+"'' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    dateres.setText(" ");
                    cinclie.setText(" ");
                    numerovo.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

        }

    }

    public void Ajouter(ActionEvent actionEvent) throws SQLException {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection= (Connection) connectionClass.getConnection();

        String sql="INSERT INTO RESERVATION VALUES ('"+date.getText()+"','"+cinclient.getText()+"','"+numérovol.getText()+"') ";
        Statement statement= (Statement) connection.createStatement();
        statement.executeUpdate(sql);
    }

    public void suprimer(ActionEvent actionEvent) {
        String dater = date.getText();
        String cin = cinclient.getText();
        String num = numérovol.getText();
        if(dater.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM RESERVATION WHERE datereservation='"+dater+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(cin.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM RESERVATION WHERE cinclient='"+cin+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(num.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM RESERVATION WHERE numdevol='"+num+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }

    public void chercher(ActionEvent actionEvent) {
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM RESERVATION WHERE datereservation=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setdate = rs.getString("datereservation");
                date.setText(setdate);
                String setcin = rs.getString("cinclient");
                cinclient.setText(setcin);
                String setnum = rs.getString("numdevol");
                numérovol.setText(setnum);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM RESERVATION WHERE cinclient=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setdate = rs.getString("datereservation");
                date.setText(setdate);
                String setcin = rs.getString("cinclient");
                cinclient.setText(setcin);
                String setnum = rs.getString("numdevol");
                numérovol.setText(setnum);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM RESERVATION WHERE numdevol=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setdate = rs.getString("datereservation");
                date.setText(setdate);
                String setcin = rs.getString("cinclient");
                cinclient.setText(setcin);
                String setnum = rs.getString("numdevol");
                numérovol.setText(setnum);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }
}
