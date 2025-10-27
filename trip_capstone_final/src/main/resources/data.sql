INSERT INTO app_role (role_name) VALUES ('ADMIN');
INSERT INTO app_role (role_name) VALUES ('USER');

INSERT INTO app_user (user_name, user_email, user_password) 
VALUES ('Nikitha', 'admin@travel.com', '$2a$12$V3wU1cXyCY1ARruf8482VujArN.auamsfV8vucV.HMLIChrulgjE2');

INSERT INTO app_user (user_name, user_email, user_password) 
VALUES ('John Doe', 'john@example.com', 'johnpass');

INSERT INTO app_user (user_name, user_email, user_password) 
VALUES ('Priya Sharma', 'priya@example.com', 'priya123');

INSERT INTO app_user (user_name, user_email, user_password) 
VALUES ('David Smith', 'david@example.com', 'davidpass');

INSERT INTO app_user (user_name, user_email, user_password) 
VALUES ('Niki', 'niki@example.com', '$2a$12$lj2iy6avbDDHOsjAN1hcoO5dYlhv1AY2N5XORqBEbiToO0UQAX85W');

INSERT INTO app_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO app_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO app_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO app_user_role (user_id, role_id) VALUES (4, 2);

INSERT INTO app_wallet (user_id, wallet_balance) VALUES (1, 10000.00);
INSERT INTO app_wallet (user_id, wallet_balance) VALUES (2, 7500.50);
INSERT INTO app_wallet (user_id, wallet_balance) VALUES (3, 5200.00);
INSERT INTO app_wallet (user_id, wallet_balance) VALUES (4, 3000.00);

INSERT INTO wallet_transaction (wallet_id, transaction_type, transaction_amount) 
VALUES (2, 'CREDIT', 2500.00);

INSERT INTO wallet_transaction (wallet_id, transaction_type, transaction_amount) 
VALUES (3, 'CREDIT', 2000.00);

INSERT INTO wallet_transaction (wallet_id, transaction_type, transaction_amount) 
VALUES (4, 'CREDIT', 1500.00);

INSERT INTO wallet_transaction (wallet_id, transaction_type, transaction_amount) 
VALUES (2, 'DEBIT', 500.00);

-- ===========================
-- TRAVEL PACKAGES (10 TOTAL)
-- ===========================

-- 1
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Chennai to Goa Beach Getaway', '3 nights, 4 days beach relaxation package including water sports and local sightseeing.', 'Chennai', 'Goa', 8500.00, 4, DATE '2025-11-10', DATE '2025-11-14', 30, 'https://plus.unsplash.com/premium_photo-1664304458186-9a67c1330d02?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8Z29hJTIwYmVhY2h8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&q=60&w=800');

-- 2
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Delhi to Manali Adventure', 'Experience snow-clad mountains, adventure sports, and scenic views.', 'Delhi', 'Manali', 12500.00, 5, DATE '2025-12-01', DATE '2025-12-06', 25, 'https://plus.unsplash.com/premium_photo-1661878942694-6adaa2ce8175?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8bWFuYWxpfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

-- 3
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Bangalore to Ooty Hills', 'Explore the serene hills of Ooty with tea gardens and boating.', 'Bangalore', 'Ooty', 7800.00, 3, DATE '2025-11-15', DATE '2025-11-18', 40, 'https://plus.unsplash.com/premium_photo-1725408090963-49dd5bfc1baf?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8b290eXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=800');

-- 4
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Hyderabad to Kerala Backwaters', 'Luxury houseboat experience through Alleppey and Kochi.', 'Hyderabad', 'Kerala', 14000.00, 5, DATE '2025-12-10', DATE '2025-12-15', 20, 'https://plus.unsplash.com/premium_photo-1697729438401-fcb4ff66d9a8?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8a2VyYWxhfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

-- 5
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Mumbai to Jaipur Royal Escape', 'Discover forts, palaces, and traditional Rajasthani culture.', 'Mumbai', 'Jaipur', 9800.00, 4, DATE '2025-11-20', DATE '2025-11-24', 35, 'https://plus.unsplash.com/premium_photo-1661963054563-ce928e477ff3?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8amFpcHVyfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

