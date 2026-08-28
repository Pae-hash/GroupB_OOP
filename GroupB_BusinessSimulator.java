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
