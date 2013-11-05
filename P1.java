/** 
 * Assignment 1					P1.java					Due August 10, 2013
 * login #: cs11vau 
 **/

import java.util.*; // Scanner for input
import java.text.*;

public class P1 {
  public static void main(String[] args) {
    final double SALES_5K = 5000.00; // $5k sales
    final double SALES_10K = 10000.00; // first $10k sales
    final double PCT_8 = 0.08; // $0.01-$k sales 8% commission
    final double PCT_10 = 0.1; // $5000.01 - $10k 10% commission
    final double PCT_12 = 0.12; // $10000.01+ 12% commission
    final double INIT_AMT = 0.00; // Zero sales initially
    char choice; // Repeat loop
    double comm_goal = INIT_AMT; // Input goal to earn commission
    double sales_amt; // Sales amount calculated from commission goal
    Scanner scan = new Scanner(System.in); // Read input from keyboard
    String name = null; // Input sales rep name
    String inputStr = null; // Input string reference
    DecimalFormat df = new DecimalFormat("#.##");

    do {
      System.out.print("Enter Sale Representative's name: ");
      name = scan.next(); // Assign word to string

      do {
        System.out.print("Enter Commission Goal for " + name + ": ");
        comm_goal = scan.nextDouble(); // Assign to double
        if (comm_goal < INIT_AMT) { // Error message if negative
          System.out.println("Error! Enter positive number.");
        }
      } while (comm_goal < INIT_AMT); // Check for positive value

      double total_pay = SALES_5K + comm_goal;
      double commission = 0.00;
      sales_amt = 0.00;
      while (commission < comm_goal) {
        switch ((int) ((int) (sales_amt / 10000.01) + (int) (sales_amt / 5000.01))) {
        case 0:
          sales_amt += 0.01 / PCT_8;
          break;
        case 1:
          sales_amt += 0.01 / PCT_10;
          break;

        default:
          sales_amt += 0.01 / PCT_12;
        }
        commission += 0.01;
      }
      System.out.println(" Sales amount of $" + df.format(sales_amt) + " is"
          + " needed to make a commission of $" + df.format(comm_goal));
      System.out.println(" Total pay is $" + df.format(total_pay) + " using"
          + " while loop\n");

      total_pay = SALES_5K + comm_goal;
      commission = 0.00;

      for (sales_amt = 0.00; commission < comm_goal; commission += 0.01)
        if (sales_amt <= SALES_5K) {
          sales_amt += 0.01 / PCT_8;
        } else if (sales_amt <= SALES_10K) {
          sales_amt += 0.01 / PCT_10;
        } else {
          sales_amt += 0.01 / PCT_12;
        }

      System.out.println(" Sales amount of $" + df.format(sales_amt)
          + " is needed to " + "make a commission of $" + df.format(comm_goal));
      System.out.println(" Total pay is $" + df.format(total_pay)
          + " using for loop");

      System.out.print("Want to calculate sales needed to reach goal (y/n)? ");
      inputStr = scan.next(); // Read and assign string
      System.out.println("");
      choice = inputStr.charAt(0); // Assign to character

    } while (choice != 'n' && choice != 'N'); // Loop while NOT n nor N

    scan.close(); // Close Scanner
    System.exit(0); // Close dialog box
  }
}