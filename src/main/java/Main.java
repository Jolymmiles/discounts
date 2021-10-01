import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cost = 0, cost_not_percent = 0, sum_pecent = 0;
        while (true) {
            double input_digit = sc.nextDouble();
            if (input_digit < 0 ) break;
            if (input_digit >= 1000) {
                cost += input_digit - input_digit * 0.05;
                sum_pecent += input_digit * 0.05;
                cost_not_percent += input_digit;
            } else {
                cost += input_digit;
                cost_not_percent += input_digit;
            }

        }
        System.out.print(Math.floor(cost_not_percent*100)/100 + " " + Math.floor(cost*100)/100 + " " + Math.floor(sum_pecent*100)/100);
    }
}
