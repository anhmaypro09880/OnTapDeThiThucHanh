package com.example.ontapsqlite3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText edtEmail,edtPass1,edtPass2;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        khaiBao();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String pass1 = edtPass1.getText().toString();
                String pass2 = edtPass2.getText().toString();
                MainActivity.auth.createUserWithEmailAndPassword(email,pass1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Register.this,"ThanhCong",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    private void khaiBao() {
        edtEmail = findViewById(R.id.edtEmailR);
        edtPass1 = findViewById(R.id.edtPass1);
        edtPass2 = findViewById(R.id.edtPass2);
        btnRegister = findViewById(R.id.btnRegister);
    }
}