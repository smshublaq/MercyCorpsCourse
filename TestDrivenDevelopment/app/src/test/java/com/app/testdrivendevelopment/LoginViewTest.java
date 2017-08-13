package com.app.testdrivendevelopment;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by iSaleem on 8/10/17.
 */

public class LoginViewTest {

    @Test
    public void exceedLoginAttempts(){
        LoginView loginView = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(loginView);
        Assert.assertEquals(1,presenter.incrementLoginAttempts());
        Assert.assertEquals(2,presenter.incrementLoginAttempts());
        Assert.assertEquals(3,presenter.incrementLoginAttempts());
        Assert.assertTrue(presenter.isExceedLimit());
    }

    @Test
    public void checkIfLoginSucceeded(){
        LoginView loginView = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(loginView);
        presenter.doLogin("aa","12");
        verify(loginView).showSuccessMessage();
    }


}
