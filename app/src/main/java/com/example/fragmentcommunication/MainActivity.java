package com.example.fragmentcommunication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private InputFragment inputFragment;
    private OutputFragment outputFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize fragments
        inputFragment = new InputFragment();
        outputFragment = new OutputFragment();

        // Add input fragment to the activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.inputContainer, inputFragment);
        transaction.add(R.id.outputContainer, outputFragment);
        transaction.commit();
    }

    // This method is called when a button (e.g., "Send") is clicked in the input fragment.
    public void sendMessage(View view) {
        String message = inputFragment.getMessage();
        outputFragment.displayMessage(message);
    }
}
