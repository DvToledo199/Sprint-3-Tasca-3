package level1;

public interface MainCourseStepOptions<T> {

    T isVegan();

    T isGlutenFree();

    T withSupplement(String supplement);

    AfterMainStep finishMainOptions();
}
