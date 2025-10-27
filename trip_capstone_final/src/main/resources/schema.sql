CREATE TABLE IF NOT EXISTS app_role (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS app_user (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(100) NOT NULL,
    user_email VARCHAR(100) UNIQUE NOT NULL,
    user_password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS app_user_role (
    user_role_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    CONSTRAINT fk_user_role_user FOREIGN KEY (user_id) REFERENCES app_user(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_user_role_role FOREIGN KEY (role_id) REFERENCES app_role(role_id) ON DELETE CASCADE,
    CONSTRAINT unique_user_role UNIQUE (user_id, role_id)
);

CREATE TABLE IF NOT EXISTS app_wallet (
    wallet_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL UNIQUE,
    wallet_balance DECIMAL(15, 2) DEFAULT 0.00,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_wallet_user FOREIGN KEY (user_id) REFERENCES app_user(user_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS wallet_transaction (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    wallet_id INT NOT NULL,
    transaction_type VARCHAR(20) NOT NULL, -- CREDIT or DEBIT
    transaction_amount DECIMAL(15, 2) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_wallet_txn FOREIGN KEY (wallet_id) REFERENCES app_wallet(wallet_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS travel_package (
    package_id INT AUTO_INCREMENT PRIMARY KEY,
    package_title VARCHAR(150) NOT NULL,
    package_description CLOB,
    package_source_city VARCHAR(100),
    package_destination_city VARCHAR(100),
    package_base_price DECIMAL(10, 2) NOT NULL,
    package_duration_days INT,
    package_start_date DATE,
    package_end_date DATE,
    package_available_slots INT,
    package_image_url VARCHAR(255),
    package_status VARCHAR(50) DEFAULT 'ACTIVE',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS hotel_info (
    hotel_id INT AUTO_INCREMENT PRIMARY KEY,
    package_id INT NOT NULL,
    hotel_name VARCHAR(100),
    hotel_location VARCHAR(100),
    hotel_rating DECIMAL(3,1),
    hotel_price_per_night DECIMAL(10,2),
    hotel_amenities CLOB,
    hotel_image_url VARCHAR(255),
    CONSTRAINT fk_hotel_package FOREIGN KEY (package_id) REFERENCES travel_package(package_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS itinerary_plan (
    itinerary_id INT AUTO_INCREMENT PRIMARY KEY,
    package_id INT NOT NULL,
    day_number INT NOT NULL,
    place_name VARCHAR(100),
    place_description CLOB,
    activities CLOB,
    CONSTRAINT fk_itinerary_package FOREIGN KEY (package_id) REFERENCES travel_package(package_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS transport_mode (
    transport_id INT AUTO_INCREMENT PRIMARY KEY,
    package_id INT NOT NULL,
    transport_type VARCHAR(50), -- BUS / TRAIN / FLIGHT
    transport_provider VARCHAR(100),
    departure_city VARCHAR(100),
    arrival_city VARCHAR(100),
    departure_time TIME,
    arrival_time TIME,
    seat_price DECIMAL(10, 2),
    available_seats INT,
    transport_image_url VARCHAR(255),
    CONSTRAINT fk_transport_package FOREIGN KEY (package_id) REFERENCES travel_package(package_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS app_booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    package_id INT NOT NULL,
    transport_id INT,
    booking_total_amount DECIMAL(10, 2),
    booking_status VARCHAR(50) DEFAULT 'PENDING', -- CONFIRMED / CANCELLED etc.
    booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_booking_user FOREIGN KEY (user_id) REFERENCES app_user(user_id) ON DELETE CASCADE,
    CONSTRAINT fk_booking_package FOREIGN KEY (package_id) REFERENCES travel_package(package_id) ON DELETE CASCADE,
    CONSTRAINT fk_booking_transport FOREIGN KEY (transport_id) REFERENCES transport_mode(transport_id)
);

CREATE TABLE IF NOT EXISTS booking_passenger (
    passenger_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT,
    passenger_name VARCHAR(100),
    passenger_email VARCHAR(100),
    passenger_phone VARCHAR(20),
    passenger_age INT,
    passenger_dob DATE,
    passenger_gender VARCHAR(20),
    CONSTRAINT fk_passenger_booking FOREIGN KEY (booking_id) REFERENCES app_booking(booking_id) ON DELETE CASCADE
);
