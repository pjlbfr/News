package news.com.news.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import news.com.news.R;
import news.com.news.interfaces.OnNewsSelectedListener;
import news.com.news.responseobjects.News;

/**
 * Created by Zodiakaio on 01.03.2018.
 *
 */

public class NewsFragment extends Fragment implements NewsContract.View{

    public static final String NEWS_ID = "News_id";
    private NewsContract.Presenter presenter;
    private NewsRecycleViewAdapter newsRecycleView;
    private int pageSize = 10;
    private int id;

    public interface OpenDetailsListener {
        void openDetails(News element);
    }

    public static NewsFragment newInstance(int id) {
        NewsFragment newsFragment = new NewsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(NEWS_ID, id);
        newsFragment.setArguments(bundle);
        return newsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
            id = getArguments().getInt(NEWS_ID);
    }

    @Override
    public void setPresenter(NewsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycle_view, null);
        if (getActivity() != null)
            getActivity().setTitle(R.string.title_news);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        newsRecycleView = new NewsRecycleViewAdapter();
        newsRecycleView.setCanLoadMore(true);
        newsRecycleView.setOnNewsSelectedListener(onNewsSelectedListener);
        recyclerView.setAdapter(newsRecycleView);
        presenter.setToFirstPage();
        presenter.getNews(id);
        return view;
    }

    @Override
    public void setData(List<News> list) {
        if (list.size() < pageSize)
            newsRecycleView.setCanLoadMore(false);
        newsRecycleView.setData(list);
    }

    OnNewsSelectedListener onNewsSelectedListener = new OnNewsSelectedListener() {
        @Override
        public void onNewsSelected(News element) {
            if (getActivity() != null)
                ((OpenDetailsListener)getActivity()).openDetails(element);
        }

        @Override
        public void loadPage() {
            presenter.getNews(id);
            newsRecycleView.setLoaded();
        }
    };
}
