package br.com.fiap.natura.naturaapp.simulacao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.natura.naturaapp.bean.Parceiro;

/**
 * Created by daniel on 09/09/17.
 */

public class ListaParceiros {

    private static List<Parceiro> parceiros;

    public ListaParceiros() {
        criaParceiros();
    }

    private void criaParceiros() {
        parceiros = new ArrayList<Parceiro>();

        parceiros.add(new Parceiro(0, "Natura",                     "logotipo_natura1"));
        parceiros.add(new Parceiro(1, "Mercearia Açores",           "logo_mercearia"));
        parceiros.add(new Parceiro(2, "Extra",                      "logo_extra"));
        parceiros.add(new Parceiro(3, "Kabum",                      "logo_kabum"));
        parceiros.add(new Parceiro(4, "Zaeli",                      "logo_zaeli"));
        parceiros.add(new Parceiro(5, "João & Cia Supermercado",    "logo_supermercado"));
        parceiros.add(new Parceiro(6, "Gatos & Corujas Petshop",    "logo_petshop"));

    }

    public static List<Parceiro> getParceiros() {
        return parceiros;
    }

    public static void setParceiros(List<Parceiro> parceiros) {
        ListaParceiros.parceiros = parceiros;
    }

    public static Parceiro buscaPorId(long id){
        for (Parceiro parceiro : parceiros) {
            if(parceiro.getId() == id){
                return parceiro;
            }
        }
        return null;
    }

}
