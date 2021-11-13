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

public class tabVol implements Initializable {
    public AnchorPane base;
    public TextField numdevol;
    public TextField dateddeepart;
    public Label numvol;
    public Label datedepart;
    public TextField chercher;
    public ImageView recherche;
    public Label datearrivee;
    public Label heuredepart;
    public TextField datearr;
    public TextField hdep;
    public TextField heurearr;
    public TextField pilote;
    public TextField codevd;
    public TextField codeva;
    public Label heurearrivee;
    public Label matricule;
    public Label cvd;
    public Label cva;
    public ImageView icon;
    public Label liste;
    public TableView table;
    public TableColumn num;
    public TableColumn dd;
    public TableColumn da;
    public TableColumn hd;
    public TableColumn ha;
    public TableColumn pilo;
    public TableColumn cvilled;
    public TableColumn cvillea;
    ObservableList<unvol> List= FXCollections.observableArrayList();

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
        pilo.setCellValueFactory(new PropertyValueFactory<>("matriculepilote"));
        cvilled.setCellValueFactory(new PropertyValueFactory<>("codevilledepart"));
        cvillea.setCellValueFactory(new PropertyValueFactory<>("codevillearrivee"));


        // creation de cell factory to insert b

        table.setItems(List);
    }

    public void back(ActionEvent actionEvent) throws IOException {
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Page2.fxml"));
        base.getChildren().setAll(pane);
    }

    public void Ajouter(ActionEvent actionEvent) throws SQLException {
        ConnectionClass connectionClass=new ConnectionClass();
        Connection connection= (Connection) connectionClass.getConnection();

        String sql="INSERT INTO VOL VALUES ('"+numdevol.getText()+"','"+dateddeepart.getText()+"','"+datearr.getText()+"','"+hdep.getText()+"','"+heurearr.getText()+"','"+pilote.getText()+"','"+codevd.getText()+"','"+codeva.getText()+"') ";
        Statement statement= (Statement) connection.createStatement();
        statement.executeUpdate(sql);

    }

    public void chercher(ActionEvent actionEvent) {
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM VOL WHERE numvol=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numdevol.setText(setnum);
                String setdd = rs.getString("datedepart");
                dateddeepart.setText(setdd);
                String setfda = rs.getString("datearrivee");
                datearr.setText(setfda);
                String sethd = rs.getString("heuredepart");
                hdep.setText(sethd);
                String setha = rs.getString("heurearrivee");
                heurearr.setText(setha);
                String setmp = rs.getString("matriculepilote");
                pilote.setText(setmp);
                String setcvd = rs.getString("codevilledepart");
                codevd.setText(setcvd);
                String setcva = rs.getString("codevillearrivee");
                codeva.setText(setcva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM PILOTE WHERE datedepart=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numdevol.setText(setnum);
                String setdd = rs.getString("datedepart");
                dateddeepart.setText(setdd);
                String setfda = rs.getString("datearrivee");
                datearr.setText(setfda);
                String sethd = rs.getString("heuredepart");
                hdep.setText(sethd);
                String setha = rs.getString("heurearrivee");
                heurearr.setText(setha);
                String setmp = rs.getString("matriculepilote");
                pilote.setText(setmp);
                String setcvd = rs.getString("codevilledepart");
                codevd.setText(setcvd);
                String setcva = rs.getString("codevillearrivee");
                codeva.setText(setcva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM PILOTE WHERE datearrivee=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numdevol.setText(setnum);
                String setdd = rs.getString("datedepart");
                dateddeepart.setText(setdd);
                String setfda = rs.getString("datearrivee");
                datearr.setText(setfda);
                String sethd = rs.getString("heuredepart");
                hdep.setText(sethd);
                String setha = rs.getString("heurearrivee");
                heurearr.setText(setha);
                String setmp = rs.getString("matriculepilote");
                pilote.setText(setmp);
                String setcvd = rs.getString("codevilledepart");
                codevd.setText(setcvd);
                String setcva = rs.getString("codevillearrivee");
                codeva.setText(setcva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM PILOTE WHERE heuredepart=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numdevol.setText(setnum);
                String setdd = rs.getString("datedepart");
                dateddeepart.setText(setdd);
                String setfda = rs.getString("datearrivee");
                datearr.setText(setfda);
                String sethd = rs.getString("heuredepart");
                hdep.setText(sethd);
                String setha = rs.getString("heurearrivee");
                heurearr.setText(setha);
                String setmp = rs.getString("matriculepilote");
                pilote.setText(setmp);
                String setcvd = rs.getString("codevilledepart");
                codevd.setText(setcvd);
                String setcva = rs.getString("codevillearrivee");
                codeva.setText(setcva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM PILOTE WHERE heurearrivee=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numdevol.setText(setnum);
                String setdd = rs.getString("datedepart");
                dateddeepart.setText(setdd);
                String setfda = rs.getString("datearrivee");
                datearr.setText(setfda);
                String sethd = rs.getString("heuredepart");
                hdep.setText(sethd);
                String setha = rs.getString("heurearrivee");
                heurearr.setText(setha);
                String setmp = rs.getString("matriculepilote");
                pilote.setText(setmp);
                String setcvd = rs.getString("codevilledepart");
                codevd.setText(setcvd);
                String setcva = rs.getString("codevillearrivee");
                codeva.setText(setcva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM PILOTE WHERE matriculepilote=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numdevol.setText(setnum);
                String setdd = rs.getString("datedepart");
                dateddeepart.setText(setdd);
                String setfda = rs.getString("datearrivee");
                datearr.setText(setfda);
                String sethd = rs.getString("heuredepart");
                hdep.setText(sethd);
                String setha = rs.getString("heurearrivee");
                heurearr.setText(setha);
                String setmp = rs.getString("matriculepilote");
                pilote.setText(setmp);
                String setcvd = rs.getString("codevilledepart");
                codevd.setText(setcvd);
                String setcva = rs.getString("codevillearrivee");
                codeva.setText(setcva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM PILOTE WHERE codevilledepart=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numdevol.setText(setnum);
                String setdd = rs.getString("datedepart");
                dateddeepart.setText(setdd);
                String setfda = rs.getString("datearrivee");
                datearr.setText(setfda);
                String sethd = rs.getString("heuredepart");
                hdep.setText(sethd);
                String setha = rs.getString("heurearrivee");
                heurearr.setText(setha);
                String setmp = rs.getString("matriculepilote");
                pilote.setText(setmp);
                String setcvd = rs.getString("codevilledepart");
                codevd.setText(setcvd);
                String setcva = rs.getString("codevillearrivee");
                codeva.setText(setcva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
        try{
            ConnectionClass connectionClass=new ConnectionClass();
            Connection connection= (Connection) connectionClass.getConnection();
            String sql="SELECT * FROM PILOTE WHERE codevillearrivee=?";
            PreparedStatement pst= connection.prepareStatement(sql);
            pst.setString(1,chercher.getText());
            ResultSet rs=pst.executeQuery();
            if (rs.next()){
                String setnum = rs.getString("numvol");
                numdevol.setText(setnum);
                String setdd = rs.getString("datedepart");
                dateddeepart.setText(setdd);
                String setfda = rs.getString("datearrivee");
                datearr.setText(setfda);
                String sethd = rs.getString("heuredepart");
                hdep.setText(sethd);
                String setha = rs.getString("heurearrivee");
                heurearr.setText(setha);
                String setmp = rs.getString("matriculepilote");
                pilote.setText(setmp);
                String setcvd = rs.getString("codevilledepart");
                codevd.setText(setcvd);
                String setcva = rs.getString("codevillearrivee");
                codeva.setText(setcva);
            }

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void quitter(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void suprimer(ActionEvent actionEvent) {
        String N = numdevol.getText();
        String dd = dateddeepart.getText();
        String da = datearr.getText();
        String hd = hdep.getText();
        String ha = heurearr.getText();
        String mp=pilote.getText();
        String cvd = codevd.getText();
        String cva = codeva.getText();

        if(N.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM VOL WHERE numvol='"+N+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(dd.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM VOL WHERE datedepart='"+dd+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(da.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM VOL WHERE datearrivee='"+da+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(hd.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM VOL WHERE heuredepart='"+hd+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(ha.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM VOL WHERE heurearrivee='"+ha+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(mp.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM VOL WHERE matriculepilote='"+mp+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(cvd.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM VOL WHERE codevilledepart='"+cvd+"' ";
            try{
                ConnectionClass connectionClass=new ConnectionClass();
                Connection connection= (Connection) connectionClass.getConnection();
                Statement statement= (Statement) connection.createStatement();
                statement.executeUpdate(requete);

            }catch(SQLException e){
                System.out.println(e);
            }
        }
        if(cva.trim().isEmpty()){

        }
        else{

            String requete ="DELETE FROM VOL WHERE codevillearrivee='"+cva+"' ";
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

    public void Modifier(ActionEvent actionEvent) {
        String N1 = numdevol.getText();
        String dd1 = dateddeepart.getText();
        String da1 = datearr.getText();
        String hd1 = hdep.getText();
        String ha1 = heurearr.getText();
        String mp1=pilote.getText();
        String cvd1 = codevd.getText();
        String cva1 = codeva.getText();
        String N = numdevol.getText();
        String dd = dateddeepart.getText();
        String da = datearr.getText();
        String hd = hdep.getText();
        String ha = heurearr.getText();
        String mp=pilote.getText();
        String cvd = codevd.getText();
        String cva = codeva.getText();

        if(N1.trim().isEmpty()){

        }
        else{
            if(N.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VOL SET numvol='"+N+"' datedepart='"+dd+"' datearrivee='"+da+"' heuredepart='"+hd+"' heurearrivee='"+ha+"' matriculepilote='"+mp+"' codevilledepart='"+cvd+"' codevillearrivee='"+cva+"' WHERE numvol='"+N+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    numdevol.setText(" ");
                    dateddeepart.setText(" ");
                    datearr.setText(" ");
                    hdep.setText(" ");
                    heurearr.setText(" ");
                    pilote.setText(" ");
                    codevd.setText(" ");
                    codeva.setText(" ");


                }catch(SQLException e){
                    System.out.println(e);

                }
            }

            if(dd.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VOL SET datedepart='"+dd+"' WHERE numvol='"+N+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    numdevol.setText(" ");
                    dateddeepart.setText(" ");
                    datearr.setText(" ");
                    hdep.setText(" ");
                    heurearr.setText(" ");
                    pilote.setText(" ");
                    codevd.setText(" ");
                    codeva.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(da.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VOL SET datearrivee='"+da+"' WHERE numvol='"+N+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    numdevol.setText(" ");
                    dateddeepart.setText(" ");
                    datearr.setText(" ");
                    hdep.setText(" ");
                    heurearr.setText(" ");
                    pilote.setText(" ");
                    codevd.setText(" ");
                    codeva.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(hd.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VOL SET heuredepart='"+hd+"' WHERE numvol='"+N+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    numdevol.setText(" ");
                    dateddeepart.setText(" ");
                    datearr.setText(" ");
                    hdep.setText(" ");
                    heurearr.setText(" ");
                    pilote.setText(" ");
                    codevd.setText(" ");
                    codeva.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(ha.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VOL SET heurearrivee='"+ha+"' WHERE numvol='"+N+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    numdevol.setText(" ");
                    dateddeepart.setText(" ");
                    datearr.setText(" ");
                    hdep.setText(" ");
                    heurearr.setText(" ");
                    pilote.setText(" ");
                    codevd.setText(" ");
                    codeva.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(mp.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VOL SET matriculepilote='"+mp+"' WHERE numvol='"+N+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    numdevol.setText(" ");
                    dateddeepart.setText(" ");
                    datearr.setText(" ");
                    hdep.setText(" ");
                    heurearr.setText(" ");
                    pilote.setText(" ");
                    codevd.setText(" ");
                    codeva.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(cvd.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VOL SET codevilledepart='"+cvd+"' WHERE numvol='"+N+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    numdevol.setText(" ");
                    dateddeepart.setText(" ");
                    datearr.setText(" ");
                    hdep.setText(" ");
                    heurearr.setText(" ");
                    pilote.setText(" ");
                    codevd.setText(" ");
                    codeva.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }
            if(cva.trim().isEmpty()){

            }
            else{
                String requete ="UPDATE VOL SET codevillearrivee='"+cva+"' WHERE numvol='"+N+"' ";
                try{
                    ConnectionClass connectionClass=new ConnectionClass();
                    Connection connection= (Connection) connectionClass.getConnection();
                    Statement statement= (Statement) connection.createStatement();
                    statement.executeUpdate(requete);
                    numdevol.setText(" ");
                    dateddeepart.setText(" ");
                    datearr.setText(" ");
                    hdep.setText(" ");
                    heurearr.setText(" ");
                    pilote.setText(" ");
                    codevd.setText(" ");
                    codeva.setText(" ");

                }catch(SQLException e){
                    System.out.println(e);

                }
            }

        }
    }
}
