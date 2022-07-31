package deenasty.data.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter @Setter @NoArgsConstructor @Entity
public class Country {
    @Id
    private Long    id;
    private String  name;
    private String  flagLink;
    // TODO : private String  capital; // City FK
    // TODO : private String  officialLanguage; // Language FK
}
