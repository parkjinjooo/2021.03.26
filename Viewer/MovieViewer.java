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

                String msg = new String("개별 보기할 번호를 입력하시거나 뒤로 가실려면 0을 입력해주세요. ");
                int id = ScannerUtil.nextInt(sc, msg);

                MovieDTO m = controller.selectOne(id);

                while (!(id == 0 || list.contains(m))) {
                    System.out.println("상영중인 영화가 아닙니다.");
                    System.out.println("다시 선택해주세요.");
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
                String msg = new String("1. 새로운 영화등록 2. 영화수정 3. 영화삭제 4.뒤로 돌아가기");
                int uc = ScannerUtil.nextInt(sc, msg, 1, 4);
                if (uc == 1) {
                    add();
                } else if (uc == 2) {
                    msg = new String("수정할 영화의 번호를 입력하세요.");
                    int id = ScannerUtil.nextInt(sc, msg);

                    MovieDTO m = controller.selectOne(id);
                    while (m == null) {
                        System.out.println("잘못 입력하셨습니다.");
                        id = ScannerUtil.nextInt(sc, msg);
                        m = controller.selectOne(id);
                    }

                    update(id);

                } else if (uc == 3) {
                    msg = new String("삭제할 영화의 번호를 입력하세요.");
                    int id = ScannerUtil.nextInt(sc, msg);

                    MovieDTO m = controller.selectOne(id);
                    while (m == null) {
                        System.out.println("잘못 입력하셨습니다. ");
                        id = ScannerUtil.nextInt(sc, msg);
                        m = controller.selectOne(id);
                    }

                    delete(id);
                } else if (uc == 4) {
                    System.out.println("이전 화면으로 돌아갑니다.");
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

        // 로그인의 상수 값에 따라 평점 남기기 다르게
    }

    public void add() {
        MovieDTO m = new MovieDTO();
        String msg = new String("영화제목을 입력해주세요.");
        m.setTitle(ScannerUtil.nextLine(sc, msg));
        msg = new String("영화줄거리를 입력해주세요.");
        m.setContent(ScannerUtil.nextLine(sc, msg));
        msg = new String("영화등급 입력해주세요.");
        m.setRank(ScannerUtil.nextLine(sc, msg));
        controller.add(m);

    }

    public void update(int id) {
        MovieDTO m = controller.selectOne(id);
        String msg = new String("영화제목을 입력해주세요.");
        m.setTitle(ScannerUtil.nextLine(sc, msg));
        msg = new String("영화줄거리를 입력해주세요.");
        m.setContent(ScannerUtil.nextLine(sc, msg));
        msg = new String("영화등급 입력해주세요.");
        m.setRank(ScannerUtil.nextLine(sc, msg));

        controller.update(m);
    }

    public void delete(int id) {
        MovieDTO m = controller.selectOne(id);
        if (m.getId() == id) {
            String msg = new String("정말로 삭제하시겠습니까? y/n");
            String yesNo = ScannerUtil.nextLine(sc, msg);
            if (yesNo.equalsIgnoreCase("y")) {
                controller.delete(m);
            }
        }

    }

}
