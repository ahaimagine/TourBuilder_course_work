package com.example.cursach.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.cursach.DataBaseActions.ManagerDB;
import com.example.cursach.DataBaseActions.QueryConst;
import com.example.cursach.HelloApplication;
import com.example.cursach.Voucher.Client;
import com.example.cursach.Voucher.Voucher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class SelectDataController {

    ObservableList<Voucher> arr;
    ObservableList<Client> arr1;

    @FXML
    private TableColumn<Voucher, String> City;

    @FXML
    private TextField ClientsField;

    @FXML
    private TableColumn<Voucher, String> Country;

    @FXML
    private TableColumn<Voucher, String> DayIn;

    @FXML
    private TableColumn<Voucher, String> DayOut;



    @FXML
    private ChoiceBox<String> ForClients;

    @FXML
    private ChoiceBox<String> ForVouchers;

    @FXML
    private TableColumn<Voucher, String> Hotel;

    @FXML
    private TableColumn<?, ?> IDC;

    @FXML
    private TableColumn<Voucher, Integer> IDV;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<Voucher, String> OwnName;

    @FXML
    private TableColumn<Voucher, String> OwnSurname;

    @FXML
    private TableColumn<Voucher, Double> PricePer;

    @FXML
    private TableColumn<?, ?> Surname;

    @FXML
    private TableColumn<Voucher, String> Type;

    @FXML
    private TextField VouchersField;

    @FXML
    private TableView<Client> TableClientsID;

    @FXML
    private TableView<Voucher> TableVoucherID;
    private Scene scene;
    private FXMLLoader root;

    private ObservableList<String> comboboxersV = FXCollections.observableArrayList();
    private ObservableList<String> comboboxersC = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        comboboxersV.add("VoucherID");
        comboboxersV.add("VoucherType");
        comboboxersV.add("OwnName");
        comboboxersV.add("OwnSurname");
        comboboxersV.add("Country");
        comboboxersV.add("City");
        comboboxersV.add("Hotel");
        comboboxersV.add("DayIn");
        comboboxersV.add("DayOut");
        comboboxersV.add("PricePerDay");
        comboboxersC.add("ClientID");
        comboboxersC.add("FirstName");
        comboboxersC.add("LastName");
        ForClients.setItems(comboboxersC);
        ForVouchers.setItems(comboboxersV);
    }

    public void switchBack(ActionEvent event) throws IOException {
        root = new FXMLLoader(HelloApplication.class.getResource("ChoseePage.fxml"));
        scene = new Scene(root.load(), 900, 600);
        HelloApplication.getStage().setScene(scene);
    }

    public void ForSelect(){
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
    }

    public void selectVouchers(ActionEvent event) {
        arr = FXCollections.observableArrayList(ManagerDB.getInstance().GetDataVouchers(QueryConst.selectAllValues));
        ForSelect();
        TableVoucherID.setItems(arr);

    }

    public void selectClients(ActionEvent event) {
        arr1 = FXCollections.observableArrayList(ManagerDB.getInstance().GetDataClients(QueryConst.selectAllClients));
        IDC.setCellValueFactory(new PropertyValueFactory<>("IDC"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Surname.setCellValueFactory(new PropertyValueFactory<>("Surname"));
        TableClientsID.setItems(arr1);
    }

    public void DeleteVoucher(ActionEvent event) {
        ObservableList<Voucher> oblv = TableVoucherID.getSelectionModel().getSelectedItems();
        Voucher voucher = oblv.get(0);
        ManagerDB.getInstance().DeleteVoucher(voucher.getVoucherID());
    }

    public void DeleteClients(ActionEvent event) {
        ObservableList<Client> oblv = TableClientsID.getSelectionModel().getSelectedItems();
        Client client = oblv.get(0);
        ManagerDB.getInstance().DeleteClient(client.getIDC());
    }

    public void SelectSomeOfClients(ActionEvent event) {
        String column = ForClients.getValue();
        String PartOfQuery = ClientsField.getText();
        arr1 = FXCollections.observableArrayList(ManagerDB.getInstance().GetDataClients(QueryConst.CSelectID +column+" = " +PartOfQuery));
        ForSelect();
        TableClientsID.setItems(arr1);
    }

    public void SelectSomeOfVouchers(ActionEvent event) {
        String column = ForVouchers.getValue();
        String PartOfQuery = VouchersField.getText();
        arr = FXCollections.observableArrayList(ManagerDB.getInstance().GetDataVouchers(QueryConst.VSelectID+column+" = " +PartOfQuery));
        ForSelect();
        TableVoucherID.setItems(arr);
    }
}
