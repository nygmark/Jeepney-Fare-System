public class RegisteredUser extends User {

    private String username;
    private String password;
    private double balance;

    public RegisteredUser(String name, String username, String password, double balance) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public double getBalance() {
        return balance;
    }

    public void topUp(double amount) {
        balance += amount;
        System.out.println("Top-up successful.");
    }

    public boolean hasSufficientBalance(double fare) {
        return balance >= fare;
    }

    @Override
    public void payFare(double amount) {
        balance -= amount;
        System.out.println("Fare paid: ₱" + amount);
    }

    public String toFileString() {
        return name + "," + username + "," + password + "," + balance;
    }
}
