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

        msg = new String("그룹별 평점보기");
        msg = new String("1.일반 평점 2. 평론가 평점");
        int group = ScannerUtil.nextInt(sc, msg, 1, 2);
        printOne(movieId, group);

    }

    public void printOne(int movieId, int group) {
        ArrayList<UserDTO> list = userViewer.selectAll();
        ArrayList<GradeDTO> filteredList = controller.selectGradeByGroup(list, group, movieId);
        if (filteredList.isEmpty()) {
            System.out.println("아직 아무런 댓글이 없습니다!");
        }
        for (GradeDTO g : filteredList) {
            // 1. g에서 평점을 쓴 회원의 id값을 불러온다.
            int writeId = g.getWriteId();
            // 2. UserDTO 임시 객체 u를 하나 만든다.
            UserDTO u = new UserDTO();
            // 3. 임시 객체 u의 id에 int writeId를 넣는다.
            u.setId(writeId);
            // 4. 전체 회원 리스트인 userList에서
            // indexOf() 메소드를 통해서
            // 임시 객체 u와 id가 같은 엘리먼트를 찾는다.
            int userIndex = list.indexOf(u);
            // 5. 임시 객체 u의 나머지 정보도 불러오기 위해서
            // get(userIndex)로 u를 덮어 씌운다.
            u = list.get(userIndex);

            System.out.println("-------------------------------");
            System.out.println("회원 닉네임: " + u.getNickName());
            System.out.println("평점: " + g.getGrade());
            System.out.println("평론: " + g.getReview());
            System.out.println("-------------------------------");
        }

    }

}
