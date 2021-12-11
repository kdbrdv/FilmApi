package com.example.android3homework1.ui.filmDetail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.android3homework1.App;
import com.example.android3homework1.R;
import com.example.android3homework1.data.models.Films;
import com.example.android3homework1.databinding.FragmentFIlmDetailBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FIlmDetailFragment extends Fragment {

    private FragmentFIlmDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFIlmDetailBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String id = getArguments().getString("id");

        App.api.getFilms(id).enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                if (response.isSuccessful() && response.body() !=null){
                    Films films = response.body();
                    binding.filmTitle.setText(films.getTitle());
                    binding.textDescription.setText(films.getDescription());
                    Glide.with(requireContext()).load(films.getImage()).into(binding.imageFilm);
                }
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                Log.e("TAG", "onFailure: "  + t.getLocalizedMessage() );
            }
        });
    }
}