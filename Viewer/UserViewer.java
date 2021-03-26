package Viewer;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.UserController;
import Model.UserDTO;
import util.ScannerUtil;

public class UserViewer {
    private Scanner sc;
    private UserController controller;
    // 일반 사용자
    private UserDTO userLogin;
    // 평론가 사용자
    private UserDTO criticLogin;
    // 관리자 사용자
    private UserDTO adminLogin;

    // 1. 생성자, 각각 필드 선언
    public UserViewer() {
        sc = new Scanner(System.in);
        controller = new UserController();

    }

    // 2. 회원가입 담당 메소드
    public void register(int group) {
        UserDTO u = new UserDTO();

        String msg;

        msg = new String("사용할 아이디 입력");
        u.setUserName(ScannerUtil.nextLine(sc, msg));

        // 중복 아이디 필터
        while (controller.validateUsername(u)) {
            System.out.println("중복된 아이디, 다른 아이디 입력");
            u.setUserName(ScannerUtil.nextLine(sc, msg));
        }

        msg = new String("사용할 비밀번호 입력");
        u.setPassword(ScannerUtil.nextLine(sc, msg));

        msg = new String("사용자 이름 입력");
        u.setUserName(ScannerUtil.nextLine(sc, msg));

        msg = new String("사용자 닉네임 입력");
        u.setNickName(ScannerUtil.nextLine(sc, msg));

        u.setGroup(group);

        // 컨트롤러 add 메소드 호출
        controller.add(u);
    }

    // 3. 로그인 담당 메소드
    public int logIn() {
        // 2-1. 로그인한 객체의 정보를 담을 학생 객체 s를 생성
        UserDTO u = new UserDTO();

        // 2-2. 출력에 사용할 메세지를 담을 String 객체 msg 선언
        String msg;

        // 2-3. 아이디 입력
        msg = new String("아이디를 입력해주세요.");
        u.setUserName(ScannerUtil.nextLine(sc, msg));

        // 2-4. 비번 입력
        msg = new String("비밀번호를 입력해주세요.");
        u.setPassword(ScannerUtil.nextLine(sc, msg));

        // 2-5. s에 해당 정보를 담아서 컨트롤러에 보내준다.
        UserDTO result = controller.auth(u);

        // 2-6. 만약 결과가 null이면 다시 입력을 받거나
        // 뒤로 돌아갈 지 묻는다.
        while (result == null) {
            System.out.println("잘못 입력하였거나 존재하지 않는 계정입니다.");
            msg = new String("다시 입력 하시겠습니까? 다시 입력하려면 y를 입력해주세요.");
            String agree = ScannerUtil.nextLine(sc, msg);
            if (!agree.equalsIgnoreCase("y")) {
                return -1;
            }
            msg = new String("아이디를 입력해주세요.");
            u.setUserName(ScannerUtil.nextLine(sc, msg));

            msg = new String("비밀번호를 입력해주세요.");
            u.setPassword(ScannerUtil.nextLine(sc, msg));

            result = controller.auth(u);
        }

        return result.getGroup();
    }

    // 4. 사용자 로그아웃
    public void logOut() {
        System.out.println("로그아웃 되었습니다.");
        userLogin = null;
    }

    // 현재 로그인 객체를 리턴해주는 메소드

    public ArrayList<UserDTO> selectAll() {
        ArrayList<UserDTO> list = controller.selectAll();

        return list;

    }

    // 5. 컨트롤러로부터 회원 전체 목록을 따오는
    // selectAll() 메소드

}
