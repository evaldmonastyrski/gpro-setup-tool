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
                                           @NotNull StaffAndFacilities staffAndFacilities,
                                           @NotNull Practise practise) {
        return ImmutableCombinedData.builder()
                .driver(driver)
                .car(car)
                .practiseConditions(practiseConditions)
                .staffAndFacilities(staffAndFacilities)
                .practise(practise)
                .build();
    }
}
