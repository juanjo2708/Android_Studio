package camposc.ioc.reciclerview_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticlesAdaptador extends RecyclerView.Adapter<ArticlesAdaptador.ArticleViewHolder> {

    Context context;
    List<String> llistaArticles;

    public ArticlesAdaptador(Context context, List<String> llistaArticles) {
        this.context = context;
        this.llistaArticles = llistaArticles;
    }

    @NonNull
    @Override  // Retorna una vista (viewholder) sense personalitzar.
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.llista_compra_layout,parent,false);
        return new ArticleViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        String articleStr = llistaArticles.get(position);
        holder.article.setText(articleStr);
    }

    @Override
    public int getItemCount() {
        return llistaArticles.size();
    }

    /**
     * ArticleViewHolder
     *
     */
    class ArticleViewHolder extends RecyclerView.ViewHolder{ //implements View.OnClickListener {
        private CheckBox chBox;
        private TextView article;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
           // chBox = itemView.findViewById(R.id.seleccio);
            article = itemView.findViewById(R.id.article);

            // Activem l'oient per a l'event onClick
           // itemView.setOnClickListener(this);
        }

        /*/ Implementem l'event click sobre l'element
        @Override
        public void onClick(View view) {
            if(chBox.isChecked()){
                chBox.setChecked(false);
            }else{
                chBox.setChecked(true);
            }
        }*/
    }
}
