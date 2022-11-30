package com.example.cursach.Controllers;

import com.example.cursach.DataBaseActions.ManagerDB;
import com.example.cursach.DataBaseActions.QueryConst;
import com.example.cursach.HelloApplication;
import com.example.cursach.Voucher.Voucher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class SearchForController {
    private Scene scene;
    private FXMLLoader root;
    @FXML
    private TableView<Voucher> Table;
    @FXML
    private TextField txtField1;

    @FXML
    private TextField txtfield2;

    @FXML
    private TableColumn<Voucher, String> City;
    @FXML
    private TableColumn<Voucher, String> Type;
    @FXML
    private TableColumn<Voucher, String> Country;

    @FXML
    private TableColumn<Voucher, String> DayIn;

    @FXML
    private TableColumn<Voucher, String> DayOut;
    @FXML
    private TableColumn<Voucher, String> Hotel;
    @FXML
    private TableColumn<Voucher, String> OwnName;
    @FXML
    private TableColumn<Voucher, Integer> IDV;
    @FXML
    private TableColumn<Voucher, String> OwnSurname;

    @FXML
    private TableColumn<Voucher, Double> PricePer;

    ObservableList<Voucher> arr;
    @FXML
    private ChoiceBox<String> choiseBox;

    private ObservableList<String> combobox = FXCollections.observableArrayList();



    @FXML
    void initialize() {
        combobox.add("Max price");
        combobox.add("Min price");
        combobox.add("Choose diapazon");
        choiseBox.setItems(combobox);

    }
    public void SwitchBack(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("ChoseePage.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }
    public void SearchSomething(ActionEvent event) {
        String value = choiseBox.getValue();
        if(value.equals("Max price"))
            arr = FXCollections.observableArrayList(ManagerDB.getInstance().GetDataVouchers(QueryConst.ChooseMax));
        else if(value.equals("Min price"))
            arr = FXCollections.observableArrayList(ManagerDB.getInstance().GetDataVouchers(QueryConst.ChooseMin));
        else{
            arr = FXCollections.observableArrayList(ManagerDB.getInstance().GetDataVouchers(QueryConst.ChooseDiapazon+"PricePerDay > "+ Double.parseDouble(txtField1.getText())
            + "and PricePerDay < "+ Double.parseDouble(txtfield2.getText())));
        }
        City.setCellValueFactory(new PropertyValueFactory<>("City"));
        IDV.setCellValueFactory(new PropertyValueFactory<>("VoucherID"));
        Type.setCellValueFactory(new PropertyValueFactory<>("type"));
        Country.setCellValueFactory(new PropertyValueFactory<>("Country"));
        OwnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        OwnSurname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        Hotel.setCellValueFactory(new PropertyValueFactory<>("Hotel"));
        DayIn.setCellValueFactory(new PropertyValueFactory<>("FirstDay"));
        DayOut.setCellValueFactory(new PropertyValueFactory<>("LastDay"));
        PricePer.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Table.setItems(arr);
    }
}
