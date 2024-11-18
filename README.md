# Holiday Calendar Project

## About the Project

This project is a web application designed to allow users to view holiday calendars specific to Germany and its states. The holidays are listed on a country and region basis, with various filtering options available for customized viewing according to user needs.

## Project Scope

### 1. Frontend:
- A React-based user interface is developed.
- Users can list holiday dates based on the selected country and region.
- The application offers both yearly and monthly views.
- Holidays can be filtered by type (e.g., public holidays, religious holidays).

### 2. Backend:
- PostgreSQL is used for storing and managing holiday data.
- An API is developed to query and serve holiday dates.

## Installation

Follow these steps to run the project:

1. **Set Up the Database**: Install PostgreSQL and create a new database.
2. **Create Tables**: Use the following SQL statements to create the necessary tables.
## Usage

The project allows users to query holiday dates. The React frontend presents the data to the users, while the backend API retrieves the data from the database.

## License

This project is open source and can be used freely.

## Additional Information

This project is built with **Java 17**.

### Configuration

The application can be configured using the following properties:
```properties
spring.application.name=holiday-calendar
server.servlet.context-path=/holiday-calendar
spring.datasource.url=jdbc:postgresql://localhost:5432/XXX
spring.datasource.username=XXX
spring.datasource.password=XXX
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## Database Structure

### Country and Region Tables

```sql
CREATE TABLE countries (
    country_id SERIAL PRIMARY KEY,
    country_name VARCHAR(255) NOT NULL
);

CREATE TABLE regions (
    region_id SERIAL PRIMARY KEY,
    country_id INT REFERENCES countries(country_id),
    region_name VARCHAR(255) NOT NULL
);

CREATE TABLE holiday_types (
    holiday_type_id SERIAL PRIMARY KEY,
    holiday_type_name VARCHAR(255) NOT NULL
);

CREATE TABLE holidays (
    holiday_id SERIAL PRIMARY KEY,
    holiday_name VARCHAR(255) NOT NULL,
    holiday_date DATE NOT NULL,
    region_id INT REFERENCES regions(region_id),
    holiday_type_id INT REFERENCES holiday_types(holiday_type_id)
);

INSERT INTO countries (country_name) VALUES ('Germany');

INSERT INTO regions (country_id, region_name)
VALUES
    (1, 'Baden-Württemberg'),
    (1, 'Bayern'),
    (1, 'Berlin'),
    (1, 'Brandenburg'),
    (1, 'Bremen'),
    (1, 'Hamburg'),
    (1, 'Hessen'),
    (1, 'Mecklenburg-Vorpommern'),
    (1, 'Niedersachsen'),
    (1, 'Nordrhein-Westfalen'),
    (1, 'Rheinland-Pfalz'),
    (1, 'Saarland'),
    (1, 'Sachsen'),
    (1, 'Sachsen-Anhalt'),
    (1, 'Schleswig-Holstein'),
    (1, 'Thüringen');

INSERT INTO holiday_types (holiday_type_name)
VALUES
    ('Public Holiday'),
    ('Religious Holiday'),
    ('Special Day');

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'New Year''s Day', '2024-01-01', region_id, 1 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Good Friday', '2024-03-29', region_id, 2 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Easter Sunday', '2024-03-31', region_id, 2 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Easter Monday', '2024-04-01', region_id, 2 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Labour Day', '2024-05-01', region_id, 1 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Father''s Day', '2024-05-09', region_id, 3 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Mother''s Day', '2024-05-12', region_id, 3 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Ascension Day', '2024-05-09', region_id, 2 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Whit Monday', '2024-05-20', region_id, 2 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'German Unity Day', '2024-10-03', region_id, 1 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'Christmas Day', '2024-12-25', region_id, 2 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
SELECT 'St. Stephen''s Day', '2024-12-26', region_id, 2 FROM regions;

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('Three Kings Day', '2024-01-06', 17, 2),
    ('Three Kings Day', '2024-01-06', 18, 2),
    ('Three Kings Day', '2024-01-06', 30, 2);

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('International Women''s Day', '2024-03-08', 19, 3),
    ('International Women''s Day', '2024-03-08', 24, 3);

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('Easter Sunday', '2024-03-31', 20, 2);

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('Anniversary of the End of WWII', '2024-05-08', 20, 1);

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('Corpus Christi', '2024-05-30', 17, 2),
    ('Corpus Christi', '2024-05-30', 18, 2),
    ('Corpus Christi', '2024-05-30', 23, 2),
    ('Corpus Christi', '2024-05-30', 26, 2),
    ('Corpus Christi', '2024-05-30', 27, 2),
    ('Corpus Christi', '2024-05-30', 28, 2);

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('Assumption Day', '2024-08-15', 18, 2),
    ('Assumption Day', '2024-08-15', 28, 2);

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('World Children''s Day', '2024-09-20', 32, 3);

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('All Saints'' Day', '2024-11-01', 17, 2),
    ('All Saints'' Day', '2024-11-01', 18, 2),
    ('All Saints'' Day', '2024-11-01', 26, 2),
    ('All Saints'' Day', '2024-11-01', 27, 2),
    ('All Saints'' Day', '2024-11-01', 28, 2);

INSERT INTO holidays (holiday_name, holiday_date, region_id, holiday_type_id)
VALUES 
    ('Reformation Day', '2024-10-31', 20, 2),
    ('Reformation Day', '2024-10-31', 21, 2),
    ('Reformation Day', '2024-10-31', 22, 2),
    ('Reformation Day', '2024-10-31', 25, 2),
    ('Reformation Day', '2024-10-31', 24, 2),
    ('Reformation Day', '2024-10-31', 29, 2),
    ('Reformation Day', '2024-10-31', 30, 2),
    ('Reformation Day', '2024-10-31', 31, 2),
    ('Reformation Day', '2024-10-31', 32, 2);
    

