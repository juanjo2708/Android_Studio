package camposc.ioc.rw_one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderArticle> {

     private List<String> articles;
     private LayoutInflater lInflater;

    public Adaptador(List<String> articles, Context context) {
        this.articles = articles;
        this.lInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Adaptador.ViewHolderArticle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = lInflater.inflate(R.layout.item_llista,parent,false);
        return new ViewHolderArticle(vista,this);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolderArticle holder, int position) {
        String articleStr = articles.get(position);
        holder.tv_article.setText(articleStr);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    /**
     * ViewHolderArticle
     *
     * **************************************************************************************
     */
    class ViewHolderArticle extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final TextView tv_article;
        public final CheckBox cb_article;

        final Adaptador mAdapter;

        public ViewHolderArticle(@NonNull View itemView, Adaptador mAdapter) {
            super(itemView);
            this.tv_article =itemView.findViewById(R.id.tv_layout);
            this.cb_article = itemView.findViewById(R.id.cb_article);
            this.mAdapter = mAdapter;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View vista) {
            if(cb_article.isChecked()){
                cb_article.setChecked(false);
            }else{
                cb_article.setChecked(true);
            }
        }
    }
}
