CREATE TABLE car (
    id INT AUTO_INCREMENT PRIMARY KEY,
    slug TEXT,
    year_model INT NOT NULL,
    reg_number TEXT NOT NULL CHECK (REGEXP_LIKE(reg_number, '^[A-Z]{3}[0-9]{2}[A-Z0-9]{1}$')),
    model_id INT,
    description TEXT,
    cover BLOB,
    price DECIMAL(10, 2) NOT NULL,
    mileage INT,
    body_type_id INT,
    gearbox_type_id INT,
    horsepower INT,
    fuel_type_id INT,
    created_date DATETIME NOT NULL
);