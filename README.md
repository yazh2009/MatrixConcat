# MatrixConcat

Приложение для конкатенации таблиц

## Описание функционала

Приложение предназначено для объединение таблиц **DB1,...,DBn** с полями **id, V1, V2** в одну таблицу **DB** с полями 
**id, V11, V12, ..., Vn1, Vn2**

## Инструкция по работе с приложением

### Настройка
Необходимо изменить в классе *MatrixConcat/src/main/java/net/yazh/MatrixConcat.java* параметры подключения к БД, 
заменив соответствующие значения констант, там же нужно указать количество **N** используемых таблиц.
В файле *MatrixConcat/src/main/resources/database/initDB.sql* представлен пример создания таблиц для **N**=5.
В файле *MatrixConcat/src/main/resources/database/initData.sql* представлен пример заполнения таблиц значениями.

### Сборка
С помощью запуска в папке *MatrixConcat* из командной строки команды **mvn clean package** происходит создание исполняемого файла 
*MatrixConcat/target/MatrixConcat-1.0-SNAPSHOT.jar*

### Развёртывание
Запуск выполняется командой **java -jar MatrixConcat-1.0-SNAPSHOT.jar**
