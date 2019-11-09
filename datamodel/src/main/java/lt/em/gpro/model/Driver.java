package lt.em.gpro.model;

import org.immutables.value.Value;

@Value.Immutable
public interface Driver {
    int getEnergy();

    int getOverall();

    int getConcentration();

    int getTalent();

    int getAggressiveness();

    int getExperience();

    int getTechnicalInsight();

    int getStamina();

    int getCharisma();

    int getMotivation();

    int getReputation();

    int getWeight();

    int getAge();
}
