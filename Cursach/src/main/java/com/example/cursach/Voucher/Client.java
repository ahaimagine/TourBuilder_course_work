package com.example.cursach.Voucher;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Client {
    private SimpleIntegerProperty IDC;
    private SimpleStringProperty Name;
    private SimpleStringProperty Surname;

    public Client(int IDC, String name, String surname) {
        this.IDC = new SimpleIntegerProperty(IDC);
        this.Name = new SimpleStringProperty( name);
        this.Surname = new SimpleStringProperty(surname);
    }

    public int getIDC() {
        return IDC.get();
    }

    public SimpleIntegerProperty IDCProperty() {
        return IDC;
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public String getSurname() {
        return Surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return Surname;
    }
}