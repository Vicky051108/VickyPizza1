public class Main{
    public static void main(String[] args) {
        
        VickyPizza vickypizza = new vickypizza("Slice O Heaven", " Heaven Street", "heaven@email.com", "1234567890", "cheesePizza", "tomatoSause, cheese, dough", 89.00, "fries", "coke", 8, 97.00 );
        System.out.println("Taking Order");
        info.takeOrder(vickypizza.getStoreMenu(), vickypizza.getPizzaIngredients(), vickypizza.getPizzaPrice(), vickypizza.getSides(), vickypizza.getDrinks());
        System.out.println("Making Pizza");
        info.makePizza(vickypizza.getPizzaIngredients());
    }
}