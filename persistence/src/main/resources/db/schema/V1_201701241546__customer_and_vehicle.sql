CREATE TABLE customer (
	id BIGINT AUTO_INCREMENT NOT NULL,
	firstName VARCHAR(255),
	lastName VARCHAR(255),
	email VARCHAR(255) NOT NULL,
	PRIMARY KEY (id))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

CREATE TABLE vehicle (
	id BIGINT AUTO_INCREMENT NOT NULL,
	owner_fk BIGINT NOT NULL,
	registration_number VARCHAR(255) NOT NULL,
	weight_in_kg DOUBLE,
	number_of_wheels INT,
	PRIMARY KEY (id),
	INDEX vehicle_to_customer_idx (owner_fk ASC),
	CONSTRAINT vehicle_to_customer
	    FOREIGN KEY (owner_fk)
	    REFERENCES customer (id)
	    ON DELETE NO ACTION
	    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;