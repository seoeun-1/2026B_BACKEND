# 속성/ 필드 제약조건

create table test3(
    필드명1 tinty not null,
    필드명2 smallint unique,
    필드명3 int default 100,
    필드명4 datetime default now(),
    필드명5  bigint auto_increment,
    constraint primary key( 필드명5 ) 
);

create table test4(
    필드명1 bigint, constraint foreign key( 필드명1 ) references test3 (필드명5)
);