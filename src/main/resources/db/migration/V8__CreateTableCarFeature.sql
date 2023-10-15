CREATE TABLE car_feature (
    car_id INT,
    feature_id INT,
    PRIMARY KEY (car_id, feature_id),
    FOREIGN KEY (car_id) REFERENCES car (id),
    FOREIGN KEY (feature_id) REFERENCES feature (id)
);