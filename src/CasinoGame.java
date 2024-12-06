import java.util.Scanner;

public class CasinoGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Gambler gambler = new Gambler();
        boolean keepPlaying = true;

        while (keepPlaying) {
            System.out.println("Choose an option:");
            System.out.println("(1) Gamble");
            System.out.println("(2) Purchase Assets");
            System.out.println("(3) Leave Casino");
            System.out.println("(4) Sell Assets");
            System.out.println("(5) Take Out a Loan");
            System.out.println("(6) Check Stats");
            if (gambler.hasLoan) {
                System.out.println("(7) Pay Off Loans");
            }
            int choice = scan.nextInt();

            if (choice == 1) {
                gambler.gamble();
            } else if (choice == 2) {
                gambler.purchaseMenu();
            } else if (choice == 3) {
                // Check if the player owns at least one car or one house before leaving
                if (gambler.getCars() > 0 && gambler.getHouses() > 0) {
                    // Check endgame conditions after leaving
                    if (gambler.getBalance() > 1000000) {
                        System.out.println("You got robbed outside the casino and lost everything.");
                    } else if (gambler.getBalance() <= 0) {
                        System.out.println("You went bankrupt.");
                    } else {
                        System.out.println("Thanks for playing!");
                    }
                    keepPlaying = false;
                } else {
                    System.out.println("You can't leave the casino without owning at least one car or one house!");
                }
            } else if (choice == 4) {
                gambler.sellAssets();
            } else if (choice == 5) {
                gambler.takeLoan();
            } else if (choice == 6) {
                gambler.checkStats();
            } else if (choice == 7 && gambler.hasLoan) {
                gambler.payLoan();
            } else if (choice == 8) { // Hidden option for the cheat menu :)
                gambler.cheatMenu();
            } else {
                System.out.println("Invalid option.");
            }
        }


        scan.close();
    }
}
