
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



insert into profesor (JMB, Verifikovan, email) values ('2108988105034', 1 , 'milijana.djukic@mail.com');
insert into profesor (JMB, Verifikovan, email) values ('1210987100018', 1 , 'petar.jankovic@mail.com');
insert into profesor (JMB, Verifikovan, email) values ('1312981163309', 0 , 'mirko.filipovic@mail.com');
insert into profesor (JMB, Verifikovan, email) values ('1312981163312', 1 , 'darko.filipovic@mail.com');
insert into profesor (JMB, Verifikovan, email) values ('1210987100778', 1 , 'milan.jankovic@mail.com');


insert into prostorija (Broj, Tip) values (1, 'ucionica');
insert into prostorija (Broj, Tip) values (2, 'ucionica');
insert into prostorija (Broj, Tip) values (3, 'ucionica');
insert into prostorija (Broj, Tip) values (4, 'ucionica');
insert into prostorija (Broj, Tip) values (11, 'kabinet');
insert into prostorija (Broj, Tip) values (12, 'kabinet');
insert into prostorija (Broj, Tip) values (21, 'kancelarija');
insert into prostorija (Broj, Tip) values (22, 'kancelarija');


insert into adresa (Ulica, PTTBroj, Grad, Drzava) values ('Koševo 3', 71000, 'Sarajevo', 'BiH');
insert into adresa (Ulica, PTTBroj, Grad, Drzava) values ('Veljka Mlađenovića bb', 78000, 'Banja Luka', 'BiH');
insert into adresa (Ulica, PTTBroj, Grad, Drzava) values ('Vase Pelagića 11a', 78000, 'BanjaLuka', 'BiH');
insert into adresa (Ulica, PTTBroj, Grad, Drzava) values ('Nikole Tesle 72', 72600, 'Mrkonjic Grad', 'BiH');



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


insert into osoba_u_upravi (ZAPOSLENI_JMB, Uloga, PROSTORIJA_Broj, SKOLA_JIB) values ('1907951100012', 'sekretar', 21, 123456);
insert into osoba_u_upravi (ZAPOSLENI_JMB, Uloga, PROSTORIJA_Broj, SKOLA_JIB) values ('1804964163303', 'direktor', 21, 123456); -- u istoj su prostoriji
insert into osoba_u_upravi (ZAPOSLENI_JMB, Uloga, PROSTORIJA_Broj, SKOLA_JIB) values ('1503990125037', 'pedagog', 22, 123456);


insert into profesor_ro (JMB, SedmicniBrojCasova, SkolaZaDopunuCasova, PROSTORIJA_Broj, PotrebniBrojSedmicnihCasova) values ('2108988105034', 7, NULL, 11, 21);
insert into profesor_ro (JMB, SedmicniBrojCasova, SkolaZaDopunuCasova, PROSTORIJA_Broj, PotrebniBrojSedmicnihCasova) values ('1210987100018', 3, 'Gimnazija Banja Luka', 12, 24);
insert into profesor_ro (JMB, SedmicniBrojCasova, SkolaZaDopunuCasova, PROSTORIJA_Broj, PotrebniBrojSedmicnihCasova) values ('1312981163312', 6, NULL, 12, 20);
insert into profesor_ro (JMB, SedmicniBrojCasova, SkolaZaDopunuCasova, PROSTORIJA_Broj, PotrebniBrojSedmicnihCasova) values ('1210987100778', 6, NULL, 12, 20); -- pripravnik



insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('0308983126116', 1, 1, 111, '2108988105034', 'ana.mirkovic@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('2108968196769', 1, 1, 222, '2108988105034', 'milena.petkovic@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('0702964105027', 1, 1, 333, '2108988105034', 'mirjana.gavric@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('0512983100067', 1, 2, 444, '1210987100018', 'slavko.popovic@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('0607989100027', 1, 2, 555, '1210987100018', 'danijel.stojanovic@mail.com', 0, 1);	
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('1002952100005', 1, 2, 666, '1210987100018', 'mitrovic.nikola@mail.com', 0, 1);	
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('1006949100067', 3, 2, 777, '1312981163312', 'stanko.soldat@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('1010988101124', 3, 2, 888, '1312981163312', 'dejan.babic@mail.com', 0, 1);
insert into ucenik (JMB,Razred,Odjeljenje, BrojMaticneKnjige, JMB_RAZREDNIKA, email, Obnova, IdSmjera) values ('1206986101234', 3, 2, 999, '1312981163312', 'marko.mirkovic@mail.com', 0, 1);

insert into pomocno_osoblje (ZAPOSLENI_JMB) values ('2208988105039');
insert into pomocno_osoblje (ZAPOSLENI_JMB) values ('2102979163201');
insert into pomocno_osoblje (ZAPOSLENI_JMB) values ('2804950103891');


insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (1, '2208988105039');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (2, '2208988105039');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (3, '2208988105039');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (4, '2208988105039');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (11, '2804950103891');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (12, '2804950103891');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (21, '2804950103891');
insert into odrzava (PROSTORIJA_Broj, ZAPOSLENI_JMB) values (22, '2102979163201');


insert into telefon(BrojTelefona, SKOLA_JIB) values ('+38751221820', '123456');
insert into telefon(BrojTelefona, SKOLA_JIB) values ('+38751221855', '123456');
insert into telefon(BrojTelefona, SKOLA_JIB) values ('+38751319142', '666555');

insert into predmet (IdPredmeta, Naziv) values (1111, 'Matematika');
insert into predmet (IdPredmeta, Naziv) values (3111, 'Matematika' );
insert into predmet (IdPredmeta, Naziv) values (1222, 'Srpski' );
insert into predmet (IdPredmeta, Naziv) values (3222, 'Srpski');
insert into predmet (IdPredmeta, Naziv ) values (3333, 'Fizka' );
insert into predmet (IdPredmeta, Naziv ) values (1555, 'Informatika' );
insert into predmet (IdPredmeta, Naziv ) values (1444, 'Muzicko' );

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



insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2019-02-03', 1222, 2 , 'Tekst Zadace' , '2019-04-08');
insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2019-04-03', 1111, 2 , 'Tekst Zadace' , '2019-04-11');
insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2021-04-03', 3222, 2 , 'Tekst Zadace' , '2021-04-08');
insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2021-04-10', 3222, 2 , 'Tekst Zadace' , '2021-04-20');
insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje) values ('2021-07-06', 3111, 2 , 'Tekst Zadace' , '2021-07-07');



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