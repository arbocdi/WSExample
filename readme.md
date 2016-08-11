# Серверное приложение осуществляющее аутентификацию пользователя
### Развертка приложения
* Нужно создать БД и имопртирровать в неё содержимое файла wse.sql
* На сервере приложений (для разработки использловался Glassfish) нужно создать jdbc-ресурс с именем jdbc/wse
* Задеплоить приложение на сервер

### Проверка работоспособности
Тестовая html-страница находится по адресу: http://localhost:8080/wse/wstest.html
Запрос успешной аутентификации:
```json
{
  "type": "LOGIN_CUSTOMER",
  "sequence_id": "123",
  "data": {
    "email": "fpi@bk.ru",
    "password": "123123"
  }
}
```
Ответ:
```json
{
  "type": "CUSTOMER_API_TOKEN",
  "sequence_id": "123",
  "data": {
    "api_token": "2a62e657-d7b9-4885-9f02-071eaf5bb40c",
    "api_token_expiration_date": "2016-08-11T11:16:31+0600"
  }
}
```
После аутентификации можно использовать полученный токен:
```json
{
  "type": "PING",
  "sequence_id": "123",
  "data": {
   "api_token": "2a62e657-d7b9-4885-9f02-071eaf5bb40c"
  }
}
```
Успешный ответ:
```json
{
  "type": "PING",
  "sequence_id": "123",
  "data": {}
}
```
Ответ в случае ошибки:
```json
{
  "type": "CUSTOMER_ERROR",
  "sequence_id": "123",
  "data": {
    "error_description": "Token not found",
    "error_code": "token.notFound"
  }
}```
либо
```json
{
  "type": "CUSTOMER_ERROR",
  "sequence_id": "123",
  "data": {
    "error_description": "Token expired",
    "error_code": "token.expired"
  }
}
```
