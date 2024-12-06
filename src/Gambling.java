import java.util.Scanner;
public class Gambling {
    Gambler user = new Gambler();
    Scanner scan = new Scanner(System.in);

    public void gamble() {
        System.out.println("How much money do you have to gamble?");
        user.setBalance(scan.nextInt());
        System.out.println("Enter your bet: ");
        double bet = scan.nextDouble();
        if (bet > user.getBalance()) {
            System.out.println("You don't have enough money to bet!");
        } else {
            double outcome = Math.random();
            if (outcome > 0.5) {
                balance += bet;
                System.out.println("You won! Your balance is now: $" + balance);
                adjustHappiness(true, bet);
            } else {
                balance -= bet;
                System.out.println("You lost! Your balance is now: $" + balance);
                adjustHappiness(false, bet);
            }
        }
    }
}
