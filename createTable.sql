CREATE TABLE Webpage (
    id INT AUTO_INCREMENT PRIMARY KEY,
    webName VARCHAR(50),
    url VARCHAR(255),
    budget INT
);

CREATE TABLE Technology (
    id INT AUTO_INCREMENT PRIMARY KEY,
    techName VARCHAR(50),
    techType VARCHAR(50),
    purpose VARCHAR(50),
    releaseYear INT,
    license VARCHAR(50)
);

CREATE TABLE Website_Technology (
    id INT AUTO_INCREMENT PRIMARY KEY,
    websiteId INT,
    technologyId INT,
    FOREIGN KEY (websiteId) REFERENCES Website(id),
    FOREIGN KEY (technologyId) REFERENCES Technology(id)
);

	
SELECT * from webpage 
FULL OUTER JOIN webpage_technology ON webpage.id=webpage_technology.websiteId
FULL OUTER JOIN technology ON technology.id=webpage_technology.technologyId;

--FULL OUTER JOIN inclusive simulation for MySQL
CREATE VIEW simulation_full_outer AS
SELECT *
FROM website
LEFT JOIN Website_Technology ON website.webid = Website_Technology.websiteId
LEFT JOIN Technology ON Website_Technology.technologyId = technology.techid
UNION
SELECT *
FROM website
RIGHT JOIN Website_Technology ON website.webid = Website_Technology.websiteId
RIGHT JOIN Technology ON Website_Technology.technologyId = technology.techid
WHERE website.webid IS NULL;

--QUERY to fetch the list of technologies from a webpage:
SELECT simulation_full_outer.techName from simulation_full_outer
WHERE simulation_full_outer.webName='linkedin';

--incluye todos los registros, que en la vista son varios por estar relacionado con varias tech

SELECT webName, url, budget from simulation_full_outer WHERE LOWER(simulation_full_outer.webName) LIKE '%amaz%';

