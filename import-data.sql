USE feiras-livres;
LOAD DATA INFILE '/var/lib/DEINFO_AB_FEIRASLIVRES_2014.csv'
INTO TABLE feira_livre
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
IGNORE 1 LINES
(longitude, latitude, setor_censitario, area_ponderacao, codigo_distrito, distrito, codigo_subprefeitura, subprefeitura, regiao5, regiao8, nome_feira, registro, logradouro, numero, bairro, referencia)
set id = NULL;