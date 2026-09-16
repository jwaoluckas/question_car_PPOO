public class SimplePart implements CarPart {
    private String name;
    private int weight;

    public SimplePart(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String get_name() {
        return name;
    }

    @Override
    public int get_weight() {
        return weight;
    }

    @Override
    public void accumulate_weight(WeightAccumulator accumulator) {
        accumulator.add(name, weight);
    }
}
