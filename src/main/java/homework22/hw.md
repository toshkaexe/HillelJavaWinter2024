Створити таблицю Homework. Ця таблиця складається з атрибутів: id, name, description
Для атрибуту ID має бути забезпечене обмеження Primary Key та AutoIncrement
Створити таблицю Lesson. Ця таблиця складається з атрибутів: id, name, updatedAt, homework_id (зв'язок one-to-one)
Для атрибуту ID має бути забезпечене обмеження Primary Key та AutoIncrement
Пов'язано з таблицею Homework через Foreign Key
Створити таблицю Schedule. Ця таблиця складається з атрибутів: id, name, updatedAt, lessons (зв'язок many-to-many)
Для атрибуту ID має бути забезпечене обмеження Primary Key і AutoIncrement
Зв'язано з таблицею Lesson через Foreign Key
