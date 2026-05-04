package level1;

public interface EntrantStep<T> {

    T isVegan();

    T isGlutenFree();

    MainCourseStep goToMainCourse();
}
