-- Create the database nba
CREATE DATABASE IF NOT EXISTS nba;

-- Select the database nba
USE nba;

-- Create the team table
CREATE TABLE IF NOT EXISTS team (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL -- City column included directly in the team table
);

-- Create the player table
CREATE TABLE IF NOT EXISTS player (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    jersey_number TINYINT NOT NULL,
    team_id INT,
    FOREIGN KEY (team_id) REFERENCES team(id),
    UNIQUE (jersey_number, team_id) -- Ensure that jersey number is unique per team
);

-- Insert data into the team table
INSERT INTO team (name, city)
VALUES
    ('Los Angeles Lakers', 'Los Angeles'),
    ('Dallas Mavericks', 'Dallas'),
    ('Boston Celtics', 'Boston'),
    ('Golden State Warriors', 'San Francisco');

-- Insert data into the player table
INSERT INTO player (first_name, last_name, jersey_number, team_id)
VALUES
    -- Los Angeles Lakers
    ('LeBron', 'James', 23, 1),
    ('Anthony', 'Davis', 3, 1),
    ('Austin', 'Reaves', 15, 1),
    ('D’Angelo', 'Russell', 1, 1),
    ('Bronny', 'James', 9, 1),
    
    -- Dallas Mavericks
    ('Luka', 'Dončić', 77, 2),
    ('Kyrie', 'Irving', 11, 2),
    ('Klay', 'Thompson', 31, 2),
    ('Dereck', 'Lively', 2, 2),
    ('PJ', 'Washington', 25, 2),
    
    -- Boston Celtics
    ('Jaylen', 'Brown', 7, 3),
    ('Jrue', 'Holiday', 4, 3),
    ('Jayson', 'Tatum', 0, 3),
    ('Kristaps', 'Porzingis', 8, 3),
    ('Derrick', 'White', 9, 3),
    
    -- Golden State Warriors
    ('Stephen', 'Curry', 30, 4),
    ('Draymond', 'Green', 23, 4),
    ('Kevon', 'Looney', 5, 4),
    ('Andrew', 'Wiggins', 22, 4),
    ('Gary', 'Payton II', 0, 4);

-- Query the data from the team table
SELECT * FROM team;

-- Query the data from the player table
SELECT * FROM player;