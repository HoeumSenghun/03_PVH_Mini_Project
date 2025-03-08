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
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER, ShownBorders.ALL);
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Unit Price ($)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Quantity", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Import Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        //Loop Product
        products.stream().forEach(pro -> {
            table.addCell(String.valueOf(pro.getId()),center );
            table.addCell(pro.getName(),center);
            table.addCell(String.valueOf(pro.getPrice()),center );
            table.addCell(String.valueOf(pro.getQuantity()),center );
            table.addCell(String.valueOf(pro.getImportDate()),center );
        });

        // Print table
        System.out.println(table.render());
    }

    public void displayMenu() {
        System.out.println("            --------- Menu ---------            ");
        System.out.println(" N) Next Page   P) Previous Page   F) First Page   L) Last Page");
        System.out.println(" W) Write       R) Read (id)        U) Update      D) Delete   S) Search(name)");
        System.out.println(" Sa) Save    Un) Unsaved   Se) Set rows   Ba) Backup   Re) Restore");
        System.out.println(" E) Exit");
        System.out.println("-----------------------------------------------");
    }

    public String getUserChoice() {
        System.out.print("=> Choose an option: ");
        return scanner.nextLine().trim().toUpperCase();
    }
}
