package kidchai.restaurant.voting.system.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurant_id"),
        @NamedQuery(name = Dish.GET_ALL, query = "SELECT d FROM Dish d WHERE d.restaurant.id=:restaurant_id"),
})
@Entity
@Table(name = "dishes")
public class Dish extends AbstractEntity {

    public static final String DELETE = "Dish.delete";
    public static final String GET_ALL = "Dish.getAll";
    @Column(name = "dish_name", nullable = false)
    @NotBlank
    private String dishName;
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

    public Dish(LocalDate date, String dishName, int price) {
        this(null, date, dishName, price);
    }

    public Dish(Integer dishId, LocalDate date, String dishName, int price) {
        super(dishId);
        this.date = date;
        this.dishName = dishName;
        this.price = price;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String name) {
        this.dishName = name;
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
