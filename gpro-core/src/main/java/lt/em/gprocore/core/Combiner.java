package lt.em.gprocore.core;

import lt.em.gpro.model.Car;
import lt.em.gpro.model.CombinedData;
import lt.em.gpro.model.Driver;
import lt.em.gpro.model.ImmutableCombinedData;
import lt.em.gpro.model.Practise;
import lt.em.gpro.model.PractiseConditions;
import lt.em.gpro.model.StaffAndFacilities;
import org.jetbrains.annotations.NotNull;

enum Combiner {
    ;

    @NotNull
    static CombinedData createCombinedData(@NotNull Driver driver,
                                           @NotNull Car car,
                                           @NotNull PractiseConditions practiseConditions,
                                           @NotNull Practise practise,
                                           @NotNull StaffAndFacilities staffAndFacilities) {
        return ImmutableCombinedData.builder()
                .driver(driver)
                .car(car)
                .practiseConditions(practiseConditions)
                .practise(practise)
                .staffAndFacilities(staffAndFacilities)
                .build();
    }
}
