package com.app.testdrivendevelopment;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView{
    EditText etUsername;
    EditText etPassword;
    Button btnLogin;
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializePresenter();
        initView();
    }

    public void initializePresenter(){
        presenter = new LoginPresenter(this);
    }

    public void initView(){
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.doLogin(etUsername.getText().toString(),etPassword.getText().toString());
            }
        });
    }

    @Override
    public void showUsernamePasswordError() {
        Toast.makeText(this, "Error in Username or Password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserExceededLimit() {
        Snackbar.make(etUsername,"Exceeded Attempts Limit",Snackbar.LENGTH_SHORT).show();
    }


    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show();
    }
}
