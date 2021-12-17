import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Principal {
    final private Map<Integer, List<Pair<ProfesorInterface, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new TeacherTC(1,"Josefina"), true),
                            new Pair<>( new TeacherTC(2,"Edonisio"), true),
                            new Pair<>( new TeacherTC(1,"Edufasio"), false),
                            new Pair<>( new TeacherTC(1,"Adriano"), true),
                            new Pair<>( new TeacherTC(0,"Sabino"), true)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new TeacherTC(1,"Eduarda"), true),
                            new Pair<>( new TeacherTC(1,"Abelardo"), false),
                            new Pair<>( new TeacherTC(1,"Francisca"), false),
                            new Pair<>( new TeacherTC(1,"Alejandra"), false)
                    )
            )

    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }
    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {
            boolean hasToIncreaseOneExtraPoint = false;

            hasToIncreaseOneExtraPoint = isHasToIncreaseOneExtraPoint(hasToIncreaseOneExtraPoint);
            float gradesSum       = 0f;
            int   gradesWeightSum = 0;

            for (Pair<Integer, Float> examGrade : examsStudents) {
                gradesSum += (examGrade.first() * examGrade.second() / 100);
                gradesWeightSum += examGrade.first();
            }
            return extracted(hasReachedMinimumClasses, hasToIncreaseOneExtraPoint, gradesSum, gradesWeightSum);
        } else {
            return 0f;
        }
    }

    private float extracted(boolean hasReachedMinimumClasses, boolean hasToIncreaseOneExtraPoint, float gradesSum, int gradesWeightSum) {
        if (gradesWeightSum == 100) {
            if (hasReachedMinimumClasses) {
                if (hasToIncreaseOneExtraPoint) {
                    return Float.min(10f, gradesSum + 1);
                } else {
                    return gradesSum;
                }
            } else {
                return 0f;
            }
        } else if (gradesWeightSum > 100) {
            return -1f;
        } else {
            return -2f;
        }
    }

    private boolean isHasToIncreaseOneExtraPoint(boolean hasToIncreaseOneExtraPoint) {
        for (Map.Entry<Integer, List<Pair<ProfesorInterface, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (!(yearToCalculate != yearlyTeachers.getKey())) {
                List<Pair<ProfesorInterface, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<ProfesorInterface, Boolean> teacher : teachers) {
                    if (teacher.second() != true || teacher.first().tipo != 1) {
                        continue;
                    }else{
                        hasToIncreaseOneExtraPoint = true;
                    }
                }
            }
        }
        return hasToIncreaseOneExtraPoint;
    }

    public void imprimirNombresProfesores() {
            for (Map.Entry<Integer, List<Pair<ProfesorInterface, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
                    List<Pair<ProfesorInterface, Boolean>> teachers = yearlyTeachers.getValue();
                    for (Pair<ProfesorInterface, Boolean> teacher : teachers) {
                        if (teacher.second() == true) {
                            System.out.println(teacher.first().name());
                        }
                    }
            }
    }

    public static void main(String[] args) {
        /*
        This is a comment
        This is another comment
        */
    }
}
