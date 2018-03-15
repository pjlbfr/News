package news.com.news.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import news.com.news.responseobjects.News;
import news.com.news.R;

/**
 * Created by Zodiakaio on 01.03.2018.
 *
 */

public class DetailsFragment extends Fragment implements DetailsContract.View{

    public static final String DETAILS_TAG = "Details_Tag";
    private TextView titleTextView;
    private TextView dateTextView;
    private TextView descriptionTextView;
    private News news;
    private DetailsContract.Presenter presenter;

    public static DetailsFragment newInstance(News element){
        DetailsFragment details = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(DETAILS_TAG,element);
        details.setArguments(bundle);
        return details;
    }

    @Override
    public void setPresenter(@NonNull DetailsContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        news = (News)getArguments().getParcelable(DETAILS_TAG);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_details, null);
        if (getActivity() != null)
            getActivity().setTitle(R.string.title_details);
        titleTextView = (TextView) view.findViewById(R.id.text_details_title);
        dateTextView = (TextView) view.findViewById(R.id.text_details_date);
        descriptionTextView = (TextView) view.findViewById(R.id.text_details_description);
        titleTextView.setText(news.getTitle());
        dateTextView.setText(formatDate(news.getDate()));
        descriptionTextView.setText(news.getShortDescription());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getDetails(news.getId());
    }

    public void setData(News element){
        titleTextView.setText(element.getTitle());
        dateTextView.setText(formatDate(element.getDate()));
        descriptionTextView.setText(Html.fromHtml(element.getFullDescription()));
        descriptionTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private String formatDate(Date dateString){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.US);
        formatter.setTimeZone(TimeZone.getDefault());
        return formatter.format(dateString);
    }
}