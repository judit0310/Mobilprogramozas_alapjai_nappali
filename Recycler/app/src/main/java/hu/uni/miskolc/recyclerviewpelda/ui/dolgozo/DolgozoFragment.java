package hu.uni.miskolc.recyclerviewpelda.ui.dolgozo;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hu.uni.miskolc.recyclerviewpelda.R;

public class DolgozoFragment extends Fragment {

    private DolgozoViewModel mViewModel;
    private DolgozoAdapter adapter;

    public static DolgozoFragment newInstance() {
        return new DolgozoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dolgozo_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DolgozoViewModel.class);
        RecyclerView recyclerView = getView().findViewById(R.id.recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getView().getContext());
        recyclerView.setLayoutManager(layoutManager);
        mViewModel.getDolgozok().observe(getViewLifecycleOwner(), dolgozok -> {
            System.out.println(dolgozok);
            adapter = new DolgozoAdapter(dolgozok);
            recyclerView.setAdapter(adapter);
            adapter.setOnDolgozokClickListener(new DolgozoAdapter.SajatClickListener() {
                @Override
                public void onDolgozoClick(int position, View v) {
                    System.out.println("A következőre kattintottam: "+dolgozok.get(position));
                    //Akár activity indítás is
                }
            });

        });
        // TODO: Use the ViewModel
    }

}