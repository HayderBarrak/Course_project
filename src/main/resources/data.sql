DROP TABLE IF EXISTS course;

CREATE TABLE course (
  courseid INT AUTO_INCREMENT  PRIMARY KEY,
  coursename VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
);

INSERT INTO course (coursename, author) VALUES
  ('angular', 'hayder'),
  ('angular2', 'hayder3');
