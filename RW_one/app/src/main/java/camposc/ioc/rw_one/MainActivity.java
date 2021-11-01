package camposc.ioc.rw_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> llistaArticles = new ArrayList<>();
    RecyclerView rvArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        omplirLlista();
        rvArticles = findViewById(R.id.rvLlista);
        rvArticles.addItemDecoration (new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        rvArticles.setAdapter(new Adaptador(llistaArticles,this));
        rvArticles.setLayoutManager(new LinearLayoutManager(this));


    }

    public void omplirLlista(){
        for(int i=0; i<21; i++){
            llistaArticles.add("Article número "+i);
        }
    }
}