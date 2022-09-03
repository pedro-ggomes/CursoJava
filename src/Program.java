import Entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        //Leitura de informações do cliente
        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email:");
        String email = sc.nextLine();
        System.out.print("Birthdate (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(),fmt1);
        Client client = new Client(name,email,birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status:");
        String status = sc.nextLine();
        System.out.print("How many items for this order?");
        int n = sc.nextInt();

        Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client);

        for (int i=1; i<=n; i++){
            System.out.println("Enter #" + i + " item data:" );
            sc.nextLine();
            System.out.print("Product name:");
            String pname = sc.nextLine();
            System.out.print("Product price:");
            double price = sc.nextDouble();
            Product product = new Product(pname,price);
            System.out.print("Quantity:");
            int quantity = sc.nextInt();
            OrderItem item = new OrderItem(quantity,price,product);
            order.addItem(item);
        }
        System.out.println();
        System.out.println("ORDER SUMMARY:");
        System.out.print(order);








        sc.close();
    }
}
