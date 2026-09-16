public class WeightAccumulator {
    private int total_weight;

    public void add(String part_name, int part_weight) {
        total_weight += part_weight;
        System.out.println("Somando agora o peso de " + part_name + ": " + part_weight
                + ". Total parcial: " + total_weight);
    }

    public int get_total_weight() {
        return total_weight;
    }
}
