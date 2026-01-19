import java.io.*;
import java.util.*;

public class JeepneyFareSystemBruh {

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
                if (d.length >= 2 && d[1].equalsIgnoreCase(username)) {
                    return true;
                }
            }
        } catch (IOException ignored) {}
        return false;
    }

    static void printJeepney() {
        System.out.println();
        System.out.println("⠀⠀⠀⠀⠀⣴⣶⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⣿⣿⡇⢠⣾⡿⠛⢿⣷⡄⢠⣾⡿⠛⢿⣷⡄⢸⣿⣿⡾⠿⣿⣿⡆");
        System.out.println("⣶⣶⡆⠀⠀⣿⣿⡇⢸⣿⡷⠶⠾⠿⠇⢸⣿⡷⠶⠾⠿⠇⢸⣿⣿⠀⠀⢸⣿⣿");
        System.out.println("⠹⣿⣷⣶⣶⣿⣿⠃⠸⣿⣷⣤⣴⣶⠆⠘⣿⣷⣤⣴⣶⠆⢸⣿⣿⣄⣀⣼⣿⡏");
        System.out.println("⠀⠈⠉⠛⠋⠉⠀⠀⠀⠀⠉⠛⠉⠁⠀⠀⠀⠉⠛⠉⠁⠀⢸⣿⣿⠙⠛⠛⠋⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠿⠟⠀⠀⠀⠀⠀");
        System.out.println();
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⢀⣴⣶⣶⣶⣶⣾⣿⢿⣿⣿⣿⠿⠿⣿⣿⣿⣟⣛⠛⠛⠛⠋⠉⠉⠛⣛⣛⢛⣟⠛⠛⠛⠿⠷⠶⢶⣤⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠐⣼⡏⡏⠀⠀⠂⠂⠀⣾⣿⡇⣿⣶⠒⠲⠶⠦⠬⣭⣽⣿⢳⡶⠶⠶⠿⠿⠿⠿⢿⣿⡿⠿⠿⠿⠿⠿⣟⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⣿⡇⣧⡤⠤⠤⠤⢴⣿⣿⣷⢹⣿⠐⢦⠀⠀⠀⠀⣿⢻⡌⢿⠛⠛⠛⠛⡆⠀⠀⢿⣧⠀⠀⠀⠀⠀⠀⠹⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⢻⣇⣿⣧⠀⠀⠀⠀⢿⣿⣿⢼⣿⠀⢸⡀⠀⠀⠀⢸⠀⢧⠘⣧⠀⣀⣠⣇⠀⠀⠸⣿⡄⠀⠀⠀⠀⠀⠀⣹⣻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⢸⣿⣿⣿⡀⠀⠀⠀⢸⣿⣿⣿⣿⣄⣼⠇⠀⠀⠀⢸⠀⢘⡆⠘⠿⢿⣿⣿⣶⣶⡾⣿⣷⣶⣾⣿⣿⣿⣿⣿⣯⣿⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠈⣿⣿⡏⠉⠉⠙⠛⠛⣿⣿⣿⣿⣷⣿⣿⡛⣿⣛⢻⣶⡫⢿⡀⠈⣻⡿⠿⠿⠿⣻⣿⣿⣟⣛⣛⣉⠉⠉⠉⠉⠉⢉⠙⠛⠻⣛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⡀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⣹⠿⠿⠤⣤⣀⣀⣠⣿⣿⣭⣿⣿⠽⡿⡇⠀⢒⡈⢿⠉⠉⣇⠸⣅⣀⣀⣀⣀⣀⣀⡀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⣿⣿⡿⣏⡉⠀⣀⣤⣀⣴⣿⠏⢳⢹⡇⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⢿⡇⠀⠀⠀⣀⣬⣩⡉⠉⠙⠋⠹⡆⣧⣿⣠⣶⣒⣺⣇⣀⣿⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⣿⣿⠀⣸⣿⣿⣿⣿⢹⡟⢯⣧⣼⣸⡇⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⣿⡇⠀⢀⡞⠉⠀⠀⠙⢦⠀⠀⠀⢻⣍⠉⠙⠳⢤⣠⠾⠛⣿⠀⠀⠀⠀⠀⠀⣀⣤⣤⠤⣤⣤⣤⣤⣄⣄⣀⣀⣀⣠⣟⠻⠿⠋⣿⣿⣿⢻⢸⡇⣠⣽⡿⠋⠁⠀⠀⠀⠀⠀");
        System.out.println("⠀⣠⣼⡇⠀⣾⢁⣴⠶⠛⠓⠺⣷⡀⠀⠀⠙⠿⣗⣶⣾⣿⣷⣿⣿⠀⠀⠀⠀⢠⣾⠽⠭⠭⠽⠿⠿⠿⠿⢿⣿⡿⠿⠿⠛⠛⣧⣖⡟⣿⣿⣿⣸⣸⡇⠙⣻⣷⣤⡀⠀⠀⠀⠀⠀");
        System.out.println("⣸⣿⣿⣿⣶⣿⣿⠗⣒⣶⣦⡀⠘⣧⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠀⠀⠀⣠⣿⠋⠀⠀⠀⠀⠀⣀⣀⣀⣀⣿⣷⡀⠀⢀⡀⢸⡌⠀⣿⣿⣿⠿⠻⠃⣠⣼⣥⣉⣻⣦⣠⣤⣤⣴");
        System.out.println("⠀⠉⠉⠉⠙⣿⠇⣾⢯⡴⡽⡽⡄⠙⢷⡦⣤⣄⣀⣀⣀⣀⣀⣀⣤⣄⣀⣴⣿⠃⠀⠀⠀⢀⣴⢟⣛⣋⡙⠛⢯⡻⢿⣏⠛⠿⣿⣇⣠⣭⣥⣴⣶⣾⣿⣷⠿⠻⠿⠋⠉⠉⠉⢹⣿");
        System.out.println("⠀⠀⠀⠀⠀⣿⡀⢻⡘⣇⣼⠇⢳⠀⠈⣧⣀⣈⣥⡟⠋⡭⡭⠻⠟⣿⣿⣿⣓⣒⣒⡒⣶⣿⡵⠋⠉⢈⣉⠳⣤⠙⣦⠙⣷⡀⠈⣁⣶⣿⣿⣿⡍⣀⣀⣠⣤⣤⢶⡶⠚⣾⡿⠻⢻");
        System.out.println("⠀⠀⠀⠀⠀⢻⣧⠈⢷⣄⣠⡇⣼⠀⢠⡟⠉⠉⠙⠛⠛⠛⠛⠛⠛⠋⠁⠉⠉⠉⠉⢻⣿⣿⠀⢀⡞⣉⣉⠙⢮⢧⠘⡆⢸⣿⣿⣽⣿⣿⣿⢿⣿⣛⡿⠯⠗⡿⢀⡇⢸⣿⠇⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠻⣧⣄⡀⣀⡼⠃⢀⣼⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⢸⠀⡋⠈⢧⠈⡿⡄⢻⢘⢻⡿⠟⠛⠉⢻⣆⠙⠳⠤⠴⠚⢁⡾⢃⣼⡟⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠈⠻⠿⢥⡤⠶⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⠘⣇⠳⣤⡾⢀⣧⠇⣼⠀⢸⡇⠀⠀⠀⠀⠙⠷⣦⣤⣤⣶⣿⣵⠾⠋⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢿⣷⡀⠈⠳⠤⠤⢪⡞⣠⡏⢀⣾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⣗⣶⣶⣞⣫⣴⣏⣠⡾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠛⠿⠿⠛⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        System.out.println();
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pause() {
        System.out.print("\n[Press Enter to continue...]");
        sc.nextLine();
    }

    public static void main(String[] args) {
        while (true) {
            clearScreen();
            printJeepney();
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                                                    ║");
            System.out.println("║          JEEPNEY FARE SYSTEM - CAVITE              ║");
            System.out.println("║                  EPZA - TRECE                      ║");
            System.out.println("║                                                    ║");
            System.out.println("╚════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println("┌────────────────────────────────────���───────────────┐");
            System.out.println("│                                                    │");
            System.out.println("│   [1] Login                                        │");
            System.out.println("│   [2] Register                                     │");
            System.out.println("│   [3] Continue as Guest                            │");
            System.out.println("│   [4] View Jeepney Fare Chart                      │");
            System.out.println("│   [5] Exit                                         │");
            System.out.println("│                                                    │");
            System.out.println("└────────────────────────────────────────────────────┘");
            System.out.print("\n>> Choose an option: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\n[ERROR] Please enter a number 1-5.");
                pause();
                continue;
            }
            sc.nextLine();

            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> guestFlow();
                case 4 -> showFareChart();
                case 5 -> {
                    clearScreen();
                    System.out.println("\n╔════════════════════════════════════════════════════╗");
                    System.out.println("║                                                    ║");
                    System.out.println("║     Thank you for using Jeepney Fare System!       ║");
                    System.out.println("║              Ingat sa byahe! (Safe travels!)       ║");
                    System.out.println("║                                                    ║");
                    System.out.println("╚════════════════════════════════════════════════════╝\n");
                    System.exit(0);
                }
                default -> {
                    System.out.println("\n[ERROR] Invalid choice.");
                    pause();
                }
            }
        }
    }

    /* ================= LOGIN ================= */
    static void login() {
        clearScreen();
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║                     LOGIN                          ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        System.out.print("Username: ");
        String user = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        RegisteredUser ru = findUser(user, pass);
        if (ru != null) {
            System.out.println("\n[SUCCESS] Login successful! Welcome, " + ru.name);
            pause();
            userMenu(ru);
        } else {
            System.out.println("\n[ERROR] Invalid credentials.");
            pause();
        }
    }

    /* ================= REGISTER ================= */
    static void register() {
        clearScreen();
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║                REGISTER NEW ACCOUNT                ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Username: ");
        String user = sc.nextLine();

        if (usernameExists(user)) {
            System.out.println("\n[ERROR] Username already exists. Please choose another.");
            pause();
            return;
        }

        System.out.print("Password: ");
        String pass = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_FILE, true))) {
            bw.write(name + "," + user + "," + pass + ",0");
            bw.newLine();
            System.out.println("\n[SUCCESS] Registration successful! You can now login.");
        } catch (IOException e) {
            System.out.println("\n[ERROR] Error saving user.");
        }
        pause();
    }

    /* ================= USER MENU ================= */
    static void userMenu(RegisteredUser ru) {
        while (true) {
            clearScreen();
            System.out.println("╔════════════════════════════════════════════════════╗");
            System.out.println("║                                                    ║");
            System.out.println("║  Welcome, " + String.format("%-41s", ru.name) + "║");
            System.out.println("║                                                    ║");
            System.out.println("╚════════════════════════════════════════════════════╝");
            System.out.println();
            System.out.println("┌────────────────────────────────────────────────────┐");
            System.out.println("│                                                    │");
            System.out.println("│   [1] Check Balance                                │");
            System.out.println("│   [2] Top Up                                       │");
            System.out.println("│   [3] Pay Fare                                     │");
            System.out.println("│   [4] View Transactions                            │");
            System.out.println("│   [5] View Fare Chart                              │");
            System.out.println("│   [6] Logout                                       │");
            System.out.println("│                                                    │");
            System.out.println("└────────────────────────────────────────────────────┘");
            System.out.print("\n>> Choose an option: ");

            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\n[ERROR] Please enter a number 1-6.");
                pause();
                continue;
            }
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    clearScreen();
                    System.out.println("╔════════════════════════════════════════════════════╗");
                    System.out.println("║                 CURRENT BALANCE                    ║");
                    System.out.println("╚════════════════════════════════════════════════════╝\n");
                    System.out.println("┌──────────────────────────────────────���─────────────┐");
                    System.out.println("│                                                    │");
                    System.out.printf("│  Your Balance: P%-33.2f │%n", ru.getBalance());
                    System.out.println("│                                                    │");
                    System.out.println("└────────────────────────────────────────────────────┘");
                    pause();
                }
                case 2 -> {
                    clearScreen();
                    System.out.println("╔════════════════════════════════════════════════════╗");
                    System.out.println("║                   TOP UP BALANCE                   ║");
                    System.out.println("╚════════════════════════════════════════════════════╝\n");
                    System.out.print(">> Amount: P");
                    double amt;
                    try {
                        amt = sc.nextDouble();
                    } catch (InputMismatchException e) {
                        sc.nextLine();
                        System.out.println("\n[ERROR] Please enter a valid amount.");
                        pause();
                        continue;
                    }
                    sc.nextLine();
                    if (amt <= 0) {
                        System.out.println("\n[ERROR] Amount must be positive.");
                        pause();
                        continue;
                    }
                    ru.topUp(amt);
                    updateUserBalance(ru);
                    System.out.println("\n[SUCCESS] Balance updated.");
                    pause();
                }
                case 3 -> payFareFlow(ru);
                case 4 -> viewTransactions(ru.getUsername());
                case 5 -> showFareChart();
                case 6 -> {
                    System.out.println("\n[SUCCESS] Logged out successfully!");
                    pause();
                    return;
                }
                default -> {
                    System.out.println("\n[ERROR] Invalid choice.");
                    pause();
                }
            }
        }
    }

    /* ================= PAY FARE ================= */
    static void payFareFlow(RegisteredUser ru) {
        clearScreen();
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║                     PAY FARE                       ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        showRoute();

        System.out.print("\nPick-up location: ");
        String from = sc.nextLine();
        System.out.print("Drop-off location: ");
        String to = sc.nextLine();

        double distance = getDistance(from, to);
        if (distance < 0) {
            pause();
            return;
        }

        int type = passengerType();
        double fare = calculateFare(distance, type);

        System.out.println("\n┌────────────────────────────────────────────────────┐");
        System.out.println("│               FARE CALCULATION                     │");
        System.out.println("├────────────────────────────────────────────────────┤");
        System.out.printf("│  Distance: %-40.2f km │%n", distance);
        System.out.printf("│  Final Fare: P%-36.2f │%n", fare);
        System.out.println("└────────────────────────────────────────────────────┘");

        if (ru.hasSufficientBalance(fare)) {
            ru.payFare(fare);
            saveTransaction(ru.getUsername(), from + " to " + to, distance, fare);
            updateUserBalance(ru);
            System.out.println("\n[SUCCESS] Fare paid.");
        } else {
            System.out.println("\n[ERROR] Insufficient balance. Please top up.");
        }
        pause();
    }

    /* ================= GUEST ================= */
    static void guestFlow() {
        clearScreen();
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║                    GUEST MODE                      ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        System.out.print("Enter your name: ");
        GuestUser guest = new GuestUser(sc.nextLine());

        showRoute();

        System.out.print("\nPick-up location: ");
        String from = sc.nextLine();
        System.out.print("Drop-off location: ");
        String to = sc.nextLine();

        double distance = getDistance(from, to);
        if (distance < 0) {
            pause();
            return;
        }

        int type = passengerType();
        double fare = calculateFare(distance, type);

        System.out.println("\n┌────────────────────────────────────────────────────┐");
        System.out.println("│               FARE CALCULATION                     │");
        System.out.println("├────────────────────────────────────────────────────┤");
        System.out.printf("│  Distance: %-40.2f km │%n", distance);
        System.out.printf("│  Fare Amount: P%-36.2f │%n", fare);
        System.out.println("└────────────────────────────────────────────────────┘\n");

        guest.payFare(fare);
        pause();
    }

    /* ================= HELPER METHODS ================= */

    static int passengerType() {
        System.out.println("\n┌────────────────────────────────────────────────────┐");
        System.out.println("│             SELECT PASSENGER TYPE                  │");
        System.out.println("├────────────────────────────────────────────────────┤");
        System.out.println("│  [1] Regular (No Discount)                         │");
        System.out.println("│  [2] Student (20% Discount)                        │");
        System.out.println("│  [3] Senior (20% Discount)                         │");
        System.out.println("│  [4] PWD (20% Discount)                            │");
        System.out.println("└────────────────────────────────────────────────────┘");
        System.out.print("\n>> Choose passenger type: ");
        int type;
        try {
            type = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("\n[ERROR] Please enter 1-4.");
            return 1;
        }
        sc.nextLine();
        return type;
    }

    static void showRoute() {
        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("│              AVAILABLE STOPS                       │");
        System.out.println("├────────────────────────────────────────────────────┤");
        for (int i = 0; i < ROUTE.length; i++) {
            System.out.printf("│  %2d. %-45s │%n", (i + 1), ROUTE[i]);
        }
        System.out.println("└────────────────────────────────────────────────────┘");
    }

    static double getDistance(String from, String to) {
        int a = -1, b = -1;
        for (int i = 0; i < ROUTE.length; i++) {
            if (ROUTE[i].equalsIgnoreCase(from)) a = i;
            if (ROUTE[i].equalsIgnoreCase(to)) b = i;
        }
        if (a == -1 || b == -1) {
            System.out.println("\n[ERROR] Invalid location.");
            return -1;
        }
        return Math.abs(b - a) * 1.5; // 1.5 km per segment
    }

    static double calculateFare(double distance, int passengerType) {
        double baseFare = 13.0;
        double extraDistance = distance - 4.0;

        if (extraDistance <= 0) return baseFare;

        double ratePerKm = 1.80;
        // Discounted rate for Student, Senior, PWD (on succeeding kms only)
        if (passengerType == 2 || passengerType == 3 || passengerType == 4) {
            ratePerKm = 1.44;
        }
        return baseFare + (extraDistance * ratePerKm);
    }

    static void showFareChart() {
        clearScreen();
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║                 JEEPNEY FARE CHART                 ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("│             REGULAR PASSENGER                      │");
        System.out.println("├────────────────────────────────────────────────────┤");
        System.out.println("│  First 4 kilometers     :  P13.00                  │");
        System.out.println("│  Succeeding kilometers  :  P1.80 per km            │");
        System.out.println("└────────────────────────────────────────────────────┘");

        System.out.println("\n┌────────────────────────────────────────────────────┐");
        System.out.println("│      STUDENT / SENIOR / PWD (20% Discount)         │");
        System.out.println("├────────────────────────────────────────────────────┤");
        System.out.println("│  First 4 kilometers     :  P13.00                  │");
        System.out.println("│  Succeeding kilometers  :  P1.44 per km            │");
        System.out.println("└────────────────────────────────────────────────────┘");

        System.out.println("\n┌────────────────────────────────────────────────────┐");
        System.out.println("│                      NOTES                         │");
        System.out.println("├────────────────────────────────────────────────────┤");
        System.out.println("│  - Discount applies only to succeeding kilometers  │");
        System.out.println("│  - Base fare is fixed and not discounted           │");
        System.out.println("│  - Fare is distance-based along the route          │");
        System.out.println("│  - EPZA - TRECE route                              │");
        System.out.println("└────────────────────────────────────────────────────┘");

        pause();
    }

    /* ================= FILE HANDLING ================= */

    static RegisteredUser findUser(String user, String pass) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                if (d.length >= 3 && d[1].equals(user) && d[2].equals(pass)) {
                    double bal = 0.0;
                    if (d.length >= 4) {
                        try { bal = Double.parseDouble(d[3]); } catch (NumberFormatException ignored) {}
                    }
                    return new RegisteredUser(d[0], d[1], d[2], bal);
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
                if (d.length >= 2 && d[1].equals(ru.getUsername())) {
                    bw.write(ru.toFileString());
                } else {
                    bw.write(line);
                }
                bw.newLine();
            }
        } catch (IOException ignored) {}

        // Replace original file
        if (!orig.delete()) {
            // fallback: try to overwrite
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(orig))) {
                try (BufferedReader br = new BufferedReader(new FileReader(temp))) {
                    String l;
                    while ((l = br.readLine()) != null) {
                        bw.write(l);
                        bw.newLine();
                    }
                }
            } catch (IOException ignored) {}
        } else {
            temp.renameTo(orig);
        }
    }

    static void saveTransaction(String user, String route, double dist, double fare) {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("transactions_" + user + ".txt", true))) {
            String date = new Date().toString();
            Transaction t = new Transaction(date, route, dist, fare);
            bw.write(t.toFileString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("\n[ERROR] Error saving transaction.");
        }
    }

    static void viewTransactions(String user) {
        clearScreen();
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║               TRANSACTION HISTORY                  ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        File f = new File("transactions_" + user + ".txt");
        if (!f.exists()) {
            System.out.println("[INFO] No transactions found.");
            pause();
            return;
        }

        System.out.println("┌────────────────────────────────────────────────────┐");
        System.out.println("│  Date & Time          | Route        | Dist | Fare │");
        System.out.println("├────────────────────────────────────────────────────┤");

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    System.out.printf("│  %-50s│%n", line);
                }
            }
        } catch (IOException e) {
            System.out.println("\n[ERROR] Error reading file.");
        }

        System.out.println("└────────────────────────────────────────────────────┘");
        pause();
    }
}