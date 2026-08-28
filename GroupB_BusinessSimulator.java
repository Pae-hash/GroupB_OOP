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
// --------------------------------
        // 2. DISPLAY PRICE LIST
        // --------------------------------

        System.out.println("==== KAMPALA CORNER CAFE ====");

        for (int i = 0; i < items.length; i++) {
            System.out.printf(
                "%d. %-16s UGX %.2f%n",
                i + 1,
                items[i],
                prices[i]
            );
        }

        // --------------------------------
        // 3. QUANTITIES PURCHASED  ("check yourself" example: total = UGX 50,000.00)
        // --------------------------------

        int[] quantities = {
            3,   // Rice (plate)
            2,   // Chicken (piece)
            2,   // Chapati
            6    // Soda
        };

        // --------------------------------
        // DISCOUNT RULES (per item, since each rule is different)
        // threshold        : minimum quantity for the discount to kick in
        // discountValue    : 0.05 = 5%, 500.0 = flat UGX 500, etc.
        // isPercentage     : true = % off the item's total, false = flat UGX off
        // neverDiscounted  : true overrides everything else (Chicken)
        // --------------------------------

        int[] thresholds = {
            4,                  // Rice: 4+ plates
            Integer.MAX_VALUE,  // Chicken: unreachable threshold, never discounted
            3,                  // Chapati: 3+
            6                   // Soda: 6+
        };

        double[] discountValues = {
            0.05,   // Rice: 5% off rice total
            0.0,    // Chicken: n/a
            500.0,  // Chapati: flat UGX 500 off chapati total
            0.10    // Soda: 10% off soda total
        };

        boolean[] isPercentage = {
            true,   // Rice
            false,  // Chicken (unused)
            false,  // Chapati (flat amount)
            true    // Soda
        };

        boolean[] neverDiscounted = {
            false,  // Rice
            true,   // Chicken
            false,  // Chapati
            false   // Soda
        };
     // --------------------------------
        // 4. CALCULATE SUBTOTALS + NOTES
        // --------------------------------

        double[] subtotals = new double[items.length];
        String[] notes = new String[items.length];

        for (int i = 0; i < items.length; i++) {

            subtotals[i] = calculateSubtotal(
                prices[i],
                quantities[i],
                thresholds[i],
                discountValues[i],
                isPercentage[i]
            );

            notes[i] = buildNote(
                quantities[i],
                thresholds[i],
                neverDiscounted[i],
                isPercentage[i],
                discountValues[i]
            );
        }

        // --------------------------------
        // 5 & 6. PRINT RECEIPT
        // --------------------------------

        printReceipt(
            items,
            quantities,
            subtotals,
            notes
        );
    }
}