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
        g.setReview("����");
        list.add(g);

        g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(3);
        g.setMovieNumber(1);
        g.setGrade(4);
        g.setReview("������");
        list.add(g);

        g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(2);
        g.setMovieNumber(2);
        g.setGrade(2);
        g.setReview("��");
        list.add(g);

        g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(3);
        g.setMovieNumber(2);
        g.setGrade(3);
        g.setReview("��");
        list.add(g);

        g = new GradeDTO();
        g.setId(id++);
        g.setWriteId(2);
        g.setMovieNumber(3);
        g.setGrade(2);
        g.setReview("��");
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
            // ���� ���� ����Ʈ�� i��° ������Ʈ��
            // g�� writerId()�� ��ġ�ϴ�
            // ����DTO ��ü�� userList���� ã�Ƽ�
            // ���� �ش� ��ü�� group��
            // �Ķ���ͷ� ���� group�� ������
            // g�� grade�� �߰��Ѵ�.

            // 1. g���� ������ �� ȸ���� id���� �ҷ��´�.
            int writeId = g.getWriteId();
            // 2. UserDTO �ӽ� ��ü u�� �ϳ� �����.
            UserDTO u = new UserDTO();
            // 3. �ӽ� ��ü u�� id�� int writeId�� �ִ´�.
            u.setId(writeId);
            // 4. ��ü ȸ�� ����Ʈ�� userList����
            // indexOf() �޼ҵ带 ���ؼ�
            // �ӽ� ��ü u�� id�� ���� ������Ʈ�� ã�´�.
            int userIndex = userList.indexOf(u);
            // 5. �ӽ� ��ü u�� ������ ������ �ҷ����� ���ؼ�
            // get(userIndex)�� u�� ���� �����.
            u = userList.get(userIndex);
            // 6. ���� ������ ��� �� u��
            // group ���� �Ķ���ͷ� ���� group�� ������
            // grade�� g�� �߰��Ѵ�.

            if (u.getGroup() == group) {
                temp.add(g);
            }

        }
        return temp;
    }
}
