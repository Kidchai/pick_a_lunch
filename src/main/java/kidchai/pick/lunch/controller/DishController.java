package kidchai.pick.lunch.controller;

import kidchai.pick.lunch.model.AbstractEntity;
import kidchai.pick.lunch.model.Dish;
//import kidchai.pick.lunch.repository.DishRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DishController {
    private static final Logger log = LoggerFactory.getLogger(DishController.class);

//    private final DishRepository repository;
//
//    public DishController(DishRepository repository) {
//        this.repository = repository;
//    }
//
//    public Dish get(int id) {
//        int restaurantId = AbstractEntity.START_SEQ;
//        log.info("get dish {} for restaurant {}", id, restaurantId);
//        return repository.get(id, restaurantId);
//    }
//
//    public void delete(int id) {
//        int restaurantId = AbstractEntity.START_SEQ;
//        log.info("delete dish {} for restaurant {}", id, restaurantId);
//        repository.delete(id, restaurantId);
//    }
//
//    public List<Dish> getAll() {
//        int restaurantId = AbstractEntity.START_SEQ;
//        log.info("getAll for restaurant {}", restaurantId);
//        return repository.getAll(restaurantId);
//    }
//
//    public Dish create(Dish dish) {
//        int restaurantId = AbstractEntity.START_SEQ;
//        if (!dish.isNew()) {
//            throw new IllegalArgumentException(dish + " must be new (id=null)");
//        }
//        log.info("create new dish {} for restaurantId {}", dish, restaurantId);
//        return repository.create(dish, restaurantId);
//    }
//
//    public void update(Dish dish, int id) {
//        int restaurantId = AbstractEntity.START_SEQ;
//        //assureIdConsistent(meal, id);
//        log.info("update dish {} for restaurant {}", dish, restaurantId);
//        repository.update(dish, restaurantId);
//    }
}
