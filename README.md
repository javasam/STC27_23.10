# STC27_23.10
# Задание
Разработать REST-сервис, позволяющий по URL вида
http://host:port/service_name/{table_name} получить все содержимое таблицы в БД, а по
URL вида http://host:port/service_name/{table_name}/{row_id} - одну запись. Данные URL
защитить с помощью spring security.<br>
#######################################
Для проверки проект развернут на сервисе heroku по ссылке https://rest-service-23.herokuapp.com/<br>
Для авторизации необходимо ввести логин: user, пароль: password<br>

Получение конкретной записи из таблицы по id по ссылке http://localhost:8080/rest/car?id=1 <br>
Добавление записи в базу POST запрос {"modelName":"VW"}<br>
Изменение записи в базе POST запрос {"id":5,"modelName":"VW"}<br>

Примерное время на выполнение - 2 часа.
