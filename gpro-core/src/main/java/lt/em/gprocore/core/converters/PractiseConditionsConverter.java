package lt.em.gprocore.core.converters;

import lt.em.gpro.model.PractiseConditions;
import lt.em.gprocalculator.calculator.datamodel.CPractiseConditions;
import lt.em.gprocalculator.calculator.datamodel.ImmutableCPractiseConditions;
import org.jetbrains.annotations.NotNull;

enum PractiseConditionsConverter {
    ;

    @NotNull
    static CPractiseConditions convert(@NotNull PractiseConditions practiseConditions) {
        return ImmutableCPractiseConditions.builder()
                .trackName(practiseConditions.getTrackName())
                .trackId(practiseConditions.getTrackId())
                .trackPower(practiseConditions.getTrackPower())
                .trackHandling(practiseConditions.getTrackHandling())
                .trackAcceleration(practiseConditions.getTrackAcceleration())
                .temperatureQ1(practiseConditions.getTemperatureQ1())
                .humidityQ1(practiseConditions.getHumidityQ1())
                .weather(practiseConditions.getWeather())
                .build();
    }
}
