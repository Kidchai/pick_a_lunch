package kidchai.restaurant.voting.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractEntity {
    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    public Restaurant() {

    }

    public Restaurant(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
