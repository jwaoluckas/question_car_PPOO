/**
 * Monta a arvore de pecas do carro e calcula o peso total
 */
public class Main {
    public static void main(String[] args) {
        CompositePart body = new CompositePart("Carroceria");
        body.add_part(new SimplePart("Para-lama dianteiro esquerdo", 10));
        body.add_part(new SimplePart("Para-lama dianteiro direito", 10));
        body.add_part(new SimplePart("Para-lama traseiro esquerdo", 10));
        body.add_part(new SimplePart("Para-lama traseiro direito", 10));
        body.add_part(new SimplePart("Porta dianteira esquerda", 15));
        body.add_part(new SimplePart("Porta dianteira direita", 15));
        body.add_part(new SimplePart("Porta traseira esquerda", 15));
        body.add_part(new SimplePart("Porta traseira direita", 15));
        body.add_part(new SimplePart("Painel", 5));
        body.add_part(new SimplePart("Porta-malas", 8));
        body.add_part(new SimplePart("Capo", 12));

        CompositePart powertrain = new CompositePart("Trem de forca");
        powertrain.add_part(new SimplePart("Motor", 90));
        powertrain.add_part(new SimplePart("Transmissao", 40));
        powertrain.add_part(new SimplePart("Diferencial", 25));
        powertrain.add_part(new SimplePart("Roda dianteira esquerda", 18));
        powertrain.add_part(new SimplePart("Roda dianteira direita", 18));
        powertrain.add_part(new SimplePart("Roda traseira esquerda", 18));
        powertrain.add_part(new SimplePart("Roda traseira direita", 18));

        CompositePart chassis = new CompositePart("Chassi");
        chassis.add_part(powertrain);
        chassis.add_part(new SimplePart("Suspensao", 20));

        CompositePart car = new CompositePart("Carro");
        car.add_part(body);
        car.add_part(chassis);

        WeightAccumulator accumulator = new WeightAccumulator();
        car.accumulate_weight(accumulator);

        System.out.println("Peso total do carro: " + car.get_weight());
    }
}
