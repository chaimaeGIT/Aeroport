package sample;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.UpdatableResultSet;
import com.sun.scenario.effect.FilterEffect;
import connectivity.ConnectionClass;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.collections.transformation.FilteredList;

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

public class USER implements Initializable {
    public AnchorPane base;
    public ImageView background;
    public Label l1;
    public Label l2;
    public Label l3;
    public Label l4;
    public Label l5;
    public Label l6;
    public TextField cin;
    public TextField numerovol;
    public TextField date;
    public TableView table;
    public TableColumn dd;
    public TableColumn da;
    public TableColumn num;
    public TableColumn ha;
    public TableColumn mp;
    public TableColumn hd;
    public TableColumn vd;
    public TableColumn va;
    public TextField recherche;
    public ImageView cher;

    ObservableList<unvol> List= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File backgroundFile=new File("image/background.jpg");
        Image backgroundImage=new Image(backgroundFile.toURI().toString());
        background.setImage(backgroundImage);

        File cherFile=new File("image/rech.png");
        Image cherImage=new Image(cherFile.toURI().toString());
        cher.setImage(cherImage);
        ConnectionClass connection  = new ConnectionClass();
        villetableview();


    }
    private void villetableview(){
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();

            String sql="SELECT * FROM VOL";
            Statement statement= (Statement) connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                List.add(new unvol(Integer.parseInt(rs.getString("NUMVOL")), rs.getString("DATEDEPART"),rs.getString("DATEARRIVEE"),rs.getString("HEUREDEPART"),rs.getString("HEUREARRIVEE"),Integer.parseInt(rs.getString("MATRICULEPILOTE")),Integer.parseInt(rs.getString("CODEVILLEDEPART")),Integer.parseInt(rs.getString("CODEVILLEARRIVEE"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        num.setCellValueFactory(new PropertyValueFactory<>("numvol"));
        dd.setCellValueFactory(new PropertyValueFactory<>("datedepart"));
        da.setCellValueFactory(new PropertyValueFactory<>("datearrivee"));
        hd.setCellValueFactory(new PropertyValueFactory<>("heuredepart"));
        ha.setCellValueFactory(new PropertyValueFactory<>("heurearrive"));
        mp.setCellValueFactory(new PropertyValueFactory<>("matriculepilote"));
        vd.setCellValueFactory(new PropertyValueFactory<>("codevilledepart"));
        va.setCellValueFactory(new PropertyValueFactory<>("codevillearrivee"));


        // creation de cell factory to insert b

        table.setItems(List);
    }




    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("userlogin.fxml"));
        base.getChildren().setAll(pane);
    }

    public void reserver(ActionEvent actionEvent) throws SQLException {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection= (Connection) connectionClass.getConnection();

        String sql="INSERT INTO RESERVATION VALUES ('"+date.getText()+"','"+cin.getText()+"','"+numerovol.getText()+"') ";
        Statement statement= (Statement) connection.createStatement();
        statement.executeUpdate(sql);
    }



    public void chercher(ActionEvent actionEvent) {

        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT numvol FROM VOL WHERE numvol=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,recherche.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numerovol.setText(setnum);

            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT numvol FROM VOL WHERE codevillearrivee=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,recherche.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numerovol.setText(setnum);

            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT numvol FROM VOL WHERE datedepart=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,recherche.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numerovol.setText(setnum);

            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT numvol FROM VOL WHERE datearrivee=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,recherche.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numerovol.setText(setnum);

            }

        }catch(SQLException e){
            System.out.println(e);
        }

    }
}
