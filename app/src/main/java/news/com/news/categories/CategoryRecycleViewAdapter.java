package news.com.news.categories;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import news.com.news.interfaces.OnCategorySelectedListener;
import news.com.news.responseobjects.Category;
import news.com.news.R;

/**
 * Created by Zodiakaio on 28.02.2018.
 *
 */

public class CategoryRecycleViewAdapter extends RecyclerView.Adapter<CategoryRecycleViewAdapter.ViewHolder> {

    private List<Category> categories = new ArrayList<>();
    private OnCategorySelectedListener onCategorySelectedListener;

    public CategoryRecycleViewAdapter(OnCategorySelectedListener onCategorySelectedListener){
        this.onCategorySelectedListener = onCategorySelectedListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent,false);
        return new ViewHolder(cardView);
    }

    public void setData(List<Category> list){
        categories.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Category category = categories.get(position);
        holder.category.setText(category.getName());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onCategorySelectedListener != null)
                    onCategorySelectedListener.onCategorySelected(category.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories != null ? categories.size():0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView category;
        private CardView cardView;

        public ViewHolder(CardView itemView) {
            super(itemView);
            cardView = itemView;
            category = (TextView) cardView.findViewById(R.id.text_category);
        }
    }
}
