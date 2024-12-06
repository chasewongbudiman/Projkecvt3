import java.util.Scanner;

public class Gambler {
    private double balance;
    private double loans;
    private int cars, houses, mansions, yachts;
    public boolean hasLoan;
    private int happiness; // Happiness meter

    Scanner scan = new Scanner(System.in);

    public Gambler() {
        balance = 0;
        loans = 0;
        cars = 0;
        houses = 0;
        mansions = 0;
        yachts = 0;
        hasLoan = false;
        happiness = 100;
    }

    public void setBalance(int amount) {
        balance = amount;
    }

    public Gambler(int balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getCars() {
        return cars;
    }

    public int getHouses() {
        return houses;
    }

    public void purchaseMenu() {
        System.out.println("What would you like to purchase?");
        System.out.println("(1) Car ($1)");
        System.out.println("(2) House ($1)");
        System.out.println("(3) Mansion ($1)");
        System.out.println("(4) Yacht ($1)");
        // 1 dollar is placeholder price
        int choice = scan.nextInt();


        if (choice == 1) {
            cars++;
            balance -= 1;
            System.out.println("You now have " + cars + " cars!");
            adjustHappinessForPurchase();
        } else if (choice == 2) {
            houses++;
            balance -= 1;
            System.out.println("You now have " + houses + " houses!");
            adjustHappinessForPurchase();
        } else if (choice == 3) {
            mansions++;
            balance -= 1;
            System.out.println("You now have " + mansions + " mansions!");
            adjustHappinessForPurchase();
        } else if (choice == 4) {
            yachts++;
            balance -= 1;
            System.out.println("You now have " + yachts + " yachts!");
            adjustHappinessForPurchase();
        } else {
            System.out.println("Invalid option.");
        }
    }


    public void sellAssets() {
        System.out.println("What would you like to sell?");
        System.out.println("(1) Car");
        System.out.println("(2) House");
        System.out.println("(3) Mansion");
        System.out.println("(4) Yacht");
        int choice = scan.nextInt();


        if (choice == 1 && cars > 0) {
            cars--;
            balance += 1;
            System.out.println("You sold a car. Balance: $" + balance);
        } else if (choice == 2 && houses > 0) {
            houses--;
            balance += 1;
            System.out.println("You sold a house. Balance: $" + balance);
        } else if (choice == 3 && mansions > 0) {
            mansions--;
            balance += 1;
            System.out.println("You sold a mansion. Balance: $" + balance);
        } else if (choice == 4 && yachts > 0) {
            yachts--;
            balance += 1;
            System.out.println("You sold a yacht. Balance: $" + balance);
        } else {
            System.out.println("You don't have that asset to sell.");
        }
    }


    public void takeLoan() {
        System.out.println("How much money would you like to loan?");
        double amount = scan.nextDouble();
        if (amount > 0) {
            loans += amount * 1.25;
            balance += amount;
            hasLoan = true;
            System.out.println("You took a loan of $" + amount + ". You owe: $" + loans);
            adjustHappinessForLoan();
        } else {
            System.out.println("Invalid loan amount.");
        }
    }


    public void payLoan() {
        if (hasLoan) {
            if (balance >= loans) {
                balance -= loans;
                loans = 0;
                hasLoan = false;
                System.out.println("You paid off your loan!!!! Balance: $" + balance);
            } else {
                System.out.println("You don't have enough money to pay off your loan!!!!");
            }
        } else {
            System.out.println("You don't have any loans????");
        }
    }


    public void checkStats() {
        System.out.println("Balance: $" + balance);
        System.out.println("Loans: $" + loans);
        System.out.println("Cars: " + cars);
        System.out.println("Houses: " + houses);
        System.out.println("Mansions: " + mansions);
        System.out.println("Yachts: " + yachts);
        System.out.println("Happiness: " + happiness);
        System.out.println(); // Extra blank line
    }


    private void adjustHappiness(boolean wonGamble, double bet) {
        if (wonGamble) {
            happiness += 10;
            System.out.println(" Happiness is now: " + happiness);
        } else {
            happiness -= 10;
            System.out.println(" Happiness decreases to: " + happiness);
        }
        checkHappiness();
    }

    private void adjustHappinessForPurchase() {
        happiness += 5;
        System.out.println(" Happiness increased to: " + happiness);
        checkHappiness();
    }

    private void adjustHappinessForLoan() {
        happiness -= 15;
        System.out.println(" Happiness decreased to: " + happiness);
        checkHappiness();
    }

    private void checkHappiness() {
        if (happiness <= 0) {
            System.out.println("");
        } else if (happiness >= 100) {
            System.out.println("");
        }
    }


    public boolean isGameOver() {
        if (balance > 1000000) {
            System.out.println("You got robbed outside the casino!!!");
            return true;
        }
        if (balance < 0) {
            System.out.println("You went bankrupt!!!");
            return true;
        }
        if (happiness <= 0 || happiness >= 100) {
            return true;
        }
        return false;
    }


    public void cheatMenu() {
        System.out.println("CHEAT MENU:");
        System.out.println("(1) Set Balance");
        System.out.println("(2) Set Happiness");
        System.out.println("(3) Set Assets");
        int choice = scan.nextInt();


        if (choice == 1) {
            System.out.println("Enter new balance: ");
            balance = scan.nextDouble();
        } else if (choice == 2) {
            System.out.println("Enter new happiness: ");
            happiness = scan.nextInt();
        } else if (choice == 3) {
            System.out.println("Enter number of cars: ");
            cars = scan.nextInt();
            System.out.println("Enter number of houses: ");
            houses = scan.nextInt();
            System.out.println("Enter number of mansions: ");
            mansions = scan.nextInt();
            System.out.println("Enter number of yachts: ");
            yachts = scan.nextInt();
        } else {
            System.out.println("Invalid choice.");
        }
    }


    public void mainMenu() {
        System.out.println("(1) Gamble");
        System.out.println("(2) Purchase");
        System.out.println("(3) Sell Assets");
        System.out.println("(4) Take Loan");
        System.out.println("(5) Pay Loan");
        System.out.println("(6) Check Stats");
        System.out.println("(7) Quit");


        int choice = scan.nextInt();
        if (choice == 1)  gamble();
        else if (choice == 2) purchaseMenu();
        else if (choice == 3) sellAssets();
        else if (choice == 4) takeLoan();
        else if (choice == 5) payLoan();
        else if (choice == 6) checkStats();
        else if (choice == 8) cheatMenu();
        else System.out.println("Invalid choice.");
    }
}


