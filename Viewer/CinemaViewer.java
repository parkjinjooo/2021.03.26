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

    // ���� ��ü ����� �����ִ� �޼ҵ�
    // ���� id�� ������ �����ð�
    // ���帮��Ʈ�� ������ ����
    // ���� �̸�, ���� ��ġ, ���� ��ȭ��ȣ
    public void printList(int group) {
        while (true) {
            // ���� ��ü ��� ��������
            ArrayList<CinemaDTO> list = controller.selectAll();

            System.out.println("----------------------------------------------");
            for (CinemaDTO c : list) {
                // ��� �κ�
                System.out.println();
                System.out.printf("��ȣ: %02d �����̸�: %s\n������ġ: %s ��ȭ��ȣ: %s\n", c.getId(), c.getName(), c.getLocation(),
                        c.getPhoneNumber());
                System.out.println();
            }
            System.out.println("----------------------------------------------");

            // ��ϵ� ��ȭ���� ���� ��
            if (list.size() == 0) {
                System.out.println("��ϵ� ��ȭ���� �����ϴ�.\n�ڷ� ���ư��ϴ�.");
                break;
            }

            // �� ��ȭ�� ���� (�Ϲ�, ��а�)
            if (group == 1 || group == 2) {
                String msg = new String("�� ��ȭ�� �� �󿵿�ȭ ����� ���÷��� ���� ��ȣ�� " + "�Է��ϼ���.\n" + "�ڷ� ���ư��÷��� 0�� �Է��ϼ���.");
                int uc = ScannerUtil.nextInt(sc, msg);

                if (uc == 0) {
                    System.out.println("�ڷ� ���ư��ϴ�.");
                    break;
                } else {
                    // ScreenViewer ����
                    // uc�� CinemaDTO�� id ��
                    screenInfoViewer.infoList(uc);
                }
            }

            if (group == 3) {
                String msg = new String("1. ��ȭ�� ��� 2. ��ϵ� ��ȭ�� ���� 3. ��ϵ� ��ȭ�� ���� 4. �ڷ� ���ư���");
                int uc = ScannerUtil.nextInt(sc, msg, 1, 4);
                if (uc == 1) {
                    // ��ȭ�� ��� �޼ҵ� ����
                    insert();
                } else if (uc == 2) {
                    // ��ȭ�� ���� �޼ҵ� ����
                    msg = new String("������ ��ȭ�� ��ȣ �Է�");
                    int update = ScannerUtil.nextInt(sc, msg);
                    CinemaDTO c = controller.selectOne(update);

                    while (c == null) {
                        System.out.println("�߸��� ��ȣ�Դϴ�. ");
                        update = ScannerUtil.nextInt(sc, msg);
                        c = controller.selectOne(update);
                    }

                    showUpdate(update);
                } else if (uc == 3) {
                    // ��ȭ�� ���� �޼ҵ� ����
                    msg = new String("������ ��ȭ�� ��ȣ �Է�");
                    int del = ScannerUtil.nextInt(sc, msg);

                    CinemaDTO c = controller.selectOne(del);

                    while (c == null) {
                        System.out.println("�߸��� ��ȣ�Դϴ�. ");
                        del = ScannerUtil.nextInt(sc, msg);
                        c = controller.selectOne(del);
                    }
                    delete(del);
                } else if (uc == 4) {
                    msg = new String("�ڷ� ���ư��ϴ�.");
                    break;
                }

            }

        }

    }

    // �����ڿ� ���� �޼ҵ�
    public void showUpdate(int id) {
        CinemaDTO c = controller.selectOne(id);
        String msg;

        // ���� �̸�
        msg = new String("���� �̸�");
        c.setName(ScannerUtil.nextLine(sc, msg));
        // ���� �ּ�
        msg = new String("���� �ּ� �Է�");
        c.setLocation(ScannerUtil.nextLine(sc, msg));
        // ���� ��ȭ��ȣ
        msg = new String("���� ��ȭ��ȣ �Է�");
        c.setPhoneNumber(ScannerUtil.nextLine(sc, msg));

        controller.update(c);
    }

    // �����ڿ� ���� �޼ҵ�
    public void delete(int id) {
        CinemaDTO c = controller.selectOne(id);
        if (c.getId() == id) {
            String msg = new String("������ �����Ͻðڽ��ϱ�? Y/N");
            String yesNo = ScannerUtil.nextLine(sc, msg);
            if (yesNo.equalsIgnoreCase("y")) {
                controller.delete(c);
            } else {
                System.out.println("�߸��� �Է��Դϴ�.");
            }
        }
    }

    // �����ڿ� ��ȭ�� ��� �޼ҵ�
    public void insert() {
        System.out.println("�� ��ȭ���� ����մϴ�.");
        CinemaDTO c = new CinemaDTO();
        String msg;

        msg = new String("��ȭ�� �̸� �Է�");
        c.setName(ScannerUtil.nextLine(sc, msg));

        msg = new String("��ȭ�� �ּ� �Է�");
        c.setLocation(ScannerUtil.nextLine(sc, msg));

        msg = new String("��ȭ�� ��ȭ��ȣ �Է�");
        c.setPhoneNumber(ScannerUtil.nextLine(sc, msg));

        // �ߺ��Ǵ� ��ȭ�� �̸�?

        // ��Ʈ�ѷ� add �޼ҵ� ȣ��
        controller.add(c);

    }

    // ������ ������ ���� �������� �޼ҵ�
    public void printForScreenInfo(int group) {
        while (true) {
            // ���� ��ü ��� ��������
            ArrayList<CinemaDTO> list = controller.selectAll();

            System.out.println("----------------------------------------------");
            for (CinemaDTO c : list) {
                // ��� �κ�
                System.out.printf("��ȣ: %02d �����̸�: %s ������ġ: %s ��ȭ��ȣ: %s\n", c.getId(), c.getName(), c.getLocation(),
                        c.getPhoneNumber());
            }
            System.out.println("----------------------------------------------");

            // ��ϵ� ��ȭ���� ���� ��
            if (list.size() == 0) {
                System.out.println("��ϵ� ��ȭ���� �����ϴ�.\n�ڷ� ���ư��ϴ�.");
                break;
            }

            if (group == 3) {
                String msg = new String("�������� ������ ���� ��ȣ�� �Է��ϼ���. �ڷ� ���ư����� 0�� �Է��ϼ���.");
                int uc = ScannerUtil.nextInt(sc, msg);
                if (uc == 0) {
                    System.out.println("�ڷ� ���ư��ϴ�.");
                    break;
                } else {
                    screenInfoViewer.adminInfoList(uc);
                }

            }
        }

    }

    // �ó׸� ����(���� �߰��� �������) ��� �󿵺����� �����ִ� �޼ҵ�
    public ArrayList<CinemaDTO> sendAll() {
        ArrayList<CinemaDTO> temp = new ArrayList<>();
        for (CinemaDTO c : controller.selectAll()) {
            temp.add(c);
        }

        return temp;
    }

}
