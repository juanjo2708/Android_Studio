package camposc.ioc.reciclerview_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> llistaArticles;
    private RecyclerView rv;
    private ArticlesAdaptador aAdaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        omplirLlistaArticles();
        configurarReciclerView();

    }

    /**
     * Configura el RecyclerView
     *   - Layout manager,
     *   - adaptador
     */
    public void configurarReciclerView(){
        rv = findViewById(R.id.reciclerView);
        aAdaptador = new ArticlesAdaptador(this,llistaArticles);
        rv.setAdapter(aAdaptador);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Crea una llista d'articles per fer proves de funcionament
     */
    public void omplirLlistaArticles(){
        for (int i=0; i<21;i++){
            llistaArticles.add("Article numero "+i);
        }
    }
}