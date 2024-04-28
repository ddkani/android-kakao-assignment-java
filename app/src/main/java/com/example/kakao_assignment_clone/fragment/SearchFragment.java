package com.example.kakao_assignment_clone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kakao_assignment_clone.BuildConfig;
import com.example.kakao_assignment_clone.databinding.FragmentSearchBinding;
import com.example.kakao_assignment_clone.dto.SearchImageDocument;
import com.example.kakao_assignment_clone.dto.SearchImageResult;
import com.example.kakao_assignment_clone.recycler.search_iamge.SearchResultAdapter;
import com.example.kakao_assignment_clone.retrofit.RetrofitFactory;
import com.example.kakao_assignment_clone.retrofit.RetrofitService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {

    List<SearchImageDocument> dataset = new ArrayList<>();

    FragmentSearchBinding binding;
    RetrofitService retrofitClient;

    public SearchFragment() {
        // Required empty public constructor
    }

    // newInstance 호출 시점?
    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    // onCreate 호출 시점?
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // onCreateView 호출 시점?
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        retrofitClient = RetrofitFactory.create();

        RecyclerView searchResultView = binding.searchResultView;
        SearchResultAdapter searchResultAdapter = new SearchResultAdapter(dataset, getContext());
        searchResultView.setAdapter(searchResultAdapter);

        binding.searchButton.setOnClickListener(view -> {

            String searchParam = binding.searchEditText.getText().toString();

            // TODO: Pagination 구현하기
            retrofitClient.getImageSearch(
                BuildConfig.KAKAO_API_KEY,
                searchParam,
                "recency",
                100, 100
            ).enqueue(new Callback<SearchImageResult>() {
                @Override
                public void onResponse(Call<SearchImageResult> call, Response<SearchImageResult> response) {

                }

                @Override
                public void onFailure(Call<SearchImageResult> call, Throwable t) {

                }
            });

        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}