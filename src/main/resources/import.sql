INSERT INTO "Coffee"(
	id, price, typ)
	VALUES (1, 4, 'capuccino');
INSERT INTO "Coffee"(
	id, price, typ)
	VALUES (2, 3, 'machiatto');
INSERT INTO "Coffee"(
	id, price, typ)
	VALUES (3, 2, 'espresso');

INSERT INTO "User"(id, email, "isAdmin", nachname, passwort, vorname)
	VALUES (1, 'jon@gmail.com', TRUE, 'Bunjaku', 'password', 'Jon');
INSERT INTO "User"(id, email, "isAdmin", nachname, passwort, vorname)
	VALUES (2, 'max@muster', FALSE, 'muster', 'maxmuster', 'max');
INSERT INTO "User"(id, email, "isAdmin", nachname, passwort, vorname)
	VALUES (3, 'test@test', FALSE, 'test', 'test', 'test');

INSERT INTO user_coffee(
	coffee_id, user_id)
	VALUES (1, 1);
INSERT INTO user_coffee(
	coffee_id, user_id)
	VALUES (2, 1);
INSERT INTO user_coffee(
	coffee_id, user_id)
	VALUES (3, 1);


INSERT INTO "Bookingstatus"(id, bookingstatus)
	VALUES (1, 'pending');
INSERT INTO "Bookingstatus"(id, bookingstatus)
	VALUES (2, 'accepted');
    INSERT INTO "Bookingstatus"(id, bookingstatus)
	VALUES (3, 'denied');

INSERT INTO "Workspace"(
	id, name)
	VALUES (1, 'Dietikon');
INSERT INTO "Workspace"(
	id, name)
	VALUES (2, 'Urdorf');
INSERT INTO "Workspace"(
	id, name)
	VALUES (3, 'Schlieren');

INSERT INTO "Booking"(
	id, end_date, start_date, "bookingStatus_id", users_id, workspaces_id)
	VALUES (1, '2022-03-10', '2022-03-05', 2, 1, 1);
INSERT INTO "Booking"(
	id, end_date, start_date, "bookingStatus_id", users_id, workspaces_id)
	VALUES (2, '2022-04-10', '2022-04-05', 2, 1, 2);
INSERT INTO "Booking"(
	id, end_date, start_date, "bookingStatus_id", users_id, workspaces_id)
	VALUES (3, '2022-05-10', '2022-05-05', 2, 1, 1);