USE `db-movies`;
INSERT INTO member(last_name,first_name,login,password,is_admin)
VALUES 	
			('Pierre', 'moi','Pierre','1234',TRUE),
			('Baille', 'Anne-Lise', 'abaille@campus-eni.fr', 'Pa$$w0rd', TRUE),
 			('Gobin', 'Stéphane', 'sgobin@campus-eni.fr', 'Pa$$w0rd', FALSE),
 			('Trillard', 'Julien', 'jtrillard@campus-eni.fr', 'Pa$$w0rd', FALSE);
SELECT * FROM member;

UPDATE member
SET	login = 'anne',
		PASSWORD = '4321'
WHERE member.id = 2;

INSERT INTO genre(name)
VALUES 	('Animation'),
			('Science-fiction'),
 			('Documentaire'),
 			('Action'),
 			('Comédie'),
 			('Drame');
SELECT * FROM genre;


INSERT INTO participant(first_name,last_name)
VALUES 	('Spielberg', 'Steven'),
			('Cronenberg', 'David'),
			('Attenborough', 'Richard'),
			('Goldblum', 'Jeff'),
			('Davis', 'Geena'),
			('Rylance', 'Mark'),
			('Barnhill', 'Ruby');
 		
SELECT * FROM participant;


				
				
INSERT INTO movie(title,year,duration,synopsis,director_id,genre_id)
VALUES 	('Jurassic Park', 1993, 128,'Le film raconte l''histoire d''un milliardaire et son équipe de généticiens parvenant à ramener à la vie des dinosaures grâce au clonage.', 1, 2),
			('The Fly', 1986, 95,'Il s''agit de l''adaptation cinématographique de la nouvelle éponyme de l''auteur George Langelaan.', 2, 2),
 			('The BFG', 2016, 117,'Le Bon Gros Géant est un géant bien différent des autres habitants du Pays des Géants.', 1, 5);
SELECT * FROM movie;
				

INSERT INTO movie_actors(movie_id,actors_id)
VALUES 	(1, 3),
			(1, 4),
			(2, 4),
			(2, 5),
			(3, 6),
			(3, 7);



SELECT * FROM movie_actors;
SELECT * FROM movie;
SELECT * FROM opinion;
SELECT * FROM member;
SELECT * FROM hobby;