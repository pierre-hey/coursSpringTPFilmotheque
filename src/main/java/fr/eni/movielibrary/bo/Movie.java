package fr.eni.movielibrary.bo;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    private Integer id;

    @NotNull(message = "Le titre est obligatoire")
    @NotBlank(message = "Ne doit pas être vide")
    private String title;


    @NotNull(message = "L'année est obligatoire")
    private Integer year;

    @NotNull(message = "La durée du film est obligatoire")
    @DecimalMin(value = "0", message = "La durée du film doit être supérieure à 0")
    private Integer duration;

    @Size(min = 1, max = 250, message = "Le commentaire doit faire entre 1 et 250 caractères")
    private String synopsis;


    private Genre genre;

    @NotNull(message = "Le réalisateur du film est obligatoire")
    private Participant director;
    private List<Participant> actors;
    private List<Opinion> opinions = new ArrayList<>();


    public Movie(Integer id, String title, Integer year, Integer duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    public void addOpinion(Opinion opinion){
        this.opinions.add(opinion);
    }

}
