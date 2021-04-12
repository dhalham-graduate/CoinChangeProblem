import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean keepGoing = true;
        int again = 1;
        String timeInStr;
        String timeOutStr;
        LocalTime timeIn;
        LocalTime timeOut;
        double cost = 3;
        double remainder;
        double paymentIn = 0;
        double changeDue = 0;
        BigDecimal changeDueBigDec;

        while (keepGoing){

            try {
                System.out.println("Please enter the time you entered the car park (in the format hh:mm) :");
                timeInStr = sc.nextLine();
                timeIn = LocalTime.parse(timeInStr, DateTimeFormatter.ofPattern("HH:mm"));
                System.out.println("Please enter the time you left the car park (in the format hh:mm) :");
                timeOutStr = sc.nextLine();
                timeOut = LocalTime.parse(timeOutStr, DateTimeFormatter.ofPattern("HH:mm"));
                Duration duration = Duration.between(timeIn, timeOut);
                remainder = duration.getSeconds();
                remainder = remainder - 3600;

                if (remainder > 0) {
                    remainder = remainder / 60;
                    remainder = Math.floor(remainder);
                    remainder = remainder / 100;
                    cost = cost + remainder;
                }

                System.out.println("Total cost: £" + cost);

                System.out.println("Please enter the amount of £20 notes: ");
                paymentIn = paymentIn + (sc.nextInt() * 20);
                System.out.println("Please enter the amount of £10 notes: ");
                paymentIn = paymentIn + (sc.nextInt() * 10);
                System.out.println("Please enter the amount of £5 notes: ");
                paymentIn = paymentIn + (sc.nextInt() * 5);
                System.out.println("Please enter the amount of £1 coins: ");
                paymentIn = paymentIn + (sc.nextInt());
                System.out.println("Please enter the amount of 50p coins: ");
                paymentIn = paymentIn + (sc.nextInt() * 0.5);
                System.out.println("Please enter the amount of 20p coins: ");
                paymentIn = paymentIn + (sc.nextInt() * 0.2);
                System.out.println("Please enter the amount of 10p coins: ");
                paymentIn = paymentIn + (sc.nextInt() * 0.1);
                System.out.println("Please enter the amount of 5p coins: ");
                paymentIn = paymentIn + (sc.nextInt() * 0.05);
                System.out.println("Please enter the amount of 2p coins: ");
                paymentIn = paymentIn + (sc.nextInt() * 0.02);
                System.out.println("Please enter the amount of 1p coins: ");
                paymentIn = paymentIn + (sc.nextInt() * 0.01);

                if (paymentIn < cost) {
                    System.out.println("Error, insufficient funds.");
                } else {
                    changeDue = new BigDecimal(String.valueOf(paymentIn)).subtract(new BigDecimal(String.valueOf(cost))).doubleValue();

                    System.out.println("Your change is as follows");
                    System.out.println("Total change: £" + changeDue);

                    if ((changeDue / 20) >= 1) {
                        System.out.println("£20: " + (int) Math.floor(changeDue / 20));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("20")).doubleValue();
                    }

                    if ((changeDue / 10) >= 1) {
                        System.out.println("£10: " + (int) Math.floor(changeDue / 10));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("10")).doubleValue();
                    }

                    if ((changeDue / 5) >= 1) {
                        System.out.println("£5: " + (int) Math.floor(changeDue / 5));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("5")).doubleValue();
                    }

                    if ((changeDue / 1) >= 1) {
                        System.out.println("£1: " + (int) Math.floor(changeDue / 1));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("1")).doubleValue();
                    }

                    if ((changeDue / 0.5) >= 1) {
                        System.out.println("50p: " + (int) Math.floor(changeDue / 0.5));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("0.5")).doubleValue();
                    }

                    if ((changeDue / 0.2) >= 1) {
                        System.out.println("20p: " + (int) Math.floor(changeDue / 0.2));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("0.2")).doubleValue();
                    }

                    if ((changeDue / 0.1) >= 1) {
                        System.out.println("10p: " + (int) Math.floor(changeDue / 0.1));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("0.1")).doubleValue();
                    }

                    if ((changeDue / 0.05) >= 1) {
                        System.out.println("5p: " + (int) Math.floor(changeDue / 0.05));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("0.05")).doubleValue();
                    }

                    if ((changeDue / 0.02) >= 1) {
                        System.out.println("2p: " + (int) Math.floor(changeDue / 0.02));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("0.02")).doubleValue();
                    }

                    if ((changeDue / 0.01) >= 1) {
                        System.out.println("1p: " + (int) Math.floor(changeDue / 0.01));
                        changeDueBigDec = new BigDecimal(String.valueOf(changeDue));
                        changeDue = changeDueBigDec.remainder(new BigDecimal("0.01")).doubleValue();
                    }
                }
            } catch (Exception e) {
                System.out.println("Error, invalid input.");
            }

            System.out.println("Do you want to start again? Type 1 to start again, or any other number to exit:");
            again = sc.nextInt();
            if (again != 1){
                keepGoing = false;
            }
            cost = 3;
            remainder = 0;
            changeDue = 0;
            paymentIn = 0;
            sc.nextLine();
        }

        System.out.println("End.");

    }

}