import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    while (true) {
      Scanner in = new Scanner(System.in);
      // user input: account balance
      boolean ok = false;
      double initial_amount = 0;
      do {
        System.out.print("Enter account balance: ");
        String init = in.nextLine();
        try {
          Double d = Double.parseDouble(init);
          initial_amount = d;
          ok = true;
        } catch (NumberFormatException e) {
          ok = false;
        }
        if (ok) {
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
        }
      } while(!ok);
      // user input: interest rate
      ok = false;
      double interest_rate = 0;
      do {
        System.out.print("Enter interest rate(%): ");
        String init = in.nextLine();
        try {
          Double d = Double.parseDouble(init);
          interest_rate = d;
          ok = true;
        } catch (NumberFormatException e) {
          ok = false;
        }
        if (ok) {
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
        }
      } while(!ok);
      double interest_amount = 1;
      // hold values (to be used later for resetting the initial amount)
      double tmp1 = initial_amount;
      double tmp2 = interest_rate;
      for (int qq = 1; qq <= 3; qq++) {
        int n;
        if (qq == 1) {
          // annually
          n = 1;
        } else if (qq == 2) {
          // monthly
          n = 12;
        } else {
          // daily
          n = 365;
        }
        // percentage to decimal
        interest_rate /= 100;
        // time period of the interest
        interest_rate /= n;
        // calculate interest amount for the next 10 years
        interest_rate++;
        for (int i = 0; i < n * 10; i++) {
          interest_amount *= interest_rate;
        }
        initial_amount *= interest_amount;
        // create labels for printing
        String s = "";
        if (qq == 1) {
          s = "Annually";
        } else if (qq == 2) {
          s = "Monthly";
        } else {
          s = "Daily";
        }
        System.out.print("Compounded " + s + ": ");
        System.out.printf("%.2f\n", initial_amount);
        // reset values
        initial_amount = tmp1;
        interest_rate = tmp2;
        interest_amount = 1;
      }
      // prompt the user to continue or exit the program
      char c = ' ';
      boolean checker = false;
      boolean exit = false;
      do {
        System.out.print("\nDo you want to calculate again? (Y/N): ");
        c = in.next().charAt(0);
        if (c == 'Y' || c == 'y') {
          System.out.println();
          checker = true;
        } else if (c == 'N' || c == 'n') {
          System.out.println("Exiting program...");
          exit = true;
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
        }
      } while (!checker);
      if (exit) {
        break;
      }
    }
  }
}
