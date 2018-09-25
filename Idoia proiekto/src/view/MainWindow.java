/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import controller.GestionListaEnMemoria;
import javafx.util.converter.NumberStringConverter;

import model.Txakurrak;


/**
 *
 * @author idoia
 */
public class MainWindow extends Application {

    private TableView<Txakurrak> table = new TableView<>();

     HBox hb = new HBox();
    
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        
        ObservableList<Txakurrak> data = GestionListaEnMemoria.cargarDatos();
        
        stage.setTitle("Datuen Taula");
        stage.setWidth(450);
        stage.setHeight(550);
         Label label = new Label("Txakurrak");
        label.setFont(new Font("Arial", 20));
        
        table.setEditable(true);
        
        TableColumn<Txakurrak, String> dogSpecie =
            new TableColumn<>("Mota");
        dogSpecie.setMinWidth(100);
        dogSpecie.setCellValueFactory(
            new PropertyValueFactory<>("Mota"));
        dogSpecie.setCellFactory(TextFieldTableCell.<Txakurrak>forTableColumn());
        dogSpecie.setOnEditCommit((TableColumn.CellEditEvent<Txakurrak, String> t) -> {
            ((Txakurrak) t.getTableView().getItems().get(
            t.getTablePosition().getRow())
            ).setMota(t.getNewValue());
            });
        
        TableColumn<Txakurrak, String> dogHairSize = new TableColumn<>("Hile luzea / motza");
        dogHairSize.setMinWidth(200);
        dogHairSize.setCellValueFactory(
        new PropertyValueFactory<>("Hile luzea / motza"));
        dogHairSize.setCellFactory(TextFieldTableCell.<Txakurrak>forTableColumn());
        dogHairSize.setOnEditCommit((TableColumn.CellEditEvent<Txakurrak, String> t) -> {
                ((Txakurrak) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setTamaño(t.getNewValue());
            });
        
        TableColumn<Txakurrak, String> dogFunction = new TableColumn<>("Funtzioa");
        dogFunction.setMinWidth(200);
        dogFunction.setCellValueFactory(
        new PropertyValueFactory<>("Funtzioa"));
        dogFunction.setCellFactory(TextFieldTableCell.<Txakurrak>forTableColumn());
        dogFunction.setOnEditCommit((TableColumn.CellEditEvent<Txakurrak, String> t) -> {
                ((Txakurrak) t.getTableView().getItems().get(
                t.getTablePosition().getRow())
                ).setFuntzioa(t.getNewValue());
            });
        table.setItems(data);
        table.getColumns().addAll(dogSpecie, dogHairSize, dogFunction);
         TextField addSpecie = new TextField();
        addSpecie.setPromptText("mota");
        addSpecie.setMaxWidth(dogSpecie.getPrefWidth());
         TextField addHeight = new TextField();
        addHeight.setMaxWidth(dogHairSize.getPrefWidth());
        addHeight.setPromptText("Hile luzea / motza");
         TextField addFunction = new TextField();
        addFunction.setMaxWidth(dogFunction.getPrefWidth());
        addFunction.setPromptText("funtzioa");
       
        final Button addButton = new Button("Gehitu");        
        addButton.setOnAction((ActionEvent e) -> {
            Txakurrak p = new Txakurrak(
                addSpecie.getText(),
                addHeight.getText(),
                addFunction.getText());
            data.add(p);
            
            addSpecie.clear();
            addHeight.clear();
            addFunction.clear();
        });
        
        final Button removeButton = new Button("Ezabatu");        
        removeButton.setOnAction((ActionEvent e) -> {
            Txakurrak dog = table.getSelectionModel().getSelectedItem();    
            data.remove(dog);
        });
        
        hb.getChildren().addAll(addSpecie, addHeight, addFunction, addButton, removeButton);
        hb.setSpacing(3);
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
