select * from student;
select * from student where age between 19 and 21;
select name from student;
select * from student where name like '%r%';
select * from student where age < 25;
select * from student order by age;
select * from student order by age;
select faculty_name from student;
select student.name from student,faculty where student.faculty_name = faculty.name and faculty.name like 'Have no idea'
