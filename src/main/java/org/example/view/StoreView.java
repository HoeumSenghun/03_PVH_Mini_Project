package org.example.view;

import org.example.controller.Controller;

import java.sql.SQLException;

public class StoreView {
    public void displayProduct() throws SQLException {
        Controller controller = new Controller();
        controller.productTable();
    };
}
