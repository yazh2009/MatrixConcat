TRUNCATE TABLE DB1;
TRUNCATE TABLE DB2;
TRUNCATE TABLE DB3;
TRUNCATE TABLE DB4;
TRUNCATE TABLE DB5;

INSERT INTO DB1 (id, V1, V2) VALUES
  (1, 'value111', 'value112'), (3, 'value311', 'value312'), (4, 'value411', 'value412'),
  (5, 'value511', 'value512'), (7, 'value711', 'value712'), (8, 'value811', 'value812');

INSERT INTO DB2 (id, V1, V2) VALUES
  (1, 'value121', 'value122'), (2, 'value221', 'value222'), (4, 'value421', 'value422'),
  (6, 'value621', 'value622'), (7, 'value721', 'value722'), (8, 'value821', 'value822'),
  (9, 'value921', 'value922');

INSERT INTO DB3 (id, V1, V2) VALUES
  (2, 'value231', 'value232'), (3, 'value331', 'value332'), (4, 'value431', 'value432'),
  (5, 'value531', 'value532'), (8, 'value831', 'value832');

INSERT INTO DB4 (id, V1, V2) VALUES
  (1, 'value141', 'value142'), (3, 'value341', 'value342'), (5, 'value541', 'value542'),
  (6, 'value641', 'value642'), (7, 'value741', 'value742'), (8, 'value841', 'value842'),
  (9, 'value941', 'value942');

INSERT INTO DB5 (id, V1, V2) VALUES
  (4, 'value451', 'value452'), (5, 'value551', 'value552'),
  (6, 'value651', 'value652'), (7, 'value751', 'value752'), (8, 'value851', 'value852'),
  (9, 'value951', 'value952');