package fr.eni.movielibrary.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Le titre est obligatoire")
    @NotBlank(message = "Ne doit pas être vide")
    @Column(length = 250, nullable = false) // Longueur max d'une insertion dans la bdd et non nul
    private String title;


    @NotNull(message = "L'année est obligatoire")
    private Integer year;

    @NotNull(message = "La durée du film est obligatoire")
    @DecimalMin(value = "0", message = "La durée du film doit être supérieure à 0")
    private Integer duration;

    @Size(min = 1, max = 250, message = "Le commentaire doit faire entre 1 et 250 caractères")
    @NotBlank(message = "Ne doit pas être vide")
    @Column(length = 250, nullable = false)
    private String synopsis;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Genre genre;

    @NotNull(message = "Le réalisateur du film est obligatoire")
    @ManyToOne(fetch = FetchType.LAZY)
    private Participant director;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Participant> actors;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "movie_id")
    private List<Opinion> opinions = new ArrayList<>();


    public Movie(Integer id, String title, Integer year, Integer duration, String synopsis) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.synopsis = synopsis;
    }

    public void addOpinion(Opinion opinion){
        opinions.add(opinion);
    }

}
