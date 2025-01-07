package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate (Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        List<String> nullFields = new ArrayList<>();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    nullFields.add(field.getName());
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        return nullFields;
    }
}
// END
