package Exemplo_Interface.Exemplo1.Equipaments.Multfuncional;

import Exemplo_Interface.Exemplo1.Equipaments.Copiadora.Copiadora;
import Exemplo_Interface.Exemplo1.Equipaments.Digitalizadora.Digitalizadora;
import Exemplo_Interface.Exemplo1.Equipaments.Impressora.Impressora;

public class EquipamentoMultifuncional implements Copiadora, Digitalizadora, Impressora {
    @Override
    public void copiando() {
        System.out.println("Copiando...");
    }

    @Override
    public void digitalizando() {
        System.out.println("Scanneando...");
        System.out.println("Digitalizando...");
    }

    @Override
    public void Imprimindo() {
        System.out.println("Imprimindo Multfuncional...");
    }
}
