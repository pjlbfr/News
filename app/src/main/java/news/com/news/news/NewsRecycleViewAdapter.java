package news.com.news.news;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import news.com.news.interfaces.OnNewsSelectedListener;
import news.com.news.responseobjects.News;
import news.com.news.R;

/**
 * Created by Zodiakaio on 01.03.2018.
 *
 */

public class NewsRecycleViewAdapter extends RecyclerView.Adapter<NewsRecycleViewAdapter.ViewHolder> {

    private List<News> news = new ArrayList<>();
    private boolean isLoading;
    private boolean canLoadMore = true;

    private OnNewsSelectedListener onNewsSelectedListener;

    public void setOnNewsSelectedListener(OnNewsSelectedListener listener){
        this.onNewsSelectedListener = listener;
    }

    public void setLoaded() {
        isLoading = false;
    }

    public void setCanLoadMore(boolean canLoadMore) {
        this.canLoadMore = canLoadMore;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent,false);
        return new ViewHolder(cardView);
    }

    public void setData(List<News> list){
        news.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position == getItemCount()-1 && canLoadMore && !isLoading)
            onNewsSelectedListener.loadPage();
        final News element = news.get(position);
        holder.newsDate.setText(formatDate(element.getDate()));
        holder.newsTitle.setText(element.getTitle());
        holder.newsShortDescription.setText(element.getShortDescription());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNewsSelectedListener.onNewsSelected(element);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news != null ? news.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView newsTitle;
        private TextView newsShortDescription;
        private TextView newsDate;
        private CardView cardView;

        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView =  itemView;
            newsDate = (TextView) cardView.findViewById(R.id.text_news_date);
            newsTitle = (TextView) cardView.findViewById(R.id.text_news_title);
            newsShortDescription = (TextView) cardView.findViewById(R.id.text_news_short_description);
        }
    }

    private String formatDate(Date dateString){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.US);
        formatter.setTimeZone(TimeZone.getDefault());
        return formatter.format(dateString);
    }
}