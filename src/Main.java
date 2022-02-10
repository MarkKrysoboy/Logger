import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.get();
        Scanner scanner = new Scanner(System.in);
        logger.log("Запускаем программу.");
        System.out.println("Привет!");
        logger.log("Просим ввести размер списка.");

        System.out.println("Введите размер списка: ");
        try {
            int size = scanner.nextInt();
            logger.log("Пользователь ввел размер списка - " + size);
            logger.log("Просим ввести верхнюю границу.");

            System.out.println("Введите верхнюю границу: ");
            int limit = scanner.nextInt();
            logger.log("Пользователь ввел верхнюю границу - " + limit);

            Random random = new Random();
            logger.log("Создаем новый список и заполняем случайными числами.");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                list.add(random.nextInt(limit));
                logger.log("Добавляем в список число № " + (i + 1));
            }

            logger.log("Выводим список на экран.");
            System.out.println("Получили список - " + list.toString());

            int max = Collections.max(list);
            int min = Collections.min(list);

            logger.log("Просим ввести число для фильтрации.");
            System.out.println("Введите число для фильтрации: ");
            int f = scanner.nextInt();
            logger.log("Пользователь ввел число для фильтрации - " + f);

            if (f > max) {
                logger.log("Сообщаем, что список будет пуст.");
                System.out.println("Число больше наибольшего в списке. Результирующий список будет пуст.");
            } else if (f <= min) {
                logger.log("Сообщаем, что список будет идентичным и выводим его.");
                System.out.println("Число меньше наименьшего в списке или равен ему. Результирующий список будет " +
                        "идентичным исходному.");
                System.out.println(list.toString());
            } else {
                logger.log("Запускаем фильтрацию.");
                Filter filter = new Filter(f);
                List<Integer> filterList = filter.filterOut(list);
                logger.log("Выводим отфильтрованный список на экран.");
                System.out.println("Отфильтрованный список - " + filterList.toString());
                logger.log("Завершаем программу.");
            }
        } catch (InputMismatchException e) {
            logger.log("Пользователь ввел некорректные данные. Программа завершилась с ошибкой.");
            e.printStackTrace();
        }
    }
}