-- 6
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Kolkata to Darjeeling Mountain Retreat', 'Witness the sunrise at Tiger Hill and enjoy scenic tea gardens.', 'Kolkata', 'Darjeeling', 11200.00, 4, DATE '2025-11-25', DATE '2025-11-29', 28, 'https://plus.unsplash.com/premium_photo-1697730303782-6679b6bec202?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8ZGFyamVlbGluZ3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=800');

-- 7
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Pune to Andaman Islands', '5-day tropical island experience with scuba diving and coral reef tours.', 'Pune', 'Andaman', 18500.00, 5, DATE '2025-12-05', DATE '2025-12-10', 18, 'https://plus.unsplash.com/premium_photo-1661903221734-11c7d6fc11e7?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8YW5kYW1hbnxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=800');

-- 8
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Ahmedabad to Rann of Kutch Festival', 'Witness the beauty of the white desert and local cultural events.', 'Ahmedabad', 'Rann of Kutch', 9500.00, 3, DATE '2025-12-12', DATE '2025-12-15', 32, 'https://images.unsplash.com/photo-1670406312373-6d4d1776e4aa?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8a3V0Y2h8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&q=60&w=800');

-- 9
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Lucknow to Varanasi Heritage Tour', 'Explore the ghats of Ganga and ancient temples of Kashi.', 'Lucknow', 'Varanasi', 7200.00, 3, DATE '2025-11-28', DATE '2025-12-01', 40, 'https://images.unsplash.com/photo-1561359313-0639aad49ca6?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8dmFyYW5hc2l8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&q=60&w=800');

