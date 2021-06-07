create table Roles
    (
        id int identity not null,
        name varchar2 not null,
        primary key (id)
);

create table Users
(
    id int identity not null,
    username varchar2 not null,
    password varchar2 not null,
    firstname varchar2 ,
    lastname varchar2 ,
    email varchar2 ,
    enabled bool not null default 1,
    primary key (id)
);

create unique index UI_users_username on Users(username);
create unique index UI_users_email on Users (email);

create table Users_Roles
(
    userId int not null references Users(id),
    roleId int not null references Roles(id)
);

create unique index PK_users_roles on Users_Roles(userId, roleId);