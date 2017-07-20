package org.launchcode.BeSTL.models.data;

import org.launchcode.BeSTL.models.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by estel on 7/20/2017.
 */
@Repository
@Transactional
public interface RestaurantDao extends CrudRepository<Restaurant, Integer> {
}
