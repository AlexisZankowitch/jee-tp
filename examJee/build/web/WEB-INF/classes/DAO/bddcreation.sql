CREATE TABLE bddUser
 (
 ID int NOT NULL primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
 firstname varchar(255),
 birthname varchar(255),
 login varchar(255)
 )

