import java.time.LocalDate;
import java.time.Period;

public class Person {

    private final String name;

    private final String surname;

    private final String patronymic;

    private final LocalDate birthDate;

    public Person(String[] fullName, LocalDate birthDate) {
        surname = fullName[0];
        name = fullName[1];
        patronymic = fullName[2];
        this.birthDate = birthDate;
    }

    private String getAge() {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        String ageSuffix;
        if (age % 10 == 1 && age != 11) {
            ageSuffix = "год";
        } else if (age % 10 >= 2 && age % 10 <= 4 && (age < 10 || age >= 20)) {
            ageSuffix = "года";
        } else {
            ageSuffix = "лет";
        }
        return "Возраст: " + age + " " + ageSuffix;
    }

    private String getGender() {
        if (patronymic.endsWith("ич")) {
            return "Пол: Мужской";
        }
        return "Пол: Женский";
    }

    private String getInitials() {
        return surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
    }

    @Override
    public String toString() {
        return getInitials() + "\n" + getGender() + "\n" + getAge();
    }
}
