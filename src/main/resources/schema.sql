create table if not exists config(id integer primary key autoincrement, date string not null, title string);
insert or ignore into config values(0, "2020-01-01", "2020年第一天");