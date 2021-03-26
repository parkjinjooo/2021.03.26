package Model;

public class ScreenInfoDTO {
    // 1. �ʵ�

    // ������ ��ȣ
    private int id;
    // ��ȭ ��ȣ
    private int movieId;
    // ���� ��ȣ
    private int cinemaId;
    // �� �ð�
    private String showingTime;

    // 2. �޼ҵ�
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getShowingTime() {
        return showingTime;
    }

    public void setShowingTime(String showingTime) {
        this.showingTime = showingTime;
    }

    // equals
    public boolean equals(Object o) {
        if (o instanceof ScreenInfoDTO) {
            ScreenInfoDTO s = (ScreenInfoDTO) o;
            if (id == s.id) {
                return true;
            }

        }
        return false;
    }

}
