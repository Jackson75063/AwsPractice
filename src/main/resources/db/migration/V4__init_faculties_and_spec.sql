INSERT INTO faculty VALUES(12,'Комп`ютерні науки' );
INSERT INTO faculty VALUES(14,'Хімічний' );
INSERT INTO faculty VALUES(15,'Фізика' );
INSERT INTO faculty VALUES(16,'Деревооброблювальних технологій' );



INSERT INTO specialization VALUES(21,3233, 'Комп’ютерна інженерія');
-- INSERT INTO  specialization_need_subjects VALUES (21,' MATH');
INSERT INTO  specialization_need_subjects VALUES (21,' UKR_MOVA');
INSERT INTO  specialization_need_subjects VALUES (21,' PHISIC');
INSERT INTO  specialization_need_subjects VALUES (21,' MATH');


INSERT INTO specialization VALUES(22,3234, 'Обслуговування програмних систем і комплексів');
INSERT INTO  specialization_need_subjects VALUES (22,' UKR_MOVA');
INSERT INTO  specialization_need_subjects VALUES (22,' PHISIC');
INSERT INTO  specialization_need_subjects VALUES (22,' MATH');



INSERT INTO specialization VALUES(23,3235, 'Кібернетика' );
INSERT INTO specialization VALUES(24,3236, 'Інформаційна безпека');

INSERT INTO specialization VALUES(25,3334, 'Хімічна деревообробка' );
INSERT INTO specialization VALUES(26,3334, 'Хімічні сполуки' );

INSERT INTO specialization VALUES(27,3334, 'Фізика та астрономія' );
INSERT INTO specialization VALUES(28,3335, 'Прикладна фізика та наноматеріали' );
INSERT INTO specialization VALUES(29,3336, 'Середня освіта (фізика)' );

INSERT INTO specialization VALUES(30,4036, 'Деревообробні та меблеві технологі' );
INSERT INTO specialization VALUES(31,4037, 'Технології захисту навколишнього середовища');
INSERT INTO  specialization_need_subjects VALUES (31,' UKR_MOVA');
INSERT INTO  specialization_need_subjects VALUES (31,' PHISIC');
INSERT INTO  specialization_need_subjects VALUES (31,' MATH');


INSERT INTO  faculty_specializations VALUES (12,21);


INSERT INTO  faculty_specializations VALUES (12,22);
INSERT INTO  faculty_specializations VALUES (12,23);
INSERT INTO  faculty_specializations VALUES (12,24);


INSERT INTO  faculty_specializations VALUES (14,25);
INSERT INTO  faculty_specializations VALUES (14,26);

INSERT INTO  faculty_specializations VALUES (15,27);
INSERT INTO  faculty_specializations VALUES (15,28);
INSERT INTO  faculty_specializations VALUES (15,29);

INSERT INTO  faculty_specializations VALUES (16,30);
INSERT INTO  faculty_specializations VALUES (16,31);



