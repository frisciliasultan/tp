package seedu.iscam.model.commons;

import static java.util.Objects.requireNonNull;
import static seedu.iscam.commons.util.AppUtil.checkArgument;

/**
 * Represents a Client's iscam in the iscam book.
 * Guarantees: immutable; is valid as declared in {@link #isValidLocation(String)}
 */
public class Location {

    public static final String MESSAGE_CONSTRAINTS = "Locations can take any values, and it should not be blank";
    public static final String MESSAGE_LENGTH_CONSTRAINTS = "Locations should not be longer than 100 characters.";
    /*
     * The first character of the iscam must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[^\\s].*";
    private static final int MESSAGE_MAX_LENGTH = 100;
    public final String value;

    /**
     * Constructs an {@code Location}.
     *
     * @param location A valid location.
     */
    public Location(String location) {
        requireNonNull(location);
        checkArgument(isValidLocation(location), MESSAGE_CONSTRAINTS);
        checkArgument(isValidLength(location), MESSAGE_LENGTH_CONSTRAINTS);
        value = location;
    }

    /**
     * Returns true if a given string is a valid email.
     */
    public static boolean isValidLocation(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if a given location has valid length.
     */
    public static boolean isValidLength(String test) {
        return test.length() <= MESSAGE_MAX_LENGTH;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Location // instanceof handles nulls
                && value.equals(((Location) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
