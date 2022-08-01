package deenasty.data.api.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jsoup.select.Elements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter @NoArgsConstructor @Entity
public class Deenasty {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    private String  name;
    private String  link;
}
