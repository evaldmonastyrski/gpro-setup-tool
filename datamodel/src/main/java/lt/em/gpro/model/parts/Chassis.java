package lt.em.gpro.model.parts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableChassis.class)
@JsonDeserialize(as = ImmutableChassis.class)
public interface Chassis extends CarPart {
}
