package lt.em.gpro.model.output;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;

@Value.Immutable
@JsonSerialize(as = ImmutableSetup.class)
@JsonDeserialize(as = ImmutableSetup.class)
public interface Setup {
    int getFrontWing();
    int getRearWing();
    int getEngine();
    int getBrakes();
    int getGear();
    int getSuspension();

    @NotNull
    static Setup getDefaultSetup() {
        return ImmutableSetup.builder()
                .frontWing(0)
                .rearWing(0)
                .engine(0)
                .brakes(0)
                .gear(0)
                .suspension(0)
                .build();
    }
}
