CREATE TABLE Homework
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    description VARCHAR(255)
);

CREATE TABLE Lesson
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255),
    updatedAt   TIMESTAMP,
    homework_id INT UNIQUE,
    FOREIGN KEY (homework_id) REFERENCES Homework (id)
);

CREATE TABLE Schedule
(
    id        INT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(255),
    updatedAt TIMESTAMP
);

CREATE TABLE Schedule_Lesson
(
    schedule_id INT,
    lesson_id   INT,
    PRIMARY KEY (schedule_id, lesson_id),
    FOREIGN KEY (schedule_id) REFERENCES Schedule (id),
    FOREIGN KEY (lesson_id) REFERENCES Lesson (id)
);