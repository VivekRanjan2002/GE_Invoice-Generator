 create database Invoice_Generator;
 mysql> show databases;
 +--------------------+
 | Database           |
 +--------------------+
 | addressbookservice |
 | information_schema |
 | invoice_generator  |
 | mysql              |
 | payroll_service    |
 | performance_schema |
 | sakila             |
 | sys                |
 | world              |
 +--------------------+
 mysql> create table RideRepository(
     -> `UserID` INT,
     -> `Distance(in Km)` Double,
     -> `Time(in min)`  Double);
 Query OK, 0 rows affected (0.06 sec)

mysql> insert into RideRepository(`UserID`,`Distance(in Km)`,`Time(in min)`)  values(1,5,5);
Query OK, 1 row affected (0.01 sec)

mysql> insert into RideRepository(`UserID`,`Distance(in Km)`,`Time(in min)`)  values(2,1,3);
Query OK, 1 row affected (0.01 sec)

mysql> insert into RideRepository(`UserID`,`Distance(in Km)`,`Time(in min)`)  values(1,4.5,2);
Query OK, 1 row affected (0.01 sec)

mysql> insert into RideRepository(`UserID`,`Distance(in Km)`,`Time(in min)`)  values(2,5.5,3.5);
Query OK, 1 row affected (0.01 sec)

mysql> insert into RideRepository(`UserID`,`Distance(in Km)`,`Time(in min)`)  values(2,5.5,3.5);
Query OK, 1 row affected (0.01 sec)

mysql> insert into RideRepository(`UserID`,`Distance(in Km)`,`Time(in min)`)  values(3,0.5,1);
Query OK, 1 row affected (0.01 sec)

mysql> insert into RideRepository(`UserID`,`Distance(in Km)`,`Time(in min)`)  values(1,0.1,2);
Query OK, 1 row affected (0.00 sec)

mysql> select * from RideRepository;
+--------+-----------------+--------------+
| UserID | Distance(in Km) | Time(in min) |
+--------+-----------------+--------------+
|      1 |               5 |            5 |
|      2 |               1 |            3 |
|      1 |             4.5 |            2 |
|      2 |             5.5 |          3.5 |
|      2 |             5.5 |          3.5 |
|      3 |             0.5 |            1 |
|      1 |             0.1 |            2 |
+--------+-----------------+--------------+
mysql> alter table RideRepository
    -> add column Fare Double AS (Case when (`Distance(in Km)`*10+`Time(in min)`)>5.0 then  (`Distance(in Km)`*10+`Time(in min)`) Else 5.0 end)
    -> after `Time(in min)`;
Query OK, 0 rows affected (0.03 sec)
Records: 0  Duplicates: 0  Warnings: 0

//UC1 UC2
mysql> select * from RideRepository;
+--------+-----------------+--------------+------+
| UserID | Distance(in Km) | Time(in min) | Fare |
+--------+-----------------+--------------+------+
|      1 |               5 |            5 |   55 |
|      2 |               1 |            3 |   13 |
|      1 |             4.5 |            2 |   47 |
|      2 |             5.5 |          3.5 | 58.5 |
|      2 |             5.5 |          3.5 | 58.5 |
|      3 |             0.5 |            1 |    6 |
|      1 |             0.1 |            2 |    5 |
+--------+-----------------+--------------+------+
7 rows in set (0.00 sec)

//UC3
mysql> select count(UserID) as Total_Ride, Avg(Fare) as Avg_Fare , sum(Fare) as Total_Fare from RideRepository;
+------------+--------------------+------------+
| Total_Ride | Avg_Fare           | Total_Fare |
+------------+--------------------+------------+
|          7 | 34.714285714285715 |        243 |
+------------+--------------------+------------+
1 row in set (0.00 sec)

//UC4
mysql> select UserID, count(UserID) as Total_Ride, Avg(Fare) as Avg_Fare , sum(Fare) as Total_Fare  from RideRepository group by UserID;
+--------+------------+--------------------+------------+
| UserID | Total_Ride | Avg_Fare           | Total_Fare |
+--------+------------+--------------------+------------+
|      1 |          3 | 35.666666666666664 |        107 |
|      2 |          3 | 43.333333333333336 |        130 |
|      3 |          1 |                  6 |          6 |
+--------+------------+--------------------+------------+
3 rows in set (0.00 sec)

