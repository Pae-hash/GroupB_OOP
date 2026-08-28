public class GroupB_BusinessSimulator {

    // Generic subtotal calculator: supports either a percentage discount
    // or a flat UGX amount off, once a quantity threshold is reached.
    public static double calculateSubtotal(double price, int quantity,
                                            int threshold, double discountValue,
                                            boolean isPercentage) {
        double subtotal = price * quantity;

        if (quantity >= threshold) {
            if (isPercentage) {
                subtotal = subtotal - (subtotal * discountValue);
            } else {
                subtotal = subtotal - discountValue;
            }
        }

        return subtotal;
    }
    
    // This method creates the discount explanation that will be displayed next to each item on the receipt.
    public static String buildNote(int quantity, int threshold, boolean neverDiscounted,
                                    boolean isPercentage, double discountValue) {
        if (neverDiscounted) {
            return "no discount \u2014 never discounted";
        }
        if (quantity >= threshold) {
            if (isPercentage) {
                return (int) Math.round(discountValue * 100) + "% discount applied";
            } else {
                return "UGX " + String.format("%.0f", discountValue) + " off applied";
            }
        } else {
            return "no discount \u2014 fewer than " + threshold;
        }
    }
// Store the four products sold by Kampala Corner Cafe in an array.
// Method to print the receipt in the required KABS-style format
    public static void printReceipt(String[] items, int[] quantities,
                                     double[] subtotals, String[] notes) {

        System.out.println("\n==== RECEIPT ====");

        double grandTotal = 0;

        for (int i = 0; i < items.length; i++) {
            System.out.printf(
                "%-16s x%-3d = UGX %-10.2f (%s)%n",
                items[i],
                quantities[i],
                subtotals[i],
                notes[i]
            );
            grandTotal += subtotals[i];
        }

        System.out.println("--------------------------------------------------");
        System.out.printf("TOTAL            = UGX %.2f%n", grandTotal);
    }

    public static void main(String[] args) {

        // --------------------------------
        // 1. STORE ITEMS AND PRICES  (Group B - Kampala Corner Cafe)
        // --------------------------------

        String[] items = {
            "Rice (plate)",
            "Chicken (piece)",
            "Chapati",
            "Soda"
        };

        double[] prices = {
            3500.00,
            12000.00,
            1000.00,
            2500.00
        };
