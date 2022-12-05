package kidchai.pick.lunch.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurant_id"),
        @NamedQuery(name = Dish.GET_ALL, query = "SELECT d FROM Dish d WHERE d.restaurant.id=:restaurant_id"),
})
@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "date"}, name = "dish_unique_name")})
public class Dish extends AbstractEntity {

    public static final String DELETE = "Dish.delete";
    public static final String GET_ALL = "Dish.getAll";
    @Column(name = "dish", nullable = false)
    @NotBlank
    private String dish;
    @Column(name = "price", nullable = false)
    @NotNull
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant", nullable = false)
    @NotNull
    private Restaurant restaurant;
    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;

    public Dish() {

    }

    public Dish(LocalDate date, String dish, int price) {
        this(null, date, dish, price);
    }

    public Dish(Integer dishId, LocalDate date, String dish, int price) {
        super(dishId);
        this.date = date;
        this.dish = dish;
        this.price = price;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String name) {
        this.dish = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
