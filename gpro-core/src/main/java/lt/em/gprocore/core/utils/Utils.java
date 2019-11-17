package lt.em.gprocore.core.utils;

import lt.em.gprocore.core.GPROMain;
import org.jetbrains.annotations.NotNull;

public enum Utils {
    ;

    public static boolean isDependencyAvailable(@NotNull String dependency) {
        try {
            Class.forName(dependency, false, GPROMain.class.getClassLoader());
        } catch (LinkageError | ClassNotFoundException e) {
            return false;
        }
        return true;
    }
}
