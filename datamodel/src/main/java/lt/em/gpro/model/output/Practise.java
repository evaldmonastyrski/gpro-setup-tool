package lt.em.gpro.model.output;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;

@Value.Immutable
@JsonSerialize(as = ImmutablePractise.class)
@JsonDeserialize(as = ImmutablePractise.class)
public interface Practise {
    int getAttempt();
    double getNetTime();
    int getFrontWingSetup();
    int getRearWingSetup();
    int getEngineSetup();
    int getBrakesSetup();
    int getGearSetup();
    int getSuspensionSetup();
    @NotNull String getTyreType();
}
