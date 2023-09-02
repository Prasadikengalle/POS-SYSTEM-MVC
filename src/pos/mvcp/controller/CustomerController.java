/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvcp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pos.mvcp.db.DBConnection;
import pos.mvcp.model.CustomerModel;

/**
 *
 * @author Prasadi
 */
public class CustomerController {

    public String saveCustomer(CustomerModel customer) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();

        String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, customer.getCustId());
        preparedStatement.setString(2, customer.getCustTitle());
        preparedStatement.setString(3, customer.getCustName());
        preparedStatement.setString(4, customer.getDob());
        preparedStatement.setDouble(5, customer.getSalary());
        preparedStatement.setString(6, customer.getCustAddress());
        preparedStatement.setString(7, customer.getCity());
        preparedStatement.setString(8, customer.getProvince());
        preparedStatement.setString(9, customer.getZip());

        if (preparedStatement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "fail";
        }

    }

    public ArrayList<CustomerModel> getAllCustomers() throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String query = "SELECT * FROM Customer";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet rst = statement.executeQuery();

        ArrayList<CustomerModel> customerModels = new ArrayList<>();

        while (rst.next()) {
            CustomerModel cm = new CustomerModel(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9));

            customerModels.add(cm);
        }

        return customerModels;
    }

    public CustomerModel getCustomerModel(String custId) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String query = "SELECT * FROM Customer WHERE custID = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, custId);

        ResultSet rst = statement.executeQuery();

        while (rst.next()) {
            CustomerModel cm = new CustomerModel(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9));

            return cm;
        }
        return null;
    }

    public String updateCustomer(CustomerModel customer) throws ClassNotFoundException, SQLException {
        
        Connection   connection = DBConnection.getInstance().getConnection();
         
         
         String query = "UPDATE Customer SET  CustTitle=?, CustName=?, DOB=?, salary=?, CustAddress=?, City=?, Province=?, PostalCode=?  WHERE CustID=?"  ;
         
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           
           preparedStatement.setString(1, customer.getCustTitle());
           preparedStatement.setString(2, customer.getCustName());
           preparedStatement.setString(3, customer.getDob());
           preparedStatement.setDouble(4, customer.getSalary());
           preparedStatement.setString(5, customer.getCustAddress());
           preparedStatement.setString(6, customer.getCity());
           preparedStatement.setString(7, customer.getProvince());
           preparedStatement.setString(8, customer.getZip());
           preparedStatement.setString(9, customer.getCustId());
         
           if(preparedStatement.executeUpdate() > 0){
            return "Success";
           }else{
            return "Fail" ;
           }  
    }
}
