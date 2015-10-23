CREATE TABLE Bonus
 (
 ID int NOT NULL primary key
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1), 
 ssn varchar(255) NOT NULL,
 bonus varchar(255)
 )
