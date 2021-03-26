package Model;

public class GradeDTO {
    // C. ����

    // ���� ��ȣ(������ȣ --> equals)
    private int id;

    // �ۼ� ȸ�� ��ȣ 
    private int writeId;

    // ��ȭ ��ȣ
    private int movieNumber;

    // ����
    private int grade;

    // ���
    private String review;

    // getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWriteId() {
        return writeId;
    }

    public void setWriteId(int writeId) {
        this.writeId = writeId;
    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public void setMovieNumber(int movieNumber) {
        this.movieNumber = movieNumber;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    // equals()

    public boolean equals(Object o) {
        if (o instanceof GradeDTO) {
            GradeDTO g = (GradeDTO) o;
            if (id == g.id) {
                return true;
            }
        }
        return false;
    }

}
