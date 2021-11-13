package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class unclient {
    private SimpleIntegerProperty cinc;
    private SimpleStringProperty nomc;
    private SimpleStringProperty prenomc;
    private SimpleStringProperty adressc;

    public unclient(int cinc, String nomc, String prenomc, String adressc) {
        this.cinc =new SimpleIntegerProperty( cinc);
        this.nomc =new SimpleStringProperty( nomc);
        this.prenomc =new SimpleStringProperty( prenomc);
        this.adressc =new SimpleStringProperty( adressc);
    }

    public int getCinc() {
        return cinc.get();
    }

    public void setCinc(int cinc) {
        this.cinc.set(cinc);
    }

    public String getNomc() {
        return nomc.get();
    }

    public void setNomc(String nomc) {
        this.nomc.set(nomc);
    }

    public String getPrenomc() {
        return prenomc.get();
    }

    public void setPrenomc(String prenomc) {
        this.prenomc.set(prenomc);
    }

    public String getAdressc() {
        return adressc.get();
    }

    public void setAdressc(String adressc) {
        this.adressc.set(adressc);
    }
}
