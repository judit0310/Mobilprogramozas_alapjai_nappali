package hu.uni.miskolc.recyclerviewpelda.ui.dolgozo;

import android.view.DragEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hu.uni.miskolc.recyclerviewpelda.R;

public class DolgozoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView id;
    TextView keresztnev;
    TextView vezeteknev;
    private static DolgozoAdapter.SajatClickListener listener;

    public DolgozoViewHolder(LinearLayout v, DolgozoAdapter.SajatClickListener clickListener) {
        super(v);
        v.setOnClickListener(this);
        id= v.findViewById(R.id.idMezo);
        keresztnev= v.findViewById(R.id.keresztnevMezo);
        vezeteknev = v.findViewById(R.id.vezeteknevMezo);
        listener = clickListener;
    }

    @Override
    public void onClick(View view) {
        listener.onDolgozoClick(getAdapterPosition(), view);
    }

}
