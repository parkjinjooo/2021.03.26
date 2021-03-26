package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.CinemaDTO;

public class CinemaController {
    // ��ü ����
    private ArrayList<CinemaDTO> list;
    private int id;
    private Scanner sc;

    public CinemaController() {
        // 1. ������
        list = new ArrayList<>();
        sc = new Scanner(System.in);
        id = 1;

        // ���� A
        CinemaDTO c = new CinemaDTO();
        c.setId(id++);
        c.setName("CGV ����");
        c.setLocation("����Ư���� ������ ������� 438");
        c.setPhoneNumber("1544-1122");

        list.add(c);

        // ���� B
        c = new CinemaDTO();
        c.setId(id++);
        c.setName("CGV ����");
        c.setLocation("��⵵ ������ �ȴޱ� ������� 924");
        c.setPhoneNumber("1544-1133");

        list.add(c);

    }

    // selectOne()�޼ҵ�
    public CinemaDTO selectOne(int id) {
        for (CinemaDTO c : list) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // add() �޼ҵ�
    public void add(CinemaDTO c) {
        c.setId(id++);

        list.add(c);
    }

    // ��ȭ�� ���� �޼ҵ�
    public void update(CinemaDTO updated) {
        for (CinemaDTO c : list) {
            if (c.getId() == updated.getId()) {
                c.setName(updated.getName());
                c.setLocation(updated.getLocation());
                c.setPhoneNumber(updated.getPhoneNumber());
            }
        }
    }

    // ���� ���� delete() �޼ҵ�
    public void delete(CinemaDTO c) {
        list.remove(c);
    }

    // ������ ��ü�� ��� �������ִ� �޼ҵ�
    public ArrayList<CinemaDTO> selectAll() {
        ArrayList<CinemaDTO> temp = new ArrayList<>();
        for (CinemaDTO c : list) {
            temp.add(c);

        }
        return temp;
    }

    // ������ ������ �������� �ҷ����� �޼ҵ�
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
