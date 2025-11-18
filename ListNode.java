public class ListNode {

    // Data fields
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String zipCode;
    private String phoneNumber;

    public ListNode next;

    public ListNode(String firstName, String lastName, String streetAddress, String city, String zipCode, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + lastName + ", " + firstName + "\n" +
                "Phone: " + phoneNumber + "\n" +
                "Address: " + streetAddress + "\n" +
                "         " + city + ", " + zipCode + "\n" +
                "----------------------------------";
    }
}
