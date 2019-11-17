package lt.em.gpro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;

@Value.Immutable
@JsonSerialize(as = ImmutableStaffAndFacilities.class)
@JsonDeserialize(as = ImmutableStaffAndFacilities.class)
public interface StaffAndFacilities {
    int getOverall();
    @NotNull Staff getStaff();
    @NotNull Facilities getFacilities();
}
