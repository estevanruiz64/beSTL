package org.launchcode.BeSTL.models.data;

import org.launchcode.BeSTL.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by estel on 7/20/2017.
 */
@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
    User findByUsername(String username);

}
