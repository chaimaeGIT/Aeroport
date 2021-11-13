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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.sql.StatementEventListener;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Handler;

public class tabVille implements Initializable {
    public Label liste;
    public AnchorPane base;
    public ImageView icon;
    public TableView<uneville> table;
    public TableColumn codeville;
    public TableColumn nomville;
    public javafx.scene.control.TextField code_ville;
    public javafx.scene.control.TextField nom_ville;
    public Label code;
    public Label nom;
    public TextField chercher;
    public ImageView recherche;


    ObservableList<uneville> List= FXCollections.observableArrayList();

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

            String sql="SELECT * FROM VILLE";
            Statement statement= (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                List.add(new uneville(Integer.parseInt(rs.getString("CODEVILLE")), rs.getString("NOM")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        codeville.setCellValueFactory(new PropertyValueFactory<>("Codev"));
        nomville.setCellValueFactory(new PropertyValueFactory<>("Nomv"));

        // creation de cell factory to insert b

        table.setItems(List);
    }







    public void quitter(ActionEvent actionEvent) {

        System.exit(0);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Page2.fxml"));
        base.getChildren().setAll(pane);

    }

    public void Modifier(ActionEvent actionEvent) {
        String code = code_ville.getText();
        String nom1 = nom_ville.getText();
        String code2 = code_ville.getText();
        String nom=nom_ville.getText();
        if(code.trim().isEmpty()){

        }
        else{
            if(code2.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VILLE SET codeville='"+code2+"' nom='"+nom+"' WHERE codeville='"+code+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    code_ville.setText(" ");
                    nom_ville.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

            if(nom.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VILLE SET nom='"+nom+"' WHERE codeville='"+code+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    code_ville.setText(" ");
                    nom_ville.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

            }
        if(nom1.trim().isEmpty()){

        }
        else{
            if(nom.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VILLE SET codeville='"+code2+"' nom='"+nom+"' WHERE nom='"+nom1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    code_ville.setText(" ");
                    nom_ville.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

            if(code2.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VILLE SET codeville='"+code2+"' WHERE nom='"+nom1+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    code_ville.setText(" ");
                    nom_ville.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

        }

        }

    public void Ajouter(ActionEvent actionEvent) throws SQLException {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection= (Connection) connectionClass.getConnection();

        String sql="INSERT INTO VILLE VALUES ('"+code_ville.getText()+"','"+nom_ville.getText()+"') ";
        Statement statement= (Statement) connection.createStatement();
        statement.executeUpdate(sql);


    }

    public void suprimer(ActionEvent actionEvent) {
        String nom = nom_ville.getText();
        String code = code_ville.getText();
        if(code.trim().isEmpty()){

        }
        else{

                String requete ="DELETE FROM VILLE WHERE codeville='"+code+"' ";
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

            String requete ="DELETE FROM VILLE WHERE nom='"+nom+"' ";
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
            String sql="SELECT * FROM VILLE WHERE codeville=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setcode = rs.getString("codeville");
                code_ville.setText(setcode);
                String setname = rs.getString("nom");
                nom_ville.setText(setname);
            }

        }catch(SQLException e){
            System.out.println(e);
            }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM VILLE WHERE nom=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setcode = rs.getString("codeville");
                code_ville.setText(setcode);
                String setname = rs.getString("nom");
                nom_ville.setText(setname);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
    }
   }












