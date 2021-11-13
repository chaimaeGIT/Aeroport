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

public class tabClients implements Initializable {
    public AnchorPane base;
    public TextField cin;
    public TextField nomC;
    public Label cinc;
    public Label nomL;
    public TextField chercher;
    public ImageView recherche;
    public Label prenoml;
    public Label adressl;
    public TextField prenom;
    public TextField adress;
    public ImageView icon;
    public Label liste;
    public TableView table;
    public TableColumn cincl;
    public TableColumn name;
    public TableColumn firstname;
    public TableColumn adressp;
    ObservableList<unclient> List= FXCollections.observableArrayList();

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

            String sql="SELECT * FROM CLIENT";
            Statement statement= (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                List.add(new unclient(Integer.parseInt(rs.getString("CINCLIENT")), rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("ADRESS")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cincl.setCellValueFactory(new PropertyValueFactory<>("cinc"));
        name.setCellValueFactory(new PropertyValueFactory<>("nomc"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
        adressp.setCellValueFactory(new PropertyValueFactory<>("adressc"));

        // creation de cell factory to insert b

        table.setItems(List);
    }


    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Page2.fxml"));
        base.getChildren().setAll(pane);
    }

    public void Modifier(ActionEvent actionEvent) {
        String cin1 = cin.getText();
        String nom1 = nomC.getText();
        String prenom1 = prenom.getText();
        String adress1 = adress.getText();
        String cinn = cin.getText();
        String nom=nomC.getText();
        String fnom = prenom.getText();
        String adres = adress.getText();
        if(cin1.trim().isEmpty()){

        }
        else{
            if(cinn.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE CLIENT SET CINCLIENT='"+cinn+"' nom='"+nom+"' prenom='"+fnom+"' adress='"+adres+"' WHERE cinclient='"+cin1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    cin.setText(" ");
                    nomC.setText(" ");
                    prenom.setText(" ");
                    adress.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

            if(nom.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE CLIENT SET nom='"+nom+"' WHERE cinclient='"+cin1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    cin.setText(" ");
                    nomC.setText(" ");
                    prenom.setText(" ");
                    adress.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(fnom.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE CLIENT SET prenom='"+fnom+"' WHERE cinclient='"+cin1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    cin.setText(" ");
                    nomC.setText(" ");
                    prenom.setText(" ");
                    adress.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(adres.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE CLIENT SET adress='"+adres+"' WHERE cinclient='"+cin1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    cin.setText(" ");
                    nomC.setText(" ");
                    prenom.setText(" ");
                    adress.setText(" ");
                }catch(SQLException e){
                    System.out.println(e);

                }
            }

        }

    }

    public void Ajouter(ActionEvent actionEvent) throws SQLException {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection= (Connection) connectionClass.getConnection();

        String sql="INSERT INTO CLIENT VALUES ('"+cin.getText()+"','"+nomC.getText()+"','"+prenom.getText()+"','"+adress.getText()+"') ";
        Statement statement= (Statement) connection.createStatement();
        statement.executeUpdate(sql);
    }

    public void suprimer(ActionEvent actionEvent) {
        String cinc = cin.getText();
        String nom = nomC.getText();
        String fname = prenom.getText();
        String adr = adress.getText();
        if(cinc.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM CLIENT WHERE matricule='"+cinc+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }

        if(nom.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM CLIENT WHERE nom='"+nom+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }

        if(fname.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM CLIENT WHERE prenom='"+fname+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }

        if(adr.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM CLIENT WHERE adress='"+adr+"' ";
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
            String sql="SELECT * FROM CLIENT WHERE cinclient=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setcode = rs.getString("cinclient");
                cin.setText(setcode);
                String setname = rs.getString("nom");
                nomC.setText(setname);
                String setfname = rs.getString("prenom");
                prenom.setText(setfname);
                String setadress = rs.getString("adress");
                adress.setText(setadress);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM CLIENT WHERE nom=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setcode = rs.getString("cinclient");
                cin.setText(setcode);
                String setname = rs.getString("nom");
                nomC.setText(setname);
                String setfname = rs.getString("prenom");
                prenom.setText(setfname);
                String setadress = rs.getString("adress");
                adress.setText(setadress);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM CLIENT WHERE prenom=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setcode = rs.getString("cinclient");
                cin.setText(setcode);
                String setname = rs.getString("nom");
                nomC.setText(setname);
                String setfname = rs.getString("prenom");
                prenom.setText(setfname);
                String setadress = rs.getString("adress");
                adress.setText(setadress);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM CLIENT WHERE adress=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setcode = rs.getString("cinclient");
                cin.setText(setcode);
                String setname = rs.getString("nom");
                nomC.setText(setname);
                String setfname = rs.getString("prenom");
                prenom.setText(setfname);
                String setadress = rs.getString("adress");
                adress.setText(setadress);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void quitter(ActionEvent actionEvent) { System.exit(0);
    }
}
