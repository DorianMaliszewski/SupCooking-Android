package com.supinfo.app.supcooking;

import com.supinfo.app.supcooking.models.User;

/**
 * This class is created to store all statics properties used in the projects
 * It's allow developers to simplify the configuration and improve the cohesion
 */
public class ApplicationProperties {


    public static final String SERVER_URL = "http://supinfo.steve-colinet.fr/supcooking/";
    public static final String LOGIN_ACTION = "login";
    public static final String APPLICATION_NAME = "SupCooking";

    public static User CURRENT_USER = null;
}
