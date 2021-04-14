package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "get_user_by_fullName",
        query = "from User WHERE fullName like :fullName"
        ),
        @NamedQuery(name = "get_email_from_user",
        query = "from User WHERE eMail like :eMail")
})
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String fullName;
    private String eMail;

    private boolean rootUser;

    @Override
    public String getSlogan() {
        return "I am a USER";
    }
}
