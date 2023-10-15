INSERT INTO make (name) VALUES
                            ('Audi'),
                            ('BMW'),
                            ('Volvo');

INSERT INTO model (make_id, name) VALUES
                                      (1, 'A5'),
                                      (1, 'Q5'),
                                      (2, 'X3'),
                                      (2, 'X5'),
                                      (3, 'XC60'),
                                      (3, 'XC90');

INSERT INTO body_type (name) VALUES
                                 ('Sedan'),
                                 ('SUV'),
                                 ('Coupe'),
                                 ('Hatchback');

INSERT INTO fuel_type (name) VALUES
                                 ('Diesel'),
                                 ('Gasoline'),
                                 ('Hybrid'),
                                 ('Electric');

INSERT INTO gearbox_type (name) VALUES
                                    ('Automatic'),
                                    ('Manual'),
                                    ('DSG'),
                                    ('CVT');

INSERT INTO feature (name) VALUES
                               ('4WD'),
                               ('Keyless Entry'),
                               ('Leather Seats'),
                               ('Sunroof'),
                               ('Navigation System');
