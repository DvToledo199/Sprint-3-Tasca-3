package level1;

public interface StartStep {

    EntrantStep<MenuBuilder> withEntrant(String entrant);

    MainCourseStep skipEntrant();
}
