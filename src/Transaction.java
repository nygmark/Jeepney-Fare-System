public class Transaction {

    private String date;
    private String route;
    private double distance;
    private double fare;

    public Transaction(String date, String route, double distance, double fare) {
        this.date = date;
        this.route = route;
        this.distance = distance;
        this.fare = fare;
    }

    public String toFileString() {
        return date + "," + route + "," + distance + "," + fare;
    }
}
