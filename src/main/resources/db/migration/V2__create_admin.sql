
create extension if not exists pgcrypto;


INSERT INTO abiturients (username, email, password, id_abit_code )
                VALUES ('admin','admin@gmail.com','admin11',1);


update abiturients set password = crypt(password, gen_salt('bf', 8));
