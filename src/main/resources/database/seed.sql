-- 1. Insert 2 Users (Passwords must be plaintext to match your UserDAO)
INSERT INTO users (username, password, role) VALUES ('tenant1', 'pass123', 'TENANT');
INSERT INTO users (username, password, role) VALUES ('landlord1', 'pass123', 'LANDLORD');

-- 2. Insert 2 Properties (Belonging to landlord1, whose ID is 2)
INSERT INTO properties (landlord_id, name, address, description)
VALUES (2, 'Sunset Boarding House', '123 Main St, Labangon', 'Quiet and affordable boarding house.');

INSERT INTO properties (landlord_id, name, address, description)
VALUES (2, 'Downtown Apartments', '456 City Center, Cebu', 'Premium apartments near the university.');

-- 3. Insert 3 Rooms
INSERT INTO rooms (property_id, room_number, capacity, price, is_available) VALUES (1, '101', 2, 5000.0, 1);
INSERT INTO rooms (property_id, room_number, capacity, price, is_available) VALUES (1, '102', 4, 3500.0, 0);
INSERT INTO rooms (property_id, room_number, capacity, price, is_available) VALUES (2, '201A', 1, 8000.0, 1);

-- 4. Insert 1 Booking (tenant1 books room 102)
INSERT INTO bookings (tenant_id, room_id, status) VALUES (1, 2, 'APPROVED');

-- 5. Insert 1 Review (tenant1 reviews Sunset Boarding House)
INSERT INTO reviews (property_id, tenant_id, rating, comment) VALUES (1, 1, 5, 'Great landlord and clean rooms!');