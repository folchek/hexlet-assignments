package exercise;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
       /* // Создаем карту атрибутов
        Map<String, String> attributes = Map.of("class", "v-10", "id", "wop");

        // Создаем объект Tag
        Tag tag = new Tag("img", attributes);

        // Выводим строковое представление тега
        System.out.println(tag.toString());
        // Результат: <img class="v-10" id="wop">
*/

        // Атрибуты и дочерние теги
        Map<String, String> attributes = Map.of("class", "container");
        List<Tag> children = List.of(
                new SingleTag("img", Map.of("src", "image.jpg")),
                new SingleTag("br", Map.of())
        );

        // Создаем парный тег
        PairedTag pairedTag = new PairedTag("div", attributes, "Hello, world!", children);

        // Печатаем результат
        System.out.println(pairedTag.toString());
        // Результат: <div class="container">Hello, world!<img src="image.jpg"><br></div>
    }
}
