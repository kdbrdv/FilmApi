package com.example.android3homework1.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.android3homework1.R;
import com.example.android3homework1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}