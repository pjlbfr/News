package news.com.news.categories;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import news.com.news.interfaces.OnCategorySelectedListener;
import news.com.news.R;
import news.com.news.responseobjects.Category;

/**
 * Created by Zodiakaio on 01.03.2018.
 *
 */


public class CategoryFragment extends Fragment implements CategoryContract.View {

    private CategoryContract.Presenter presenter;
    private CategoryRecycleViewAdapter categoryRecycleViewAdapter;

    public interface OpenNewsListener {
        void openNews(int id);
    }

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public void setPresenter(@NonNull CategoryContract.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void setData(List<Category> list) {
        categoryRecycleViewAdapter.setData(list);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycle_view, null);
        if (getActivity() != null)
            getActivity().setTitle(R.string.title_categories);
        categoryRecycleViewAdapter = new CategoryRecycleViewAdapter(onCategorySelectedListener);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(categoryRecycleViewAdapter);
        presenter.getCategory();
        return view;
    }

    OnCategorySelectedListener onCategorySelectedListener = new OnCategorySelectedListener() {
        @Override
        public void onCategorySelected(int id) {
            if (getActivity() != null)
                ((OpenNewsListener)getActivity()).openNews(id);
        }
    };
}
