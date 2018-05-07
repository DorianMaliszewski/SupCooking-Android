package com.supinfo.app.supcooking.repositories;

import android.app.Application;
import android.os.AsyncTask;

import com.supinfo.app.supcooking.dao.SupCookingDatabase;
import com.supinfo.app.supcooking.dao.UserDao;
import com.supinfo.app.supcooking.models.User;

import java.util.List;

public class UserRepository {
    private UserDao mUserDao;
    private List<User> mAllUsers;

    UserRepository (Application app) {
        SupCookingDatabase db = SupCookingDatabase.getDatabase(app);
        mUserDao = db.userDao();
        mAllUsers = mUserDao.getAllUsers();
    }

    List<User> getAllUsers() {
        return mAllUsers;
    }

    public void insert (User user) {
        new insertAsyncTask(mUserDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask (UserDao userDao) {
            mAsyncTaskDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            mAsyncTaskDao.insert(users[0]);
            return null;
        }
    }
}
