package fr.eni.movielibrary.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private Integer id;
    private String userName;
    private String password;
    private Boolean isAdmin;
}
