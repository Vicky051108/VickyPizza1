

public class Main {
    public static void main(String[] args) {
        VickyPizza order = new VickyPizza();
        order.takeOrder();
        order.isItYourBirthday();
        order.makeCardPayment();
        order.processCardPayment();
        System.out.println(order);
    }

}
