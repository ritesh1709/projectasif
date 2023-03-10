package com.example.gymmangement;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignupTabFragment extends Fragment {
    EditText Email, Password,ConformPassword;
    Button SignUp;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup_tab_fragment, container, false);

        Email = view.findViewById(R.id.signup_email);
        Password = view.findViewById(R.id.signup_password);
        ConformPassword = view.findViewById(R.id.signup_confirm);
        SignUp = view.findViewById(R.id.signup_button);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();




        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforSignUp();
            }

        });

        return view;
    }

    private void perforSignUp() {

        String password = Password.getText().toString();
        String conformpassword = ConformPassword.getText().toString();
        String email = Email.getText().toString();


        if (!email.matches(emailPattern)) {
            Email.setError("Enter Email");
        } else if (password.isEmpty()) {
            Password.setError("Enter Password");
        } else {
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        sendUserToNextActivity();
                        Toast.makeText(getActivity(),"SignUp Successful",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }

    }


    private void sendUserToNextActivity() {
        Intent intent = new Intent(getActivity(), ProfileActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}