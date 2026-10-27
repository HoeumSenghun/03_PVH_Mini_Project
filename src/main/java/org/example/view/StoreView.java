package org.example.view;
import java.util.*;
import org.example.model.Product;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.BorderStyle;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class StoreView {
    private Scanner scanner = new Scanner(System.in);
    CellStyle center = new CellStyle(CellStyle.HorizontalAlign.CENTER);
    final String red = "\u001b[31m";
    final String green = "\u001b[32m";
    final String yellow = "\u001b[33m";
    final String reset = "\u001b[0m";
    final String blue = "\u001B[34m";
    CellStyle cellStyle = new CellStyle(CellStyle.HorizontalAlign.CENTER);

    public void displayProducts(List<Product> products) {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 30, 30);
        table.setColumnWidth(1, 30, 30);
        table.setColumnWidth(2, 30, 30);
        table.setColumnWidth(3, 30, 30);
        table.setColumnWidth(4, 30, 30);

        table.addCell(red + "ID", cellStyle);
        table.addCell(red + "Name" , cellStyle);
        table.addCell(red + "Unit Price ($)", cellStyle);
        table.addCell(red + "Quantity", cellStyle);
        table.addCell(red + "Import Date" + reset , cellStyle);

        //Loop Product
        products.stream().forEach(pro -> {
            table.addCell(yellow + pro.getId(),center );
            table.addCell(green + pro.getName(),center);
            table.addCell(green + pro.getPrice(),center );
            table.addCell(green + pro.getQuantity(),center );
            table.addCell(green + pro.getImportDate(),center );
        });

        // Print table
        System.out.println(table.render());
    }

    public void displayMenu() {
        Table table = new Table(1, BorderStyle.UNICODE_BOX_WIDE, ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        table.setColumnWidth(0, 100, 130);
        System.out.println("\n");
        table.addCell(blue + "--------- Menu ---------", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell(green + " N) Next Page        P) Previous Page            F) First Page     L) Last Page", new CellStyle(CellStyle.HorizontalAlign.LEFT));
        table.addCell(yellow + " W) Write            R) Read (id)                U) Update         D) Delete", new CellStyle(CellStyle.HorizontalAlign.LEFT));
        table.addCell(" S) Search(name)     Se) Set rows  sa) Save      Un) UnSaved       Ba) Backup      Re) Restore", new CellStyle(CellStyle.HorizontalAlign.LEFT));
        table.addCell(red + " E) Exit" + reset, new CellStyle(CellStyle.HorizontalAlign.LEFT));

        System.out.println(table.render());

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("-----------------------------------------------");
    }

    public String getUserChoice() {
        System.out.print("=> Choose an option: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public void searchProductByName(List<Product> products){
        // Table header
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 30, 30);
        table.setColumnWidth(1, 30, 30);
        table.setColumnWidth(2, 30, 30);
        table.setColumnWidth(3, 30, 30);
        table.setColumnWidth(4, 30, 30);
        table.addCell("ID", cellStyle);
        table.addCell("Name", cellStyle);
        table.addCell("Unit Price ($)", cellStyle);
        table.addCell("Quantity", cellStyle);
        table.addCell("Import Date", cellStyle);


        //Loop Product
        products.stream().forEach(pro -> {
            table.addCell(String.valueOf(pro.getId()),center );
            table.addCell(pro.getName(),center);
            table.addCell(String.valueOf(pro.getPrice()),center );
            table.addCell(String.valueOf(pro.getQuantity()),center );
            table.addCell(String.valueOf(pro.getImportDate()),center );

        });
        System.out.println(table.render());
    }

    public void displayTableRow(Optional<Product> product) {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.setColumnWidth(0, 30, 30);
        table.setColumnWidth(1, 30, 30);
        table.setColumnWidth(2, 30, 30);
        table.setColumnWidth(3, 30, 30);
        table.setColumnWidth(4, 30, 30);
        table.addCell("ID", cellStyle);
        table.addCell("Name", cellStyle);
        table.addCell("Unit Price ($)", cellStyle);
        table.addCell("Quantity", cellStyle);
        table.addCell("Import Date", cellStyle);

        table.addCell(String.valueOf(product.get().getId()),center );
        table.addCell(String.valueOf(product.get().getName()),center );
        table.addCell(String.valueOf(product.get().getPrice()),center );
        table.addCell(String.valueOf(product.get().getQuantity()),center );
        table.addCell(String.valueOf(product.get().getImportDate()),center );

        System.out.println(table.render());
    }
}
