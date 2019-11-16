package lt.em.gpro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableRearWing.class)
@JsonDeserialize(as = ImmutableRearWing.class)
interface RearWing extends CarPart {
}
