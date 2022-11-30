package com.example.cursach.DataBaseActions;
import com.example.cursach.Voucher.Client;
import com.example.cursach.Voucher.Voucher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ManagerDB {
   private static ManagerDB instance;
  private static Connection connection = null;
  private static String URL = "jdbc:mysql://localhost:3306/forcourse";
  private static String USERNAME = "root";
  private static String PASSWORD = "26Natural2Xz";

    private ManagerDB()
    {
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException exp) {
            exp.printStackTrace();
            throw new RuntimeException(exp);
        }
    }

    public static ManagerDB getInstance() {
        if(instance==null)
            instance = new ManagerDB();
        return instance;
    }



    public void InserValues(String type,String Name,String Surname,String Country,String City, String Hotel, String DayIn, String DayOut,Double Price)
    {
        try {
            PreparedStatement ps = connection.prepareStatement(QueryConst.insertValue);
            ps.setString(1,type);
            ps.setString(2,Name);
            ps.setString(3,Surname);
            ps.setString(4,Country);
            ps.setString(5,City);
            ps.setString(6,Hotel);
            ps.setString(7,DayIn);
            ps.setString(8,DayOut);
            ps.setDouble(9, Double.parseDouble(String.valueOf(Price)));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void InsertClients(String Name, String Surname){
        try {
            PreparedStatement ps = connection.prepareStatement(QueryConst.AddNewClient);
            ps.setString(1,Name);
            ps.setString(2,Surname);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Voucher> GetDataVouchers(String query){
        List<Voucher> arr = new ArrayList<>();
        try{
            Statement statement =connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                arr.add(new Voucher(rs.getString("OwnName"),
                        rs.getString("OwnSurname"),
                        rs.getString("VoucherType"),rs.getInt("VoucherID"),
                        rs.getString("Country"),rs.getString("City"),
                        rs.getString("Hotel"),rs.getString("DayIn"),
                        rs.getString("DayOut"),rs.getDouble("PricePerDay")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  arr;
    }

    public List<Client> GetDataClients(String query){
        List<Client> arr = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                arr.add(new Client(rs.getInt("ClientID"),
                        rs.getString("FirstName"),
                        rs.getString("Lastname")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arr;
    }

    public void DeleteVoucher(int ID) {
        try {
            PreparedStatement ps = connection.prepareStatement(QueryConst.selectTodeleteV);
            ps.setInt(1,ID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void DeleteClient(int ID){
        try {
            PreparedStatement ps = connection.prepareStatement(QueryConst.selectTodeleteC);
            ps.setInt(1,ID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void close()
    {
        try {
            if(!connection.isClosed())
                connection.close();
        } catch (SQLException exp) {
            throw new RuntimeException(exp);
        }
    }

}
