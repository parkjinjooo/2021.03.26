package Model;

public class UserDTO {

    // ȸ����ȣ
    private int id;

    // �ƾƵ�
    private String userName;

    // ��й�ȣ
    private String password;

    // �г���
    private String nickName;

    // ���
    private int group;

    // getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    // equals()
    public boolean equals(Object o) {
        if (o instanceof UserDTO) {
            UserDTO u = (UserDTO) o;
            if (id == u.id) {
                return true;
            }
        }
        return false;
    }

}
