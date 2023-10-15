DELIMITER //
CREATE TRIGGER car_generate_slug
    BEFORE INSERT ON car
    FOR EACH ROW
BEGIN
    DECLARE model_make_id INT;
    DECLARE model_name VARCHAR(255);
    DECLARE make_name VARCHAR(255);

    -- Retrieve the make_id and model_name from the "model" table
    SELECT make_id, name INTO model_make_id, model_name FROM model WHERE id = NEW.model_id;

    -- Retrieve the make name from the "make" table
    SELECT name INTO make_name FROM make WHERE id = model_make_id;

    -- Generate the slug by concatenating the make_name, model_name, year_model, and reg_number
    SET NEW.slug = CONCAT(make_name, '-', model_name,'-', NEW.year_model, '-', NEW.reg_number);
END;
//
DELIMITER ;
