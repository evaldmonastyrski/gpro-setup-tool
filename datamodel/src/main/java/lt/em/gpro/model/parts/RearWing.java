package lt.em.gpro.model.parts;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableRearWing.class)
@JsonDeserialize(as = ImmutableRearWing.class)
public interface RearWing extends CarPart {
}
