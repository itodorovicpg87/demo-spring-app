CREATE TABLE car_feature (
    car_id INT NOT NULL,
    feature_id INT NOT NULL,
    PRIMARY KEY (car_id, feature_id),
    FOREIGN KEY (car_id) REFERENCES car (id),
    FOREIGN KEY (feature_id) REFERENCES feature (id)
);