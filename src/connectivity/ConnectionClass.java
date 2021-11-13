package connectivity;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.uneville;

import java.sql.*;

public class ConnectionClass {
public Connection connection;
    public Connection getConnection(){
        String basedonnee="jdbc:mysql://localhost:3306/aeroport?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatatimeCode=false&serverTimezone=UTC";
        String username="root";
        String password="";

        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection= DriverManager.getConnection(basedonnee,username,password);
            System.out.println("connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
        }


    }

