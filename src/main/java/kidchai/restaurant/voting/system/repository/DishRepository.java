package kidchai.restaurant.voting.system.repository;

import kidchai.restaurant.voting.system.model.Dish;
import kidchai.restaurant.voting.system.model.Restaurant;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class DishRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    // null if updated dish does not belong to restaurantId
    public Dish save(Dish dish, int restaurantId) {
        dish.setRestaurant(em.getReference(Restaurant.class, restaurantId));
        if (dish.isNew()) {
            em.persist(dish);
            return dish;
        } else {
            Dish existedDish = get(dish.getId(), restaurantId);
            int existedUserId = dish.getRestaurant().getId();
            return existedDish != null && restaurantId == existedUserId ? em.merge(dish) : null;
        }
    }

    @Transactional
    // false if dish does not belong to restaurantId
    public boolean delete(int id, int restaurantId) {
        return em.createNamedQuery(Dish.DELETE)
                .setParameter("id", id)
                .setParameter("restaurant_id", restaurantId)
                .executeUpdate() != 0;
    }

    // null if dish does not belong to restaurantId
    public Dish get(int id, int restaurantId) {
        Dish dish = em.find(Dish.class, id);
        return dish != null && dish.getRestaurant().getId() == restaurantId ? dish : null;
    }

    public List<Dish> getAll(int restaurantId) {
        return em.createNamedQuery(Dish.GET_ALL)
                .setParameter("restaurant_id", restaurantId)
                .getResultList();
    }
}
