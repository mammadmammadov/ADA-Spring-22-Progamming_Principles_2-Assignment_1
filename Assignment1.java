/**
 * @author Mammad I. Mammadov
 */

import java.lang.Math;

public class Assignment1 {

  public static void main(String[] args) {

    //if statement below makes sure that there should be 3 or 4 arguments
    if (args.length < 3 || args.length > 4) {
      System.out.println("Number of the input parameters is wrong!");
    } else {

      String operationCode = args[0];

      switch (operationCode) {

      case "1":

        //as mentioned above, it is possible that user can enter 3 or 4 values
        //however, for the first formula we have to make sure that it is not equal to 3
        if (args.length == 3) {
          System.out.println("Number of the input parameters are wrong! You should have have four parameters, not three.");
        } else {

          double G = 6.674 * Math.pow(10, -11);
          double m1 = Double.parseDouble(args[1]);
          double m2 = Double.parseDouble(args[2]);
          double F = Double.parseDouble(args[3]);

          if (m1 <= 0 || m2 <= 0 || F <= 0) {
            System.out.println("Warning! Masses or Force cannot be negative or equal to zero. Make sure they all are positive.");
          } else {

            double r = Math.sqrt(G * m1 * m2 / F); //F=G*m1*m2/r^2 => r = sqrt(G*m1*m2/F)
            System.out.printf("%.3e", r);
          }
        }

        break;

      case "2":

        //user can enter 3 or 4 arguments, however since this is the second formula, in case of 4 arguments, there should be warning
        if (args.length == 4) {
          System.out.println("Number of the input parameters are wrong! You should have have three parameters, not four.");
        } else {

          double x = Double.parseDouble(args[1]);
          int n = Integer.parseInt(args[2]);

          if (n <= 0) {
            System.out.println("Warning! n (number of terms) cannot be negative or equal to zero. It should be positive integer.");
          } else {
            double sumOfTaylorSeries = 0;
            long factorial = 1;
            for (int i = 1; i <= n; i++) { //starting the loop from 1

              //terms are in the order of positive, negative, positive, negative,...
              //as the initial value of i is 1, for making the first term positive it should be not (-1)^i, but (-1)^(i+1) => (-1)^2=1
			  
			  //first term's power is 1 = 2*1-1
			  //second term's power is 3 = 2*2-1
			  //third term's power is 5 = 2*3-1
			  //Therefore, i'th term's power will be 2*i-1
              sumOfTaylorSeries += Math.pow(-1, i + 1) * Math.pow(x, 2 * i - 1) / factorial;
			  
			  

              // for each value of i starting from one, we have to multiply it by 2*i*(2*i+1) for finding the factorial of the next odd number coming after i
              // for instance 3! = 1!*(2*1)*(2*1+1) = 1!*2*3
              // 5! = 3! * (2*2)*(2*2+1) = 3!*4*5
              // 7! = 5! * (2*3)*(2*3+1) = 5!*6*7 and so on...
              factorial *= (2 * i) * (2 * i + 1);
            }

            System.out.printf("%.3e", sumOfTaylorSeries);
          }
        }
        break;

      default:
        System.out.println("Your first parameter is invalid. Please enter one of following parameters: 1 for Newton's formula of gravitation OR 2 for calculating Taylor series.");
      }
    }
  }
}