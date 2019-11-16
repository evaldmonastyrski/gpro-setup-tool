package lt.em.gpro.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableUnderbody.class)
@JsonDeserialize(as = ImmutableUnderbody.class)
public interface Underbody extends CarPart {
}
