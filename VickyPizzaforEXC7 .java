import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VickyPizza {
    private static final String BLACKLISTED_NUMBER = "12345678901234";
    private String ing1, ing2, ing3;
    private String pizzaSize;
    private String extraCheese;
    private String sideDish;
    private String drinks;
    private boolean halfPay;
    private LocalDate birthday;
    private String cardNumber;
    private LocalDate cardExpiry;

public void takeOrder() {
    try(Scanner scanner = new Scanner(System.in)) {
        boolean validIngredients = false;
        while (!validIngredients) {
            System.out.println("Please pick any three of the following ingredients:");
            System.out.println("1. Mushroom");
            System.out.println("2. Paprika");
            System.out.println("3. Sun - dried tomatoes");
            System.out.println("4. Chicken");
            System.out.println("5. Pineapple");
            System.out.print("Enter any three choices (1, 2, 3,…) separated by spaces:");
            int ingChoice1 = scanner.nextInt();
            int ingChoice2 = scanner.nextInt();
            int ingChoice3 = scanner.nextInt();

            if (isValidIngredientChoice(ingChoice1) && isValidIngredientChoice(ingChoice2) && isValidIngredientChoice(ingChoice3)) {
                ing1 = getIngredientName(ingChoice1);
                ing2 = getIngredientName(ingChoice2);
                ing3 = getIngredientName(ingChoice3);
                validIngredients = true;
                } else {
                    System.out.println("Invalid choice(s). Please pick only from the given list:");
                }
            }

        boolean validSize = false;
        while (!validSize) {
            System.out.println("What size should your pizza be?");
            System.out.println("1. Large");
            System.out.println("2. Medium");
            System.out.println("3. Small");
            System.out.print("Enter only one choice (1, 2, or 3):");
            int sizeChoice = scanner.nextInt();
            if (sizeChoice >= 1 && sizeChoice <= 3) {
                    pizzaSize = getPizzaSizeName(sizeChoice);
                    validSize = true;
            } else {
                    System.out.println("Invalid choice. Please pick from the given list.");
            }
            }

            System.out.print("Do you want extra cheese (Y/N):");
            extraCheese = scanner.next();
        boolean validSideDish = false;
            while (!validSideDish) {
                System.out.println("Following are the side dish that go well with your pizza:");
                System.out.println("1. Calzone");
                System.out.println("2. Garlic bread");
                System.out.println("3. Chicken puff");
                System.out.println("4. Muffin");
                System.out.println("5. Nothing for me");
                System.out.print("What would you like? Pick one (1, 2, 3,…):");
                int sideDishChoice = scanner.nextInt();
                if (sideDishChoice >= 1 && sideDishChoice <= 5) {
                    sideDish = getSideDishName(sideDishChoice);
                    validSideDish = true;
                } else {
                    System.out.println("Invalid choice. Please pick from the given list.");
                }
            }

            boolean validDrink = false;
            while (!validDrink) {
                System.out.println("Choose from one of the drinks below. We recommend Coca Cola:");
                System.out.println("1. Coca Cola");
                System.out.println("2. Cold coffee");
                System.out.println("3. Cocoa Drink");
                System.out.println("4. No drinks for me");
                System.out.print("Enter your choice:");
                int drinkChoice = scanner.nextInt();
                if (drinkChoice >= 1 && drinkChoice <= 4) {
                    drinks = getDrinkName(drinkChoice);
                    validDrink = true;
                } else {
                    System.out.println("Invalid choice. Please pick from the given list.");
                }
            }

            System.out.print("Would you like the chance to pay only half for your order? (Y/N):");
            String halfPayInput = scanner.next();
            halfPay = halfPayInput.equalsIgnoreCase("Y");
    }
    }

    private boolean isValidIngredientChoice(int choice) {
        return choice >= 1 && choice <= 5;
    }

    private String getIngredientName(int choice) {
        switch (choice) {
            case 1:
                return "Mushroom";
            case 2:
                return "Paprika";
            case 3:
                return "Sun - dried tomatoes";
            case 4:
                return "Chicken";
            case 5:
                return "Pineapple";
            default:
                return "";
        }
    }

    private String getPizzaSizeName(int choice) {
        switch (choice) {
            case 1:
                return "Large";
            case 2:
                return "Medium";
            case 3:
                return "Small";
            default:
                return "";
        }
    }

    private String getSideDishName(int choice) {
        switch (choice) {
            case 1:
                return "Calzone";
            case 2:
                return "Garlic bread";
            case 3:
                return "Chicken puff";
            case 4:
                return "Muffin";
            case 5:
                return "Nothing for me";
            default:
                return "";
        }
    }

    private String getDrinkName(int choice) {
        switch (choice) {
            case 1:
                return "Coca Cola";
            case 2:
                return "Cold coffee";
            case 3:
                return "Cocoa Drink";
            case 4:
                return "No drinks for me";
            default:
                return "";
        }
    }

    public void isItYourBirthday() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean validDate = false;
            while (!validDate) {
                System.out.print("Is it your birthday today? (Y/N): ");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.print("Please enter your birth date (yyyy - MM - dd): ");
                    String dateStr = scanner.next();
                    try {
                        birthday = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
                        LocalDate fiveYearsAgo = LocalDate.now().minusYears(5);
                        LocalDate oneHundredTwentyYearsAgo = LocalDate.now().minusYears(120);
                        if (birthday.isAfter(fiveYearsAgo) || birthday.isBefore(oneHundredTwentyYearsAgo)) {
                            System.out.println("Invalid date. You are either too young or too dead to order.");
                            System.out.println("Please enter a valid date:");
                        } else {
                            validDate = true;
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Invalid date format. Please use yyyy - MM - dd.");
                    }
                } else if (answer.equalsIgnoreCase("N")) {
                    birthday = null;
                    validDate = true;
                } else {
                    System.out.println("Invalid answer. Please enter Y or N.");
                }
            }
        }
    }

    public void makeCardPayment() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean validExpiry = false;
            while (!validExpiry) {
                System.out.print("Enter your card's expiry date (yyyy - MM - dd): ");
                String expiryStr = scanner.next();
                try {
                    cardExpiry = LocalDate.parse(expiryStr, DateTimeFormatter.ISO_LOCAL_DATE);
                    if (cardExpiry.isBefore(LocalDate.now())) {
                        System.out.println("Invalid expiry date. Please enter a future date.");
                    } else {
                        validExpiry = true;
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Invalid date format. Please use yyyy - MM - dd.");
                }
            }
        }
    }

    public void processCardPayment() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean validCardNumber = false;
            while (!validCardNumber) {
                System.out.print("Enter your 14 - digit card number: ");
                cardNumber = scanner.next();
                if (cardNumber.length() == 14 &&!cardNumber.equals(BLACKLISTED_NUMBER)) {
                    validCardNumber = true;
                } else {
                    System.out.println("Invalid card number. Please enter a 14 - digit number that is not blacklisted.");
                }
            }
        }
    }

    public String specialOfTheDay() {
        return "Today's special is a Large pizza with Mushroom and Chicken for $15.";
    }

    
    public String toString() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("Pizza Ingredients: ").append(ing1).append(", ").append(ing2).append(", ").append(ing3).append("\n");
        receipt.append("Pizza Size: ").append(pizzaSize).append("\n");
        receipt.append("Extra Cheese: ").append(extraCheese).append("\n");
        receipt.append("Side Dish: ").append(sideDish).append("\n");
        receipt.append("Drink: ").append(drinks).append("\n");
        receipt.append("Half Pay: ").append(halfPay).append("\n");
        receipt.append("Birthday: ").append(birthday == null? "No" : birthday).append("\n");
        receipt.append("Card Number: ").append(cardNumber).append("\n");
        receipt.append("Card Expiry: ").append(cardExpiry).append("\n");
        return receipt.toString();
    }

   
}
