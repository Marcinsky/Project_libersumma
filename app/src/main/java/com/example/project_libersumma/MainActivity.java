package com.example.project_libersumma;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_libersumma.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

        ActivityMainBinding binding;

        FirebaseAuth firebaseAuth;
        FirebaseFirestore firebaseFirestore;

        ProgressDialog progressDialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            firebaseAuth=FirebaseAuth.getInstance();
            firebaseFirestore=FirebaseFirestore.getInstance();

            progressDialog = new ProgressDialog(this);
            binding.signupButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    String name= binding.nameInput.getText().toString();
                    String email= binding.emailInput.getText().toString().trim();
                    String password= binding.passwordInput.getText().toString();

                    progressDialog.show();
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                                    progressDialog.cancel();

                                    firebaseFirestore.collection("User")
                                            .document(FirebaseAuth.getInstance().getUid())
                                            .set(new UserModel(name,email));
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(MainActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                                    progressDialog.cancel();
                                }
                            });

                    }
                });
            binding.goToLoginInput.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent( MainActivity.this, LoginActivity.class));
                }
            });
            };
        }
