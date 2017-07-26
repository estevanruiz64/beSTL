package org.launchcode.BeSTL.controllers;

import org.launchcode.BeSTL.models.User;
import org.launchcode.BeSTL.models.data.CategoryDao;
import org.launchcode.BeSTL.models.data.VoteDao;
import org.launchcode.BeSTL.models.data.RestaurantDao;
import org.launchcode.BeSTL.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by estel on 7/15/2017.
 */

public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected RestaurantDao restaurantDao;

    @Autowired
    protected VoteDao voteDao;

    @Autowired
    protected CategoryDao categoryDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findOne(userId);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }

}