package Model;



public class MovieDTO {
    // B.영화 클래스
    
    // 영화 번호(고유번호 --> equals)
    private int id;

    // 영화 제목
    private String title;

    // 영화 줄거리
    private String Content;

    // 영화 등급
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
