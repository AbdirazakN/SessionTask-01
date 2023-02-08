package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@ToString(exclude = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String description;
    @OneToMany(cascade = {PERSIST,MERGE,REFRESH,DETACH,REMOVE},fetch = FetchType.LAZY,mappedBy = "country")
    private List<Address> addresses = new ArrayList<>();

    public Country(String country, String description, List<Address> addresses) {
        this.country = country;
        this.description = description;
        this.addresses = addresses;
    }
}
