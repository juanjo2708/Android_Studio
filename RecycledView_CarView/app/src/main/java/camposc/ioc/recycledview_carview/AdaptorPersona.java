package camposc.ioc.recycledview_carview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptorPersona extends RecyclerView.Adapter<AdaptorPersona.AdaptadorPersonaHolder> {

    private List<Usuari> llistatUsuaris;
    private Context context;

    public AdaptorPersona(List<Usuari> llistatUsuaris, Context context) {
        this.llistatUsuaris = llistatUsuaris;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_targeta, parent,false);
        return new AdaptadorPersonaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonaHolder holder, int position) {

        holder.tvNom.setText(llistatUsuaris.get(position).getNom());
        holder.tvEdat.setText(llistatUsuaris.get(position).getEdat());
        holder.iv.setImageResource(llistatUsuaris.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return llistatUsuaris.size();
    }

    public class AdaptadorPersonaHolder extends RecyclerView.ViewHolder{

        public final ImageView  iv;
        public final TextView tvNom,tvEdat;

        public AdaptadorPersonaHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.imageView);
            tvNom = itemView.findViewById(R.id.tvNom);
            tvEdat = itemView.findViewById(R.id.tvEdat);

        }
    }
}
