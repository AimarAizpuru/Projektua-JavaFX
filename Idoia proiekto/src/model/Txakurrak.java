/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aitor
 */

public class Txakurrak {
        
    private SimpleStringProperty mota;
    private SimpleStringProperty hileLuzera;
    private SimpleStringProperty funtzioPrintzipala;
    
    public Txakurrak(String type, String hairSize, String function) { 
        this.mota = new SimpleStringProperty(type);
        this.hileLuzera = new SimpleStringProperty(hairSize);
        this.funtzioPrintzipala = new SimpleStringProperty(function);
    }
    public String getMota() {
        return mota.get();
    }
    public void setMota(String type) {
        mota.set(type);
    }
    public String getTamaño() {
        return hileLuzera.get();
    }
    public void setTamaño(String height) {
        hileLuzera.set(height);
    }
    public String getFuntzioa() {
        return funtzioPrintzipala.get();
    }
    public void setFuntzioa(String function) {
        funtzioPrintzipala.set(function);
    }
}