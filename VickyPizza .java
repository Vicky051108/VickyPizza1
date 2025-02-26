public class VickyPizza {
    private String storeName;
    private String storeAddress;
    private String storeEmail;
    private String storePhone;
    private String storeMenu;
    private String pizzaIngredients;
    private double pizzaPrice;
    private String sides;
    private String drinks;
    private int orderID;
    private double oederTotal;

    public VickyPizza(String name, String address, String email, String phone, String menu, String ingredients, double price, String side, String drink, int orderID, double orderTotal) {
        this.storeName = name;
        this.storeAddress = address;
        this.storeEmail = email;
        this.storePhone = phone;
        this.storeMenu = menu;
        this.pizzaIngredients = ingredients;
        this.pizzaPrice = price;
        this.sides = side;
        this.drinks = drink;
        this.orderID = orderID;
        this.oederTotal = orderTotal;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    public String getStorePhone() {
        return storePhone;
    }

    public String getStoreMenu() {
        return storeMenu;
    }

    public String getPizzaIngredients() {
        return pizzaIngredients;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public String getSides() {
        return sides;
    }

    public String getDrinks() {
        return drinks;
    }

    public int getOrderID() {
        return orderID;
    }

    public double getOederTotal() {
        return oederTotal;
    }

    public void takeOrder(String storeMenu, String pizzaIngredients, double pizzaPrice, String sides, String drinks) {
        System.out.println("Order taken for " + storeMenu);
        System.out.println("Pizza Ingredients: " + pizzaIngredients);
        System.out.println("Pizza Price: " + pizzaPrice);
        System.out.println("Sides: " + sides);
        System.out.println("Drinks: " + drinks);
        getStoreName();
        getStoreAddress();
        getStoreEmail();
        getStorePhone();
        getOrderID();
        getOederTotal();
        printReceipt(storeName, storeAddress, storePhone, storeEmail, orderID, oederTotal);
    }
    
    public void makePizza(String pizzaIngredients) {
        System.out.println("Making pizza with " + pizzaIngredients);
    }

    private void printReceipt(String storeName, String storeAddress, String storePhone, String storeEmail, int orderID, double orderTotal) {
        System.out.println("********RECEIPT********");
        System.out.println("Store Name: " + storeName);
        System.out.println("Store Address: " + storeAddress);
        System.out.println("Store Phone: " + storePhone);
        System.out.println("Store Email: " + storeEmail);
        System.out.println("Order ID: " + orderID);
        System.out.println("Order Total: " + orderTotal);
    }
    
}