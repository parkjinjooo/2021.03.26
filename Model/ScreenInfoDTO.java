package Model;

public class ScreenInfoDTO {
    // 1. 필드

    // 상영정보 번호
    private int id;
    // 영화 번호
    private int movieId;
    // 극장 번호
    private int cinemaId;
    // 상영 시간
    private String showingTime;

    // 2. 메소드
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
