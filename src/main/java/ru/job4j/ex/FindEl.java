package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result < 0) {
            throw new ElementNotFoundException("Index was not found.");
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            String[] array = new String[] {"a", "b", "c"};
            FindEl.indexOf(array, "b");
            FindEl.indexOf(array, "v");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
