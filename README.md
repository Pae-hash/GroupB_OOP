# Group B - Business Simulator

## Business
**Kampala Corner Cafe**

This project is the Group B Java Fundamentals/OOP group project. It implements a small till system for a business selling four items with different discount rules.

The program follows the project brief requirements:
- Store item names and prices in arrays.
- Display the price list using a loop.
- Store customer quantities in variables/an array.
- Calculate each item's subtotal.
- Apply the correct discount when the quantity qualifies.
- Add the discounted subtotals to produce a grand total.
- Print an itemised receipt.
- Use custom methods with parameters and return values.

## Group B Prices

| Item | Price (UGX) | Discount Rule |
|---|---:|---|
| Rice (plate) | 3,500.00 | 4 or more → 5% off |
| Chicken (piece) | 12,000.00 | No discount |
| Chapati | 1,000.00 | 3 or more → UGX 500 off |
| Soda | 2,500.00 | 6 or more → 10% off |

## Subtotal and Discounts

### `calculateSubtotal()`

This method:
1. Receives the item index and quantity.
2. Calculates the original subtotal using:
   `price × quantity`
3. Checks the discount rule for that item.
4. Applies the discount when the quantity qualifies.
5. Returns the final subtotal after discount.

The method is deliberately kept as a separate contribution so it can be clearly identified in the GitHub commit history.

### Contribution commit

When submitting a contribution to GitHub, you should make a dedicated commit such as:

`Implement calculateSubtotal for Group B discount rules`

This makes the contribution visible in the repository's commit history.

## Other Methods

- `displayPriceList()` - displays the four products using a loop.
- `calculateSubtotal()` - calculates and discounts each item's subtotal.
- `discountApplied()` - determines whether the item's discount condition was met.
- `printReceipt()` - builds the itemised receipt and grand total.
- `main()` - provides test quantities and runs the program.

## Test Case

The project brief gives this Group B check:

- 3 × Rice
- 2 × Chicken
- 2 × Chapati
- 6 × Soda

Expected total:

**UGX 50,000.00**

The program can be tested with these quantities by running the Java file.

## Running the Program in VS Code

1. Open this folder in VS Code.
2. Make sure a Java JDK is installed.
3. Open `GroupB_BusinessSimulator.java`.
4. Run the file using VS Code's **Run** button, or run it from the terminal:

```bash
javac GroupB_BusinessSimulator.java
java GroupB_BusinessSimulator
```

## GitHub Contribution

To make the lecturer's GitHub view clearly show your contribution, you should commit the work yourself rather than having another group member commit it on your behalf.

Example:

```bash
git add GroupB_BusinessSimulator.java README.md
git commit -m "Implement calculateSubtotal for Group B discount rules"
git push
```

The commit should be made using your own GitHub account configured in Git so that the commit is attributed to you.
