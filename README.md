# Restaurant POS System

## Remember the database name can be modified in application.yml, mysql version cannot below 5.6

## Access address and testing account

Staff login address: http://localhost:8181/restaurant/sysuser/login.html  

Customer login address: http://localhost:8181/restaurant/guest/desklist.html  

Manager testing account:       ac: 69972123 pw: 123456 

Cashier testing account:     ac: 92876762 pw: 123456  

Chief testing account       ac: 93268745 pw: 123456  

Waiter testing account:     ac: 64789021 pw: 123456 

## Setup the project

1. Using IDEA or other IDE to open the project and setup the springboot and maven environment
2. Prepare MySQL, and create a database named 'restaurant'
3. Import/Execute the sql file inside the db folder into your restaurant database to setup all tables and data
4. Find the application.yml inside the path src/main/resources/
5. Inside the application.yml, set the datasource password as your restaruant database password, and set the last upload-image-path to the absoulte path of the folder images/restaurant/upload in your environment
