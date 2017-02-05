# scala-collection-assignments
repo for Knoldus Assignments on Lists and Collections


Assignemnt 1)
Every Student has some marks associated with it. Student details contains its id and name.
And for Marks, there are subjectId, studentId and number of marks a student scored.

Following are the requirements which is required to gain from above scenario (i.e. Student and marks)

1)
Input:- (subjectId, percentage, pass/fail)
Output:- for input pass, evaluate that how much students(id, name) are passed in the inputted subjectId
	for input fail, evaluate that how much students(id, name) are failed in the inputted subjectId
Note:- percentage is the input which defines the minimum passing criteria
e.g. 
Pass count: 15
Fail count: 10

2)
Input:- (subjectId, count, top/bottom)
Output:- based on the last input(top/bottom), output the students details who have scored max/min in that subjectId
e.g. 
input: 1 5 top
output: 
Kunal 85
Himanshu 84
Geetika 83
Anmol 82
Mahesh 81

3)
Input:-
(top/bottom, count)
OutPut:-
Overall top/least scorer based on all the subjects score, fetch students name
count- input defines that how much students name are to be printed on console
e.g.
input: top 2

output:
Himanshu 75%
Geetika 74%


4)
Input:-
(percentage, good_scholarship, normal_or_no_scholarship)
Output:- two groups of students with the amount of scholarship
e.g.
input: 85% 2000 500
output: 
Kunal 2000
Himanshu 500
Geetika 2000
Mahesh 500

5)
Input:-
(pass/fail, percentage)
count and print the number of students and all names who are passed/fail,
Pass or fail would be decided by percentage input field.
e.g.
input: fail 30
output: 
Kunal 28%
Himanshu 29%

6) Find the student(s) who have scored 95% or above and print its details.
input: 95%
output:
Kunal 95%
Himanshu 96%
Geetika 97%

7) For every student, find its marks in detail (just like detailed Report card of a student.)
Note:- must use groupBy method of List
input: reportcard
output:
Kunal 75 70 80 75 75%
Himanshu 74 70 81 75 75%
Geetika 70 70 85 75 75%


Developer Notes:

There would be two case classes
1) Student(id: Long, name: String)
2) Marks(subjectId: Int,studentId: Long, marksObtained: float)

In order to fill data in those case classes, either take inputs from a file, or take static inputs. But there must be atleast 5 subjects, and atleast 10 students.
e.g. List(Student(1, "Kunal"), Student(2, "Himanshu"), Student(3, "Geetika") ....)
List(Marks(1, 1, 95), Marks(2, 1, 75), ...)
So basically here Kunal has marks 95 and 75 for the paper 1 and 2 respectively.
