create extension if not exists pgcrypto;


INSERT INTO abiturients(id_abit_code,avg_diploma_mark, email, password, po_batkovi, request_counter, surname, username)
                    values (2,8.0, 'test1@gmail.com','password1','Васильович', 5,'Павлюк', 'Василь');

INSERT INTO user_roles VALUES (2,1);

INSERT INTO abiturients(id_abit_code,avg_diploma_mark, email, password, po_batkovi, request_counter, surname, username)
                    values (3,8.0, 'test2@gmail.com','password1','Васильович', 5,'Павлюк', 'Василь');

INSERT INTO user_roles VALUES (3,1);

update abiturients set password = crypt(password, gen_salt('bf', 8));
