package Model;

public class CinemaDTO {
    // 1. 필드
    // 극장 고유번호
    private int id;
    // 극장 이름
    private String name;
    // 극장 위치
    private String location;
    // 극장 전화번호
    private String phoneNumber;

    // 2. 메소드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // equals
    public boolean equals(Object o) {
        if (o instanceof CinemaDTO) {
            CinemaDTO c = (CinemaDTO) o;
            if (id == c.id) {
                return true;
            }
        }

        return false;
    }

}
