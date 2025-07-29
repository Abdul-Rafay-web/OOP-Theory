import java.io.*;
import java.util.*;
class Transporter implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String contact;
    private String address;

    public Transporter(String name, String contact, String address) {
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Transporter [Name=" + name + ", Contact=" + contact + ", Address=" + address + "]";
    }
}
