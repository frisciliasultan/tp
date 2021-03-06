package seedu.iscam.model.commons;

import static java.util.Objects.requireNonNull;
import static seedu.iscam.commons.util.AppUtil.checkArgument;

/**
 * Represents a Client's name in the iscam book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String MESSAGE_TYPE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank.";
    public static final String MESSAGE_LENGTH_CONSTRAINTS = "Names should not be longer than 50 characters.";
    /*
     * The first character of the iScam must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";
    private static final int MESSAGE_MAX_LENGTH = 50;
    public final String fullName;

    /**
     * Constructs a {@code Name}.
     *
     * @param name A valid name.
     */
    public Name(String name) {
        requireNonNull(name);
        checkArgument(isValidName(name), MESSAGE_TYPE_CONSTRAINTS);
        checkArgument(isValidLength(name), MESSAGE_LENGTH_CONSTRAINTS);
        fullName = name;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if a given name has valid length.
     */
    public static boolean isValidLength(String test) {
        return test.length() <= MESSAGE_MAX_LENGTH;
    }


    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

}
