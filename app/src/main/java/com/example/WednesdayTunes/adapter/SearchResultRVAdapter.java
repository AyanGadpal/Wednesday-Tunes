package com.example.WednesdayTunes.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.WednesdayTunes.R;
import com.example.WednesdayTunes.network.ResultClickListener;
import com.example.WednesdayTunes.network.model.ResultModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultRVAdapter extends RecyclerView.Adapter<SearchResultRVAdapter.ViewHolder> {

    private List<ResultModel> resultModelList;
    private ResultClickListener resultClickListener;

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.music_item_image)
        ImageView musicCoverImage;
        @BindView(R.id.music_item_title_text)
        TextView musicTitleText;
        @BindView(R.id.music_item_author_text)
        TextView musicAuthorText;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        void bindData(ResultModel resultModel) {
            musicTitleText.setText(resultModel.getTrackName());
            musicAuthorText.setText(resultModel.getArtistName());
            Glide.with(musicCoverImage.getContext())
                    .load(resultModel.getArtworkUrl100())
                    .into(musicCoverImage);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            if (pos != RecyclerView.NO_POSITION && resultClickListener != null) {
                resultClickListener.onResultItemClick(resultModelList.get(pos));
            }
        }
    }

    public SearchResultRVAdapter(ResultClickListener resultClickListener) {
        this.resultClickListener = resultClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_search_result_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(resultModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return resultModelList != null ? resultModelList.size() : 0;
    }

    public void updateResults(List<ResultModel> resultModelList) {
        this.resultModelList = resultModelList;
        notifyDataSetChanged();
    }
}
