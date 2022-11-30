package com.example.cursach.DataBaseActions;

public class QueryConst {
    public static String insertValue = "INSERT INTO vouchers(\n" +
            "VoucherType,OwnName, OwnSurname, Country, City,Hotel,DayIn,DayOut,PricePerDay) Values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";

    public static String selectAllValues = "SELECT * FROM vouchers";
    public static String selectAllClients = "SELECT * FROM clients";

    public static String selectTodeleteV = "Delete from vouchers where VoucherID = ? ";
    public static String selectTodeleteC = "Delete from clients where ClientID = ? ";

    public static String VSelectID = "SELECT * FROM vouchers where ";
    public static String CSelectID = "SELECT * FROM clients where ";

    public static String ChooseMax = "Select * From vouchers where PricePerDay = (Select Max(PricePerDay) From vouchers)";
    public static String ChooseMin = "Select * From vouchers where PricePerDay = (Select Min(PricePerDay) From vouchers)";
    public static String ChooseDiapazon = "Select * From vouchers where ";
    public static String AddNewClient = "INSERT INTO clients (FirstName, LastName) Values(?, ?)";
}
