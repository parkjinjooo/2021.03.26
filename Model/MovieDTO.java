package Model;



public class MovieDTO {
    // B.��ȭ Ŭ����
    
    // ��ȭ ��ȣ(������ȣ --> equals)
    private int id;

    // ��ȭ ����
    private String title;

    // ��ȭ �ٰŸ�
    private String Content;

    // ��ȭ ���
    private String rank;

    // getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    // equals()

    public boolean equals(Object o) {
        if (o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO) o;
            if (id == m.id) {
                return true;
            }
        }
        return false;
    }

}
