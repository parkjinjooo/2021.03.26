package Controller;

import java.util.ArrayList;

import Model.UserDTO;

public class UserController {
    // 데이터베이스 대신 사용할 ArrayList<>객체 list
    // 데이터베이스 대신 사용할 int 객체 id
    private int id;
    private ArrayList<UserDTO> list;
    private final int PEOPLE = 1;
    private final int CRITIC = 2;
    private final int ADMIN = 3;

    public UserController() {
        list = new ArrayList<>();
        id = 1;

        // 관리자
        UserDTO u = new UserDTO();
        u.setId(id++);
        u.setUserName("m1");
        u.setPassword("1");
        u.setNickName("Manager1");
        u.setGroup(ADMIN);

        list.add(u);

        u = new UserDTO();
        u.setId(id++);
        u.setUserName("s1");
        u.setPassword("1");
        u.setNickName("Critic1");
        u.setGroup(CRITIC);

        list.add(u);

        u = new UserDTO();
        u.setId(id++);
        u.setUserName("s2");
        u.setPassword("2");
        u.setNickName("Normal2");
        u.setGroup(PEOPLE);

        list.add(u);

        u = new UserDTO();
        u.setId(id++);
        u.setUserName("s3");
        u.setPassword("3");
        u.setNickName("Normal3");
        u.setGroup(PEOPLE);

        list.add(u);

    }

    // 2. 사용자 로그인 권한
    public UserDTO auth(UserDTO user) {
        for (UserDTO u : list) {
            if (user.getUserName().equals(u.getUserName()) && user.getPassword().equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    // 3. 사용자로부터 입력받은 userDTO 객체를
    // 리스트에 추가해주는 add()메소드
    public void add(UserDTO u) {
        u.setId(id++);
        list.add(u);
    }

    // 4. 사용자가 입력한 ID와 중복되는 ID가 있으면
    // true를 리턴하는 validateUsername() 메소드 (회원가입 영역)
    public boolean validateUsername(UserDTO user) {
        for (UserDTO u : list) {
            if (u.getUserName().equals(user.getUserName())) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> temp = new ArrayList<>();
        for (UserDTO u : list) {
            temp.add(u);

        }
        return temp;

    }

    // 현재 로그인한 객체의 아이디 값과 같은 그룹을 리턴해주는 메소드
    public ArrayList<UserDTO> selectGroupById(UserDTO user) {
        ArrayList<UserDTO> temp = new ArrayList<>();
        for (UserDTO u : list) {
            if (u.getGroup() == user.getGroup()) {
                temp.add(u);
            }
        }
        return temp;
    }

    // 5. 사용자가 입력한 group이 중복인지 체크하는 vaildateGroup()메소드
    // (일반 사용자와 평론가 사용자의 구분을 위함)
//    public boolean vaildateGroup(userDTO user) {
//        for(userDTO u : list) {
//            if(u.getGroup() == user.getGroup()) {
//                return true;
//            }
//        }
//        return false;
//    }

    // 6. 사용자가 파라미터로 넘겨준 int 값과 일치하는 group을 가진
    // userDTO를 리턴해주는 selectOneByGroup 메소드
//    public userDTO selectByOneGroup(int group) {
//        for(userDTO u : list) {
//            if(u.getGroup() == group) {
//                return u;
//            }
//        }
//        return null;
//    }

}
