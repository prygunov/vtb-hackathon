package ru.vtb.hackathon.model.geo;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Route implements Comparable<Route>{
    public Duration duration;
    public String status;
    public Distance distance;

    @Override
    public int compareTo(@NotNull Route o) {
        return duration.value - o.duration.value;
    }
}
