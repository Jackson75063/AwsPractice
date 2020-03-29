
create extension if not exists pgcrypto;

INSERT INTO abiturients( id_abit_code,username,surname, email, password ) VALUES (1,'admin','admin','admin@gmail.com','admin11');

update abiturients set password = crypt(password, gen_salt('bf', 8));
