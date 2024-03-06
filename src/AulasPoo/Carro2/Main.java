package AulasPoo.Carro2;

public class Main {
    public static void main(String[] args) {
        Automovel carro = new Automovel(new Motor(10, "combustivel", 10010),
                new Direcao("Preto", 17, true));

        System.out.println("Potencia do motor: "+carro.getMotor().getPotencia());
        System.out.println("Tipo de Combustivel: "+carro.getMotor().getCombustivel());
        System.out.println("Chassi: "+carro.getMotor().getChassi());
        System.out.println("Cor do carro: "+carro.getDirecao().getCor());
        System.out.println("Tamanho da Roda : Aro "+carro.getDirecao().getTamRaio());

        String multiMidia = carro.getDirecao().isKitMultimidia()? "Sim":"Não";
        System.out.println("Kit multimidia: "+multiMidia);




    }
}
