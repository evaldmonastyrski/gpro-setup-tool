package lt.em.gpro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;

@Value.Immutable
@JsonSerialize(as = ImmutableCar.class)
@JsonDeserialize(as = ImmutableCar.class)
public interface Car {
    @NotNull Chassis getChassis();
    @NotNull Engine getEngine();
    @NotNull FrontWing getFrontWing();
    @NotNull RearWing getRearWing();
    @NotNull Underbody getUnderbody();
    @NotNull Sidepods getSidepods();
    @NotNull Cooling getCooling();
    @NotNull Gearbox getGearbox();
    @NotNull Brakes getBrakes();
    @NotNull Suspension getSuspension();
    @NotNull Electronics getElectronics();
    int getPower();
    int getHandling();
    int getAcceleration();
}
