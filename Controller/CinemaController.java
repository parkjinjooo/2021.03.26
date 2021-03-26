package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.CinemaDTO;

public class CinemaController {
    // 객체 선언
    private ArrayList<CinemaDTO> list;
    private int id;
    private Scanner sc;

    public CinemaController() {
        // 1. 생성자
        list = new ArrayList<>();
        sc = new Scanner(System.in);
        id = 1;

        // 극장 A
        CinemaDTO c = new CinemaDTO();
        c.setId(id++);
        c.setName("CGV 강남");
        c.setLocation("서울특별시 강남구 강남대로 438");
        c.setPhoneNumber("1544-1122");

        list.add(c);

        // 극장 B
        c = new CinemaDTO();
        c.setId(id++);
        c.setName("CGV 수원");
        c.setLocation("경기도 수원시 팔달구 덕영대로 924");
        c.setPhoneNumber("1544-1133");

        list.add(c);

    }

    // selectOne()메소드
    public CinemaDTO selectOne(int id) {
        for (CinemaDTO c : list) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // add() 메소드
    public void add(CinemaDTO c) {
        c.setId(id++);

        list.add(c);
    }

    // 영화관 수정 메소드
    public void update(CinemaDTO updated) {
        for (CinemaDTO c : list) {
            if (c.getId() == updated.getId()) {
                c.setName(updated.getName());
                c.setLocation(updated.getLocation());
                c.setPhoneNumber(updated.getPhoneNumber());
            }
        }
    }

    // 극장 삭제 delete() 메소드
    public void delete(CinemaDTO c) {
        list.remove(c);
    }

    // 극장목록 전체를 담아 리턴해주는 메소드
    public ArrayList<CinemaDTO> selectAll() {
        ArrayList<CinemaDTO> temp = new ArrayList<>();
        for (CinemaDTO c : list) {
            temp.add(c);

        }
        return temp;
    }

    // 선택한 극장의 상영정보만 불러오는 메소드
    public ArrayList<CinemaDTO> selectByGroup(int id) {
        ArrayList<CinemaDTO> temp = new ArrayList<>();
        for (CinemaDTO c : list) {
            if (c.getId() == id) {
                temp.add(c);
            }
        }
        return temp;
    }

}
