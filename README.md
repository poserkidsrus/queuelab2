# queuelab2
company is arraylist of departments; departments are queues of executives
CREATE ARRAY OF QUEUES FOR TRACKING EXECUTIVES by department

1.method Add creates a new department in Queue of <department> objects
	a. one department is called unemployed
	b. unemployed executive salary is 0.
	c. department class has queue of <Executive> 
		c1. Executives have names, starting dates and salary

2. method Hire creates a new Executive object in Queue of persons
	a. needs to set starting date and name

3. method Join adds an existing Executive to individual department

4. method quit removes a person from their department

5. method change moves a person from one department to another

6. method payroll computes executive salary, displays from largest to smallest by department
	a. for executive in department: get starting date
	b. list sorted by date oldest to newest
	c. exec w/ oldest date gets 40k plus 5k for each below it in list

7. method salary returns the salary of a specific person
	a. executives are paid with base $40,000 plus $5000 per person 	below them in the department who has been there less time
	b. track starting date to determine seniority

8. exit method ends the program (system.exit)
