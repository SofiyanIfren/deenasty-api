package deenasty.data.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter @NoArgsConstructor @Entity
public class Country {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    private String  name;
    private String  flagLink;
    private String  capital;
}
