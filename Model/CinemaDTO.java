package Model;

public class CinemaDTO {
    // 1. �ʵ�
    // ���� ������ȣ
    private int id;
    // ���� �̸�
    private String name;
    // ���� ��ġ
    private String location;
    // ���� ��ȭ��ȣ
    private String phoneNumber;

    // 2. �޼ҵ�
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
