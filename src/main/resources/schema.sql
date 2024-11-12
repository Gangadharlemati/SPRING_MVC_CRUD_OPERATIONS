CREATE TABLE IF NOT EXISTS Clinical_trial(
     id varchar(50) PRIMARY KEY ,
    title varchar(256) NOT NULL,
    status varchar(50) NOT NULL,
    minimumAge varchar(5) NOT NULL,
    maximumAge varchar(5) NOT NULL,
    startDate varchar(20) NOT NULL,
    endDate varchar(20) NOT NULL,
    participantCount varchar(5) NOT NULL
);