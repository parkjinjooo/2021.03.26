package Viewer;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.MovieController;
import Model.MovieDTO;
import util.ScannerUtil;

public class MovieViewer {
    private Scanner sc;
    private MovieController controller;
    private GradeViewer gradeViewer;

    public MovieViewer() {
        sc = new Scanner(System.in);
        controller = new MovieController();
        gradeViewer = new GradeViewer();
    }

    public void printList(int group) {
        while (true) {
            ArrayList<MovieDTO> list = controller.selectAll();

            System.out.println("================================");
            for (MovieDTO m : list) {
                System.out.printf("%d. %s (%s)\n", m.getId(), m.getTitle(), m.getRank());
            }
            System.out.println("================================");

            if (group == 1 || group == 2) {

                String msg = new String("���� ������ ��ȣ�� �Է��Ͻðų� �ڷ� ���Ƿ��� 0�� �Է����ּ���. ");
                int id = ScannerUtil.nextInt(sc, msg);

                MovieDTO m = controller.selectOne(id);

                while (!(id == 0 || list.contains(m))) {
                    System.out.println("������ ��ȭ�� �ƴմϴ�.");
                    System.out.println("�ٽ� �������ּ���.");
                    id = ScannerUtil.nextInt(sc, msg);
                    m = controller.selectOne(id);
                }

                if (id == 0) {
                    break;
                } else {
                    printOne(id);
                    gradeViewer.printList(id);

                }
            } else if (group == 3) {
                String msg = new String("1. ���ο� ��ȭ��� 2. ��ȭ���� 3. ��ȭ���� 4.�ڷ� ���ư���");
                int uc = ScannerUtil.nextInt(sc, msg, 1, 4);
                if (uc == 1) {
                    add();
                } else if (uc == 2) {
                    msg = new String("������ ��ȭ�� ��ȣ�� �Է��ϼ���.");
                    int id = ScannerUtil.nextInt(sc, msg);

                    MovieDTO m = controller.selectOne(id);
                    while (m == null) {
                        System.out.println("�߸� �Է��ϼ̽��ϴ�.");
                        id = ScannerUtil.nextInt(sc, msg);
                        m = controller.selectOne(id);
                    }

                    update(id);

                } else if (uc == 3) {
                    msg = new String("������ ��ȭ�� ��ȣ�� �Է��ϼ���.");
                    int id = ScannerUtil.nextInt(sc, msg);

                    MovieDTO m = controller.selectOne(id);
                    while (m == null) {
                        System.out.println("�߸� �Է��ϼ̽��ϴ�. ");
                        id = ScannerUtil.nextInt(sc, msg);
                        m = controller.selectOne(id);
                    }

                    delete(id);
                } else if (uc == 4) {
                    System.out.println("���� ȭ������ ���ư��ϴ�.");
                    break;
                }

            }
        }
    }

    public void printOne(int id) {
        MovieDTO m = controller.selectOne(id);
        System.out.println("-------------------------------");
        System.out.printf("%d.%s\n", m.getId(), m.getTitle());
        System.out.printf("%s\n", m.getContent());
        System.out.printf("%s\n", m.getRank());
        System.out.println("-------------------------------");

        // �α����� ��� ���� ���� ���� ����� �ٸ���
    }

    public void add() {
        MovieDTO m = new MovieDTO();
        String msg = new String("��ȭ������ �Է����ּ���.");
        m.setTitle(ScannerUtil.nextLine(sc, msg));
        msg = new String("��ȭ�ٰŸ��� �Է����ּ���.");
        m.setContent(ScannerUtil.nextLine(sc, msg));
        msg = new String("��ȭ��� �Է����ּ���.");
        m.setRank(ScannerUtil.nextLine(sc, msg));
        controller.add(m);

    }

    public void update(int id) {
        MovieDTO m = controller.selectOne(id);
        String msg = new String("��ȭ������ �Է����ּ���.");
        m.setTitle(ScannerUtil.nextLine(sc, msg));
        msg = new String("��ȭ�ٰŸ��� �Է����ּ���.");
        m.setContent(ScannerUtil.nextLine(sc, msg));
        msg = new String("��ȭ��� �Է����ּ���.");
        m.setRank(ScannerUtil.nextLine(sc, msg));

        controller.update(m);
    }

    public void delete(int id) {
        MovieDTO m = controller.selectOne(id);
        if (m.getId() == id) {
            String msg = new String("������ �����Ͻðڽ��ϱ�? y/n");
            String yesNo = ScannerUtil.nextLine(sc, msg);
            if (yesNo.equalsIgnoreCase("y")) {
                controller.delete(m);
            }
        }

    }

}
