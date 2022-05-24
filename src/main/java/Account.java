public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        // если в строке не меньше 3 и не больше 19 символов включительно
        if (name.length() >= 3 && name.length() <= 19) {
            int space_qnt = (int) name.chars().filter(character -> character == ' ').count();
            //если в строке только один пробел
            if (space_qnt == 1) {
                // если пробел стоит не в начале и не в конце строки
                if (name.charAt(0) != ' ' && name.charAt(name.length() - 1) != ' ') {
                    return true;
                }
            }
        }
        return false;
    }
}