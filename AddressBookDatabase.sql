/* Welcome to AddressBook Database */

/* UC-1 */
mysql> CREATE DATABASE address_book_service;
Query OK, 1 row affected (0.21 sec)

 mysql> show databases;
+----------------------+
| Database             |
+----------------------+
| address_book_service |
| information_schema   |
| mysql                |
| payroll_service      |
| performance_schema   |
| school               |
| sql_hr               |
| sql_inventory        |
| sql_invoicing        |
| sql_store            |
| sys                  |
+----------------------+
11 rows in set (0.01 sec)

mysql> use address_book_service;
Database changed
mysql> select database();
+----------------------+
| database()           |
+----------------------+
| address_book_service |
+----------------------+
1 row in set (0.00 sec)


/* UC-2 */
mysql> CREATE TABLE address_book(
    ->     person_id INT PRIMARY KEY,
    ->     first_name VARCHAR(50) NOT NULL,
    ->     last_name VARCHAR(50) NOT NULL,
    ->     address VARCHAR(255),
    ->     city VARCHAR(50),
    ->     state VARCHAR(50),
    ->     zip VARCHAR(15),
    ->     phone_number VARCHAR(15) NOT NULL,
    ->     email VARCHAR(255) NOT NULL UNIQUE
    -> );
Query OK, 0 rows affected (0.03 sec)

mysql> DESCRIBE address_book;
+--------------+--------------+------+-----+---------+-------+
| Field        | Type         | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| person_id    | int          | NO   | PRI | NULL    |       |
| first_name   | varchar(50)  | NO   |     | NULL    |       |
| last_name    | varchar(50)  | NO   |     | NULL    |       |
| address      | varchar(255) | YES  |     | NULL    |       |
| city         | varchar(50)  | YES  |     | NULL    |       |
| state        | varchar(50)  | YES  |     | NULL    |       |
| zip          | varchar(15)  | YES  |     | NULL    |       |
| phone_number | varchar(15)  | NO   |     | NULL    |       |
| email        | varchar(255) | NO   | UNI | NULL    |       |
+--------------+--------------+------+-----+---------+-------+
9 rows in set (0.01 sec)


/* UC-3 */
mysql> INSERT INTO address_book (first_name, last_name, address, city, state, zip, phone_number, email)
    -> VALUES
    -> ('Karanveer', 'Singh', '123 Main St', 'kanpur', 'up', '12345', '5551234', 'karanveer962@gmail.com'),
    -> ('Rajat', 'Branwal', '456 Oak St', 'lucknow', 'up', '67890', '5555678', 'rajat123@gmail.com'),
    -> ('Priyanshu', 'Yadav', '789 Pine St', 'guwahati', 'mp', '45678', '5559876', 'priyanshu567@gmail.com');
Query OK, 3 rows affected (0.02 sec)
Records: 3  Duplicates: 0  Warnings: 0

mysql> Select * from address_book;
+-----------+------------+-----------+-------------+----------+-------+-------+--------------+------------------------+
| person_id | first_name | last_name | address     | city     | state | zip   | phone_number | email                  |
+-----------+------------+-----------+-------------+----------+-------+-------+--------------+------------------------+
|         1 | Karanveer  | Singh     | 123 Main St | kanpur   | up    | 12345 | 5551234      | karanveer962@gmail.com |
|         2 | Rajat      | Branwal   | 456 Oak St  | lucknow  | up    | 67890 | 5555678      | rajat123@gmail.com     |
|         3 | Priyanshu  | Yadav     | 789 Pine St | guwahati | mp    | 45678 | 5559876      | priyanshu567@gmail.com |
+-----------+------------+-----------+-------------+----------+-------+-------+--------------+------------------------+
3 rows in set (0.01 sec)



/* UC-4 */
mysql> UPDATE address_book
    -> SET phone_number = '6306073280',
    ->     zip = '208006'
    -> WHERE first_name = 'Karanveer' AND last_name = 'Singh';
