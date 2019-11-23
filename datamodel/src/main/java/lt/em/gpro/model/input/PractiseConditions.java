package lt.em.gpro.model.input;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;

@Value.Immutable
@JsonSerialize(as = ImmutablePractiseConditions.class)
@JsonDeserialize(as = ImmutablePractiseConditions.class)
public interface PractiseConditions {
    @NotNull String getTrackName();
    int getTrackId();
    int getTrackPower();
    int getTrackHandling();
    int getTrackAcceleration();
    int getTemperatureQ1();
    int getHumidityQ1();
    @NotNull String getWeather();
}
