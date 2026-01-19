import java.io.*;
import java.util.*;

public class JeepneyFareSystem {

    static Scanner sc = new Scanner(System.in);
    static final String USERS_FILE = "users.txt";

    static String[] ROUTE = {
        "EPZA", "TEJERO", "UMBOY", "TANZA", "MULAWIN",
        "SANJA MAJOR", "BIGA", "PUNTA", "BAGTAS",
        "PARADAHAN", "DE OCAMPO", "TRECE"
    };
    
    static boolean usernameExists(String username) {
    try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (d[1].equalsIgnoreCase(username)) {
                return true;
            }
        }
    } catch (IOException ignored) {}
    return false;
}


    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== JEEPNEY FARE SYSTEM ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Continue as Guest");
            System.out.println("4. View Jeepney Fare Chart");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> guestFlow();
                case 4 -> showFareChart();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    /* ================= LOGIN ================= */
    static void login() {
        System.out.print("Username: ");
        String user = sc.nextLine();
        
        System.out.print("Password: ");
        String pass = sc.nextLine();

        RegisteredUser ru = findUser(user, pass);
        if (ru != null) {
            userMenu(ru);
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    /* ================= REGISTER ================= */
    static void register() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Username: ");
        String user = sc.nextLine();
        if (usernameExists(user)) {
        System.out.println("Username already exists. Please choose another.");
        return;
        }
        System.out.print("Password: ");
        String pass = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            bw.write(name + "," + user + "," + pass + ",0");
            bw.newLine();
            System.out.println("Registration successful.");
        } catch (IOException e) {
            System.out.println("Error saving user.");
        }
    }

    /* ================= USER MENU ================= */
    static void userMenu(RegisteredUser ru) {

        while (true) {
            System.out.println("\nWelcome, " + ru.name);
            System.out.println("1. Check Balance");
            System.out.println("2. Top Up");
            System.out.println("3. Pay Fare");
            System.out.println("4. View Transactions");
            System.out.println("5. View Fare Chart");
            System.out.println("6. Logout");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Balance: ₱" + ru.getBalance());
                case 2 -> {
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    sc.nextLine();
                    ru.topUp(amt);
                    updateUserBalance(ru);
                }
                case 3 -> payFareFlow(ru);
                case 4 -> viewTransactions(ru.getUsername());
                case 5 -> showFareChart();
                case 6 -> { return; }
            }
        }
    }

    /* ================= PAY FARE ================= */
    static void payFareFlow(RegisteredUser ru) {

        showRoute();

        System.out.print("Pick-up: ");
        String from = sc.nextLine();
        System.out.print("Drop-off: ");
        String to = sc.nextLine();

        double distance = getDistance(from, to);
        if (distance < 0) return;

        int type = passengerType();
        double fare = calculateFare(distance, type);


        System.out.println("Final Fare: ₱" + fare);

        if (ru.hasSufficientBalance(fare)) {
            ru.payFare(fare);
            saveTransaction(ru.getUsername(), from + " to " + to, distance, fare);
            updateUserBalance(ru);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    /* ================= GUEST ================= */
    static void guestFlow() {

        System.out.print("Name: ");
        GuestUser guest = new GuestUser(sc.nextLine());

        showRoute();

        System.out.print("Pick-up: ");
        String from = sc.nextLine();
        System.out.print("Drop-off: ");
        String to = sc.nextLine();

        double distance = getDistance(from, to);
        if (distance < 0) return;

        int type = passengerType();
        double fare = calculateFare(distance, type);


        guest.payFare(fare);
    }

    /* ================= HELPER METHODS ================= */

    static int passengerType() {
        System.out.println("\nPassenger Type:");
        System.out.println("1. Regular");
        System.out.println("2. Student");
        System.out.println("3. Senior");
        System.out.println("4. PWD");
        System.out.print("Choose: ");
        int type = sc.nextInt();
        sc.nextLine();
        return type;
    }

    static void showRoute() {
        System.out.println("\nAvailable Stops:");
        for (String s : ROUTE) System.out.println("- " + s);
    }

    static double getDistance(String from, String to) {

        int a = -1, b = -1;

        for (int i = 0; i < ROUTE.length; i++) {
            if (ROUTE[i].equalsIgnoreCase(from)) a = i;
            if (ROUTE[i].equalsIgnoreCase(to)) b = i;
        }

        if (a == -1 || b == -1) {
            System.out.println("Invalid location.");
            return -1;
        }

        return Math.abs(b - a) * 1.5;
    }

    static double calculateFare(double distance, int passengerType) {

    double baseFare = 13.0;
    double extraDistance = distance - 4;

    if (extraDistance <= 0) {
        return baseFare;
    }

    double ratePerKm = 1.80;

    // Discounted rate for Student, Senior, PWD
    if (passengerType == 2 || passengerType == 3 || passengerType == 4) {
        ratePerKm = 1.44;
    }

    return baseFare + (extraDistance * ratePerKm);
    }

    static void showFareChart() {

    System.out.println("\n=== JEEPNEY FARE CHART ===");

    System.out.println("\nREGULAR PASSENGER");
    System.out.println("First 4 kilometers      : ₱13.00");
    System.out.println("Succeeding kilometers   : ₱1.80 per km");

    System.out.println("\nSTUDENT / SENIOR / PWD (20% Discount)");
    System.out.println("First 4 kilometers      : ₱13.00");
    System.out.println("Succeeding kilometers   : ₱1.44 per km");

    System.out.println("\nNOTES:");
    System.out.println("- Discount applies only to succeeding kilometers");
    System.out.println("- Base fare is fixed and not discounted");
    System.out.println("- Fare is distance-based along the EPZA–TRECE route");
    }


    /* ================= FILE HANDLING ================= */

    static RegisteredUser findUser(String user, String pass) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[1].equals(user) && d[2].equals(pass)) {
                    return new RegisteredUser(d[0], d[1], d[2], Double.parseDouble(d[3]));
                }
            }
        } catch (IOException ignored) {}
        return null;
    }

    static void updateUserBalance(RegisteredUser ru) {

        File temp = new File("temp.txt");
        File orig = new File(USERS_FILE);

        try (
            BufferedReader br = new BufferedReader(new FileReader(orig));
            BufferedWriter bw = new BufferedWriter(new FileWriter(temp))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d[1].equals(ru.getUsername())) {
                    bw.write(ru.toFileString());
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }
        } catch (IOException ignored) {}

        orig.delete();
        temp.renameTo(orig);
    }

    static void saveTransaction(String user, String route, double dist, double fare) {

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("transactions_" + user + ".txt", true))) {

            String date = new Date().toString();
            Transaction t = new Transaction(date, route, dist, fare);
            bw.write(t.toFileString());
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }

    static void viewTransactions(String user) {

        File f = new File("transactions_" + user + ".txt");
        if (!f.exists()) {
            System.out.println("No transactions found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}

