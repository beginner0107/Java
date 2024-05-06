package reflection.exercises.repeatable_annotation_quiz;

public class PermissionException extends RuntimeException {
    public PermissionException() {
        super("User does not have the right permissions for the operation");
    }
}
