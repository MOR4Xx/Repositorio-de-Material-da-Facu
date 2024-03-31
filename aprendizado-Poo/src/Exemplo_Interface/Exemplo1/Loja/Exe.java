package Exemplo_Interface.Exemplo1.Loja;

import Exemplo_Interface.Exemplo1.Equipaments.Copiadora.Copiadora;
import Exemplo_Interface.Exemplo1.Equipaments.Digitalizadora.Digitalizadora;
import Exemplo_Interface.Exemplo1.Equipaments.Impressora.Deskjet;
import Exemplo_Interface.Exemplo1.Equipaments.Impressora.Impressora;
import Exemplo_Interface.Exemplo1.Equipaments.Impressora.Laserjet;
import Exemplo_Interface.Exemplo1.Equipaments.Multfuncional.EquipamentoMultifuncional;

public class Exe {
    public static void main(String[] args) {

        //Essa parte mostra as diferentes maneira de usar uma interface
        Impressora imp1 = new Deskjet();
        imp1.Imprimindo();

        Impressora imp2 = new Laserjet();
        imp2.Imprimindo();

        Impressora imp3 = new EquipamentoMultifuncional();
        imp3.Imprimindo();

        Impressora imp4 = imp3;
        imp4.Imprimindo();

        EquipamentoMultifuncional mlt = new EquipamentoMultifuncional();
        Digitalizadora dig = mlt; //Aqui o multi funcional pode ser chamado como uma digitalizadora, pois ele tem a interface "Digitalizadora"
        Copiadora cop = mlt; // Aqui funciona da mesma maneira da linha de cima, o objeto "mlt" tem o metodo da interface "Copiadora"

    }
}
