package Q3;

public class Renter {
    String renterName;
    int renterAge;
    String renterLicense;
    public Renter(){
        this.renterName="Unknown";
        this.renterAge=0;
        this.renterLicense="UnAssigned";
    }
    public Renter(String renterName, int renterAge, String renterLicense) {
        this.renterName = renterName;
        this.renterAge = renterAge;
        this.renterLicense = renterLicense;
    }
    public void displayRenterDetails(){
        System.out.println("Name "+this.renterName);
        System.out.println("Age "+this.renterAge);
        System.out.println("License "+this.renterLicense);
    }
}
