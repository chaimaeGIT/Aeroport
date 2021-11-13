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

public class tabPilote implements Initializable {
    public AnchorPane base;
    public TextField matricule;
    public TextField nomP;
    public Label matriculeL;
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
    public TableColumn matri;
    public TableColumn name;
    public TableColumn firstname;
    public TableColumn adressp;

    ObservableList<unpilote> List= FXCollections.observableArrayList();

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

            String sql="SELECT * FROM PILOTE";
            Statement statement= (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                List.add(new unpilote(Integer.parseInt(rs.getString("MATRICULE")), rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("ADRESS")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        matri.setCellValueFactory(new PropertyValueFactory<>("matriculep"));
        name.setCellValueFactory(new PropertyValueFactory<>("nomp"));
        firstname.setCellValueFactory(new PropertyValueFactory<>("prenomp"));
        adressp.setCellValueFactory(new PropertyValueFactory<>("adressp"));

        // creation de cell factory to insert b

        table.setItems(List);
    }


    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Page2.fxml"));
        base.getChildren().setAll(pane);
    }

    public void Modifier(ActionEvent actionEvent) {
        String matr1 = matricule.getText();
        String nom1 = nomP.getText();
        String prenom1 = prenom.getText();
        String adress1 = adress.getText();
        String matr = matricule.getText();
        String nom=nomP.getText();
        String fnom = prenom.getText();
        String adres = adress.getText();
        if(matr1.trim().isEmpty()){

        }
        else{
            if(matr.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE PILOTE SET matricule='"+matr+"' nom='"+nom+"' prenom='"+fnom+"' adress='"+adres+"' WHERE matricule='"+matr1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    matricule.setText(" ");
                    nomP.setText(" ");
                    prenom.setText(" ");
                    adress.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

            if(nom.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE PILOTE SET nom='"+nom+"' prenom='"+fnom+"' adress='"+adres+"'  WHERE matricule='"+matr1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    matricule.setText(" ");
                    nomP.setText(" ");
                    prenom.setText(" ");
                    adress.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(fnom.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE PILOTE SET prenom='"+fnom+"' WHERE matricule='"+matr1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    matricule.setText(" ");
                    nomP.setText(" ");
                    prenom.setText(" ");
                    adress.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(adres.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE PILOTE SET adress='"+adres+"'  WHERE matricule='"+matr1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    matricule.setText(" ");
                    nomP.setText(" ");
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

        String sql="INSERT INTO PILOTE VALUES ('"+matricule.getText()+"','"+nomP.getText()+"','"+prenom.getText()+"','"+adress.getText()+"') ";
        Statement statement= (Statement) connection.createStatement();
        statement.executeUpdate(sql);
    }

    public void suprimer(ActionEvent actionEvent) {
        String matr = matricule.getText();
        String nom = nomP.getText();
        String fname = prenom.getText();
        String adr = adress.getText();
        if(matr.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM PILOTR WHERE matricule='"+matr+"' ";
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

            String requete ="DELETE FROM PILOTE WHERE nom='"+nom+"' ";
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

            String requete ="DELETE FROM PILOTE WHERE prenom='"+fname+"' ";
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

            String requete ="DELETE FROM PILOTE WHERE adress='"+adr+"' ";
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
            String sql="SELECT * FROM PILOTE WHERE matricule=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setcode = rs.getString("matricule");
                matricule.setText(setcode);
                String setname = rs.getString("nom");
                nomP.setText(setname);
                String setfname = rs.getString("prenom");
                prenom.setText(setfname);
                String setadress = rs.getString("adress");
                adress.setText(setadress);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }
}
