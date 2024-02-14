package embedded;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MobileNumber {
    @Column(name = "phone_type")
    private String type;
    @Column(name = "phone_number")
    private int moNumber;


    public MobileNumber() {
    }

    public MobileNumber(String type, int moNumber) {
        this.type = type;
        this.moNumber = moNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMoNumber() {
        return moNumber;
    }

    public void setMoNumber(int moNumber) {
        this.moNumber = moNumber;
    }

    @Override
    public String toString() {
        return "MobileNumber{" +
                "type='" + type + '\'' +
                ", moNumber=" + moNumber +
                '}';
    }
}
