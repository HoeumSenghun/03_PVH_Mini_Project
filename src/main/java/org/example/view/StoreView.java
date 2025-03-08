package org.example.view;

import org.example.model.Product;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.BorderStyle;

import java.util.List;
import java.util.Scanner;

public class StoreView {
    private Scanner scanner = new Scanner(System.in);

    public void displayProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products available!");
            return;
        }

        // Define table with 5 columns
        Table table = new Table(5, BorderStyle.UNICODE_BOX_DOUBLE_BORDER);
        table.addCell("ID", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Name", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Unit Price ($)", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Quantity", new CellStyle(CellStyle.HorizontalAlign.CENTER));
        table.addCell("Import Date", new CellStyle(CellStyle.HorizontalAlign.CENTER));

        // Add products to table
        for (Product p : products) {
            table.addCell(String.valueOf(p.getId()));
            table.addCell(p.getName());
            table.addCell(String.format("%.2f", p.getUnitPrice()));
            table.addCell(String.valueOf(p.getQuantity()));
            table.addCell(p.getImportDate());
        }

        // Print table
        System.out.println(table.render());
    }

    public void displayMenu() {
        System.out.println("            --------- Menu ---------            ");
        System.out.println(" N) Next Page   P) Previous Page   F) First Page   L) Last Page");
        System.out.println(" W) Write       R) Read (id)        U) Update      D) Delete");
        System.out.println(" S) Search(name)   Se) Set rows   Ba) Backup   Re) Restore");
        System.out.println(" E) Exit");
        System.out.println("-----------------------------------------------");
    }

    public String getUserChoice() {
        System.out.print("=> Choose an option: ");
        return scanner.nextLine().trim().toUpperCase();
    }
}
