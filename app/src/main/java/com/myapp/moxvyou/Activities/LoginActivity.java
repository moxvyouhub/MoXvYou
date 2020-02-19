package com.myapp.moxvyou.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.myapp.moxvyou.R;
import com.myapp.moxvyou.Utils.BaseActivity;

public class LoginActivity extends BaseActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberPass;

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit=(EditText)findViewById(R.id.account);
        passwordEdit=(EditText)findViewById(R.id.password);
        rememberPass=(CheckBox)findViewById(R.id.remember_pass);
        login=(Button)findViewById(R.id.login);
        boolean isRemenber=pref.getBoolean("remember_password",false);
        if(isRemenber){
            String account = pref.getString("account","");
            String password = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);

            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                if(!account.equals("") && !password.equals("") && account!=null  && password !=null){
                    editor=pref.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"account or passward is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
