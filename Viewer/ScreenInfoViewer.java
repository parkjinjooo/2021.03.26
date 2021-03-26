package Viewer;

import Model.CinemaDTO;
import Model.MovieDTO;
import Model.ScreenInfoDTO;
import util.ScannerUtil;

import Controller.CinemaController;
import Controller.MovieController;
import Controller.ScreenInfoController;
import java.util.ArrayList;
import java.util.Scanner;

public class ScreenInfoViewer {
    private Scanner sc;
    private ScreenInfoController controller;
    private CinemaViewer cinemaViewer;
    private MovieController movieController;
    // ������ ���� �������� �����ִ� ��ü

    public ScreenInfoViewer() {
        sc = new Scanner(System.in);
        controller = new ScreenInfoController();
        movieController = new MovieController();
    }

    public void setCinemaViewer(CinemaViewer cinemaViewer) {
        this.cinemaViewer = cinemaViewer;
    }

    // ������ ������ ������ ��ü ����(�Ϲ�, ��а���)
    // uc�� �Ϲ� ��а��� �Է��� ���� id
    public void infoList(int uc) {
        // ������ ��ȣ, ��ȭ ��ȣ, ���� ��ȣ �󿵽ð�
        ArrayList<ScreenInfoDTO> list = controller.selectByGroup(uc);
        ArrayList<MovieDTO> movieList = movieController.selectAll();
        String msg;

        while (true) {
            System.out.println("----------------------------------------------");
            for (ScreenInfoDTO s : list) {
                int movieId = s.getMovieId();
                MovieDTO m = new MovieDTO();
                m.setId(movieId);
                int movieIndex = movieList.indexOf(m);
                m = movieList.get(movieIndex);

                // �󿵹�ȣ, �󿵽ð� �״�� ����, ��ȭ��ȣ�� ��ȭ����, �����ȣ�� �����̸�����
                System.out.printf("�󿵹�ȣ: %02d ��ȭ�̸�: %s �󿵽ð�: %s\n", s.getId(), m.getTitle(), s.getShowingTime());
            }

            System.out.println("----------------------------------------------");
            msg = new String("0. �ڷ� ���ư���");
            int userChoice = ScannerUtil.nextInt(sc, msg, 0, 0);
            if (userChoice == 0) {
                break;
            }
        }

    }

    // ������ ������ �� ��ü ����� �����ִ� �޼ҵ� (�����ڿ�)
    public void adminInfoList(int uc) {
        // ������ ��ȣ, ��ȭ ��ȣ, ���� ��ȣ �󿵽ð�
        String msg;

        while (true) {

            ArrayList<MovieDTO> movieList = movieController.selectAll();
            ArrayList<CinemaDTO> cinemaList = cinemaViewer.sendAll();
            ArrayList<ScreenInfoDTO> list = controller.selectByGroup(uc);

            System.out.println("----------------------------------------------");

            for (ScreenInfoDTO s : list) {
                int movieId = s.getMovieId();
                MovieDTO m = new MovieDTO();
                m.setId(movieId);
                int movieIndex = movieList.indexOf(m);
                m = movieList.get(movieIndex);

                int cinemaId = s.getCinemaId();
                CinemaDTO c = new CinemaDTO();
                c.setId(cinemaId);
                int cinemaIndex = cinemaList.indexOf(c);
                c = cinemaList.get(cinemaIndex);

                // �󿵹�ȣ, �󿵽ð� �״�� ����, ��ȭ��ȣ�� ��ȭ����, �����ȣ�� �����̸�����
                System.out.printf("�󿵹�ȣ: %02d ��ȭ��ȣ: %02d ��ȭ�̸�: %s �����ȣ: %02d �����̸�: %s �󿵽ð�: %s�� \n", s.getId(),
                        s.getMovieId(), m.getTitle(), c.getId(), c.getName(), s.getShowingTime());
            }

            System.out.println("----------------------------------------------");
            msg = new String("1. ������ ���� ��� 2. ������ ���� 3. ������ ���� 0. �ڷ� ���ư���");
            int userChoice = ScannerUtil.nextInt(sc, msg, 0, 3);
            if (userChoice == 0) {
                break;
            } else if (userChoice == 1) {
                insert(uc);

            } else if (userChoice == 2) {
                msg = new String("������ ������ ��ȣ�� �Է��ϼ���.");
                userChoice = ScannerUtil.nextInt(sc, msg);

                ScreenInfoDTO s = controller.selectOne(userChoice);

                while (s == null || !list.contains(s)) {
                    System.out.println("�߸� �Է��ϼ˽��ϴ�.");
                    userChoice = ScannerUtil.nextInt(sc, msg);
                    s = controller.selectOne(userChoice);
                }

                showUpdate(userChoice);

            } else if (userChoice == 3) {
                msg = new String("������ ������ ��ȣ�� �Է��ϼ���.");
                userChoice = ScannerUtil.nextInt(sc, msg);

                ScreenInfoDTO s = controller.selectOne(userChoice);
                while (s == null || !list.contains(s)) {
                    System.out.println("�߸� �Է��ϼ˽��ϴ�.");
                    userChoice = ScannerUtil.nextInt(sc, msg);
                    s = controller.selectOne(userChoice);
                }
                delete(userChoice);

            }
        }

    }

    // �����ڿ� ���� �޼ҵ� (id���� ������ ��ȣ)
    public void showUpdate(int id) {
        ScreenInfoDTO s = controller.selectOne(id);
        String msg;

        // �󿵽ð�
        msg = new String("�󿵽ð� �Է�");
        s.setShowingTime(ScannerUtil.nextLine(sc, msg));

        controller.update(s);

    }

    // �����ڿ� ���� �޼ҵ�(id���� ������ ��ȣ
    public void delete(int id) {
        ScreenInfoDTO s = controller.selectOne(id);
        if (s.getId() == id) {
            String msg = new String("������ �����Ͻðڽ��ϱ�? Y/N");
            String yesNo = ScannerUtil.nextLine(sc, msg);
            if (yesNo.equalsIgnoreCase("y")) {
                controller.delete(s);
            } else {
                System.out.println("�߸��� �Է��Դϴ�.");
            }
        }
    }

    // �����ڿ� ������ ��� �޼ҵ�
    public void insert(int uc) {
        System.out.println("�� �������� ����մϴ�.");
        String msg;
        ScreenInfoDTO s = new ScreenInfoDTO();

        ArrayList<MovieDTO> movieList = movieController.selectAll();

        // ��ȭ��ȣ ���-> ��ȭ�̸�, ��ȣ ���������
        System.out.println("----------------------------------------------");
        for (MovieDTO m : movieList) {
            System.out.printf("��ȭ��ȣ: %02d ��ȭ�̸�: %s\n", m.getId(), m.getTitle());
        }
        System.out.println("----------------------------------------------");
        msg = new String("�߰��� ��ȭ�� ��ȣ�� �Է��ϼ���.");

        int mc = ScannerUtil.nextInt(sc, msg);
        MovieDTO m = movieController.selectOne(mc);

        s.setMovieId(m.getId());
        s.setCinemaId(uc);

        msg = new String("�󿵽ð��� �Է��ϼ���.");
        s.setShowingTime(ScannerUtil.nextLine(sc, msg));

        controller.add(s);

    }

}
