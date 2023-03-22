package fr.eni.movielibrary.bo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Opinion {

    private Integer id;

    private Member member;

    @Size(max = 5, message = "La note doit être comprise entre 0 et 5")
    private Integer rating;

    @NotBlank(message = "Ne doit pas être vide")
    @Size(min = 1, max = 250, message = "Le commentaire doit faire entre 1 et 250 caractères")
    private String comment;
}
