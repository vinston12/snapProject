package com.example.snapchatcopy;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class SignInUI {

    private EditText loginInput, passwordInput;
    private Button backButton, loginButton;

    public SignInUI(Activity context) {
        this.backButton = (Button) context.findViewById(R.id.backButton);
        this.loginButton = (Button) context.findViewById(R.id.loginInButton);
        this.loginInput = (EditText) context.findViewById(R.id.nameLabel);
        this.passwordInput = (EditText) context.findViewById(R.id.passLabel);
    }

    public EditText getLogin() {
        return loginInput;
    }

    public String getLoginText() {
        return loginInput.getText().toString();
    }

    public EditText getPassword() {
        return passwordInput;
    }

    public String getPasswordText() {
        return passwordInput.getText().toString();
    }

    public Button getBackButton() {
        return backButton;
    }

    public Button getLoginButton() {
        return loginButton;
    }
}
