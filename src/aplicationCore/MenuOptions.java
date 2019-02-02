package aplicationCore;

public enum MenuOptions {
    CHECK_WORKERS_ABILITIES,
    CHECK_RESOURCES,
    BUILD_WONDER,
    BUILD_A_BUILDING,
    RESOLVE_CRISIS,
    PRODUCE_RESOURCES,
    MARKETPLACE,
    END_TURN,
    VILLAGE_VIEW;

    public static MenuOptions menuOptionByOrdinal(int ordinal) {
        for (MenuOptions option : MenuOptions.values()) {
            if (option.ordinal() == ordinal) {
                return option;
            }
        }
        return null;
    }
}
