package Controller;

import java.util.ArrayList;

import Model.ScreenInfoDTO;

public class ScreenInfoController {
    // ��ü ����
    private ArrayList<ScreenInfoDTO> list;
    private int id;

    public ScreenInfoController() {
        // ������
        list = new ArrayList<>();
        id = 1;

        // ��ü1
        ScreenInfoDTO s = new ScreenInfoDTO();
        s.setId(id++);
        s.setMovieId(1); // ��ٿ�Ÿ��
        s.setCinemaId(1); // ����: A
        s.setShowingTime("9");
        list.add(s);

        // ��ü2
        s = new ScreenInfoDTO();
        s.setId(id++);
        s.setMovieId(2); // ĳ������� ����
        s.setCinemaId(1); // ����: A
        s.setShowingTime("17");
        list.add(s);

        // ��ü3
        s = new ScreenInfoDTO();
        s.setId(id++);
        s.setMovieId(3);
        s.setCinemaId(2);
        s.setShowingTime("20");
        list.add(s);

    }

    // selectOne()�޼ҵ�
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

    // ������ ������ �������� �ҷ����� �޼ҵ�
    public ArrayList<ScreenInfoDTO> selectByGroup(int id) {
        ArrayList<ScreenInfoDTO> temp = new ArrayList<>();
        for (ScreenInfoDTO s : list) {
            if (s.getCinemaId() == id) {
                temp.add(s);
                
            }
        }
        return temp;
        
    }

    // add() �޼ҵ�
    public void add(ScreenInfoDTO s) {
        s.setId(id++);

        list.add(s);
    }

    // update() �޼ҵ�
    public void update(ScreenInfoDTO updated) {
        for (ScreenInfoDTO s : list) {
            if (s.getId() == updated.getId()) {
                s.setShowingTime(updated.getShowingTime());
            }
        }
    }

    // delete() �޼ҵ�
    public void delete(ScreenInfoDTO s) {
        list.remove(s);
    }

    // ��̸���Ʈ �� �����ִ� �޼ҵ�
    public ArrayList<ScreenInfoDTO> selectAll() {
        ArrayList<ScreenInfoDTO> temp = new ArrayList<>();
        for (ScreenInfoDTO s : list) {
            temp.add(s);

        }
        return temp;
    }

}