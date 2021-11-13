package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class uneville {
    private SimpleIntegerProperty codev;
    private SimpleStringProperty nomv;

    public uneville(int codev, String nomv) {
        this.codev = new SimpleIntegerProperty(codev);
        this.nomv = new SimpleStringProperty( nomv);
    }

    public int getCodev() {
        return codev.get();
    }

    public void setCodev(int codev) {
        this.codev = new SimpleIntegerProperty( codev);
    }

    public String getNomv() {
        return nomv.get();
    }

    public void setNomv(String nomv) {
        this.nomv = new SimpleStringProperty(nomv);
    }


}
