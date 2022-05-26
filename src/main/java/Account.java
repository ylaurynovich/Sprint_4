import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }
    @Step("Проверка имени для эмбоссирования")
    public boolean checkNameToEmboss() {
        boolean isLengthValid = name.length() <= 19 && name.length() >= 3;
        boolean isSpaceOne = name.indexOf(' ') == name.lastIndexOf(' ');
        boolean isEndSpacesNotExist = name.indexOf(' ') > 0 && name.indexOf(' ') + 1 != name.length();
        return isLengthValid && isSpaceOne && isEndSpacesNotExist;
    }
}