/**
 * Group B - Business Simulator
 * Business: Kampala Corner Cafe
 
 * OOP Group Project - Java Fundamentals
 
 * Contribution by Kimberly:
 * - Implemented calculateSubtotal(), which calculates an item's subtotal
 * and applies the correct discount rule for that item.
 */
public class calculateSubtotal {

    // Group B: Kampala Corner Cafe
    static String[] itemNames = {
        "Rice (plate)",
        "Chicken (piece)",
        "Chapati",
        "Soda"
    };

    static double[] prices = {
        3500.00,
        12000.00,
        1000.00,
        2500.00
    };

    /**
     * Calculates the discounted subtotal for one item.
     *
     * @param itemIndex index of the item in the arrays
     * @param quantity quantity purchased
     * @return subtotal after applying the item's discount, if eligible
     *
     * Group member contribution:
     * Kim - calculateSubtotal()
     */
    public static double calculateSubtotal(int itemIndex, int quantity) {
        double subtotal = prices[itemIndex] * quantity;

        // Apply the discount rule belonging to each Group B item.
        switch (itemIndex) {
            case 0: // Rice: 4 or more plates -> 5% off
                if (quantity >= 4) {
                    subtotal = subtotal * 0.95;
                }
                break;

            case 1: // Chicken: no discount
                break;

            case 2: // Chapati: 3 or more -> UGX 500 off
                if (quantity >= 3) {
                    subtotal = subtotal - 500.00;
                }
                break;

            case 3: // Soda: 6 or more -> 10% off
                if (quantity >= 6) {
                    subtotal = subtotal * 0.90;
                }
                break;

            default:
                throw new IllegalArgumentException("Invalid item index: " + itemIndex);
        }

        return subtotal;
    }

    /**
     * Checks whether an item received its discount.
     */
    public static boolean discountApplied(int itemIndex, int quantity) {
        switch (itemIndex) {
            case 0:
                return quantity >= 4;
            case 1:
                return false;
            case 2:
                return quantity >= 3;
            case 3:
                return quantity >= 6;
            default:
                throw new IllegalArgumentException("Invalid item index: " + itemIndex);
        }
    }

    /**
     * Displays the cafe's price list using a loop.
     */
    public static void displayPriceList() {
        System.out.println("==== KAMPALA CORNER CAFE ====");

        for (int i = 0; i < itemNames.length; i++) {
            System.out.printf("%d. %s UGX %.2f%n",
                    i + 1, itemNames[i], prices[i]);
        }
    }

    /**
     * Prints an itemised receipt using the calculated subtotals.
     */
    public static void printReceipt(int[] quantities) {
        double grandTotal = 0.0;

        System.out.println("\n==== RECEIPT ====");

        for (int i = 0; i < itemNames.length; i++) {
            double subtotal = calculateSubtotal(i, quantities[i]);
            grandTotal += subtotal;

            if (discountApplied(i, quantities[i])) {
                System.out.printf("%s x%d = UGX %.2f (discount applied)%n",
                        itemNames[i], quantities[i], subtotal);
            } else {
                System.out.printf("%s x%d = UGX %.2f (no discount)%n",
                        itemNames[i], quantities[i], subtotal);
            }
        }

        System.out.println("----------------------------------------------------");
        System.out.printf("TOTAL = UGX %.2f%n", grandTotal);
    }

    public static void main(String[] args) {

        // Quantities can be changed to test different customer purchases.
        int[] quantities = {
            3, // Rice
            2, // Chicken
            2, // Chapati
            6  // Soda
        };

        displayPriceList();
        printReceipt(quantities);
    }
}
