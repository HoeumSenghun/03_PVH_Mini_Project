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

    public void displayProducts(List<Product> products) {
        Table table = new Table(5, BorderStyle.UNICODE_BOX, ShownBorders.ALL);
        table.setColumnWidth(0,15,15);
        table.setColumnWidth(1,15,15);
        table.setColumnWidth(2,15,15);
        table.setColumnWidth(3,15,15);
        table.setColumnWidth(4,15,15);
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Unit Price ($)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Quantity", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Import Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        //Loop Product
        products.stream().forEach(pro -> {
            table.addCell(String.valueOf(pro.getId()),center );
            table.addCell(pro.getName(),center);
            table.addCell(String.valueOf(pro.getPrice())+"$",center );
            table.addCell(String.valueOf(pro.getQuantity()),center );
            table.addCell(String.valueOf(pro.getImportDate()),center );
        });

        // Print table
        System.out.println(table.render());
    }

    public void displayMenu() {
        System.out.println("            --------- Menu ---------            ");
        System.out.println(" N) Next Page   P) Previous Page   F) First Page   L) Last Page");
        System.out.println(" W) Write       R) Read (id)        U) Update      D) Delete");
        System.out.println(" S) Search(name)   Se) Set rows  sa) Save    Un) UnSaved  Ba) Backup   Re) Restore");
        System.out.println(" E) Exit");
        System.out.println("-----------------------------------------------");
    }

    public String getUserChoice() {
        System.out.print("=> Choose an option: ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public void searchProductByName(List<Product> products){
        // Table header
        Table table = new Table(5, BorderStyle.UNICODE_BOX, ShownBorders.SURROUND_HEADER_FOOTER_AND_COLUMNS);
        table.setColumnWidth(0,15,15);
        table.setColumnWidth(1,15,15);
        table.setColumnWidth(2,15,15);
        table.setColumnWidth(3,15,15);
        table.setColumnWidth(4,15,15);
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Unit Price ($)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Quantity", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Import Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        //Loop Product
        products.stream().forEach(pro -> {
            table.addCell(String.valueOf(pro.getId()),center );
            table.addCell(pro.getName(),center);
            table.addCell(String.valueOf(pro.getPrice())+"$",center );
            table.addCell(String.valueOf(pro.getQuantity()),center );
            table.addCell(String.valueOf(pro.getImportDate()),center );

        });
        System.out.println(table.render());
    }

    public void displayTableRow(Optional<Product> product) {
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Unit Price ($)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Quantity", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Import Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        table.addCell(String.valueOf(product.get().getId()),center );
        table.addCell(String.valueOf(product.get().getName()),center );
        table.addCell(String.valueOf(product.get().getPrice())+"$",center );
        table.addCell(String.valueOf(product.get().getQuantity()),center );
        table.addCell(String.valueOf(product.get().getImportDate()),center );

        System.out.println(table.render());
    }
}
