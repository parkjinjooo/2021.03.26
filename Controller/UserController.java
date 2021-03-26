package Controller;

import java.util.ArrayList;

import Model.UserDTO;

public class UserController {
    // �����ͺ��̽� ��� ����� ArrayList<>��ü list
    // �����ͺ��̽� ��� ����� int ��ü id
    private int id;
    private ArrayList<UserDTO> list;
    private final int PEOPLE = 1;
    private final int CRITIC = 2;
    private final int ADMIN = 3;

    public UserController() {
        list = new ArrayList<>();
        id = 1;

        // ������
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

    // 2. ����� �α��� ����
    public UserDTO auth(UserDTO user) {
        for (UserDTO u : list) {
            if (user.getUserName().equals(u.getUserName()) && user.getPassword().equals(u.getPassword())) {
                return u;
            }
        }
        return null;
    }

    // 3. ����ڷκ��� �Է¹��� userDTO ��ü��
    // ����Ʈ�� �߰����ִ� add()�޼ҵ�
    public void add(UserDTO u) {
        u.setId(id++);
        list.add(u);
    }

    // 4. ����ڰ� �Է��� ID�� �ߺ��Ǵ� ID�� ������
    // true�� �����ϴ� validateUsername() �޼ҵ� (ȸ������ ����)
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

    // ���� �α����� ��ü�� ���̵� ���� ���� �׷��� �������ִ� �޼ҵ�
    public ArrayList<UserDTO> selectGroupById(UserDTO user) {
        ArrayList<UserDTO> temp = new ArrayList<>();
        for (UserDTO u : list) {
            if (u.getGroup() == user.getGroup()) {
                temp.add(u);
            }
        }
        return temp;
    }

    // 5. ����ڰ� �Է��� group�� �ߺ����� üũ�ϴ� vaildateGroup()�޼ҵ�
    // (�Ϲ� ����ڿ� ��а� ������� ������ ����)
//    public boolean vaildateGroup(userDTO user) {
//        for(userDTO u : list) {
//            if(u.getGroup() == user.getGroup()) {
//                return true;
//            }
//        }
//        return false;
//    }

    // 6. ����ڰ� �Ķ���ͷ� �Ѱ��� int ���� ��ġ�ϴ� group�� ����
    // userDTO�� �������ִ� selectOneByGroup �޼ҵ�
//    public userDTO selectByOneGroup(int group) {
//        for(userDTO u : list) {
//            if(u.getGroup() == group) {
//                return u;
//            }
//        }
//        return null;
//    }

}
