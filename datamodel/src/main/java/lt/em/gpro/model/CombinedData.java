package lt.em.gpro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;

@Value.Immutable
@JsonSerialize(as = ImmutableCombinedData.class)
@JsonDeserialize(as = ImmutableCombinedData.class)
public interface CombinedData {
    @NotNull Driver getDriver();
    @NotNull Car getCar();
    @NotNull PractiseConditions getPractiseConditions();
    @NotNull StaffAndFacilities getStaffAndFacilities();
    @NotNull Practise getPractise();
}
