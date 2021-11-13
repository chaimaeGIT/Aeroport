package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class unereservation {
    private SimpleStringProperty reservation;
    private SimpleIntegerProperty cinc;
    private SimpleIntegerProperty numv;

    public unereservation(String reservation, int cinc, int numv) {
        this.reservation =new SimpleStringProperty(reservation );
        this.cinc =new SimpleIntegerProperty( cinc);
        this.numv =new SimpleIntegerProperty( numv);
    }

    public String getReservation() {
        return reservation.get();
    }


    public void setReservation(String reservation) {
        this.reservation.set(reservation);
    }

    public int getCinc() {
        return cinc.get();
    }


    public void setCinc(int cinc) {
        this.cinc.set(cinc);
    }

    public int getNumv() {
        return numv.get();
    }


    public void setNumv(int numv) {
        this.numv.set(numv);
    }
}
