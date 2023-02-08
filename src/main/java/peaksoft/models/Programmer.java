package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.models.enums.Status;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "programmers")
public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private Status status;
    @OneToOne
    @JoinColumn(name = "location")
    private Address location;
    @ManyToMany(cascade = {ALL},fetch = FetchType.LAZY,mappedBy = "programmers")
    private List<Project> projects;

    public Programmer(String fullName, String email, LocalDate dateOfBirth, Status status, Address location, List<Project> projects) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
        this.location = location;
        this.projects = projects;
    }
}
