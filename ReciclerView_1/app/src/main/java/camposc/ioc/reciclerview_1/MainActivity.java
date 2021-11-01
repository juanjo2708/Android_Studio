package camposc.ioc.reciclerview_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> llista = new LinkedList<>();
    private RecyclerView llistaCompra;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        omplirLlista();
        llistaCompra = findViewById(R.id.RecyclerView);
        mAdapter = new WordListAdapter(this, llista);
        llistaCompra.setAdapter(mAdapter);
        llistaCompra.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * omplirLlista
     *
     * Omple la llista amb les dades de les tasques
     */
    public void omplirLlista(){
        llista.addLast("Macarrons");
        llista.addLast("Arròs");
        llista.addLast("Cigrons");
        llista.addLast("Llenties");
        llista.addLast("Oli oliva 1l.");
        llista.addLast("Vinagre vi negre 750cc");
        llista.addLast("Cansalada viada 500gr.");
        llista.addLast("Salsitxes safata 400gr.");
        llista.addLast("Espetec extra 250gr.");
        llista.addLast("Iogurt natural 120cc. pack 4uds.");
        llista.addLast("Netejaplats concentrat 0.5l");
        llista.addLast("Sabó líquid rentadora 32 rentats");
        llista.addLast("Pila AAA  pack 4uds.");
        llista.addLast("Barra de pa 1/4 ud.");
        llista.addLast("Galetes Maria pack 4");
        llista.addLast("Macarrons");
        llista.addLast("Arròs");
        llista.addLast("Cigrons");
        llista.addLast("Llenties");
        llista.addLast("Oli oliva 1l.");
        llista.addLast("Vinagre vi negre 750cc");
        llista.addLast("Cansalada viada 500gr.");
        llista.addLast("Salsitxes safata 400gr.");
        llista.addLast("Espetec extra 250gr.");
        llista.addLast("Macarrons");
        llista.addLast("Arròs");
        llista.addLast("Cigrons");
        llista.addLast("Llenties");
        llista.addLast("Oli oliva 1l.");
        llista.addLast("Vinagre vi negre 750cc");
        llista.addLast("Cansalada viada 500gr.");
        llista.addLast("Salsitxes safata 400gr.");
        llista.addLast("Espetec extra 250gr.");
    }


}