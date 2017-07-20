package org.launchcode.BeSTL.models.data;

import org.launchcode.BeSTL.models.Category;
import org.launchcode.BeSTL.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by estel on 7/20/2017.
 */
@Repository
@Transactional
public interface RestaurantDao extends CrudRepository<Restaurant, Integer> {
    List<Restaurant> findByCategory(Category category);

}
