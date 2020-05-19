Use bookStore;

DELIMITER //
CREATE TRIGGER check_no_books before update ON book FOR EACH ROW
BEGIN
	IF
		new.NoOfBooks < 0
	THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Number of books is not available by now';
	END IF;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER place_order after update ON book FOR EACH ROW
BEGIN
	IF
		new.NoOfBooks <= 5
	THEN
		insert into orders values (new.ISBN, 20);
	END IF;
END //
DELIMITER ;
drop trigger check_no_books;
drop trigger place_order;

DELIMITER //
CREATE TRIGGER confirm_order before delete ON orders FOR EACH ROW
BEGIN
		update book set NoOfBooks = NoOfBooks + old.NoOfBooks where ISBN = old.ISBN;
END //
DELIMITER ;

DELIMITER //
CREATE TRIGGER promote_users before delete ON promote FOR EACH ROW
BEGIN
		update customers set type = 'manager' where username = old.username;
END //
DELIMITER ;