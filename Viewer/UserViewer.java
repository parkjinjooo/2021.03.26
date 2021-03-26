package Viewer;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.UserController;
import Model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
    private Scanner sc;
    private UserController controller;
    // �Ϲ� �����
    private UserDTO userLogin;
    // ��а� �����
    private UserDTO criticLogin;
    // ������ �����
    private UserDTO adminLogin;

    // 1. ������, ���� �ʵ� ����
    public UserViewer() {
        sc = new Scanner(System.in);
        controller = new UserController();

    }

    // 2. ȸ������ ��� �޼ҵ�
    public void register(int group) {
        UserDTO u = new UserDTO();

        String msg;

        msg = new String("����� ���̵� �Է�");
        u.setUserName(ScannerUtil.nextLine(sc, msg));

        // �ߺ� ���̵� ����
        while (controller.validateUsername(u)) {
            System.out.println("�ߺ��� ���̵�, �ٸ� ���̵� �Է�");
            u.setUserName(ScannerUtil.nextLine(sc, msg));
        }

        msg = new String("����� ��й�ȣ �Է�");
        u.setPassword(ScannerUtil.nextLine(sc, msg));

        msg = new String("����� �̸� �Է�");
        u.setUserName(ScannerUtil.nextLine(sc, msg));

        msg = new String("����� �г��� �Է�");
        u.setNickName(ScannerUtil.nextLine(sc, msg));

        u.setGroup(group);

        // ��Ʈ�ѷ� add �޼ҵ� ȣ��
        controller.add(u);
    }

    // 3. �α��� ��� �޼ҵ�
    public int logIn() {
        // 2-1. �α����� ��ü�� ������ ���� �л� ��ü s�� ����
        UserDTO u = new UserDTO();

        // 2-2. ��¿� ����� �޼����� ���� String ��ü msg ����
        String msg;

        // 2-3. ���̵� �Է�
        msg = new String("���̵� �Է����ּ���.");
        u.setUserName(ScannerUtil.nextLine(sc, msg));

        // 2-4. ��� �Է�
        msg = new String("��й�ȣ�� �Է����ּ���.");
        u.setPassword(ScannerUtil.nextLine(sc, msg));

        // 2-5. s�� �ش� ������ ��Ƽ� ��Ʈ�ѷ��� �����ش�.
        UserDTO result = controller.auth(u);

        // 2-6. ���� ����� null�̸� �ٽ� �Է��� �ްų�
        // �ڷ� ���ư� �� ���´�.
        while (result == null) {
            System.out.println("�߸� �Է��Ͽ��ų� �������� �ʴ� �����Դϴ�.");
            msg = new String("�ٽ� �Է� �Ͻðڽ��ϱ�? �ٽ� �Է��Ϸ��� y�� �Է����ּ���.");
            String agree = ScannerUtil.nextLine(sc, msg);
            if (!agree.equalsIgnoreCase("y")) {
                return -1;
            }
            msg = new String("���̵� �Է����ּ���.");
            u.setUserName(ScannerUtil.nextLine(sc, msg));

            msg = new String("��й�ȣ�� �Է����ּ���.");
            u.setPassword(ScannerUtil.nextLine(sc, msg));

            result = controller.auth(u);
        }

        return result.getGroup();
    }

    // 4. ����� �α׾ƿ�
    public void logOut() {
        System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
        userLogin = null;
    }

    // ���� �α��� ��ü�� �������ִ� �޼ҵ�

    public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> list = controller.selectAll();

        return list;

    }

    // 5. ��Ʈ�ѷ��κ��� ȸ�� ��ü ����� ������
    // selectAll() �޼ҵ�

}
