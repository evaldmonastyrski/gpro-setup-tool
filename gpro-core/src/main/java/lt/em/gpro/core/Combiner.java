package lt.em.gpro.core;

import lt.em.gpro.model.input.Car;
import lt.em.gpro.model.input.CombinedData;
import lt.em.gpro.model.input.Driver;
import lt.em.gpro.model.input.ImmutableCombinedData;
import lt.em.gpro.model.output.Practise;
import lt.em.gpro.model.input.PractiseConditions;
import lt.em.gpro.model.input.StaffAndFacilities;
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
