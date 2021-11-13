package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class unpilote {
    private SimpleIntegerProperty matriculep;
    private SimpleStringProperty nomp;
    private SimpleStringProperty prenomp;
    private SimpleStringProperty adressp;

    public unpilote(int matriculep, String nomp, String prenomp, String adressp) {
        this.matriculep =new SimpleIntegerProperty( matriculep);
        this.nomp =new SimpleStringProperty( nomp);
        this.prenomp =new SimpleStringProperty( prenomp);
        this.adressp =new SimpleStringProperty( adressp);
    }

    public int getMatriculep() {
        return matriculep.get();
    }

    public void setMatriculep(int matriculep) {
        this.matriculep.set(matriculep);
    }

    public String getNomp() {
        return nomp.get();
    }

    public void setNomp(String nomp) {
        this.nomp.set(nomp);
    }

    public String getPrenomp() {
        return prenomp.get();
    }


    public void setPrenomp(String prenomp) {
        this.prenomp.set(prenomp);
    }

    public String getAdressp() {
        return adressp.get();
    }

    public void setAdressp(String adressp) {
        this.adressp.set(adressp);
    }
}
