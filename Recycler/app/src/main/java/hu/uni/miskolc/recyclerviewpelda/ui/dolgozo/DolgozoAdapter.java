package hu.uni.miskolc.recyclerviewpelda.ui.dolgozo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hu.uni.miskolc.recyclerviewpelda.R;
import hu.uni.miskolc.recyclerviewpelda.model.Dolgozo;

public class DolgozoAdapter extends RecyclerView.Adapter<DolgozoViewHolder> {

    private List<Dolgozo> dolgozok;
    private static SajatClickListener listener;

    public DolgozoAdapter(List<Dolgozo> dolgozok) {
        this.dolgozok = dolgozok;
    }

    @NonNull
    @Override
    public DolgozoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext()).
                inflate(R.layout.dolgozo_sor, parent, false);
        DolgozoViewHolder vh = new DolgozoViewHolder(layout, listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DolgozoViewHolder holder, int position) {
        Dolgozo dolgozo = dolgozok.get(position);
        holder.vezeteknev.setText(dolgozo.getVezetekNev());
        holder.keresztnev.setText(dolgozo.getKeresztNev());
        holder.id.setText(String.valueOf(dolgozo.getDolgozoId()));
    }

    @Override
    public int getItemCount() {
        return dolgozok.size();
    }

    public void setOnDolgozokClickListener(SajatClickListener clickListener){
        listener = clickListener;
    }

    public interface SajatClickListener{
        void onDolgozoClick(int position, View v);
    }
}
