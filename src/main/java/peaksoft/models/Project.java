package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "project_name")
    private String projectName;
    private String description;
    @Column(name = "date_of_start")
    private LocalDate dateOfStart;
    @Column(name = "date_of_finish")
    private LocalDate dateOfFinish;
    private int price;
    @ManyToMany(cascade = {ALL},fetch = FetchType.LAZY)
    private List<Programmer> programmers;

    public Project(String projectName, String description, LocalDate dateOfStart, LocalDate dateOfFinish, int price, List<Programmer> programmers) {
        this.projectName = projectName;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.price = price;
        this.programmers = programmers;
    }
}
