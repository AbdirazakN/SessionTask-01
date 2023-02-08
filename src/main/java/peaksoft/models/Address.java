package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "region_name")
    private String regionName;
    private String street;
    @Column(name = "home_number")
    private int homeNumber;
    @ManyToOne(cascade = {REFRESH,PERSIST,MERGE,DETACH},fetch = FetchType.EAGER)
    private Country country;
    @OneToOne(mappedBy = "location")
    private Programmer programmer;

    public Address(String regionName, String street, int homeNumber, Country country, Programmer programmer) {
        this.regionName = regionName;
        this.street = street;
        this.homeNumber = homeNumber;
        this.country = country;
        this.programmer = programmer;
    }
}
