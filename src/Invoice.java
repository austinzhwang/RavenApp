public class Invoice {

    private int quantity;
    private String description;
    private double price;
    private double total;

    private String name;
    private String stAddress;
    private String city;
    private String state;
    private int zipCode;

    public Invoice() {
        this.quantity = 0;
        this.price = 0;
        this.total = 0;
    }

    public Invoice(int quantity, String description, double price, double total) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStAddress() {
        return stAddress;
    }

    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


    public double getTotal() {
        return total;
    }

    public void printBillingInfo() {
        System.out.println("\nRAVENS'S INVOICE");
        System.out.println("----------------");
        System.out.println("To:");
        System.out.println(getName());
        System.out.println(getStAddress());
        System.out.println(getCity() + ", " + getState() + " " + getZipCode());
    }
}