Query OK, 1 row affected (0.07 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> Select * from address_book;
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+------------------------+
| person_id | first_name | last_name | address     | city     | state | zip    | phone_number | email                  |
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+------------------------+
|         1 | Karanveer  | Singh     | 123 Main St | kanpur   | up    | 208006 | 6306073280   | karanveer962@gmail.com |
|         2 | Rajat      | Branwal   | 456 Oak St  | lucknow  | up    | 67890  | 5555678      | rajat123@gmail.com     |
|         3 | Priyanshu  | Yadav     | 789 Pine St | guwahati | mp    | 45678  | 5559876      | priyanshu567@gmail.com |
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+------------------------+
3 rows in set (0.01 sec)


/* UC-5 */
mysql> DELETE FROM address_book
    -> WHERE first_name = 'Rajat' AND last_name = 'Branwal';
Query OK, 1 row affected (0.08 sec)

mysql> Select * from address_book;
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+------------------------+
| person_id | first_name | last_name | address     | city     | state | zip    | phone_number | email                  |
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+------------------------+
|         1 | Karanveer  | Singh     | 123 Main St | kanpur   | up    | 208006 | 6306073280   | karanveer962@gmail.com |
|         3 | Priyanshu  | Yadav     | 789 Pine St | guwahati | mp    | 45678  | 5559876      | priyanshu567@gmail.com |
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+------------------------+
2 rows in set (0.01 sec)



/* UC-6 */
mysql> Select * FROM address_book
    -> WHERE city='kanpur' OR state='up';
+-----------+------------+-----------+-------------+--------+-------+--------+--------------+------------------------+
| person_id | first_name | last_name | address     | city   | state | zip    | phone_number | email                  |
+-----------+------------+-----------+-------------+--------+-------+--------+--------------+------------------------+
|         1 | Karanveer  | Singh     | 123 Main St | kanpur | up    | 208006 | 6306073280   | karanveer962@gmail.com |
+-----------+------------+-----------+-------------+--------+-------+--------+--------------+------------------------+
1 row in set (0.06 sec)


/* UC-7 */

mysql> SELECT state, COUNT(*) AS state_count
    -> FROM address_book
    -> GROUP BY state;
+-------+-------------+
| state | state_count |
+-------+-------------+
| up    |           2 |
| mp    |           1 |
+-------+-------------+
2 rows in set (0.02 sec)


mysql> SELECT city, COUNT(*) AS city_count
    -> FROM address_book
    -> GROUP BY city;
+----------+------------+
| city     | city_count |
+----------+------------+
| kanpur   |          1 |
| guwahati |          1 |
| lucknow  |          1 |
+----------+------------+
3 rows in set (0.00 sec)


/* UC-8 */
mysql> Select * 
    -> FROM address_book
    -> WHERE city='kanpur'
    -> ORDER BY first_name,last_name
    -> ;
+-----------+------------+-----------+-------------+--------+-------+--------+--------------+-------------------------+
| person_id | first_name | last_name | address     | city   | state | zip    | phone_number | email                   |
+-----------+------------+-----------+-------------+--------+-------+--------+--------------+-------------------------+
|         6 | Jatin      | Mehra     | 123 Main St | kanpur | up    | 12345  | 5551234      | mehrajatin123@gmail.com |
|         1 | Karanveer  | Singh     | 123 Main St | kanpur | up    | 208006 | 6306073280   | karanveer962@gmail.com  |
+-----------+------------+-----------+-------------+--------+-------+--------+--------------+-------------------------+
2 rows in set (0.01 sec)


/* UC-9*/
mysql> ALTER TABLE address_book
    -> ADD COLUMN name VARCHAR(255) NOT NULL,
    -> ADD COLUMN type VARCHAR(255) NOT NULL;
Query OK, 0 rows affected (0.14 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> UPDATE address_book
    -> SET name = "Home", type = "friends"
    -> WHERE first_name="Jatin";
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE address_book
    -> SET name = "Outside", type = "business"
    -> WHERE first_name="Rajat";
Query OK, 1 row affected (0.01 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> UPDATE address_book
    -> SET name = "Outside", type = "business"
    -> WHERE first_name="Priyanshu";
Query OK, 1 row affected (0.00 sec)
Rows matched: 1  Changed: 1  Warnings: 0

mysql> Select *  FROM address_book;
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+-------------------------+---------+----------+
| person_id | first_name | last_name | address     | city     | state | zip    | phone_number | email                   | name    | type     |
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+-------------------------+---------+----------+
|         1 | Karanveer  | Singh     | 123 Main St | kanpur   | up    | 208006 | 6306073280   | karanveer962@gmail.com  | Home    | friends  |
|         3 | Priyanshu  | Yadav     | 789 Pine St | guwahati | mp    | 45678  | 5559876      | priyanshu567@gmail.com  | Outside | business |
|         5 | Rajat      | Branwal   | 456 Oak St  | lucknow  | up    | 67890  | 5555678      | rajat123@gmail.com      | Outside | business |
|         6 | Jatin      | Mehra     | 123 Main St | kanpur   | up    | 12345  | 5551234      | mehrajatin123@gmail.com | Home    | friends  |
+-----------+------------+-----------+-------------+----------+-------+--------+--------------+-------------------------+---------+----------+
4 rows in set (0.01 sec)




/* UC-10*/
mysql> SELECT type, COUNT(*) AS person_count
    -> FROM address_book
    -> GROUP BY type;
+----------+--------------+
| type     | person_count |
+----------+--------------+
| friends  |            2 |
| business |            2 |
+----------+--------------+
2 rows in set (0.06 sec)


/* UC-11*/

mysql> drop table address_book;
Query OK, 0 rows affected (0.10 sec)


mysql> CREATE TABLE address_book (
    ->     person_id    INT AUTO_INCREMENT NOT NULL,
    ->     first_name   VARCHAR(50) NOT NULL,
    ->     last_name    VARCHAR(50) NOT NULL,
    ->     address      VARCHAR(255),
    ->     city         VARCHAR(50),
    ->     state        VARCHAR(50),
    ->     zip          VARCHAR(15),
    ->     phone_number VARCHAR(15) NOT NULL,
    ->     email        VARCHAR(255) UNIQUE NOT NULL,
    ->     name         VARCHAR(255) NOT NULL,
    ->     type         VARCHAR(255) NOT NULL,
    ->     PRIMARY KEY (person_id, name, type)
    -> );
Query OK, 0 rows affected (0.10 sec)

mysql> describe address_book;
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| person_id    | int          | NO   | PRI | NULL    | auto_increment |
| first_name   | varchar(50)  | NO   |     | NULL    |                |
| last_name    | varchar(50)  | NO   |     | NULL    |                |
| address      | varchar(255) | YES  |     | NULL    |                |
| city         | varchar(50)  | YES  |     | NULL    |                |
| state        | varchar(50)  | YES  |     | NULL    |                |
| zip          | varchar(15)  | YES  |     | NULL    |                |
| phone_number | varchar(15)  | NO   |     | NULL    |                |
| email        | varchar(255) | NO   | UNI | NULL    |                |
| name         | varchar(255) | NO   | PRI | NULL    |                |
| type         | varchar(255) | NO   | PRI | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+
11 rows in set (0.09 sec)


mysql> INSERT INTO address_book (first_name, last_name, address, city, state, zip, phone_number, email, name,type)
    -> VALUES ('Jatin', 'Mehra', '123 Main St', 'kanpur', 'up', '12345', '555-1234', 'mehrajatin123', 'home','family');
Query OK, 1 row affected (0.07 sec)

mysql> INSERT INTO address_book (first_name, last_name, address, city, state, zip, phone_number, email,name,type)
    -> VALUES ('Jatin', 'Mehra', '123 Main St', 'kanpur', 'up', '12345', '555-1234', 'mehrajatin123', 'home','friends');
Query OK, 1 row affected (0.01 sec)

mysql> select * from address_book;
+-----------+------------+-----------+-------------+----------+-------+-------+--------------+------------------------+---------+----------+
| person_id | first_name | last_name | address     | city     | state | zip   | phone_number | email                  | name    | type     |
+-----------+------------+-----------+-------------+----------+-------+-------+--------------+------------------------+---------+----------+
|         1 | Karanveer  | Singh     | 123 Main St | kanpur   | up    | 12345 | 5551234      | karanveer962@gmail.com | home    | friends  |
|         2 | Rajat      | Branwal   | 456 Oak St  | lucknow  | up    | 67890 | 5555678      | rajat123@gmail.com     | home    | friends  |
|         3 | Priyanshu  | Yadav     | 789 Pine St | guwahati | mp    | 45678 | 5559876      | priyanshu567@gmail.com | outside | business |
|         4 | Jatin      | Mehra     | 123 Main St | kanpur   | up    | 12345 | 555-1234     | mehrajatin123          | home    | family   |
|         6 | Jatin      | Mehra     | 123 Main St | kanpur   | up    | 12345 | 555-1234     | mehrajatin123          | home    | friends  |
+-----------+------------+-----------+-------------+----------+-------+-------+--------------+------------------------+---------+----------+
5 rows in set (0.01 sec)



/* UC-12*/

/*  ER-Diagram */

+--------------+       +-----------------+
|   Person     |       |  AddressBook    |
+--------------+       +-----------------+
| person_id    |   1   | address_book_id |
| first_name   |------<| name            |
| last_name    |       | type            |
| address      |       +-----------------+
| city         |
| state        |       Relationships:
| zip          |       - One person can belong to multiple address books.
| phone_number |       - One address book can contain multiple persons.
| email        |
+--------------+
