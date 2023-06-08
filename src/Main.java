import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Получаем данные от пользователя и выводим стартовую информацию
        Scanner scanner = new Scanner(System.in);
        System.out.println("[i] Формат ввода данных в калькулятор: a + b, a * b, ...");
        System.out.println("[i] Разрешены числа от 1 до 10! Только целые числа!");
        System.out.println("[i] Закнчить работу с калькулятором - exit");


        while (true) {
            System.out.print("[+] Введите арифметическую операцию: ");
            // Сохраняем в переменную полученные данные от пользователя
            String input = scanner.nextLine();

            // Проверка на выход из цикла
            if ("exit".equals(input)) {
                break;
            }

            // Вызываем метод calc и выводим результат
            try {
                System.out.println("[+] Результат: " + calc(input));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String calc(String input) throws Exception {
        // Используем регулярное выражение для разбиения строки
        String regex = "(\\d+)\\s*([+\\-*/])\\s*(\\d+)";
        // Определяем переданные значения
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Если переданные значения соответсвуют регулярному выражению, переходим к расчетам
        if (matcher.matches()) {
            // Извлекаем значения из matcher и присваиваем их переменным
            int number1 = Integer.parseInt(matcher.group(1));
            String operator = matcher.group(2);
            int number2 = Integer.parseInt(matcher.group(3));

            // Проверяем соответсвуют ли значения требованиям задачи
            if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10) {
                throw new Exception("Число должно быть от 1 до 10!");
            }

            // Определяем оператор и возвращаем решение в виде строки
            switch (operator) {
                case "+" -> {
                    return String.valueOf(number1 + number2);
                }
                case "-" -> {
                    return String.valueOf(number1 - number2);
                }
                case "*" -> {
                    return String.valueOf(number1 * number2);
                }
                case "/" -> {
                    return String.valueOf(number1 / number2);
                }
            }
        }
        throw new Exception("[-] Вводимые данные не соответствуют требованиям, попробуй еще раз...");
    }
}
