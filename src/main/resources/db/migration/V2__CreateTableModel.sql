CREATE TABLE model (
    id INT AUTO_INCREMENT PRIMARY KEY,
    make_id INT,
    name TEXT,
    FOREIGN KEY (make_id) REFERENCES make(id)
);


