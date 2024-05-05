package com.example.kakao_assignment_clone.recycler.search_iamge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kakao_assignment_clone.databinding.ItemSearchResultBinding;
import com.example.kakao_assignment_clone.dto.SearchImageDocument;
import com.example.kakao_assignment_clone.dto.SearchImageResult;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<ItemSearchResultViewHolder> {

    private List<SearchImageDocument> dataset; // Adapter 에서 가지고 있는 데이터셋
    private Context context; // Glide 사용 시 필요

    public SearchResultAdapter(List<SearchImageDocument> dataset, Context context) {
        this.dataset = dataset;
        this.context = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setSearchResults(List<SearchImageDocument> newDataset) {
        dataset.clear();
        dataset.addAll(newDataset);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemSearchResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 새로운 SearchImageViewHolder 를 생성하여 반환한다.
        // ** 데이터의 렌더링은 수행하지 않는다.

        ItemSearchResultBinding binding = ItemSearchResultBinding.inflate(
            LayoutInflater.from(parent.getContext()), parent, false
        );
        return new ItemSearchResultViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemSearchResultViewHolder holder, int position) {
        SearchImageDocument document = dataset.get(position);
        ItemSearchResultBinding binding = holder.binding;

        Glide.with(context).load(document.getThumbnailUrl()).into(binding.itemSearchPreviewImage);
        Glide.with(context).load(document.getImageUrl()).into(binding.itemSearchImage);

        binding.itemSearchDescription.setText(String.format(
            "%s\n%s",
            document.getDisplaySiteName(),
            document.getDatetime()
        ));

        // TODO: OnClickListener 지정하기
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
