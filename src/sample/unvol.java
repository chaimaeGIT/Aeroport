package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class unvol {
    private SimpleIntegerProperty numvol;
    private SimpleStringProperty datedepart;
    private SimpleStringProperty datearrivee;
    private SimpleStringProperty heuredepart;
    private SimpleStringProperty heurearrive;
    private SimpleIntegerProperty matriculepilote;
    private SimpleIntegerProperty codevilledepart;
    private SimpleIntegerProperty codevillearrivee;

    public unvol(int numvol, String datedepart, String datearrivee, String heuredepart, String heurearrive, int matriculepilote, int codevilledepart, int codevillearrivee) {
        this.numvol =new SimpleIntegerProperty(numvol);
        this.datedepart =new SimpleStringProperty( datedepart);
        this.datearrivee =new SimpleStringProperty( datearrivee);
        this.heuredepart =new SimpleStringProperty( heuredepart);
        this.heurearrive =new SimpleStringProperty( heurearrive);
        this.matriculepilote =new SimpleIntegerProperty( matriculepilote);
        this.codevilledepart =new SimpleIntegerProperty( codevilledepart);
        this.codevillearrivee =new SimpleIntegerProperty( codevillearrivee);
    }

    public int getNumvol() {
        return numvol.get();
    }

    public void setNumvol(int numvol) {
        this.numvol.set(numvol);
    }

    public String getDatedepart() {
        return datedepart.get();
    }

    public void setDatedepart(String datedepart) {
        this.datedepart.set(datedepart);
    }

    public String getDatearrivee() {
        return datearrivee.get();
    }

    public void setDatearrivee(String datearrivee) {
        this.datearrivee.set(datearrivee);
    }

    public String getHeuredepart() {
        return heuredepart.get();
    }

    public void setHeuredepart(String heuredepart) {
        this.heuredepart.set(heuredepart);
    }

    public String getHeurearrive() {
        return heurearrive.get();
    }



    public void setHeurearrive(String heurearrive) {
        this.heurearrive.set(heurearrive);
    }

    public int getMatriculepilote() {
        return matriculepilote.get();
    }

    public void setMatriculepilote(int matriculepilote) {
        this.matriculepilote.set(matriculepilote);
    }

    public int getCodevilledepart() {
        return codevilledepart.get();
    }

    public void setCodevilledepart(int codevilledepart) {
        this.codevilledepart.set(codevilledepart);
    }

    public int getCodevillearrivee() {
        return codevillearrivee.get();
    }

    public void setCodevillearrivee(int codevillearrivee) {
        this.codevillearrivee.set(codevillearrivee);
    }
}
