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
    // 선택한 극장 상영정보만 보여주는 객체

    public ScreenInfoViewer() {
        sc = new Scanner(System.in);
        controller = new ScreenInfoController();
        movieController = new MovieController();
    }

    public void setCinemaViewer(CinemaViewer cinemaViewer) {
        this.cinemaViewer = cinemaViewer;
    }

    // 선택한 극장의 상영정보 전체 보기(일반, 평론가용)
    // uc는 일반 평론가가 입력한 극장 id
    public void infoList(int uc) {
        // 상영정보 번호, 영화 번호, 극장 번호 상영시간
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

                // 상영번호, 상영시간 그대로 나열, 영화번호는 영화제목, 극장번호는 극장이름으로
                System.out.printf("상영번호: %02d 영화이름: %s 상영시간: %s\n", s.getId(), m.getTitle(), s.getShowingTime());
            }

            System.out.println("----------------------------------------------");
            msg = new String("0. 뒤로 돌아가기");
            int userChoice = ScannerUtil.nextInt(sc, msg, 0, 0);
            if (userChoice == 0) {
                break;
            }
        }

    }

    // 선택한 극장의 상영 전체 목록을 보여주는 메소드 (관리자용)
    public void adminInfoList(int uc) {
        // 상영정보 번호, 영화 번호, 극장 번호 상영시간
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

                // 상영번호, 상영시간 그대로 나열, 영화번호는 영화제목, 극장번호는 극장이름으로
                System.out.printf("상영번호: %02d 영화번호: %02d 영화이름: %s 극장번호: %02d 극장이름: %s 상영시간: %s시 \n", s.getId(),
                        s.getMovieId(), m.getTitle(), c.getId(), c.getName(), s.getShowingTime());
            }

            System.out.println("----------------------------------------------");
            msg = new String("1. 상영정보 새로 등록 2. 상영정보 수정 3. 상영정보 삭제 0. 뒤로 돌아가기");
            int userChoice = ScannerUtil.nextInt(sc, msg, 0, 3);
            if (userChoice == 0) {
                break;
            } else if (userChoice == 1) {
                insert(uc);

            } else if (userChoice == 2) {
                msg = new String("수정할 상영정보 번호를 입력하세요.");
                userChoice = ScannerUtil.nextInt(sc, msg);

                ScreenInfoDTO s = controller.selectOne(userChoice);

                while (s == null || !list.contains(s)) {
                    System.out.println("잘못 입력하셧습니다.");
                    userChoice = ScannerUtil.nextInt(sc, msg);
                    s = controller.selectOne(userChoice);
                }

                showUpdate(userChoice);

            } else if (userChoice == 3) {
                msg = new String("삭제할 상영정보 번호를 입력하세요.");
                userChoice = ScannerUtil.nextInt(sc, msg);

                ScreenInfoDTO s = controller.selectOne(userChoice);
                while (s == null || !list.contains(s)) {
                    System.out.println("잘못 입력하셧습니다.");
                    userChoice = ScannerUtil.nextInt(sc, msg);
                    s = controller.selectOne(userChoice);
                }
                delete(userChoice);

            }
        }

    }

    // 관리자용 수정 메소드 (id값은 상영정보 번호)
    public void showUpdate(int id) {
        ScreenInfoDTO s = controller.selectOne(id);
        String msg;

        // 상영시간
        msg = new String("상영시간 입력");
        s.setShowingTime(ScannerUtil.nextLine(sc, msg));

        controller.update(s);

    }

    // 관리자용 삭제 메소드(id값은 상영정보 번호
    public void delete(int id) {
        ScreenInfoDTO s = controller.selectOne(id);
        if (s.getId() == id) {
            String msg = new String("정말로 삭제하시겠습니까? Y/N");
            String yesNo = ScannerUtil.nextLine(sc, msg);
            if (yesNo.equalsIgnoreCase("y")) {
                controller.delete(s);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 관리자용 상영정보 등록 메소드
    public void insert(int uc) {
        System.out.println("새 상영정보를 등록합니다.");
        String msg;
        ScreenInfoDTO s = new ScreenInfoDTO();

        ArrayList<MovieDTO> movieList = movieController.selectAll();

        // 영화번호 등록-> 영화이름, 번호 보여줘야함
        System.out.println("----------------------------------------------");
        for (MovieDTO m : movieList) {
            System.out.printf("영화번호: %02d 영화이름: %s\n", m.getId(), m.getTitle());
        }
        System.out.println("----------------------------------------------");
        msg = new String("추가할 영화의 번호를 입력하세요.");

        int mc = ScannerUtil.nextInt(sc, msg);
        MovieDTO m = movieController.selectOne(mc);

        s.setMovieId(m.getId());
        s.setCinemaId(uc);

        msg = new String("상영시간을 입력하세요.");
        s.setShowingTime(ScannerUtil.nextLine(sc, msg));

        controller.add(s);

    }

}
