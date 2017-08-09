-- attendence
INSERT INTO attendence VALUES(1,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'absent',NOW(),NOW(),NULL);
INSERT INTO attendence VALUES(2,0,CONCAT('code',2),NOW(),'hong',0,'hong',NOW(),'absent',NOW(),NOW(),NULL);
INSERT INTO attendence VALUES(3,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'absent',NOW(),NOW(),NULL);
-- supplier
INSERT INTO supplier VALUES(11,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'YIHAO');
INSERT INTO supplier VALUES(12,1,CONCAT('code',2),NOW(),'hong',0,'hong',NOW(),'ERHAO');
INSERT INTO supplier VALUES(13,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'SANHAO');
-- projects
INSERT INTO proj VALUES(21,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'SANHAO',0,NULL,NULL);
INSERT INTO proj VALUES(22,1,CONCAT('code',2),NOW(),'hong',0,'hong',NOW(),'SANHAO',0,NULL,NULL);
INSERT INTO proj VALUES(23,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'SANHAO',0,NULL,NULL);
-- department
INSERT INTO dept VALUES(31,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'運研');
INSERT INTO dept VALUES(32,1,CONCAT('code',2),NOW(),'hong',0,'hong',NOW(),'飯堂');
INSERT INTO dept VALUES(33,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'空乘');
-- os_pos
INSERT INTO os_pos VALUES(41,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'java');
INSERT INTO os_pos VALUES(42,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'csharp');
INSERT INTO os_pos VALUES(43,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'python');
-- bid
INSERT INTO bid VALUES('high',300,20,11,21,41);
INSERT INTO bid VALUES('normal',200,30,12,22,42);
INSERT INTO bid VALUES('low',100,10,13,23,43);
-- criteria
INSERT INTO criteria VALUES(51,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'sfaffEval','workHour');
INSERT INTO criteria VALUES(52,1,CONCAT('code',2),NOW(),'hong',0,'hong',NOW(),'supplierEval','workHour');
INSERT INTO criteria VALUES(53,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'canteenEval','workHour');

-- staff
INSERT INTO staff VALUES(61,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'宏','password',NULL,NULL);
INSERT INTO staff VALUES(62,1,CONCAT('code',2),NOW(),'hong',0,'hong',NOW(),'煌','password',NULL,NULL);
INSERT INTO staff VALUES(63,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'玲','password',NULL,NULL);
INSERT INTO staff VALUES(64,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'伦','password',NULL,NULL);
INSERT INTO staff VALUES(65,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'沁哥','password',NULL,NULL);
-- os_staff
INSERT INTO os_staff VALUES(71,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'宏','本科',1,1,1,1,1,61,13);
INSERT INTO os_staff VALUES(72,1,CONCAT('code',2),NOW(),'hong',0,'hong',NOW(),'煌','失了智',1,1,1,1,1,62,13);
INSERT INTO os_staff VALUES(73,1,CONCAT('code',3),NOW(),'hong',0,'hong',NOW(),'玲','文盲',1,1,1,1,1,63,13);
INSERT INTO os_staff VALUES(74,1,CONCAT('code',4),NOW(),'hong',0,'hong',NOW(),'伦','贫下中农',1,1,1,1,1,64,13);

-- update staff
UPDATE staff s
SET s.fk_os_staff_id = (
	SELECT o.id FROM os_staff o WHERE o.name = '宏'
)
WHERE s.name = '宏';

UPDATE staff s
SET s.fk_os_staff_id = (
	SELECT o.id FROM os_staff o WHERE o.name = '煌'
)
WHERE s.name = '煌';

UPDATE staff s
SET s.fk_os_staff_id = (
	SELECT o.id FROM os_staff o WHERE o.name = '玲'
)
WHERE s.name = '玲';

UPDATE staff s
SET s.fk_os_staff_id = (
	SELECT o.id FROM os_staff o WHERE o.name = '伦'
)
WHERE s.name = '伦';

-- cs_staff
INSERT INTO cs_staff VALUES(81,1,CONCAT('code',1),NOW(),'hong',0,'hong',NOW(),'沁哥',65);

-- update cs_staff
UPDATE staff s
SET s.fk_cs_staff_id = (
	SELECT c.id FROM cs_staff c WHERE c.name = '沁哥'
)
WHERE s.name = '沁哥';

-- os_staff_statestate
INSERT INTO os_staff_state(id, validation) VALUES(91, 1)
INSERT INTO os_staff_state(id, validation) VALUES(92, 1)
INSERT INTO os_staff_state(id, validation) VALUES(93, 1)

-- attendence
INSERT INTO attendence(id, sign_in, sign_out, fk_os_staff_state_id)
	VALUES(101, NOW(), NOW(),91)
INSERT INTO attendence(id, sign_in, sign_out, fk_os_staff_state_id)
	VALUES(102, NOW(), NOW(),92)
INSERT INTO attendence(id, sign_in, sign_out, fk_os_staff_state_id)
	VALUES(103, NOW(), NOW(),93)