import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Ввод месяца
        String monthInput = JOptionPane.showInputDialog("Введите номер месяца (1-12) или его сокращенное название (Янв.-Дек.):");
        int month = getMonthFromString(monthInput);

        // Ввод года
        String yearInput = JOptionPane.showInputDialog("Введите год (1900-2100):");
        int year = Integer.parseInt(yearInput);

        // Генерация и вывод календаря
        String calendar = generateCalendar(month, year);
        JOptionPane.showMessageDialog(null, calendar);
    }

    // Метод для получения числового значения месяца из строки
    private static int getMonthFromString(String monthInput) {
        switch (monthInput.toLowerCase()) {
            case "янв.":
                return 1;
            case "фев.":
                return 2;
            case "мар.":
                return 3;
            case "апр.":
                return 4;
            case "май":
            case "мая":
                return 5;
            case "июн.":
                return 6;
            case "июл.":
                return 7;
            case "авг.":
                return 8;
            case "сен.":
                return 9;
            case "окт.":
                return 10;
            case "ноя.":
                return 11;
            case "дек.":
                return 12;
            default:
                return Integer.parseInt(monthInput);
        }
    }

    // Метод для генерации календаря
    private static String generateCalendar(int month, int year) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Календарь на %d %d:\n", month, year));

        // Определение дня недели, с которого начинается месяц
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        int startDayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);

        // Определение количества дней в месяце
        int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        // Формирование календаря
        sb.append("Пн Вт Ср Чт Пт Сб Вс\n");

        // Добавление пробелов для первой недели
        for (int i = 1; i < startDayOfWeek; i++) {
            sb.append("   ");
        }

        // Добавление дней месяца
        for (int day = 1; day <= daysInMonth; day++) {
            sb.append(String.format("%2d ", day));
            if ((startDayOfWeek + day - 1) % 7 == 0) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}