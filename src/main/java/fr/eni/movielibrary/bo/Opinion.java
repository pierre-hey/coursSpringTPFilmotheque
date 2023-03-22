package fr.eni.movielibrary.bo;

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
    private Integer rating;
    private String comment;
}
