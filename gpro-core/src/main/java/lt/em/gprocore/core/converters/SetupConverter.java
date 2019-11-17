package lt.em.gprocore.core.converters;

import lt.em.gpro.model.ImmutableSetup;
import lt.em.gpro.model.Setup;
import lt.em.gprocalculator.calculator.datamodel.parts.CSetup;

enum SetupConverter {
    ;

    static Setup convert(CSetup cSetup) {
        return ImmutableSetup.builder()
                .frontWing(cSetup.getFrontWing())
                .rearWing(cSetup.getRearWing())
                .engine(cSetup.getEngine())
                .brakes(cSetup.getBrakes())
                .gear(cSetup.getGear())
                .suspension(cSetup.getSuspension())
                .build();
    }
}
