<div align="center">

# Отчет

</div>

<div align="center">

## Практическая работа №4

</div>

<div align="center">

## Работа с встроенной базой данных SQLite

</div>

**Выполнил:**  
Самойлов Павел Олеговчи  
**Курс:** 2  
**Группа:** ИНС-б-о-24-1  
**Направление:** 09.03.02  
**Профиль:** Информационные системы и технологии  

---

### Цель работы

Изучить основы работы с СУБД SQLite в Android-приложениях. Научиться создавать базу данных, таблицы, выполнять основные операции CRUD (Create, Read, Update, Delete) с использованием класса SQLiteOpenHelper и отображать данные на экране.

### Ход работы
## Задание

1. Спроектировать структуру таблицы (минимум 3 поля разных типов, включая первичный ключ _id).

2. Реализовать класс SQLHelper для создания БД и таблицы.

3. Создать модель данных.

4. Реализовать методы add(), getAll(), update(), delete().

5. Разработать простой интерфейс с возможностью:

  - Добавлять новую запись (через диалог или отдельную активность).
  
  - Просматривать список всех записей.
  
  - Удалять запись по нажатию (например, долгое нажатие на элемент списка).
  
  - Обновлять запись.

## Индивидуальное задание

**База таксистов: Водитель (ФИО, марка машины, государственный номер, рейтинг).**

1. Код для создания таблицы в класск SQLHelper с полями: COLUMN_ID, COLUMN_RATING, COLUMN_NUMBER_CAR, COLUMN_BRAND_CAR, COLUMN_NAME

<div>
  
    public static final String DATABASE_NAME = "DataBase.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "MyTable";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "fio";
    public static final String COLUMN_BRAND_CAR = "car_brand";
    public static final String COLUMN_NUMBER_CAR = "number_car";
    public static final String COLUMN_RATING = "rating";

    // SQL запрос для создания таблицы
    private static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME        + " TEXT NOT NULL, "        +
                    COLUMN_BRAND_CAR   + " TEXT NOT NULL, "              +
                    COLUMN_NUMBER_CAR  + " INTEGER, "              +
                    COLUMN_RATING      + " REAL"                   +
                    ")";
</div>


2. Код модели данных для одной записи в БД.
   
<div>
  
    public class Taxis {
      private int id;
      private String fio;
      private String brand_car;
      private int number_car;
      private  float rating;
  
      public Taxis(int id, String fio, String brand_car, int nuber_car, float rating) {
          this.id = id;
          this.fio = fio;
          this.brand_car = brand_car;
          this.number_car = nuber_car;
          this.rating = rating;
      }
    }
</div>

3. Реализация методов add(), getAll(), update(), delete().

<div>
  Реализация метода add()
  
  <code>
    
        public long addTaxis(String fio, String brand_car, int number_car, float rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, fio);
        values.put(COLUMN_BRAND_CAR, brand_car);
        values.put(COLUMN_NUMBER_CAR, number_car);
        values.put(COLUMN_RATING, rating);
        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id;
    }
    
  </code>
  
</div>

<div align="center">

![Скриншот программы](images/screenshot1.png)
*Рисунок 1. Общий вид программы / Главное окно*

</div>

<div align="center">

*Рисунок 2. Результат выполнения тестового примера*
![Пример работы](images/screenshot2.png)

</div>

*Примечание по вставке изображений:*
*Скриншоты необходимо предварительно загрузить в репозиторий (например, в папку `images/`). Ссылка должна вести на файл внутри репозитория, а не на локальный диск вашего компьютера.*

### Вывод
В результате выполнения практической работы я [краткий вывод: что изучил, чему научился, что разработал].

### Ответы на контрольные вопросы
1.  **Вопрос 1:** [Ваш развернутый ответ на первый вопрос из методички].
2.  **Вопрос 2:** [Ваш ответ на второй вопрос].
3.  **Вопрос 3:** [Ваш ответ на третий вопрос].
