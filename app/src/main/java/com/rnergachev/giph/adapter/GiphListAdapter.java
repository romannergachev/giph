package com.rnergachev.giph.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnergachev.giph.BR;
import com.rnergachev.giph.R;
import com.rnergachev.giph.data.model.GiphData;
import com.rnergachev.giph.handler.GiphListAdapterHandler;
import com.rnergachev.giph.viewmodel.GiphListViewModel;

/**
 * Recycler view adapter for giphs list
 */

public class GiphListAdapter extends RecyclerView.Adapter<GiphListAdapter.GiphsListViewHolder> {

    private final GiphListViewModel viewModel;
    private GiphListAdapterHandler handler;

    class GiphsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        GiphsListViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            handler.onClick(viewModel.itemsList.get(getAdapterPosition()));
        }
    }

    public GiphListAdapter(GiphListViewModel viewModel, GiphListAdapterHandler handler) {
        this.viewModel = viewModel;
        this.handler = handler;
        this.viewModel.itemsList.addOnListChangedCallback(new ObservableList.OnListChangedCallback<ObservableList<GiphData>>() {
            @Override
            public void onChanged(ObservableList<GiphData> giphDatas) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeChanged(ObservableList<GiphData> giphDatas, int positionStart, int itemCount) {
                notifyItemRangeChanged(positionStart, itemCount);
            }

            @Override
            public void onItemRangeInserted(ObservableList<GiphData> giphDatas, int positionStart, int itemCount) {
                notifyItemRangeInserted(positionStart, itemCount);
            }

            @Override
            public void onItemRangeMoved(ObservableList<GiphData> giphDatas, int fromPosition, int toPosition, int itemCount) {
                notifyDataSetChanged();
            }

            @Override
            public void onItemRangeRemoved(ObservableList<GiphData> giphDatas, int positionStart, int itemCount) {
                notifyItemRangeRemoved(positionStart, itemCount);
            }
        });
    }

    @Override
    public GiphsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new GiphsListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.giph_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(GiphsListViewHolder holder, int position) {
        ViewDataBinding binding = DataBindingUtil.bind(holder.itemView);
        binding.setVariable(BR.model, viewModel);
        binding.setVariable(BR.position, position);
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return viewModel.itemsList.size();
    }
}
