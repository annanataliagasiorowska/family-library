package pl.sasieczno.familyLibrary;

public enum Position {
    LIVING_ROOM("living room"),
    BOYS_ROOM("boys room"),
    STUDY_ROOM("study room"),
    PARENTS_ROOM("parents room"),
    CORRIDOR("corridor"),
    KITCHEN("kitchen");

    private final String displayName;

    Position(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
