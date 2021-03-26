package Viewer;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.CinemaController;
import Model.CinemaDTO;
import util.ScannerUtil;

public class CinemaViewer {
    private Scanner sc;
    private CinemaController controller;
    private ScreenInfoViewer screenInfoViewer;

    public CinemaViewer(ScreenInfoViewer screenInfoViewer) {
        sc = new Scanner(System.in);
        controller = new CinemaController();
        this.screenInfoViewer = screenInfoViewer;
    }

    // 극장 전체 목록을 보여주는 메소드
    // 극장 id로 극장을 가져올것
    // 극장리스트에 보여줄 정보
    // 극장 이름, 극장 위치, 극장 전화번호
    public void printList(int group) {
        while (true) {
            // 극장 전체 목록 가져오기
            ArrayList<CinemaDTO> list = controller.selectAll();

            System.out.println("----------------------------------------------");
            for (CinemaDTO c : list) {
                // 출력 부분
                System.out.println();
                System.out.printf("번호: %02d 극장이름: %s\n극장위치: %s 전화번호: %s\n", c.getId(), c.getName(), c.getLocation(),
                        c.getPhoneNumber());
                System.out.println();
            }
            System.out.println("----------------------------------------------");

            // 등록된 영화관이 없을 때
            if (list.size() == 0) {
                System.out.println("등록된 영화관이 없습니다.\n뒤로 돌아갑니다.");
                break;
            }

            // 각 영화관 선택 (일반, 평론가)
            if (group == 1 || group == 2) {
                String msg = new String("각 영화관 별 상영영화 목록을 보시려면 극장 번호를 " + "입력하세요.\n" + "뒤로 돌아가시려면 0을 입력하세요.");
                int uc = ScannerUtil.nextInt(sc, msg);

                if (uc == 0) {
                    System.out.println("뒤로 돌아갑니다.");
                    break;
                } else {
                    // ScreenViewer 실행
                    // uc는 CinemaDTO의 id 값
                    screenInfoViewer.infoList(uc);
                }
            }

            if (group == 3) {
                String msg = new String("1. 영화관 등록 2. 등록된 영화관 수정 3. 등록된 영화관 삭제 4. 뒤로 돌아가기");
                int uc = ScannerUtil.nextInt(sc, msg, 1, 4);
                if (uc == 1) {
                    // 영화관 등록 메소드 실행
                    insert();
                } else if (uc == 2) {
                    // 영화관 수정 메소드 실행
                    msg = new String("수정할 영화관 번호 입력");
                    int update = ScannerUtil.nextInt(sc, msg);
                    CinemaDTO c = controller.selectOne(update);

                    while (c == null) {
                        System.out.println("잘못된 번호입니다. ");
                        update = ScannerUtil.nextInt(sc, msg);
                        c = controller.selectOne(update);
                    }

                    showUpdate(update);
                } else if (uc == 3) {
                    // 영화관 삭제 메소드 실행
                    msg = new String("삭제할 영화관 번호 입력");
                    int del = ScannerUtil.nextInt(sc, msg);

                    CinemaDTO c = controller.selectOne(del);

                    while (c == null) {
                        System.out.println("잘못된 번호입니다. ");
                        del = ScannerUtil.nextInt(sc, msg);
                        c = controller.selectOne(del);
                    }
                    delete(del);
                } else if (uc == 4) {
                    msg = new String("뒤로 돌아갑니다.");
                    break;
                }

            }

        }

    }

    // 관리자용 수정 메소드
    public void showUpdate(int id) {
        CinemaDTO c = controller.selectOne(id);
        String msg;

        // 극장 이름
        msg = new String("극장 이름");
        c.setName(ScannerUtil.nextLine(sc, msg));
        // 극장 주소
        msg = new String("극장 주소 입력");
        c.setLocation(ScannerUtil.nextLine(sc, msg));
        // 극장 전화번호
        msg = new String("극장 전화번호 입력");
        c.setPhoneNumber(ScannerUtil.nextLine(sc, msg));

        controller.update(c);
    }

    // 관리자용 삭제 메소드
    public void delete(int id) {
        CinemaDTO c = controller.selectOne(id);
        if (c.getId() == id) {
            String msg = new String("정말로 삭제하시겠습니까? Y/N");
            String yesNo = ScannerUtil.nextLine(sc, msg);
            if (yesNo.equalsIgnoreCase("y")) {
                controller.delete(c);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 관리자용 영화관 등록 메소드
    public void insert() {
        System.out.println("새 영화관을 등록합니다.");
        CinemaDTO c = new CinemaDTO();
        String msg;

        msg = new String("영화관 이름 입력");
        c.setName(ScannerUtil.nextLine(sc, msg));

        msg = new String("영화관 주소 입력");
        c.setLocation(ScannerUtil.nextLine(sc, msg));

        msg = new String("영화관 전화번호 입력");
        c.setPhoneNumber(ScannerUtil.nextLine(sc, msg));

        // 중복되는 영화관 이름?

        // 컨트롤러 add 메소드 호출
        controller.add(c);

    }

    // 상영정보 관리를 위한 극장정보 메소드
    public void printForScreenInfo(int group) {
        while (true) {
            // 극장 전체 목록 가져오기
            ArrayList<CinemaDTO> list = controller.selectAll();

            System.out.println("----------------------------------------------");
            for (CinemaDTO c : list) {
                // 출력 부분
                System.out.printf("번호: %02d 극장이름: %s 극장위치: %s 전화번호: %s\n", c.getId(), c.getName(), c.getLocation(),
                        c.getPhoneNumber());
            }
            System.out.println("----------------------------------------------");

            // 등록된 영화관이 없을 때
            if (list.size() == 0) {
                System.out.println("등록된 영화관이 없습니다.\n뒤로 돌아갑니다.");
                break;
            }

            if (group == 3) {
                String msg = new String("상영정보를 관리할 극장 번호를 입력하세요. 뒤로 돌아가려면 0을 입력하세요.");
                int uc = ScannerUtil.nextInt(sc, msg);
                if (uc == 0) {
                    System.out.println("뒤로 돌아갑니다.");
                    break;
                } else {
                    screenInfoViewer.adminInfoList(uc);
                }

            }
        }

    }

    // 시네마 정보(새로 추가된 극장까지) 모두 상영벙보로 보내주는 메소드
    public ArrayList<CinemaDTO> sendAll() {
        ArrayList<CinemaDTO> temp = new ArrayList<>();
        for (CinemaDTO c : controller.selectAll()) {
            temp.add(c);
        }

        return temp;
    }

}
