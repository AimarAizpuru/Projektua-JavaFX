/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Txakurrak;

/**
 *
 * @author idoia
 */
public class GestionListaEnMemoria {
    
 //  
    
    public static ObservableList<Txakurrak> cargarDatos(){
        
        return FXCollections.observableArrayList(new Txakurrak("Pastor Aleman", "Motza", "Eiza"));
            
        
    }         
}
