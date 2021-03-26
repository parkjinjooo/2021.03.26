package Controller;

import java.util.ArrayList;

import Model.ScreenInfoDTO;

public class ScreenInfoController {
    // 객체 선언
    private ArrayList<ScreenInfoDTO> list;
    private int id;

    public ScreenInfoController() {
        // 생성자
        list = new ArrayList<>();
        id = 1;

        // 객체1
        ScreenInfoDTO s = new ScreenInfoDTO();
        s.setId(id++);
        s.setMovieId(1); // 어바웃타임
        s.setCinemaId(1); // 극장: A
        s.setShowingTime("9");
        list.add(s);

        // 객체2
        s = new ScreenInfoDTO();
        s.setId(id++);
        s.setMovieId(2); // 캐리비안의 해적
        s.setCinemaId(1); // 극장: A
        s.setShowingTime("17");
        list.add(s);

        // 객체3
        s = new ScreenInfoDTO();
        s.setId(id++);
        s.setMovieId(3);
        s.setCinemaId(2);
        s.setShowingTime("20");
        list.add(s);

    }

    // selectOne()메소드
    public ScreenInfoDTO selectOne(int id) {
        for (ScreenInfoDTO s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public ScreenInfoDTO printOne(int id) {
        for (ScreenInfoDTO s : list) {
            if (s.getMovieId() == id) {
                return s;
            }
        }
        return null;
    }

    // 선택한 극장의 상영정보만 불러오는 메소드
    public ArrayList<ScreenInfoDTO> selectByGroup(int id) {
        ArrayList<ScreenInfoDTO> temp = new ArrayList<>();
        for (ScreenInfoDTO s : list) {
            if (s.getCinemaId() == id) {
                temp.add(s);
                
            }
        }
        return temp;
        
    }

    // add() 메소드
    public void add(ScreenInfoDTO s) {
        s.setId(id++);

        list.add(s);
    }

    // update() 메소드
    public void update(ScreenInfoDTO updated) {
        for (ScreenInfoDTO s : list) {
            if (s.getId() == updated.getId()) {
                s.setShowingTime(updated.getShowingTime());
            }
        }
    }

    // delete() 메소드
    public void delete(ScreenInfoDTO s) {
        list.remove(s);
    }

    // 어레이리스트 값 돌려주는 메소드
    public ArrayList<ScreenInfoDTO> selectAll() {
        ArrayList<ScreenInfoDTO> temp = new ArrayList<>();
        for (ScreenInfoDTO s : list) {
            temp.add(s);

        }
        return temp;
    }

}