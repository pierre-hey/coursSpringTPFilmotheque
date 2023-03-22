package fr.eni.movielibrary.bo;

import lombok.*;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Movie {
    @NonNull
    private Integer id;
    @NonNull
    private String title;
    @NonNull
    private Integer year;
    @NonNull
    private Integer duration;
    @NonNull
    private String synopsis;

    private Genre genre;
    private Participant director;
    private List<Participant> actors;
    private List<Opinion> opinions;


/*    public Movie(Integer id, String title, Integer year, Integer duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }*/
}
