package lt.em.gpro.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;

@Value.Immutable
@JsonSerialize(as = ImmutableDriver.class)
@JsonDeserialize(as = ImmutableDriver.class)
public interface Driver {
    @NotNull
    @JsonProperty("name")
    String getName();

    @JsonProperty("energy")
    int getEnergy();

    @JsonProperty("overall")
    int getOverall();

    @JsonProperty("concentration")
    int getConcentration();

    @JsonProperty("talent")
    int getTalent();

    @JsonProperty("aggressiveness")
    int getAggressiveness();

    @JsonProperty("experience")
    int getExperience();

    @JsonProperty("technicalInsight")
    int getTechnicalInsight();

    @JsonProperty("stamina")
    int getStamina();

    @JsonProperty("charisma")
    int getCharisma();

    @JsonProperty("motivation")
    int getMotivation();

    @JsonProperty("reputation")
    int getReputation();

    @JsonProperty("weight")
    int getWeight();

    @JsonProperty("age")
    int getAge();
}