-- 10
INSERT INTO travel_package 
(package_title, package_description, package_source_city, package_destination_city, package_base_price, package_duration_days, package_start_date, package_end_date, package_available_slots, package_image_url)
VALUES 
('Chandigarh to Shimla Family Getaway', 'Enjoy the hills, mall road, and toy train experience.', 'Chandigarh', 'Shimla', 8800.00, 3, DATE '2025-11-30', DATE '2025-12-03', 38, 'https://plus.unsplash.com/premium_photo-1697729733902-f8c92710db07?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8c2hpbWxhfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

-- ===========================





INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (1, 'Goa Sea View Resort', 'Baga Beach, Goa', 4.5, 2500.00, 'WiFi, Pool, Breakfast, Beach Access', 'https://plus.unsplash.com/premium_photo-1661877303180-19a028c21048?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8aG90ZWxzJTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (2, 'Himalayan Heights', 'Manali', 4.3, 2000.00, 'WiFi, Heater, Balcony View, Parking', 'https://images.unsplash.com/photo-1693956964579-0908f511e89b?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGhvdGVscyUyMGltYWdlc3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (3, 'Ooty Lake View Inn', 'Ooty', 4.2, 1800.00, 'WiFi, Parking, Breakfast', 'https://images.unsplash.com/photo-1757839939502-afa95e78dd60?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGhvdGVscyUyMGltYWdlc3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (4, 'Kerala Houseboat Retreat', 'Alleppey', 4.6, 3500.00, 'WiFi, Houseboat Stay, Meals, Scenic View', 'https://images.unsplash.com/photo-1757839939502-afa95e78dd60?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fGhvdGVscyUyMGltYWdlc3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (5, 'Jaipur Heritage Palace', 'Jaipur', 4.4, 2400.00, 'Pool, Spa, Traditional Dining, WiFi', 'https://images.unsplash.com/photo-1693956964978-eaa42f2e4074?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8aG90ZWxzJTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (6, 'Darjeeling View Resort', 'Darjeeling', 4.5, 2200.00, 'WiFi, Fireplace, Tea Lounge, Balcony', 'https://images.unsplash.com/photo-1619524804109-0bea7d7398a5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8aG90ZWxzJTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (7, 'Andaman Ocean Blue', 'Port Blair', 4.7, 4000.00, 'WiFi, Beach Access, Diving Gear, Restaurant', 'https://images.unsplash.com/photo-1619524804109-0bea7d7398a5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8aG90ZWxzJTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (8, 'Kutch Desert Camp', 'Rann of Kutch', 4.3, 1900.00, 'Cultural Shows, Bonfire, Dinner, WiFi', 'https://images.unsplash.com/photo-1693956964579-0908f511e89b?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fGhvdGVscyUyMGltYWdlc3xlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (9, 'Varanasi Ganga View Hotel', 'Varanasi', 4.1, 1600.00, 'River View, Breakfast, WiFi, AC Rooms', 'https://images.unsplash.com/photo-1693956964978-eaa42f2e4074?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8aG90ZWxzJTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');

INSERT INTO hotel_info (package_id, hotel_name, hotel_location, hotel_rating, hotel_price_per_night, hotel_amenities, hotel_image_url)
VALUES (10, 'Shimla Hilltop Resort', 'Shimla', 4.5, 2300.00, 'WiFi, Heater, Breakfast, Mountain View', 'https://plus.unsplash.com/premium_photo-1661877303180-19a028c21048?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8aG90ZWxzJTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=800');


-- Package 1: Chennai → Goa Beach Getaway (4 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(1, 1, 'Baga Beach', 'Relax at the famous Baga Beach with water sports.', 'Jet skiing, Parasailing, Beach walk'),
(1, 2, 'Dudhsagar Falls', 'Visit the majestic waterfall through a scenic jungle trail.', 'Trekking, Photography'),
(1, 3, 'Fort Aguada', 'Historic Portuguese fort overlooking the Arabian Sea.', 'Sightseeing, Sunset view'),
(1, 4, 'Goa Markets', 'Shop at Anjuna and Mapusa markets.', 'Shopping, Local food tasting');

-- Package 2: Delhi → Manali Adventure (5 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(2, 1, 'Solang Valley', 'Adventure spot surrounded by snow peaks.', 'Skiing, Paragliding'),
(2, 2, 'Rohtang Pass', 'High-altitude pass with panoramic views.', 'Snow play, Photography'),
(2, 3, 'Hidimba Temple', 'Ancient cave temple surrounded by deodar trees.', 'Temple visit, Local sightseeing'),
(2, 4, 'Mall Road', 'Popular shopping street in Manali town.', 'Shopping, Café hopping'),
(2, 5, 'Beas River', 'Scenic riverside walk before departure.', 'Boating, Relaxation');

-- Package 3: Bangalore → Ooty Hills (3 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(3, 1, 'Botanical Garden', 'Explore Ooty’s vibrant flower gardens.', 'Sightseeing, Boating'),
(3, 2, 'Tea Factory', 'Learn tea-making process and taste fresh tea.', 'Factory tour, Tea tasting'),
(3, 3, 'Doddabetta Peak', 'Highest mountain in the Nilgiris.', 'Hiking, Photography');

-- Package 4: Hyderabad → Kerala Backwaters (5 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(4, 1, 'Alleppey Backwaters', 'Cruise through scenic canals.', 'Houseboat stay, Fishing'),
(4, 2, 'Kumarakom Bird Sanctuary', 'Explore lush wetlands filled with migratory birds.', 'Birdwatching, Boating'),
(4, 3, 'Cochin Fort Area', 'Historic port with colonial architecture.', 'Sightseeing, Shopping'),
(4, 4, 'Athirappilly Falls', 'Famous waterfall known as the Niagara of India.', 'Trekking, Photography'),
(4, 5, 'Cherai Beach', 'Relax at the clean and quiet beach.', 'Swimming, Sunbathing');

-- Package 5: Mumbai → Jaipur Heritage Tour (4 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(5, 1, 'Amber Fort', 'Massive fort overlooking Maota Lake.', 'Elephant ride, Photography'),
(5, 2, 'City Palace', 'Royal residence and museum.', 'Guided tour, Museum visit'),
(5, 3, 'Hawa Mahal', 'Palace of Winds with unique architecture.', 'Sightseeing, Shopping'),
(5, 4, 'Chokhi Dhani', 'Traditional Rajasthani village experience.', 'Cultural show, Dinner');

-- Package 6: Kolkata → Darjeeling Hills (5 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(6, 1, 'Tiger Hill', 'Watch sunrise over Kanchenjunga.', 'Sightseeing, Photography'),
(6, 2, 'Batasia Loop', 'Unique spiral railway track.', 'Toy train ride, Scenic viewing'),
(6, 3, 'Tea Garden', 'Visit tea estates and learn the process.', 'Plucking, Tasting'),
(6, 4, 'Japanese Peace Pagoda', 'Serene Buddhist monument.', 'Meditation, Photography'),
(6, 5, 'Mall Road', 'Famous shopping and café area.', 'Shopping, Relaxing');

-- Package 7: Pune → Andaman Islands (6 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(7, 1, 'Port Blair', 'Visit Cellular Jail and local museum.', 'Sightseeing, Light show'),
(7, 2, 'Havelock Island', 'White sand beaches and coral reefs.', 'Snorkeling, Scuba diving'),
(7, 3, 'Radhanagar Beach', 'Asia’s top-rated beach.', 'Relaxation, Sunset viewing'),
(7, 4, 'Neil Island', 'Less crowded, natural rock formation.', 'Cycling, Photography'),
(7, 5, 'Ross Island', 'Historic ruins and wildlife.', 'Exploration, Birdwatching'),
(7, 6, 'Chidiya Tapu', 'Sunset point and bird sanctuary.', 'Trekking, Photography');

-- Package 8: Ahmedabad → Leh-Ladakh Adventure (6 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(8, 1, 'Leh Palace', 'Historic royal palace.', 'Sightseeing, Photography'),
(8, 2, 'Pangong Lake', 'High-altitude blue lake.', 'Photography, Picnic'),
(8, 3, 'Nubra Valley', 'Cold desert with double-humped camels.', 'Camel ride, Camping'),
(8, 4, 'Khardung La Pass', 'One of the highest motorable roads.', 'Adventure drive, Snow view'),
(8, 5, 'Magnetic Hill', 'Gravity-defying optical illusion.', 'Sightseeing'),
(8, 6, 'Shanti Stupa', 'Panoramic sunset views.', 'Meditation, Photography');

-- Package 9: Chennai → Singapore City Tour (5 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(9, 1, 'Marina Bay Sands', 'Luxury area with sky park view.', 'Sightseeing, Photography'),
(9, 2, 'Sentosa Island', 'Theme parks and beaches.', 'Universal Studios, Water activities'),
(9, 3, 'Gardens by the Bay', 'Futuristic garden domes.', 'Cloud forest, Light show'),
(9, 4, 'Little India & Chinatown', 'Cultural neighborhoods.', 'Shopping, Street food'),
(9, 5, 'Singapore Flyer', 'World’s largest observation wheel.', 'Panoramic city views');

-- Package 10: Delhi → Shimla & Kufri Snow Escape (4 days)
INSERT INTO itinerary_plan (package_id, day_number, place_name, place_description, activities) VALUES 
(10, 1, 'The Ridge', 'Heart of Shimla with colonial buildings.', 'Walking tour, Café hopping'),
(10, 2, 'Jakhoo Temple', 'Temple on hilltop with scenic view.', 'Trekking, Photography'),
(10, 3, 'Kufri', 'Snow adventure activities.', 'Skiing, Horse riding'),
(10, 4, 'Mall Road', 'Main market area with shops.', 'Shopping, Local food tasting');



-- 1. Chennai → Goa Beach Getaway
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (1, 'BUS', 'RedBus Travels', 'Chennai', 'Goa', TIME '06:00:00', TIME '20:00:00', 1200.00, 40, 'https://media.istockphoto.com/id/879364174/photo/white-bus-traveling-on-the-asphalt-road-in-a-rural-landscape-at-sunset.webp?a=1&b=1&s=612x612&w=0&k=20&c=ADNEIncLww57KGI1JwY-4Ztv-lkHrqDOltmIt-5-FWE=');

-- 2. Delhi → Manali Adventure
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (2, 'FLIGHT', 'Air India', 'Delhi', 'Kullu', TIME '07:00:00', TIME '08:30:00', 5000.00, 30, 'https://plus.unsplash.com/premium_photo-1679830513881-84d36eb3e3f5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZmxpZ2h0JTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=1000');

-- 3. Bangalore → Ooty Hills
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (3, 'TRAIN', 'IRCTC Express', 'Bangalore', 'Ooty', TIME '08:00:00', TIME '13:00:00', 800.00, 60, 'https://images.unsplash.com/photo-1713955942351-07c9714c03b0?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8dHJhaW4lMjBpbWFnZXN8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&q=60&w=1000');

-- 4. Hyderabad → Kerala Backwaters
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (4, 'FLIGHT', 'IndiGo Airlines', 'Hyderabad', 'Kochi', TIME '09:00:00', TIME '10:30:00', 4200.00, 50, 'https://plus.unsplash.com/premium_photo-1679830513881-84d36eb3e3f5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZmxpZ2h0JTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=1000');

-- 5. Mumbai → Jaipur Heritage Tour
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (5, 'TRAIN', 'Rajdhani Express', 'Mumbai', 'Jaipur', TIME '05:30:00', TIME '15:45:00', 1500.00, 80, 'https://images.unsplash.com/photo-1713955942351-07c9714c03b0?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8dHJhaW4lMjBpbWFnZXN8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&q=60&w=1000');

-- 6. Kolkata → Darjeeling Hills
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (6, 'TRAIN', 'Toy Train Express', 'Kolkata', 'Darjeeling', TIME '06:15:00', TIME '18:00:00', 950.00, 45, 'https://images.unsplash.com/photo-1713955942351-07c9714c03b0?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8dHJhaW4lMjBpbWFnZXN8ZW58MHx8MHx8fDA%3D&auto=format&fit=crop&q=60&w=1000');

-- 7. Pune → Andaman Islands
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (7, 'FLIGHT', 'SpiceJet Airlines', 'Pune', 'Port Blair', TIME '08:00:00', TIME '11:00:00', 7200.00, 35, 'https://plus.unsplash.com/premium_photo-1679830513881-84d36eb3e3f5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZmxpZ2h0JTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=1000');

-- 8. Ahmedabad → Leh-Ladakh Adventure
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (8, 'FLIGHT', 'GoAir', 'Ahmedabad', 'Leh', TIME '05:45:00', TIME '07:30:00', 6800.00, 30, 'https://plus.unsplash.com/premium_photo-1679830513881-84d36eb3e3f5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZmxpZ2h0JTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=1000');

-- 9. Chennai → Singapore City Tour
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (9, 'FLIGHT', 'Singapore Airlines', 'Chennai', 'Singapore', TIME '02:00:00', TIME '08:00:00', 12000.00, 40, 'https://plus.unsplash.com/premium_photo-1679830513881-84d36eb3e3f5?ixlib=rb-4.1.0&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NXx8ZmxpZ2h0JTIwaW1hZ2VzfGVufDB8fDB8fHww&auto=format&fit=crop&q=60&w=1000');

-- 10. Delhi → Shimla & Kufri Snow Escape
INSERT INTO transport_mode (package_id, transport_type, transport_provider, departure_city, arrival_city, departure_time, arrival_time, seat_price, available_seats, transport_image_url)
VALUES (10, 'BUS', 'Himachal Tourism Volvo', 'Delhi', 'Shimla', TIME '21:00:00', TIME '07:00:00', 1100.00, 55, 'https://media.istockphoto.com/id/879364174/photo/white-bus-traveling-on-the-asphalt-road-in-a-rural-landscape-at-sunset.webp?a=1&b=1&s=612x612&w=0&k=20&c=ADNEIncLww57KGI1JwY-4Ztv-lkHrqDOltmIt-5-FWE=');




INSERT INTO app_booking (user_id, package_id, transport_id, booking_total_amount, booking_status)
VALUES (2, 1, 1, 9700.00, 'CONFIRMED');

INSERT INTO app_booking (user_id, package_id, transport_id, booking_total_amount, booking_status)
VALUES (3, 3, 3, 8600.00, 'PENDING');

INSERT INTO booking_passenger (booking_id, passenger_name, passenger_email, passenger_phone, passenger_age, passenger_dob, passenger_gender)
VALUES (1, 'John Doe', 'john@example.com', '9876543210', 28, DATE '1997-04-12', 'MALE');

INSERT INTO booking_passenger (booking_id, passenger_name, passenger_email, passenger_phone, passenger_age, passenger_dob, passenger_gender)
VALUES (1, 'Priya Sharma', 'priya@example.com', '9988776655', 25, DATE '2000-01-05', 'FEMALE');



