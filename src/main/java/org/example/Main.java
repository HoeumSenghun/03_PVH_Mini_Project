package org.example;

import org.example.controller.Controller;
import org.example.view.StoreView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StoreView view = new StoreView();
        view.displayProduct();
    }
}