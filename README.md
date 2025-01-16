# File_Filter


## Флаги:
| Флаги          | Описание                                       |
|----------------|------------------------------------------------|
| -o             | Задать путь к месту сохранения файлов          |
| -p             | Добавить префикс к названию сохраняемых файлов |
| -a             | Добавление в существующие файлы                |
| -s             | Краткая статистика                             |                            
| -f             | Полная статистика                              |

### Пример: ```-o /java/test/ -p prefix_ -a -f text.txt tst2.txt```    


## Классы:
| Наименование класса/интерфейса | Описание                                                                            |
|--------------------------------|-------------------------------------------------------------------------------------|
| FileManager                    | Обеспечивает работу с файлами: создание, фильтрация, удланеие, работа с статистикой |
| FlagManager                    | Обеспечивает работоспособность флагов                                               |
| Statistics                     | Интерфейс статистики                                                                |
| StatisticsForIntAndFloat       | Реализация интерфейса Statistics Для работы с числами (float, int)                  |
| StatisticsForString            | Реализация интерфейса Statistics. Для работы со строками                            |
| Main                           | Основной класс приложения с методом main(String[] args)                             |
 |



### Пример выполнения программы
```
-o C:\Java\File_Filter\src\data\output\ -p example_ -a -f C:\Java\File_Filter\src\data\input\file.txt C:\Java\File_Filter\src\data\input\tst2.txt
Statistic fortest_integers.txt
Count of elements: 8
    └─ Additional details
        ├──Minimum:	1.0
        ├──Maximum:	1.2345679395506094E18
        ├──Summ:	1.234567939550922E18
        └──Average:	1.5432099244386525E17
Statistic fortest_floats.txt
Count of elements: 3
    └─ Additional details
        ├──Minimum:	-0.0010000000474974513
        ├──Maximum:	3.1414999961853027
        ├──Summ:	3.1404999961378053
        └──Average:	1.046833332045935
Statistic fortest_strings.txt
Count of elements: 35
    └─ Additional details
        ├──Minimum:	4.0
        └──Maximum:	49.0
```
#### java ver: 22