import java.util.ArrayList;
import java.util.List;

public class CompositePart implements CarPart {
    private String name;
    private List<CarPart> parts;

    public CompositePart(String name) {
        this.name = name;
        this.parts = new ArrayList<>();
    }

    public void add_part(CarPart part) {
        parts.add(part);
    }

    @Override
    public String get_name() {
        return name;
    }

    @Override
    public int get_weight() {
        int total_weight = 0;
        for (CarPart part : parts) {
            total_weight += part.get_weight();
        }
        return total_weight;
    }

    @Override
    public void accumulate_weight(WeightAccumulator accumulator) {
        for (CarPart part : parts) {
            part.accumulate_weight(accumulator);
        }
    }
}
