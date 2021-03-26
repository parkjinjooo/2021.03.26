package Model;

public class UserDTO {

    // 회원번호
    private int id;

    // 아아디
    private String userName;

    // 비밀번호
    private String password;

    // 닉네임
    private String nickName;

    // 등급
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
