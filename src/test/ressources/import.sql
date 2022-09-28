INSERT INTO "Coffee"(
	price, typ)
	VALUES (4, 'capuccino');
INSERT INTO "Coffee"(
	price, typ)
	VALUES (3, 'machiatto');
INSERT INTO "Coffee"(
	price, typ)
	VALUES (2, 'espresso');

INSERT INTO "User"(email, "isAdmin", nachname, passwort, vorname)
	VALUES ('jon@gmail.com', TRUE, 'Bunjaku', 'password', 'Jon');
INSERT INTO "User"(email, "isAdmin", nachname, passwort, vorname)
	VALUES ('max@muster', FALSE, 'muster', 'maxmuster', 'max');
INSERT INTO "User"(email, "isAdmin", nachname, passwort, vorname)
	VALUES ('test@test', FALSE, 'test', 'test', 'test');

INSERT INTO user_coffee(
	coffee_id, user_id)
	VALUES (1, 1);
INSERT INTO user_coffee(
	coffee_id, user_id)
	VALUES (2, 1);
INSERT INTO user_coffee(
	coffee_id, user_id)
	VALUES (3, 1);


INSERT INTO "Bookingstatus"(bookingstatus)
	VALUES ('pending');
INSERT INTO "Bookingstatus"(bookingstatus)
	VALUES ('accepted');
    INSERT INTO "Bookingstatus"(bookingstatus)
	VALUES ('denied');

INSERT INTO "Workspace"(
	name)
	VALUES ('Dietikon');
INSERT INTO "Workspace"(
	name)
	VALUES ('Urdorf');
INSERT INTO "Workspace"(
	name)
	VALUES ('Schlieren');

INSERT INTO "Booking"(
	end_date, start_date, "bookingStatus_id", users_id, workspaces_id)
	VALUES ('2022-03-10', '2022-03-05', 2, 1, 1);
INSERT INTO "Booking"(
	end_date, start_date, "bookingStatus_id", users_id, workspaces_id)
	VALUES ('2022-04-10', '2022-04-05', 2, 1, 2);
INSERT INTO "Booking"(
	end_date, start_date, "bookingStatus_id", users_id, workspaces_id)
	VALUES ('2022-05-10', '2022-05-05', 2, 1, 1);