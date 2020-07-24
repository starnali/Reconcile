package com.example.reconcile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    List<News> lstNews;
    GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),1);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        lstNews = new ArrayList<>();
        lstNews.add(new News("Article 1", "Description 1", R.drawable.gradient1));
        lstNews.add(new News("Article 2", "Description 2", R.drawable.gradient2));
        lstNews.add(new News("Article 3", "Description 3", R.drawable.gradient3));
        lstNews.add(new News("Article 4", "Description 4", R.drawable.gradient4));
        lstNews.add(new News("Article 5", "Description 5", R.drawable.gradient5));
        lstNews.add(new News("Article 6", "Description 1", R.drawable.gradient1));
        lstNews.add(new News("Article 7", "Description 2", R.drawable.gradient2));
        lstNews.add(new News("Article 8", "Description 3", R.drawable.gradient3));
        lstNews.add(new News("Article 9", "Description 4", R.drawable.gradient4));
        lstNews.add(new News("Article 10", "Description 5", R.drawable.gradient5));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), lstNews);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        /** to vary card size
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
           @Override
            public int getSpanSize(int position) {
                if (adapter.isHeader(position)) {
                    return layoutManager.getSpanCount();
                } else {
                    return 1;
                }
            }

        }); **/

        return view;

    }
}