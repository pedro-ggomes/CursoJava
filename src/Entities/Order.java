package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;
    private List <OrderItem> item = new ArrayList<>();


    public void addItem(OrderItem items){
        item.add(items);
    }
    public void removeItem(OrderItem items){
        item.remove(items);
    }

    public Order(LocalDateTime now) {
    }

    public Order(LocalDateTime moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOid() {
        return item;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Double total(){
        double sum = 0;
        for (OrderItem i:item){
            sum+=i.subTotal();
        }
        return sum;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment:");
        sb.append(moment.format(fmt1) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items:\n");
        for (OrderItem items : item) {
            sb.append(items + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
