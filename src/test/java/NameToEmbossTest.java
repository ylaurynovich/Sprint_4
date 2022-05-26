import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@DisplayName("Проверка корректности имени для печати")
public class NameToEmbossTest {
    private final String name;
    private final boolean expected;

    public NameToEmbossTest(String name, boolean expected){
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name="{index}. Input: {0}. Expected: {1}")
    public static Object[][] getName(){
        return new Object[][]{
                //валидное значение
                {"Тимоти Шаламе", true},
                // имя из двух символов
                {"Ти", false},
                // имя из трех символов (с проблелом) - мин валидное значение
                {"Т м", true},
                // имя из 19 символов (с пробелом) - максимальнео валидное значение
                {"Тимоти Шаламешаламе", true},
                // имя из 20 символов
                {"Тимотит Шаламешаламе", false},
                //пробел перед именем
                {" Тимоти Шаламе", false},
                // пробел после имени
                {"Тимоти Шаламе ", false},
                // без пробелов
                {"ТимотиШаламе", false},
                // два пробела в центре
                {"Ти моти Шаламе", false},
        };
    }

    @Test
    @DisplayName("Проверка имени для печати")
    public void checkNameTest(){
        Account acc = new Account(name);
        assertEquals(expected, acc.checkNameToEmboss());
    }
}
