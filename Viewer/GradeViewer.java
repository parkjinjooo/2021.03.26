package Viewer;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.GradeController;
import Model.GradeDTO;
import Model.UserDTO;
import util.ScannerUtil;

public class GradeViewer {
    private Scanner sc;
    private GradeController controller;
    private UserViewer userViewer;

    public GradeViewer() {
        sc = new Scanner(System.in);
        controller = new GradeController();
        userViewer = new UserViewer();

    }

    public void printList(int movieId) {
        ArrayList<UserDTO> userList = userViewer.selectAll();
        ArrayList<GradeDTO> list = controller.selectByMovie(userList, movieId);
        String msg;
        for (GradeDTO g : list) {
            int writeId = g.getWriteId();
            UserDTO u = new UserDTO();
            u.setId(writeId);
            int userIndex = userList.indexOf(u);
            u = userList.get(userIndex);

            System.out.println("-------------------------------");
            System.out.printf("%d.%s\n", g.getId(), u.getNickName());
            System.out.printf("%d\n", g.getMovieNumber());
            System.out.printf("%s/%s\n", g.getGrade(), g.getReview());
            System.out.println("-------------------------------");
        }

        msg = new String("�׷캰 ��������");
        msg = new String("1.�Ϲ� ���� 2. ��а� ����");
        int group = ScannerUtil.nextInt(sc, msg, 1, 2);
        printOne(movieId, group);

    }

    public void printOne(int movieId, int group) {
        ArrayList<UserDTO> list = userViewer.selectAll();
        ArrayList<GradeDTO> filteredList = controller.selectGradeByGroup(list, group, movieId);
        if (filteredList.isEmpty()) {
            System.out.println("���� �ƹ��� ����� �����ϴ�!");
        }
        for (GradeDTO g : filteredList) {
            // 1. g���� ������ �� ȸ���� id���� �ҷ��´�.
            int writeId = g.getWriteId();
            // 2. UserDTO �ӽ� ��ü u�� �ϳ� �����.
            UserDTO u = new UserDTO();
            // 3. �ӽ� ��ü u�� id�� int writeId�� �ִ´�.
            u.setId(writeId);
            // 4. ��ü ȸ�� ����Ʈ�� userList����
            // indexOf() �޼ҵ带 ���ؼ�
            // �ӽ� ��ü u�� id�� ���� ������Ʈ�� ã�´�.
            int userIndex = list.indexOf(u);
            // 5. �ӽ� ��ü u�� ������ ������ �ҷ����� ���ؼ�
            // get(userIndex)�� u�� ���� �����.
            u = list.get(userIndex);

            System.out.println("-------------------------------");
            System.out.println("ȸ�� �г���: " + u.getNickName());
            System.out.println("����: " + g.getGrade());
            System.out.println("���: " + g.getReview());
            System.out.println("-------------------------------");
        }

    }

}
