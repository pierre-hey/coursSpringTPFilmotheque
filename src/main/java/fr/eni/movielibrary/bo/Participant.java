package fr.eni.movielibrary.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
    private Integer id;
    private String firstName;
    private String lastName;
}
