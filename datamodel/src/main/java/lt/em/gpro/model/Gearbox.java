package lt.em.gpro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableGearbox.class)
@JsonDeserialize(as = ImmutableGearbox.class)
public interface Gearbox extends CarPart {
}
