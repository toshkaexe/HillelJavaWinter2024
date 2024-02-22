 --A.  Отримання всіх записів Homework
SELECT * FROM Homework;

--B.  Отримання всіх записів Lesson, включаючи дані Homework
SELECT Lesson.*, Homework.name AS homework_name, Homework.description AS homework_description
FROM Lesson
         JOIN Homework ON Lesson.homework_id = Homework.id;

--C. Отримання всіх записів Lesson (включаючи дані Homework)
-- відсортованих за часом оновлення
SELECT Lesson.*, Homework.name AS homework_name, Homework.description AS homework_description
FROM Lesson
         JOIN Homework ON Lesson.homework_id = Homework.id
ORDER BY Lesson.updatedAt;

--D.  Отримання всіх записів Schedule, включаючи дані Lesson
SELECT Schedule.*, Lesson.*
FROM Schedule
         JOIN Lesson ON Schedule.id = Lesson.id;

--E.  Отримання кількості Lesson для кожного Schedule
SELECT Schedule.id, Schedule.name, COUNT(Lesson.id) AS lesson_count
FROM Schedule
         LEFT JOIN Lesson ON Schedule.id = Lesson.id
GROUP BY Schedule.id, Schedule.name;
