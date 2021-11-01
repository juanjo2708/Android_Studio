package camposc.ioc.reciclerview_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mArticlesList;   //Estructura de llista enllaçada per mantenir les dades a l'adaptador


    private LayoutInflater mInflater; // LayoutInflator llegeix una descripció XML de disseny i la converteix en la corresponent vista.

    // Constructor de l'adaptador
    public WordListAdapter(Context context, LinkedList<String> articlesList){
        mInflater = LayoutInflater.from(context);
        this.mArticlesList= articlesList;
    }

    @NonNull
    @Override  //Crear la vista sense personalitzar, retorna un ViewHolder amb el disseny i l'adaptador.
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item,parent,false);
        return new WordViewHolder(mItemView,this);
    }

    @Override //personalitzem el ViewHolder en concret amb el holder i la posició.
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mArticlesList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override  // Retorna la mida de la llista d'articles.
    public int getItemCount() {
        return mArticlesList.size();
    }

    /**
     *  WordViewHolder class
     *
     *  Definim el ViewHolder associat al controlador
     */
    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        // Definim els controls de la vista i l'adaptador.
        public final TextView wordItemView;
        public final CheckBox checkBoxItem;
        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter){
            super(itemView);

            // enllacem els controls de la vista i l'adaptador
            wordItemView = itemView.findViewById(R.id.article);
            checkBoxItem = itemView.findViewById(R.id.checkBox);
            this.mAdapter = adapter;

            // Activem l'oient per a l'event onClick
            itemView.setOnClickListener(this);
        }

        // Gestionem el onclick sobre una vista.
        @Override
        public void onClick(View view) {
            int posicio = getLayoutPosition();
            String articleClicked =mArticlesList.get(posicio);
            mArticlesList.set(posicio, "x "+articleClicked);

            mAdapter.notifyDataSetChanged();
        }
    }
}
