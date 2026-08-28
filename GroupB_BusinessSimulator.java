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