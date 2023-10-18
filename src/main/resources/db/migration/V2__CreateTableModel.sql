CREATE TABLE model (
    id INT AUTO_INCREMENT PRIMARY KEY,
    make_id INT NOT NULL,
    name TEXT NOT NULL,
    FOREIGN KEY (make_id) REFERENCES make(id)
);


