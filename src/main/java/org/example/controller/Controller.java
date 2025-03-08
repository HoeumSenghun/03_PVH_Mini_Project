package org.example.controller;

import org.example.model.Product;
import org.example.utils.utils;
import org.example.view.StoreView;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {
    private Product product;
    private StoreView storeView;

    public void productTable() throws SQLException{
        Statement stm = utils.connection().createStatement();
        String qry = "SELECT * FROM stock_tb";
        ResultSet resultSet = stm.executeQuery(qry);
        CellStyle numberStyle = new CellStyle(CellStyle.HorizontalAlign.CENTER);
        Table t = new Table(5, BorderStyle.UNICODE_ROUND_BOX_WIDE, ShownBorders.ALL);
        t.setColumnWidth(0, 8, 20);
        t.setColumnWidth(1, 7, 10);
        t.setColumnWidth(2, 9, 16);
        t.setColumnWidth(3, 9, 16);
        t.setColumnWidth(4, 9, 16);


        t.addCell("ID",numberStyle);
        t.addCell("NAME", numberStyle);
        t.addCell("UNIT PRICE", numberStyle);
        t.addCell("QUANTITY", numberStyle);
        t.addCell("IMPORT DATE", numberStyle);
        while (resultSet.next()){
            t.addCell(String.valueOf(resultSet.getInt("id")),numberStyle);
            t.addCell(resultSet.getString("name"),numberStyle);
            t.addCell(String.valueOf(resultSet.getDouble("unit_price")),numberStyle);
            t.addCell(String.valueOf(resultSet.getInt("stock_qty")),numberStyle);
            t.addCell(String.valueOf(resultSet.getDate("imported_date")),numberStyle);
        }
        System.out.println(t.render());
    }
    public void readProduct()  {

    }
    public void writeProduct(){
        // write product
    }
    public void saveProduct(){
        //save product to database
    }
    public void unSaveProduct(){
        //
    }
    public void getProduct(){
        //get product from database
    }
    public void updateProduct(){
        // update pro
    }
    public void searchProduct(){
        //search logic
    }
    public void  deleteProduct(){
        // delete logic
    }
    /// =========== backup and restore
    public void backUp(){
        // back up logic
    }
    public void restore(){
        //restore logic
    }
}
