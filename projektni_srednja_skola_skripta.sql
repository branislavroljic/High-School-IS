-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Projektni_Srednja_Skola
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Projektni_Srednja_Skola
-- -----------------------------------------------------
DROP SCHEMA Projektni_Srednja_Skola;
CREATE SCHEMA IF NOT EXISTS `Projektni_Srednja_Skola` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `Projektni_Srednja_Skola` ;


SET FOREIGN_KEY_CHECKS = 1;
-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`OSOBA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`OSOBA` (
  `JMB` CHAR(13) NOT NULL,
  `Prezime` VARCHAR(20) NOT NULL,
  `Ime` VARCHAR(20) NOT NULL,
  `DatumRodjenja` DATE NOT NULL,
  `Pol` ENUM ('muski', 'zenski') NOT NULL,
  `Strucna_sprema` VARCHAR(45) NULL,
  PRIMARY KEY (`JMB`))
ENGINE = InnoDB;

insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('0308983126116', 'Mirković', 'Ana', '1983-08-03', 'zenski', NULL);
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('2108968196769', 'Petković', 'Milena', '1968-08-21', 'zenski', NULL);
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('0702964105027', 'Gavrić', 'Mirjana', '1964-02-07', 'zenski', NULL);
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('2108988105034', 'Đukić', 'Milijana', '1988-08-21', 'zenski', 'VSS');  -- profesor
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('2208988105039', 'Miljević', 'Branka', '1988-08-22',  'zenski', 'VKV'); -- cistacica
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1503990125037', 'Vasković', 'Jelena', '1990-03-15', 'zenski', 'VSS'); -- pedagog

insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('0512983100067', 'Popović', 'Slavko', '1983-12-05', 'muski', NULL); 
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('0607989100027', 'Stojanović', 'Danijel', '1989-07-06', 'muski', NULL);
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1002952100005', 'Mitrović', 'Nikola', '1952-02-10',  'muski', NULL);
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1006949100067', 'Soldat', 'Stanko', '1949-06-10', 'muski', NULL);
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1010988101124', 'Babić', 'Dejan', '1988-10-10', 'muski', NULL);
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1206986101234', 'Mirković', 'Marko', '1986-06-12', 'muski', NULL);
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1210987100018', 'Janković', 'Petar', '1987-10-12', 'muski', 'VSS');   -- profesor
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1210987100778', 'Janković', 'Milan', '1987-10-12', 'muski', 'VSS');   -- profesor - pripravnik
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1312981163309', 'Filipović', 'Mirko', '1981-12-13', 'muski', 'VSS'); 	-- profesor - honorarni
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1312981163312', 'Filipović', 'Darko', '1981-12-13', 'muski', 'VSS'); 	-- profesor
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1804964163303', 'Savić', 'Nenad', '1964-04-18', 'muski', 'VSS');			-- direktor
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1907951100012', 'Lazić', 'Zoran', '1951-07-19', 'muski', 'VSS');			-- sekretar
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('2102979163201', 'Janković', 'Janko', '1979-02-21', 'muski', 'NKV');		-- cistac
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('2804950103891', 'Ninković', 'Miloš', '1950-04-28', 'muski', 'SSS');		-- domar	
insert into osoba (JMB, Prezime, Ime, DatumRodjenja, Pol, Strucna_sprema) values ('1804964163000', 'Direktorovic', 'direktor', '1950-04-28', 'muski', 'VSS');		-- domar	


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PROFESOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PROFESOR` (
  `JMB` CHAR(13) NOT NULL,
  `Verifikovan` TINYINT(1) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  INDEX `fk_PROFESOR_Osoba_idx` (`JMB` ASC) VISIBLE,
  PRIMARY KEY (`JMB`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `fk_PROFESOR_Osoba`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`OSOBA` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


insert into profesor (JMB, Verifikovan, email) values ('2108988105034', 1 , 'milijana.djukic@mail.com');
insert into profesor (JMB, Verifikovan, email) values ('1210987100018', 1 , 'petar.jankovic@mail.com');
insert into profesor (JMB, Verifikovan, email) values ('1312981163309', 0 , 'mirko.filipovic@mail.com');
insert into profesor (JMB, Verifikovan, email) values ('1312981163312', 1 , 'darko.filipovic@mail.com');
insert into profesor (JMB, Verifikovan, email) values ('1210987100778', 1 , 'milan.jankovic@mail.com');

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PROSTORIJA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PROSTORIJA` (
  `Broj` INT NOT NULL,
  `Tip` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Broj`))
ENGINE = InnoDB;

insert into prostorija (Broj, Tip) values (1, 'ucionica');
insert into prostorija (Broj, Tip) values (2, 'ucionica');
insert into prostorija (Broj, Tip) values (3, 'ucionica');
insert into prostorija (Broj, Tip) values (4, 'ucionica');
insert into prostorija (Broj, Tip) values (11, 'kabinet');
insert into prostorija (Broj, Tip) values (12, 'kabinet');
insert into prostorija (Broj, Tip) values (21, 'kancelarija');
insert into prostorija (Broj, Tip) values (22, 'kancelarija');
-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`ADRESA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`ADRESA` (
  `Ulica` VARCHAR(255) NOT NULL,
  `PTTBroj` INT NOT NULL,
  `Grad` VARCHAR(45) NOT NULL,
  `Drzava` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Ulica`, `PTTBroj`, `Grad`, `Drzava`))
ENGINE = InnoDB;

