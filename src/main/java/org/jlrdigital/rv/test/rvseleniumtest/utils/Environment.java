package org.jlrdigital.rv.test.rvseleniumtest.utils;

public abstract class Environment {

    private static TARGET_ENVIRONMENT environment;
    private static  USER_TYPE user;

    public static enum TARGET_ENVIRONMENT {
        PROVING("https://stockmatcher.proving.rv.jlr-apps.com","jlrprov"),
        LOCAL("http://localhost:8001","jlrprov");

        public final String url;
        public final String password;

        private TARGET_ENVIRONMENT(String url, String password) {
            this.url = url;
            this.password = password;
        }
    }

    public static enum USER_TYPE {
        JAGUAR("A-AINSWO"),
        LAND_ROVER("A-ABDI")
        ;

        public final String name;

        private USER_TYPE(String name){
            this.name = name;
        }
    }

    public static String getPassword(){
        return environment.password;
    }

    public static void setTargetEnvironment(TARGET_ENVIRONMENT targetEnvironment){
        environment = targetEnvironment;
    }

    public static void setUserType (USER_TYPE userType){
        user = userType;
    }


    public static String getUserName(){
        return user.name;
    }
    public static String getUrl(){
        return environment.url;
    }
}