public class GuestUser extends User {

    public GuestUser(String name) {
        this.name = name;
    }

    @Override
    public void payFare(double amount) {
        System.out.println("Fare: ₱" + amount + " (Cash Payment)");
    }
}
