package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    void testFileKV() {
        String filePath = "src/test/resources/file.json";
        KeyValueStorage storage = new FileKV(filePath, Map.of("key1", "value1"));

        // Проверяем начальные данные
        assertThat(storage.get("key1", "default")).isEqualTo("value1");

        // Добавляем данные
        storage.set("key2", "value2");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");

        // Удаляем данные
        storage.unset("key1");
        assertThat(storage.get("key1", "default")).isEqualTo("default");

        // Проверяем сохранение всех данных
        Map<String, String> expected = Map.of("key2", "value2");
        assertThat(storage.toMap()).isEqualTo(expected);
    }
    // END
}
