public interface CarPart {
    String get_name();

    int get_weight();

    void accumulate_weight(WeightAccumulator accumulator);
}
