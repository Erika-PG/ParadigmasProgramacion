package Metodo_Shuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MazoDeCartas {
    private List<Carta> listaCartas;

    public MazoDeCartas(){
        Carta[] mazo= new Carta[52];
        int cuenta = 0;

        for(Carta.Palo palo:Carta.Palo.values()){
            for(Carta.Cara cara : Carta.Cara.values()){
                mazo[cuenta]=new Carta(cara,palo);
                ++cuenta;
            }
        }
        listaCartas=Arrays.asList(mazo);
        Collections.shuffle(listaCartas);
    }

    public List<Carta> getListaCartas() {
        return listaCartas;
    }

    public void imprimirCartas() {
    //listaCartas
       for (int i=0; i<listaCartas.size(); i++){
           System.out.printf("%-23s%s", listaCartas.get(i),((i+1)% 4==0) ? "\n":"");
       }
    }
}
