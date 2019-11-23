package lt.em.gpro.model.staffandfacilities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableStaff.class)
@JsonDeserialize(as = ImmutableStaff.class)
public interface Staff {
    int getExperience();
    int getMotivation();
    int getTechnicalSkill();
    int getStressHandling();
    int getConcentration();
    int getEfficiency();
}
