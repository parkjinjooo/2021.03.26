package Viewer;

import java.util.Scanner;
import Model.UserDTO;
import Model.MovieDTO;
import util.ScannerUtil;

public class MainViewer {
    private UserViewer userViewer;
    private MovieViewer movieViewer;
    private CinemaViewer cinemaViewer;
    private ScreenInfoViewer screenInfoViewer;
    private Scanner sc;

    public MainViewer() {
        movieViewer = new MovieViewer();
        userViewer = new UserViewer();
        screenInfoViewer = new ScreenInfoViewer();
        cinemaViewer = new CinemaViewer(screenInfoViewer);
        
        screenInfoViewer.setCinemaViewer(cinemaViewer);
        sc = new Scanner(System.in);
    }

    public void showIndex() {
        while (true) {
            System.out.println("*************** MOVIE ***************");
            String msg = new String("1. �α��� 2. ȸ������ 3. ����");
            int uc = ScannerUtil.nextInt(sc, msg, 1, 3);
            if (uc == 1) {
                if (uc == 1) {
                    int group = userViewer.logIn();
                    // UserController�� �׷� ���� ����
                    if (group == 1) {
                        // �Ϲ�
                        showMenu(group);
                    } else if (group == 2) {
                        // ��а�
                        showMenu(group);
                    } else if (group == 3) {
                        // ������
                        showAdminMenu(group);
                    }
                }
                // ȸ������
            } else if (uc == 2) {
                msg = new String("1. �Ϲ��� 2. ��а�");
                uc = ScannerUtil.nextInt(sc, msg, 1, 2);
                userViewer.register(uc);

            } else if (uc == 3) {
                System.out.println("������ּż� �����մϴ�.");
                break;
            }

        }
    }

    public void showMenu(int group) {
        while (true) {
            String msg = new String("1. ��ȭ��� ���� 2. ������ ���� 3. ����");
            int uc = ScannerUtil.nextInt(sc, msg, 1, 4);
            if (uc == 1) {
                movieViewer.printList(group);
            } else if (uc == 2) {
                // CinemaViewer();
                cinemaViewer.printList(group);
            } else if (uc == 3) {
                System.out.println("�ʱ�ȭ������ ���ư��ϴ�.");
                break;

            }

        }
    }

    public void showAdminMenu(int group) {
        while (true) {
            String msg = new String("1. ��ȭ���� 2. ������� 3. ������ ���� 4. ����");
            int uc = ScannerUtil.nextInt(sc, msg, 1, 4);
            if (uc == 1) {
                // MovieViewer()
                movieViewer.printList(group);
            } else if (uc == 2) {
                // CinemaViewer()
                cinemaViewer.printList(group);
            } else if (uc == 3) {
                // ScreenInfoViwer
                // ��ȭ�� ����� ���� ����
                cinemaViewer.printForScreenInfo(group);
            } else if (uc == 4) {
                System.out.println("�ʱ�ȭ������ ���ư��ϴ�.");
                break;
            }
        }

    }
}