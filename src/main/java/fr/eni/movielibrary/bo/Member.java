package fr.eni.movielibrary.bo;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Ne peut pas être vide")
    private String firstName;
    @NotBlank(message = "Ne peut pas être vide")
    private String lastName;
    @Column(nullable = false, unique = true) // Contraintes bdd
    private String login;
    @NotBlank(message = "Ne peut pas être vide")
    private String password;
    private Boolean isAdmin;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "hobby", joinColumns = @JoinColumn(name = "id_hobby", referencedColumnName = "id"))
    private List<String> hobbies = new ArrayList<>();


/*    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<Opinion> opinions =new ArrayList<>();*/

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public void addHobby(String hobby){
        this.hobbies.add(hobby);
    }

}
