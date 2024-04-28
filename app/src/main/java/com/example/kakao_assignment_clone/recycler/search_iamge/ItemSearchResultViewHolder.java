package com.example.kakao_assignment_clone.recycler.search_iamge;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kakao_assignment_clone.databinding.ItemSearchResultBinding;
import com.example.kakao_assignment_clone.dto.SearchImageDocument;


public class ItemSearchResultViewHolder extends RecyclerView.ViewHolder {
    public final ItemSearchResultBinding binding;

    public ItemSearchResultViewHolder(ItemSearchResultBinding binding) {
        // 생성자로 이미 inflate 된 ViewBinding 인스턴스를 받는다.
        // 데이터의 렌더링은 이곳에서 하지 않는다.
        super(binding.getRoot());
        this.binding = binding;
    }
}
