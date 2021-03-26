package Controller;

import java.util.ArrayList;

import Model.GradeDTO;
import Model.UserDTO;

public class GradeController {

    private ArrayList<GradeDTO> list;
    private UserController userController;

    private int id;

    public GradeController() {

        list = new ArrayList<>();
        id = 1;

        GradeDTO g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(2);
        g.setMovieNumber(1);
        g.setGrade(3);
        g.setReview("꿀잼");
        list.add(g);

        g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(3);
        g.setMovieNumber(1);
        g.setGrade(4);
        g.setReview("개꿀잼");
        list.add(g);

        g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(2);
        g.setMovieNumber(2);
        g.setGrade(2);
        g.setReview("잼");
        list.add(g);

        g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(3);
        g.setMovieNumber(2);
        g.setGrade(3);
        g.setReview("잼");
        list.add(g);

        g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(2);
        g.setMovieNumber(3);
        g.setGrade(2);
        g.setReview("잼");
        list.add(g);
    }

    public ArrayList<GradeDTO> selectByMovie( ArrayList<UserDTO> userList, int movieId) {
        ArrayList<GradeDTO> temp = new ArrayList<>();
        for (GradeDTO g : list) {
            if (g.getMovieNumber() == movieId) {
                temp.add(g);
            }
        }
        return temp;
    }

    public ArrayList<GradeDTO> selectGradeByGroup(ArrayList<UserDTO> userList, int group, int movieId) {
        ArrayList<GradeDTO> temp = new ArrayList<>();

        for (GradeDTO g : selectByMovie(userList,movieId)) {
            // 만약 평점 리스트의 i번째 엘리먼트인
            // g의 writerId()와 일치하는
            // 유저DTO 객체를 userList에서 찾아서
            // 만약 해당 객체의 group이
            // 파라미터로 들어온 group과 같으면
            // g를 grade에 추가한다.

            // 1. g에서 평점을 쓴 회원의 id값을 불러온다.
            int writeId = g.getWriteId();
            // 2. UserDTO 임시 객체 u를 하나 만든다.
            UserDTO u = new UserDTO();
            // 3. 임시 객체 u의 id에 int writeId를 넣는다.
            u.setId(writeId);
            // 4. 전체 회원 리스트인 userList에서
            // indexOf() 메소드를 통해서
            // 임시 객체 u와 id가 같은 엘리먼트를 찾는다.
            int userIndex = userList.indexOf(u);
            // 5. 임시 객체 u의 나머지 정보도 불러오기 위해서
            // get(userIndex)로 u를 덮어 씌운다.
            u = userList.get(userIndex);
            // 6. 만약 정보가 모두 들어간 u의
            // group 값이 파라미터로 들어온 group과 같으면
            // grade에 g를 추가한다.

            if (u.getGroup() == group) {
                temp.add(g);
            }

        }
        return temp;
    }
}
