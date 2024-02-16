import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 1. chaque utilisation de lambda, déterminer le type du paramètre qui accueille la lambda et le type de retour de la lambda
// 2. pour chaque affichage, définissez le contenu de la collection affichée ("c'est une collection qui contient des étudiants qui... ordonnées par ..." par exemple)
// 3. renommez les variables pour qu'elles soient plus explicites quant à leur contenu

public class Main {

    public static void main(String[] args) {
        // Création de la liste d'étudiants
        List<Student> students = Arrays.asList(
                new Student("Alice", 22, 85.5),
                new Student("Bob", 20, 72.0),
                new Student("Charlie", 24, 90.2),
                new Student("David", 19, 68.8),
                new Student("Eva", 21, 78.3)
        );

        List<Student> studentsList1 = new ArrayList<>(students.stream()
                .filter(student -> student.getNote() > 70)
                .toList());

        studentsList1.sort((s1, s2) -> Integer.compare(s2.getAge(), s1.getAge()));

        List<String> stringsList1 = studentsList1.stream()
                .map(student -> String.format("Nom: %s, Age: %d, Note: %.2f", student.getName(), student.getAge(), student.getNote()))
                .toList();

        double result = students.stream()
                .mapToDouble(student2 -> student2.getNote())
                .average()
                .orElse(0.0);

        List<String> stringsList2 = students.stream()
                .filter(student -> student.getAge() % 2 == 0)
                .map(student1 -> student1.getName())
                .map(string -> string.toUpperCase())
                .toList();

        Student theStudent = students.stream()
                .max((s1, s2) -> 0 - Double.compare(s1.getNote(), s2.getNote()))
                .orElse(null);

        studentsList1.forEach(System.out::println);

        stringsList1.forEach(System.out::println);

        System.out.println(result);

        stringsList2.forEach(System.out::println);

        System.out.println(theStudent);
    }
}