insert into adresa (Ulica, PTTBroj, Grad, Drzava) values ('Koševo 3', 71000, 'Sarajevo', 'BiH');
insert into adresa (Ulica, PTTBroj, Grad, Drzava) values ('Veljka Mlađenovića bb', 78000, 'Banja Luka', 'BiH');
insert into adresa (Ulica, PTTBroj, Grad, Drzava) values ('Vase Pelagića 11a', 78000, 'BanjaLuka', 'BiH');
insert into adresa (Ulica, PTTBroj, Grad, Drzava) values ('Nikole Tesle 72', 72600, 'Mrkonjic Grad', 'BiH');
-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`SKOLA`
-- -----------------------------------------------------
-- drop table skola;
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`SKOLA` (
  `NazivSkole` VARCHAR(255) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `Vrsta` VARCHAR(45) NOT NULL,
  `JIB` CHAR(13) NOT NULL,
  `Osnivac` VARCHAR(255) NOT NULL,
  `ADRESA_Ulica` VARCHAR(255) NOT NULL,
  `ADRESA_PTTBroj` INT NOT NULL,
  `ADRESA_Grad` VARCHAR(45) NOT NULL,
  `ADRESA_Drzava` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  PRIMARY KEY (`JIB`),
  INDEX `fk_SKOLA_ADRESA1_idx` (`ADRESA_Ulica` ASC, `ADRESA_PTTBroj` ASC, `ADRESA_Grad` ASC, `ADRESA_Drzava` ASC) VISIBLE,
  CONSTRAINT `fk_SKOLA_ADRESA1`
    FOREIGN KEY (`ADRESA_Ulica` , `ADRESA_PTTBroj` , `ADRESA_Grad` , `ADRESA_Drzava`)
    REFERENCES `Projektni_Srednja_Skola`.`ADRESA` (`Ulica` , `PTTBroj` , `Grad` , `Drzava`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into skola (JIB, NazivSkole, email, Vrsta, Osnivac, ADRESA_Ulica, ADRESA_PTTBroj, ADRESA_Grad, ADRESA_Drzava)  values ('123456', 'Gimnazija Mrkonjic Grad', 'mggimn@mail.com', 'Gimnazija', 'drzava', 'Nikole Tesle 72', 72600, 'Mrkonjic Grad', 'BiH');
insert into skola (JIB, NazivSkole, email, Vrsta, Osnivac, ADRESA_Ulica, ADRESA_PTTBroj, ADRESA_Grad, ADRESA_Drzava)  values ('666555', 'Masinska Skola Mrkonjic Grad', 'mgmassk@mail.com', 'Strukovna', 'drzava', 'Nikole Tesle 72', 72600, 'Mrkonjic Grad', 'BiH');


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`ZAPOSLENI`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`ZAPOSLENI` (
  `JMB` CHAR(13) NOT NULL,
  `Plata` DECIMAL(6,2) UNSIGNED NOT NULL,
  `JMB_DIREKTORA` CHAR(13) NULL,
  `UgovorORadu` VARCHAR(1000) NOT NULL,
  `Period` TINYINT NULL,
  PRIMARY KEY (`JMB`),
  UNIQUE INDEX `JMB_UNIQUE` (`JMB` ASC) VISIBLE,
  INDEX `fk_ZAPOSLENI_DIREKTOR_idx` (`JMB_DIREKTORA` ASC) VISIBLE,
  UNIQUE INDEX `UgovorORadu_UNIQUE` (`UgovorORadu` ASC) VISIBLE,
  CONSTRAINT `fk_ZAPOSLENI_OSOBA`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`OSOBA` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    )
ENGINE = InnoDB;

insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('2108988105034',  1000.00, 'tekst ugovora1 ', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('2208988105039',  700.00, 'tekst ugovora2 ', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('1503990125037',  1000.00, 'tekst ugovora3 ', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('1210987100018',  1200.00, 'tekst ugovora4 ', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('1907951100012',  900.00, 'tekst ugovora6', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('2102979163201',  800.00, 'tekst ugovora7', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('2804950103891',  800.00, 'tekst ugovora8', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('1312981163312',  1100.00, 'tekst ugovora11', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('1210987100778',  800.00, 'tekst ugovora12', NULL, '1804964163303');
insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('1804964163303',  1500.00, 'tekst ugovora9', NULL, NULL);
-- insert into zaposleni (JMB, Plata, UgovorORadu, Period, JMB_DIREKTORA) values ('1804964163000',  1500.00, 'tekst ugovora10', NULL, NULL);


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`OSOBA_U_UPRAVI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`OSOBA_U_UPRAVI` (
  `ZAPOSLENI_JMB` CHAR(13) NOT NULL,
  `Uloga` VARCHAR(45) NOT NULL,
  `PROSTORIJA_Broj` INT NOT NULL,
  `SKOLA_JIB` CHAR(13) NULL,
  INDEX `fk_OSOBA_U_UPRAVI_ZAPOSLENI1_idx` (`ZAPOSLENI_JMB` ASC) VISIBLE,
  PRIMARY KEY (`ZAPOSLENI_JMB`),
  INDEX `fk_OSOBA_U_UPRAVI_PROSTORIJA1_idx` (`PROSTORIJA_Broj` ASC) VISIBLE,
  INDEX `fk_OSOBA_U_UPRAVI_SKOLA1_idx` (`SKOLA_JIB` ASC) VISIBLE,
  CONSTRAINT `fk_OSOBA_U_UPRAVI_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`ZAPOSLENI` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OSOBA_U_UPRAVI_PROSTORIJA1`
    FOREIGN KEY (`PROSTORIJA_Broj`)
    REFERENCES `Projektni_Srednja_Skola`.`PROSTORIJA` (`Broj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OSOBA_U_UPRAVI_SKOLA1`
    FOREIGN KEY (`SKOLA_JIB`)
    REFERENCES `Projektni_Srednja_Skola`.`SKOLA` (`JIB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- add foreign key to avoid chicken-and-egg problem
alter table ZAPOSLENI add CONSTRAINT `fk_ZAPOSLENI_DIREKTOR`
	FOREIGN KEY (`JMB_DIREKTORA`)
	REFERENCES `Projektni_Srednja_Skola`.`OSOBA_U_UPRAVI` (`ZAPOSLENI_JMB`)
	ON DELETE NO ACTION
	ON UPDATE NO ACTION;

insert into osoba_u_upravi (ZAPOSLENI_JMB, Uloga, PROSTORIJA_Broj, SKOLA_JIB) values ('1907951100012', 'sekretar', 21, 123456);
insert into osoba_u_upravi (ZAPOSLENI_JMB, Uloga, PROSTORIJA_Broj, SKOLA_JIB) values ('1804964163303', 'direktor', 21, 123456); -- u istoj su prostoriji
insert into osoba_u_upravi (ZAPOSLENI_JMB, Uloga, PROSTORIJA_Broj, SKOLA_JIB) values ('1503990125037', 'pedagog', 22, 123456);


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PROFESOR_RO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PROFESOR_RO` (
  `JMB` CHAR(13) NOT NULL,
  `SedmicniBrojCasova` TINYINT UNSIGNED NOT NULL,
  `SkolaZaDopunuCasova` VARCHAR(45) NULL,
  `PROSTORIJA_Broj` INT NOT NULL,
  `PotrebniBrojSedmicnihCasova` TINYINT NOT NULL,
  INDEX `fk_PROFESOR RO_ZAPOSLENI1_idx` (`JMB` ASC) VISIBLE,
  PRIMARY KEY (`JMB`),
  INDEX `fk_PROFESOR RO_PROSTORIJA1_idx` (`PROSTORIJA_Broj` ASC) VISIBLE,
  CONSTRAINT `fk_PROFESOR RO_ZAPOSLENI1`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`ZAPOSLENI` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROFESOR RO_PROFESOR1`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`PROFESOR` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROFESOR RO_PROSTORIJA1`
    FOREIGN KEY (`PROSTORIJA_Broj`)
    REFERENCES `Projektni_Srednja_Skola`.`PROSTORIJA` (`Broj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into profesor_ro (JMB, SedmicniBrojCasova, SkolaZaDopunuCasova, PROSTORIJA_Broj, PotrebniBrojSedmicnihCasova) values ('2108988105034', 7, NULL, 11, 21);
insert into profesor_ro (JMB, SedmicniBrojCasova, SkolaZaDopunuCasova, PROSTORIJA_Broj, PotrebniBrojSedmicnihCasova) values ('1210987100018', 3, 'Gimnazija Banja Luka', 12, 24);
insert into profesor_ro (JMB, SedmicniBrojCasova, SkolaZaDopunuCasova, PROSTORIJA_Broj, PotrebniBrojSedmicnihCasova) values ('1312981163312', 6, NULL, 12, 20);
insert into profesor_ro (JMB, SedmicniBrojCasova, SkolaZaDopunuCasova, PROSTORIJA_Broj, PotrebniBrojSedmicnihCasova) values ('1210987100778', 6, NULL, 12, 20); -- pripravnik


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`UCENIK`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`UCENIK` (
  `JMB` CHAR(13) NOT NULL,
  `Odjeljenje` TINYINT UNSIGNED NOT NULL,
  `Razred` TINYINT UNSIGNED NOT NULL,
  `BrojMaticneKnjige` CHAR(7) NOT NULL,
  `JMB_RAZREDNIKA` CHAR(13) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `Obnova` TINYINT(1) NOT NULL,
  `IdSmjera` INT NOT NULL,
  PRIMARY KEY (`JMB`),
  UNIQUE INDEX `BrojMaticneKnjige_UNIQUE` (`BrojMaticneKnjige` ASC) VISIBLE,
  INDEX `fk_UCENIK_PROFESOR RO1_idx` (`JMB_RAZREDNIKA` ASC) VISIBLE,
  UNIQUE INDEX `e-mail_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `JMB_UNIQUE` (`JMB` ASC) VISIBLE,
  INDEX `fk_UCENIK_SMJER1_idx` (`IdSmjera` ASC) VISIBLE,
  CONSTRAINT `fk_UCENIK_OSOBA`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`OSOBA` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UCENIK_PROFESOR RO1`
    FOREIGN KEY (`JMB_RAZREDNIKA`)
    REFERENCES `Projektni_Srednja_Skola`.`PROFESOR_RO` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UCENIK_SMJER1`
    FOREIGN KEY (`IdSmjera`)
    REFERENCES `Projektni_Srednja_Skola`.`SMJER` (`IdSmjera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('0308983126116', 1, 1, 111, '2108988105034', 'ana.mirkovic@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('2108968196769', 1, 1, 222, '2108988105034', 'milena.petkovic@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('0702964105027', 1, 1, 333, '2108988105034', 'mirjana.gavric@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('0512983100067', 1, 2, 444, '1210987100018', 'slavko.popovic@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('0607989100027', 1, 2, 555, '1210987100018', 'danijel.stojanovic@mail.com', 0, 1);	
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('1002952100005', 1, 2, 666, '1210987100018', 'mitrovic.nikola@mail.com', 0, 1);	
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('1006949100067', 3, 2, 777, '1312981163312', 'stanko.soldat@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('1010988101124', 3, 2, 888, '1312981163312', 'dejan.babic@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('1206986101234', 3, 2, 999, '1312981163312', 'marko.mirkovic@mail.com', 0, 1);

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`POMOCNO_OSOBLJE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`POMOCNO_OSOBLJE` (
  `ZAPOSLENI_JMB` CHAR(13) NOT NULL,
  INDEX `fk_POMOCNO_OSOBLJE_ZAPOSLENI1_idx` (`ZAPOSLENI_JMB` ASC) VISIBLE,
  PRIMARY KEY (`ZAPOSLENI_JMB`),
  CONSTRAINT `fk_POMOCNO_OSOBLJE_ZAPOSLENI1`
    FOREIGN KEY (`ZAPOSLENI_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`ZAPOSLENI` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into pomocno_osoblje (ZAPOSLENI_JMB) values ('2208988105039');
insert into pomocno_osoblje (ZAPOSLENI_JMB) values ('2102979163201');
insert into pomocno_osoblje (ZAPOSLENI_JMB) values ('2804950103891');
-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`HONORARNI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`HONORARNI` (
  `JMB` CHAR(13) NOT NULL,
  `UgovorODjelu` VARCHAR(1000) NOT NULL,
  `Naknada` DECIMAL(6,2) NOT NULL,
  `Preduzece` VARCHAR(45) NULL,
  PRIMARY KEY (`JMB`),
  UNIQUE INDEX `JMB_UNIQUE` (`JMB` ASC) VISIBLE,
  UNIQUE INDEX `UgovorODjelu_UNIQUE` (`UgovorODjelu` ASC) VISIBLE,
  CONSTRAINT `fk_HONORARNI_OSOBA`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`OSOBA` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into honorarni (JMB, UgovorODjelu, Naknada, Preduzece) values ('1312981163309', 'Ugovor o djelu 1' , 600.00, 'HE Bocac');

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PRIPRAVNIK_PROFESOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PRIPRAVNIK_PROFESOR` (
  `JMB` CHAR(13) NOT NULL,
  `ZavrsetakPripravnickogStaza` DATE NOT NULL,
  `PROFESOR_JMB` CHAR(13) NOT NULL,
  INDEX `fk_PRIPRAVNIK_PROFESOR RO1_idx` (`JMB` ASC) VISIBLE,
  PRIMARY KEY (`JMB`),
  INDEX `fk_PRIPRAVNIK_PROFESOR1_idx` (`PROFESOR_JMB` ASC) VISIBLE,
  CONSTRAINT `fk_PRIPRAVNIK_PROFESOR RO1`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`PROFESOR_RO` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRIPRAVNIK_PROFESOR1`
    FOREIGN KEY (`PROFESOR_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`PROFESOR` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into pripravnik_profesor (JMB, ZavrsetakPripravnickogStaza, PROFESOR_JMB) values ('1210987100778', '2021-09-05', '1210987100018');
-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`HON_PROFESOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`HON_PROFESOR` (
  `JMB` CHAR(13) NOT NULL,
  PRIMARY KEY (`JMB`),
  INDEX `fk_HON_NASTAVNIK_HONORARNI1_idx` (`JMB` ASC) VISIBLE,
  CONSTRAINT `fk_HON_NASTAVNIK_HONORARNI1`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`HONORARNI` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HON_PROFESOR_PROFESOR1`
    FOREIGN KEY (`JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`PROFESOR` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into hon_profesor (JMB) values ('1312981163309');
-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`ODRZAVA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`ODRZAVA` (
  `PROSTORIJA_Broj` INT NOT NULL,
  `ZAPOSLENI_JMB` CHAR(13) NOT NULL,
  PRIMARY KEY (`PROSTORIJA_Broj`, `ZAPOSLENI_JMB`),
  INDEX `fk_UCIONICA_has_POMOCNO_OSOBLJE_POMOCNO_OSOBLJE1_idx` (`ZAPOSLENI_JMB` ASC) VISIBLE,
  INDEX `fk_UCIONICA_has_POMOCNO_OSOBLJE_UCIONICA1_idx` (`PROSTORIJA_Broj` ASC) VISIBLE,
  CONSTRAINT `fk_UCIONICA_has_POMOCNO_OSOBLJE_UCIONICA1`
    FOREIGN KEY (`PROSTORIJA_Broj`)
    REFERENCES `Projektni_Srednja_Skola`.`PROSTORIJA` (`Broj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UCIONICA_has_POMOCNO_OSOBLJE_POMOCNO_OSOBLJE1`
    FOREIGN KEY (`ZAPOSLENI_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`POMOCNO_OSOBLJE` (`ZAPOSLENI_JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (1, '2208988105039');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (2, '2208988105039');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (3, '2208988105039');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (4, '2208988105039');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (11, '2804950103891');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (12, '2804950103891');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (21, '2804950103891');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (22, '2102979163201');

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`TELEFON`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`TELEFON` (
  `BrojTelefona` VARCHAR(12) NOT NULL,
  `SKOLA_JIB` CHAR(13) NOT NULL,
  PRIMARY KEY (`BrojTelefona`, `SKOLA_JIB`),
  INDEX `fk_TELEFON_SKOLA1_idx` (`SKOLA_JIB` ASC) VISIBLE,
  CONSTRAINT `fk_TELEFON_SKOLA1`
    FOREIGN KEY (`SKOLA_JIB`)
    REFERENCES `Projektni_Srednja_Skola`.`SKOLA` (`JIB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into telefon(BrojTelefona, SKOLA_JIB) values ('+38751221820', '123456');
insert into telefon(BrojTelefona, SKOLA_JIB) values ('+38751221855', '123456');
insert into telefon(BrojTelefona, SKOLA_JIB) values ('+38751319142', '666555');

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`SMJER`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`SMJER` (
  `IdSmjera` INT NOT NULL,
  `Trajanje_Godina` INT NOT NULL,
  `Naziv` VARCHAR(45) NULL,
  `SKOLA_JIB` CHAR(13) NOT NULL,
  `Zvanje` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdSmjera`),
  INDEX `fk_SMJER_SKOLA1_idx` (`SKOLA_JIB` ASC) VISIBLE,
  CONSTRAINT `fk_SMJER_SKOLA1`
    FOREIGN KEY (`SKOLA_JIB`)
    REFERENCES `Projektni_Srednja_Skola`.`SKOLA` (`JIB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into smjer (IdSmjera, Trajanje_Godina, Naziv, SKOLA_JIB, Zvanje) values (1, 4, 'Opsti' , 123456, 'Gimnazijalac');
insert into smjer (IdSmjera, Trajanje_Godina, Naziv, SKOLA_JIB, Zvanje) values (2, 3, 'Jezicki' , 123456, 'Jezicar');
insert into smjer (IdSmjera, Trajanje_Godina, Naziv, SKOLA_JIB, Zvanje) values (3, 4, 'Informaticki' , 123456, 'Informaticar');

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PREDMET`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PREDMET` (
  `IdPredmeta` INT NOT NULL,
  `Naziv` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`IdPredmeta`))
ENGINE = InnoDB;

insert into predmet (IdPredmeta, Naziv) values (1111, 'Matematika');
insert into predmet (IdPredmeta, Naziv) values (3111, 'Matematika' );
insert into predmet (IdPredmeta, Naziv) values (1222, 'Srpski' );
insert into predmet (IdPredmeta, Naziv) values (3222, 'Srpski');
insert into predmet (IdPredmeta, Naziv ) values (3333, 'Fizka' );
insert into predmet (IdPredmeta, Naziv ) values (1555, 'Informatika' );
insert into predmet (IdPredmeta, Naziv ) values (1444, 'Muzicko' );
-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PREDMET_NA_SMJERU`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PREDMET_NA_SMJERU` (
  `IdPredmeta` INT NOT NULL,
  `IdSmjera` INT NOT NULL,
  `Tip` CHAR(1) NOT NULL,
  `Razred` TINYINT(1) NULL,
  `MinimalniBrojPismenihProvjera` TINYINT UNSIGNED NOT NULL,
  `MinimalniBrojUsmenihProvjera` TINYINT UNSIGNED NOT NULL,
  PRIMARY KEY (`IdPredmeta`, `IdSmjera`),
  INDEX `fk_PREDMET_has_SMJER_SMJER1_idx` (`IdSmjera` ASC) VISIBLE,
  INDEX `fk_PREDMET_has_SMJER_PREDMET1_idx` (`IdPredmeta` ASC) VISIBLE,
  CONSTRAINT `fk_PREDMET_has_SMJER_PREDMET1`
    FOREIGN KEY (`IdPredmeta`)
    REFERENCES `Projektni_Srednja_Skola`.`PREDMET` (`IdPredmeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PREDMET_has_SMJER_SMJER1`
    FOREIGN KEY (`IdSmjera`)
    REFERENCES `Projektni_Srednja_Skola`.`SMJER` (`IdSmjera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (1111, 1, 'O', 1, 4, 2); 
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (3111, 1, 'O', 3, 4, 2);
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (1222, 1, 'O', 1, 4, 2);
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (3222, 1, 'O', 3, 4, 2);
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (1444, 1, 'I', 1, 1, 1);
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (3333, 1, 'I', 3, 2, 2);

insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (1111, 2, 'O', 1, 2, 2);
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (3111, 2, 'I', 3, 2, 2);
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (1222, 2, 'O', 1, 4, 2);
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (3222, 2, 'O', 3, 4, 2);
insert into predmet_na_smjeru (IdPredmeta, IdSmjera, Tip, Razred, MinimalniBrojPismenihProvjera, MinimalniBrojUsmenihProvjera) values (1444, 2, 'O', 1, 2, 1);
-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PROVJERA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PROVJERA` (
  `Datum` DATE NOT NULL,
  `Odjeljenje` TINYINT NOT NULL,
  `Tip` CHAR(1) NOT NULL,
  `TrajanjeMin` INT NOT NULL,
  `BrojNegativnihOcjena` INT NOT NULL,
  `BrojPrisutnihUcenika` INT NOT NULL,
  `Ponovljena` TINYINT(1) NULL,
  `PROSTORIJA_Broj` INT NOT NULL,
  `IdPredmeta` INT NOT NULL,
  `IdSmjera` INT NOT NULL,
  PRIMARY KEY (`Datum`, `IdPredmeta`, `IdSmjera`, `Odjeljenje`),
  INDEX `fk_PROVJERA_PROSTORIJA1_idx` (`PROSTORIJA_Broj` ASC) VISIBLE,
  INDEX `fk_PROVJERA_PREDMET_NA_SMJERU1_idx` (`IdPredmeta` ASC, `IdSmjera` ASC) VISIBLE,
  CONSTRAINT `fk_PROVJERA_PROSTORIJA1`
    FOREIGN KEY (`PROSTORIJA_Broj`)
    REFERENCES `Projektni_Srednja_Skola`.`PROSTORIJA` (`Broj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROVJERA_PREDMET_NA_SMJERU1`
    FOREIGN KEY (`IdPredmeta` , `IdSmjera`)
    REFERENCES `Projektni_Srednja_Skola`.`PREDMET_NA_SMJERU` (`IdPredmeta` , `IdSmjera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into provjera (Datum, Odjeljenje, Tip, TrajanjeMin,BrojNegativnihOcjena,BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj, IdPredmeta, IdSmjera)
values ('2020-10-5', 1, 'p', 45, 5, 21, 0, 1, 1111, 1);
insert into provjera (Datum, Odjeljenje,Tip, TrajanjeMin,BrojNegativnihOcjena,BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj, IdPredmeta, IdSmjera)
values ('2020-10-12', 1, 'u', 45, 2, 21, 0, 1, 1111, 1);
insert into provjera (Datum,Odjeljenje, Tip, TrajanjeMin,BrojNegativnihOcjena,BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj, IdPredmeta, IdSmjera)
values ('2020-10-6', 1, 'p', 90, 0, 21, 0, 1, 1111, 1);
insert into provjera (Datum, Odjeljenje,Tip, TrajanjeMin,BrojNegativnihOcjena,BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj, IdPredmeta, IdSmjera)
values ('2021-10-19', 2, 'p', 45, 11, 20, 0, 2, 3111, 1);
insert into provjera (Datum, Odjeljenje,Tip, TrajanjeMin,BrojNegativnihOcjena,BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj, IdPredmeta, IdSmjera)
values ('2021-3-1', 2, 'u', 45, 1, 17, 0, 3, 1222, 2);

-- ovo simuliram proslost, hocu da cuvam zapis za marka mirkovica kad je bio 1-2 (sad je 3-2)
insert into provjera (Datum, Odjeljenje, Tip, TrajanjeMin,BrojNegativnihOcjena,BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj, IdPredmeta, IdSmjera)
values ('2019-3-1', 1, 'u', 45, 4, 23, 0, 3, 1111, 1);
insert into provjera (Datum, Odjeljenje, Tip, TrajanjeMin,BrojNegativnihOcjena,BrojPrisutnihUcenika, Ponovljena, PROSTORIJA_Broj, IdPredmeta, IdSmjera)
values ('2019-3-1', 2, 'p', 45, 1, 17, 0, 1, 1222, 1);

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PREDAJE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PREDAJE` (
  `PROFESOR_JMB` CHAR(13) NOT NULL,
  `PROSTORIJA_Broj` INT NOT NULL,
  `PREDMET_NA_SMJERU_PREDMET_IdPredmeta` INT NOT NULL,
  `PREDMET_NA_SMJERU_SMJER_IdSmjera` INT NOT NULL,
  PRIMARY KEY (`PROFESOR_JMB`, `PREDMET_NA_SMJERU_PREDMET_IdPredmeta`, `PREDMET_NA_SMJERU_SMJER_IdSmjera`),
  INDEX `fk_PROFESOR_has_PREDMET_NA_SMJERU_PROFESOR1_idx` (`PROFESOR_JMB` ASC) VISIBLE,
  INDEX `fk_PREDAJE_PROSTORIJA1_idx` (`PROSTORIJA_Broj` ASC) VISIBLE,
  INDEX `fk_PREDAJE_PREDMET_NA_SMJERU1_idx` (`PREDMET_NA_SMJERU_PREDMET_IdPredmeta` ASC, `PREDMET_NA_SMJERU_SMJER_IdSmjera` ASC) VISIBLE,
  CONSTRAINT `fk_PROFESOR_has_PREDMET_NA_SMJERU_PROFESOR1`
    FOREIGN KEY (`PROFESOR_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`PROFESOR` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PREDAJE_PROSTORIJA1`
    FOREIGN KEY (`PROSTORIJA_Broj`)
    REFERENCES `Projektni_Srednja_Skola`.`PROSTORIJA` (`Broj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PREDAJE_PREDMET_NA_SMJERU1`
    FOREIGN KEY (`PREDMET_NA_SMJERU_PREDMET_IdPredmeta` , `PREDMET_NA_SMJERU_SMJER_IdSmjera`)
    REFERENCES `Projektni_Srednja_Skola`.`PREDMET_NA_SMJERU` (`IdPredmeta` , `IdSmjera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`IMA_NASTAVU`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`IMA_NASTAVU` (
  `UCENIK_JMB` CHAR(13) NOT NULL,
  `IdPredmeta` INT NOT NULL,
  `IdSmjera` INT NOT NULL,
  PRIMARY KEY (`UCENIK_JMB`, `IdPredmeta`, `IdSmjera`),
  INDEX `fk_UCENIK_has_PREDMET_NA_SMJERU_UCENIK1_idx` (`UCENIK_JMB` ASC) VISIBLE,
  INDEX `fk_IMA_NASTAVU_PREDMET_NA_SMJERU1_idx` (`IdPredmeta` ASC, `IdSmjera` ASC) VISIBLE,
  CONSTRAINT `fk_UCENIK_has_PREDMET_NA_SMJERU_UCENIK1`
    FOREIGN KEY (`UCENIK_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`UCENIK` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_IMA_NASTAVU_PREDMET_NA_SMJERU1`
    FOREIGN KEY (`IdPredmeta` , `IdSmjera`)
    REFERENCES `Projektni_Srednja_Skola`.`PREDMET_NA_SMJERU` (`IdPredmeta` , `IdSmjera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into ima_nastavu (ucenik_jmb, IdPredmeta, IdSmjera) values ('0308983126116',  1111, 1);
insert into ima_nastavu (ucenik_jmb, IdPredmeta, IdSmjera) values ('0702964105027',  1111, 1);
insert into ima_nastavu (ucenik_jmb,  IdPredmeta, IdSmjera) values ('0512983100067',  1111, 1);
insert into ima_nastavu (ucenik_jmb,  IdPredmeta, IdSmjera) values ('2108968196769',  1111, 1);
insert into ima_nastavu (ucenik_jmb,  IdPredmeta, IdSmjera) values ('1006949100067',  3111, 1);
insert into ima_nastavu (ucenik_jmb, IdPredmeta, IdSmjera) values ('1010988101124',  3111, 1);
insert into ima_nastavu (ucenik_jmb,  IdPredmeta, IdSmjera) values ('1206986101234',  3111, 1);
-- trebam li ovo za proslost dodavati??
insert into ima_nastavu (ucenik_jmb,  IdPredmeta, IdSmjera) values ('1206986101234',  1111, 1);
insert into ima_nastavu (ucenik_jmb,  IdPredmeta, IdSmjera) values ('1206986101234',  1222, 1);

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`ZADACA`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`ZADACA` (
  `IdZadace` INT NOT NULL AUTO_INCREMENT,
  `DatumZadavanja` DATE NOT NULL,
  `IdPredmeta` INT NOT NULL,
  `IdSmjera` INT NOT NULL,
  `Tekst` VARCHAR(1000) NOT NULL,
  `DatumPredaje` DATE NULL,
  PRIMARY KEY (`IdZadace`),
  INDEX `fk_ZADACA_PREDMET_NA_SMJERU1_idx` (`IdPredmeta` ASC, `IdSmjera` ASC) VISIBLE,
  CONSTRAINT `fk_ZADACA_PREDMET_NA_SMJERU1`
    FOREIGN KEY (`IdPredmeta` , `IdSmjera`)
    REFERENCES `Projektni_Srednja_Skola`.`PREDMET_NA_SMJERU` (`IdPredmeta` , `IdSmjera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2019-02-03', 1222, 2 , 'Tekst Zadace' , '2019-04-08');
insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2019-04-03', 1111, 2 , 'Tekst Zadace' , '2019-04-11');
insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2021-04-03', 3222, 2 , 'Tekst Zadace' , '2021-04-08');
insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2021-04-10', 3222, 2 , 'Tekst Zadace' , '2021-04-20');
insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2021-07-06', 3111, 2 , 'Tekst Zadace' , '2021-07-07');


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`RASPORED_CASOVA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`RASPORED_CASOVA` (
  `Razred` TINYINT NOT NULL,
  `Odjeljenje` TINYINT NOT NULL,
  `DatumObjave` DATE NOT NULL,
  PRIMARY KEY (`Razred`, `Odjeljenje`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`RESPORED_PREDMET`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`RESPORED_PREDMET` (
  `Dan` ENUM('Ponedjeljak', 'Utorak', 'Srijeda', 'Cetvrtak', 'Petak') NOT NULL,
  `TrajanjeMin` int NOT NULL,
  `Vrijeme` TIME NOT NULL,
  `IdPredmeta` INT NOT NULL,
  `IdSmjera` INT NOT NULL,
  `Razred` TINYINT NOT NULL,
  `Odjeljenje` TINYINT NOT NULL,
  `PROSTORIJA_Broj` INT NOT NULL,
  PRIMARY KEY (`Dan`, `IdPredmeta`, `IdSmjera`, `Vrijeme`, `Razred`, `Odjeljenje`),
  INDEX `fk_RASPORED_CASOVA_has_PREDMET_NA_SMJERU_PREDMET_NA_SMJERU1_idx` (`IdPredmeta` ASC, `IdSmjera` ASC) VISIBLE,
  INDEX `fk_RESPORED_PREDMET_RASPORED_CASOVA1_idx` (`Razred` ASC, `Odjeljenje` ASC) VISIBLE,
  INDEX `fk_RESPORED_PREDMET_PROSTORIJA1_idx` (`PROSTORIJA_Broj` ASC) VISIBLE,
  CONSTRAINT `fk_RASPORED_CASOVA_has_PREDMET_NA_SMJERU_PREDMET_NA_SMJERU1`
    FOREIGN KEY (`IdPredmeta` , `IdSmjera`)
    REFERENCES `Projektni_Srednja_Skola`.`PREDMET_NA_SMJERU` (`IdPredmeta` , `IdSmjera`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RESPORED_PREDMET_RASPORED_CASOVA1`
    FOREIGN KEY (`Razred` , `Odjeljenje`)
    REFERENCES `Projektni_Srednja_Skola`.`RASPORED_CASOVA` (`Razred` , `Odjeljenje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RESPORED_PREDMET_PROSTORIJA1`
    FOREIGN KEY (`PROSTORIJA_Broj`)
    REFERENCES `Projektni_Srednja_Skola`.`PROSTORIJA` (`Broj`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`RADI_PROVJERU`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`RADI_PROVJERU` (
  `UCENIK_JMB` CHAR(13) NOT NULL,
  `Datum` DATE NOT NULL,
  `IdPredmeta` INT NOT NULL,
  `IdSmjera` INT NOT NULL,
  `Odjeljenje` TINYINT NOT NULL,
  `Ocjena` TINYINT NOT NULL,
  PRIMARY KEY (`UCENIK_JMB`, `Datum`, `IdPredmeta`, `IdSmjera`, `Odjeljenje`),
  INDEX `fk_UCENIK_has_PROVJERA_PROVJERA1_idx` (`Datum` ASC, `IdPredmeta` ASC, `IdSmjera` ASC, `Odjeljenje` ASC) VISIBLE,
  INDEX `fk_UCENIK_has_PROVJERA_UCENIK1_idx` (`UCENIK_JMB` ASC) VISIBLE,
  CONSTRAINT `fk_UCENIK_has_PROVJERA_UCENIK1`
    FOREIGN KEY (`UCENIK_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`UCENIK` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UCENIK_has_PROVJERA_PROVJERA1`
    FOREIGN KEY (`Datum` , `IdPredmeta` , `IdSmjera` , `Odjeljenje`)
    REFERENCES `Projektni_Srednja_Skola`.`PROVJERA` (`Datum` , `IdPredmeta` , `IdSmjera` , `Odjeljenje`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


insert into radi_provjeru (UCENIK_JMB,Odjeljenje,  Datum, IdPredmeta, IdSmjera, Ocjena) values ('0308983126116', 1,'2020-10-5', 1111, 1, 4);
insert into radi_provjeru (UCENIK_JMB, Odjeljenje, Datum, IdPredmeta, IdSmjera, Ocjena) values ('0308983126116', 1,'2020-10-12', 1111, 1, 5);
insert into radi_provjeru (UCENIK_JMB, Odjeljenje, Datum, IdPredmeta, IdSmjera, Ocjena) values ('0308983126116', 1,'2020-10-6', 1111, 1, 5);
--
insert into radi_provjeru (UCENIK_JMB,Odjeljenje,  Datum, IdPredmeta, IdSmjera, Ocjena) values ('0702964105027', 1,'2020-10-5', 1111, 1, 1);
insert into radi_provjeru (UCENIK_JMB, Odjeljenje, Datum, IdPredmeta, IdSmjera, Ocjena) values ('0702964105027', 1,'2020-10-6', 1111, 1, 3);
--
insert into radi_provjeru (UCENIK_JMB, Odjeljenje, Datum, IdPredmeta, IdSmjera, Ocjena) values ('0512983100067', 2, '2021-03-01', 1222, 2, 1);
insert into radi_provjeru (UCENIK_JMB, Odjeljenje, Datum, IdPredmeta, IdSmjera, Ocjena) values ('1230983126116', 2,'2021-03-01' ,1222, 2, 4);

insert into radi_provjeru (UCENIK_JMB, Odjeljenje, Datum, IdPredmeta, IdSmjera, Ocjena) values ('1206986101234', 1,'2021-10-19', 3111, 1, 5);
-- ocjene marka mirkovica kad je bio 1. razred
insert into radi_provjeru (UCENIK_JMB,Odjeljenje,  Datum, IdPredmeta, IdSmjera, Ocjena) values ('1206986101234', 1,'2019-3-1', 1111, 1, 1);
insert into radi_provjeru (UCENIK_JMB, Odjeljenje, Datum, IdPredmeta, IdSmjera, Ocjena) values ('1206986101234', 1,'2019-3-1', 1222, 1, 1);


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`PRIPRAVNIK_U_UPRAVI`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`PRIPRAVNIK_U_UPRAVI` (
  `OSOBA_U_UPRAVI_ZAPOSLENI_JMB` CHAR(13) NOT NULL,
  `ZavrsetakPripravnickogStaza` DATE NULL,
  `OSOBA_U_UPRAVI_ZAPOSLENI_JMB1` CHAR(13) NOT NULL,
  PRIMARY KEY (`OSOBA_U_UPRAVI_ZAPOSLENI_JMB`),
  INDEX `fk_PRIPRAVNIK_U_UPRAVI_OSOBA_U_UPRAVI2_idx` (`OSOBA_U_UPRAVI_ZAPOSLENI_JMB1` ASC) VISIBLE,
  CONSTRAINT `fk_PRIPRAVNIK_U_UPRAVI_OSOBA_U_UPRAVI1`
    FOREIGN KEY (`OSOBA_U_UPRAVI_ZAPOSLENI_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`OSOBA_U_UPRAVI` (`ZAPOSLENI_JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PRIPRAVNIK_U_UPRAVI_OSOBA_U_UPRAVI2`
    FOREIGN KEY (`OSOBA_U_UPRAVI_ZAPOSLENI_JMB1`)
    REFERENCES `Projektni_Srednja_Skola`.`OSOBA_U_UPRAVI` (`ZAPOSLENI_JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`RADI`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`RADI_ZADACU` (
  `UCENIK_JMB` CHAR(13) NOT NULL,
  `IdZadace` INT NOT NULL,
  `Ocjena` TINYINT NULL,
  PRIMARY KEY (`UCENIK_JMB`, `IdZadace`),
  INDEX `fk_UCENIK_has_ZADACA_ZADACA1_idx` (`IdZadace` ASC) VISIBLE,
  INDEX `fk_UCENIK_has_ZADACA_UCENIK1_idx` (`UCENIK_JMB` ASC) VISIBLE,
  CONSTRAINT `fk_UCENIK_has_ZADACA_UCENIK1`
    FOREIGN KEY (`UCENIK_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`UCENIK` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_UCENIK_has_ZADACA_ZADACA1`
    FOREIGN KEY (`IdZadace`)
    REFERENCES `Projektni_Srednja_Skola`.`ZADACA` (`IdZadace`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- 2019. (oni su sad 3. razred)
insert into radi_zadacu values ('1206986101234', 3, 3);
insert into radi_zadacu values ('1206986101234', 4, 5);
insert into radi_zadacu values ('1010988101124', 4, 1);
insert into radi_zadacu values ('1010988101124', 5, 4);
-- 2021.
insert into radi_zadacu values ('1206986101234', 5, 5);
insert into radi_zadacu values ('1206986101234', 6, NULL); -- nije ocjenjen iz zadace
insert into radi_zadacu values ('1010988101124', 6, 4); -- nije radio zadacu 5
-- 1. razred
insert into radi_zadacu values ('0308983126116', 1, 5);
insert into radi_zadacu values ('0308983126116', 2, NULL);
insert into radi_zadacu values ('0702964105027', 1, 3);
insert into radi_zadacu values ('0702964105027', 2, NULL);
insert into radi_zadacu values ('1002952100005', 1, 5);
-- insert into radi_zadacu values ('0308983126116', 2, NULL);

-- -----------------------------------------------------
-- Table `Projektni_Srednja_Skola`.`OSOBA_ADRESA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Projektni_Srednja_Skola`.`OSOBA_ADRESA` (
  `IdAdrese` INT NOT NULL AUTO_INCREMENT,
  `OSOBA_JMB` CHAR(13) NOT NULL,
  `ADRESA_Ulica` VARCHAR(255) NOT NULL,
  `ADRESA_PTTBroj` INT NOT NULL,
  `ADRESA_Grad` VARCHAR(45) NOT NULL,
  `ADRESA_Drzava` VARCHAR(45) NOT NULL,
  INDEX `fk_OSOBA_has_ADRESA_ADRESA1_idx` (`ADRESA_Ulica` ASC, `ADRESA_PTTBroj` ASC, `ADRESA_Grad` ASC, `ADRESA_Drzava` ASC) VISIBLE,
  INDEX `fk_OSOBA_has_ADRESA_OSOBA1_idx` (`OSOBA_JMB` ASC) VISIBLE,
  PRIMARY KEY (`IdAdrese`),
  CONSTRAINT `fk_OSOBA_has_ADRESA_OSOBA1`
    FOREIGN KEY (`OSOBA_JMB`)
    REFERENCES `Projektni_Srednja_Skola`.`OSOBA` (`JMB`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_OSOBA_has_ADRESA_ADRESA1`
    FOREIGN KEY (`ADRESA_Ulica` , `ADRESA_PTTBroj` , `ADRESA_Grad` , `ADRESA_Drzava`)
    REFERENCES `Projektni_Srednja_Skola`.`ADRESA` (`Ulica` , `PTTBroj` , `Grad` , `Drzava`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

