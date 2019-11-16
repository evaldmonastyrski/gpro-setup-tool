package lt.em.gpro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableBrakes.class)
@JsonDeserialize(as = ImmutableBrakes.class)
public interface Brakes extends CarPart {
}
