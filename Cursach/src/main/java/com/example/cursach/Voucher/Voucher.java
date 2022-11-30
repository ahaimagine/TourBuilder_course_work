package com.example.cursach.Voucher;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Voucher {
    private SimpleStringProperty Name;
    private SimpleStringProperty Surname;
    private SimpleStringProperty type;
    private SimpleIntegerProperty VoucherID;
    private SimpleStringProperty Country;
    private SimpleStringProperty City;
    private SimpleStringProperty Hotel;
    private SimpleStringProperty FirstDay;
    private SimpleStringProperty LastDay;
    private SimpleDoubleProperty Price;

    public Voucher(String name, String surname, String type, int voucherID,
                   String country, String city, String hotel, String firstDay, String lastDay, double price) {
        this.Name = new SimpleStringProperty(name);
        this.Surname = new SimpleStringProperty(surname);
        this.type = new SimpleStringProperty(type);
        this.VoucherID = new SimpleIntegerProperty(voucherID);
        this.Country = new SimpleStringProperty(country);
        this.City = new SimpleStringProperty(city);
        this.Hotel = new SimpleStringProperty(hotel);
        this.FirstDay = new SimpleStringProperty(firstDay);
        this.LastDay = new SimpleStringProperty(lastDay);
        this.Price = new SimpleDoubleProperty(price);
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

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public int getVoucherID() {
        return VoucherID.get();
    }

    public SimpleIntegerProperty voucherIDProperty() {
        return VoucherID;
    }

    public String getCountry() {
        return Country.get();
    }

    public SimpleStringProperty countryProperty() {
        return Country;
    }

    public String getCity() {
        return City.get();
    }

    public SimpleStringProperty cityProperty() {
        return City;
    }

    public String getHotel() {
        return Hotel.get();
    }

    public SimpleStringProperty hotelProperty() {
        return Hotel;
    }

    public String getFirstDay() {
        return FirstDay.get();
    }

    public SimpleStringProperty firstDayProperty() {
        return FirstDay;
    }

    public String getLastDay() {
        return LastDay.get();
    }

    public SimpleStringProperty lastDayProperty() {
        return LastDay;
    }

    public double getPrice() {
        return Price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return Price;
    }


}
