package lt.em.gpro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableChassis.class)
@JsonDeserialize(as = ImmutableChassis.class)
interface Chassis extends CarPart {
}
