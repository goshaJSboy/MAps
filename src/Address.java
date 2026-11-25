public class Address {
    private String city;
    private String country;

    public Address(String country, String city){
        this.city = city;
        this.country = country; 
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Address address = (Address) obj;

        if (!city.equals(address.city)) return false;
        return country.equals(address.country);
    }

    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }
}
