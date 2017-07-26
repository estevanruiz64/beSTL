package org.launchcode.BeSTL.models.data;

import org.launchcode.BeSTL.models.Restaurant;
import org.launchcode.BeSTL.models.User;
import org.launchcode.BeSTL.models.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by estel on 7/20/2017.
 */
@Repository
@Transactional
public interface VoteDao extends CrudRepository<Vote, Integer> {
    List<Vote> findByUserAndRestaurant(User user, Restaurant restaurant);
}
