package lt.em.gprocore.core.converters;

import lt.em.gpro.model.*;
import lt.em.gprocalculator.calculator.datamodel.CCar;
import lt.em.gprocalculator.calculator.datamodel.ImmutableCCar;
import lt.em.gprocalculator.calculator.datamodel.parts.*;
import org.jetbrains.annotations.NotNull;

enum CarConverter {
    ;

    @NotNull
    static CCar convert(@NotNull Car car) {
        return ImmutableCCar.builder()
                .power(car.getPower())
                .handling(car.getHandling())
                .acceleration(car.getAcceleration())
                .chassis(ImmutableCChassis.builder()
                        .level(car.getChassis().getLevel())
                        .wear(car.getChassis().getWear())
                        .build())
                .engine(ImmutableCEngine.builder()
                        .level(car.getEngine().getLevel())
                        .wear(car.getEngine().getWear())
                        .build())
                .frontWing(ImmutableCFrontWing.builder()
                        .level(car.getFrontWing().getLevel())
                        .wear(car.getFrontWing().getWear())
                        .build())
                .rearWing(ImmutableCRearWing.builder()
                        .level(car.getRearWing().getLevel())
                        .wear(car.getRearWing().getWear())
                        .build())
                .underbody(ImmutableCUnderbody.builder()
                        .level(car.getUnderbody().getLevel())
                        .wear(car.getUnderbody().getWear())
                        .build())
                .sidepods(ImmutableCSidepods.builder()
                        .level(car.getSidepods().getLevel())
                        .wear(car.getSidepods().getWear())
                        .build())
                .cooling(ImmutableCCooling.builder()
                        .level(car.getCooling().getLevel())
                        .wear(car.getCooling().getWear())
                        .build())
                .gearbox(ImmutableCGearbox.builder()
                        .level(car.getGearbox().getLevel())
                        .wear(car.getGearbox().getWear())
                        .build())
                .brakes(ImmutableCBrakes.builder()
                        .level(car.getBrakes().getLevel())
                        .wear(car.getBrakes().getWear())
                        .build())
                .suspension(ImmutableCSuspension.builder()
                        .level(car.getSuspension().getLevel())
                        .wear(car.getSuspension().getWear())
                        .build())
                .electronics(ImmutableCElectronics.builder()
                        .level(car.getElectronics().getLevel())
                        .wear(car.getElectronics().getWear())
                        .build())
                .build();
    }
}
