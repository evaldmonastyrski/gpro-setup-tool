package lt.em.gpro.model.staffandfacilities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableFacilities.class)
@JsonDeserialize(as = ImmutableFacilities.class)
public interface Facilities {
    int getWindTunnel();
    int getPitstopTrainingCentre();
    int getRnDWorkshop();
    int getRnDDesignCentre();
    int getEngineeringWorkshop();
    int getAlloyAndChemicalLab();
    int getCommercial();
}
