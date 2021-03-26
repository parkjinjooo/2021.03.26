package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.MovieDTO;
import util.ScannerUtil;

public class MovieController {

    private ArrayList<MovieDTO> list;
    private Scanner sc;

    private int id;

    public MovieController() {

        list = new ArrayList<>();
        sc = new Scanner(System.in);
        id = 1;

        MovieDTO m = new MovieDTO();
        m.setId(id++);
        m.setTitle("어바웃타임");
        m.setContent("시간여행으로 사랑에 빠진 남자");
        m.setRank("15세 이상 관람");
        list.add(m);

        m = new MovieDTO();
        m.setId(id++);
        m.setTitle("캐리비안의 해적");
        m.setContent("해적여행");
        m.setRank("12세 이상 관람");
        list.add(m);

        m = new MovieDTO();
        m.setId(id++);
        m.setTitle("해리포터");
        m.setContent("도비이즈프리");
        m.setRank("12세 이상 관람");
        list.add(m);

    }
    
    
    public void add(MovieDTO m) {
        m.setId(id++);

        list.add(m);
    }

    public void delete(MovieDTO m) {
        list.remove(m);
    }

    public ArrayList<MovieDTO> selectAll() {
        ArrayList<MovieDTO> temp = new ArrayList<>();
        for (MovieDTO m : list) {
            temp.add(m);
        }

        return temp;
    }

    public MovieDTO selectOne(int id) {
        for (MovieDTO m : list) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    public void update(MovieDTO m) {
        for (MovieDTO mm : list) {
            if (mm.getId() == id) {
                list.add(mm);
            }
        }

    }
    
    // 선택한 극장의 상영정보만 불러오는 메소드
    public ArrayList<MovieDTO> selectByGroup(int id) {
        ArrayList<MovieDTO> temp = new ArrayList<>();
        for (MovieDTO m : list) {
            if (m.getId() == id) {
                temp.add(m);
            }
        }
        return temp;
    }

}
