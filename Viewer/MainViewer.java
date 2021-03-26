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
            String msg = new String("1. 로그인 2. 회원가입 3. 종료");
            int uc = ScannerUtil.nextInt(sc, msg, 1, 3);
            if (uc == 1) {
                if (uc == 1) {
                    int group = userViewer.logIn();
                    // UserController의 그룹 값을 리턴
                    if (group == 1) {
                        // 일반
                        showMenu(group);
                    } else if (group == 2) {
                        // 평론가
                        showMenu(group);
                    } else if (group == 3) {
                        // 관리자
                        showAdminMenu(group);
                    }
                }
                // 회원가입
            } else if (uc == 2) {
                msg = new String("1. 일반인 2. 평론가");
                uc = ScannerUtil.nextInt(sc, msg, 1, 2);
                userViewer.register(uc);

            } else if (uc == 3) {
                System.out.println("사용해주셔서 갑사합니다.");
                break;
            }

        }
    }

    public void showMenu(int group) {
        while (true) {
            String msg = new String("1. 영화목록 보기 2. 극장목록 보기 3. 종료");
            int uc = ScannerUtil.nextInt(sc, msg, 1, 4);
            if (uc == 1) {
                movieViewer.printList(group);
            } else if (uc == 2) {
                // CinemaViewer();
                cinemaViewer.printList(group);
            } else if (uc == 3) {
                System.out.println("초기화면으로 돌아갑니다.");
                break;

            }

        }
    }

    public void showAdminMenu(int group) {
        while (true) {
            String msg = new String("1. 영화관리 2. 극장관리 3. 상영정보 관리 4. 종료");
            int uc = ScannerUtil.nextInt(sc, msg, 1, 4);
            if (uc == 1) {
                // MovieViewer()
                movieViewer.printList(group);
            } else if (uc == 2) {
                // CinemaViewer()
                cinemaViewer.printList(group);
            } else if (uc == 3) {
                // ScreenInfoViwer
                // 영화관 목록을 띄우고 실행
                cinemaViewer.printForScreenInfo(group);
            } else if (uc == 4) {
                System.out.println("초기화면으로 돌아갑니다.");
                break;
            }
        }

    }
}