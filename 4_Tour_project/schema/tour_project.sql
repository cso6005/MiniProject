
USE playdata;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS travel;

CREATE TABLE travel (
	   travel_id    	VARCHAR(20)  PRIMARY KEY,
       travel_name 		VARCHAR(30) NOT NULL,
       city          VARCHAR(30) NOT NULL,
       period           VARCHAR(30) NOT NULL, 
       price         	int(20) NOT NULL,
       star_rate        int(20) NOT NULL
              
);

CREATE TABLE users (
		user_id 	VARCHAR(20) PRIMARY KEY,
        user_pw 	varchar(30) NOT NULL,
        user_name 	varchar(30)  NOT NULL,
		travel_id 	varchar(50),
                
       CONSTRAINT fk_travel_user  FOREIGN KEY(travel_id) REFERENCES travel(travel_id) ON DELETE SET NULL
);

-- insert travel
insert into travel values('t1', '베트남 패키지', '다낭, 하노이, 하롱베이', '5박6일', 70, 3);
insert into travel values('t2', '유럽일주', '피렌체, 로마, 런던, 마드리드 ...', '17박18일', 500, 4);
insert into travel values('t3', '일본 자유여행', '도쿄, 오사카', '4박5일', 40, 2);
insert into travel values('t4', '지중해 일주', '스페인, 포르투갈, 코로코', '10박12일', 350, 4);
insert into travel values('t5', '베트남 자유여행', '다낭, 호이안' , '4박5일' ,40, 4);
insert into travel values('t6', '유럽 자유여행', '프라하, 피렌체, 로마, 런던' , '10박11일' ,250, 4);
insert into travel values('t7', '아프리카 패키지', '몽골, 테렐지, 엘승타사르하이' , '5박7일' ,130, 4);

-- insert users 
insert into users values('user1',  '1111','김민지' ,'t1');
insert into users values('user2', '1231', '오선경',  't2');
insert into users values('user3', '2211','배승아',  't3');
insert into users values('user4', '0000', '박효민' , 't4');

-- desc users;
-- desc travel;
-- select * from travel;
-- select * from users;

