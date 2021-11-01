package camposc.ioc.recycledview_carview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declaració de variables
    RecyclerView rv1;
    AdaptorPersona ap;
    List<Usuari> usuaris = new ArrayList<>();

    //Vectors amb les dades
    String [] noms = { "Mariona Campos","Joan Campos","Juanjo Campos","Ona Dominguez","An Dominguez","Anna Dominguez","Juanjo Piedra","Juan Miranda"};
    int [] edats = {24,23,53,15,12,55,70,85};
    int [] fotos = {R.drawable.MarionaDNI,R.drawable.PerfilRodo,R.drawable.PerfilRodo_1,R.drawable.MarionaDNI,R.drawable.PerfilRodo,R.drawable.PerfilRodo_1,R.drawable.MarionaDNI,R.drawable.PerfilRodo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        omplirLlistaUsuaris();
        inicialitzarElements();


    }

    public void inicialitzarElements(){
        rv1 = findViewById(R.id.rv1);
        rv1.setLayoutManager((new LinearLayoutManager(this)));
        ap = new AdaptorPersona(usuaris, this);
        rv1.setAdapter(ap);
    }


    public void omplirLlistaUsuaris(){
       for(int i=0; i<20;i++){
           usuaris.add("Nom cognoms"+i, i, 1);
       }
    }
}