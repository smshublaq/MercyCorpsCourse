package com.app.testdrivendevelopment;

/**
 * Created by iSaleem on 8/10/17.
 */

public class LoginPresenter {

    private static final int MAX_ATTEMPTS = 3;
    private final LoginView loginView;
    private int attempts = 0;

    LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }
    public int incrementLoginAttempts(){
        return this.attempts += 1;
    }

    public boolean isExceedLimit(){
        return attempts >= MAX_ATTEMPTS;
    }

    public void doLogin(String username,String password){
        if(isExceedLimit()){
            loginView.showUserExceededLimit();
            return;
        }

        if(username.equals("aa") && password.equals("12")){
            loginView.showSuccessMessage();
            return;
        }

        incrementLoginAttempts();
        loginView.showUsernamePasswordError();

    }


}
