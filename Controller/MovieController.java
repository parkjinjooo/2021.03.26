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
        m.setTitle("��ٿ�Ÿ��");
        m.setContent("�ð��������� ����� ���� ����");
        m.setRank("15�� �̻� ����");
        list.add(m);

        m = new MovieDTO();
        m.setId(id++);
        m.setTitle("ĳ������� ����");
        m.setContent("��������");
        m.setRank("12�� �̻� ����");
        list.add(m);

        m = new MovieDTO();
        m.setId(id++);
        m.setTitle("�ظ�����");
        m.setContent("������������");
        m.setRank("12�� �̻� ����");
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
    
    // ������ ������ �������� �ҷ����� �޼ҵ�
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
