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
import pos.mvcp.model.ItemModel;

/**
 *
 * @author Prasadi
 */
public class ItemController {

    public ArrayList<ItemModel> getAllItems() throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();

        String query = "SELECT * FROM Item";

        PreparedStatement statement = connection.prepareStatement(query);

        ResultSet rst = statement.executeQuery();

        ArrayList<ItemModel> itemModels = new ArrayList<>();

        while (rst.next()) {
            ItemModel item = new ItemModel(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getInt(5));

            itemModels.add(item);
        }

        return itemModels;
    }

    public String saveItem(ItemModel itemModel) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String query = "INSERT INTO Item VALUES(?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, itemModel.getItemCode());
        preparedStatement.setString(2, itemModel.getDescription());
        preparedStatement.setString(3, itemModel.getPackSize());
        preparedStatement.setDouble(4, itemModel.getUnitPrice());
        preparedStatement.setInt(5, itemModel.getQoh());

        if (preparedStatement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "fail";
        }
    }

    public ItemModel searchItem(String itemCode) throws ClassNotFoundException, SQLException {

        Connection connection = DBConnection.getInstance().getConnection();

        String query = "SELECT * FROM Item WHERE ItemCode = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, itemCode);

        ResultSet rst = statement.executeQuery();

        while (rst.next()) {
            ItemModel item = new ItemModel(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getInt(5));

            return item;
        }
        return null;
    }

}
