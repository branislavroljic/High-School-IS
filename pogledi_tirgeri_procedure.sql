

-- predmeti po smjeru i razredu
-- drop view predmeti_po_razredima_i_smjerovima;
create view predmeti_po_razredima_i_smjerovima (IdSmjera,  Razred, IdPredmeta) as
	select ps.idSmjera, ps.Razred, group_concat(p.IdPredmeta)
	from predmet p
	inner join predmet_na_smjeru ps on p.IdPredmeta = ps.IdPredmeta
	group by ps.IdSmjera, ps.Razred;

SET GLOBAL log_bin_trust_function_creators = 1;

drop function if exists nadji_prosjek_ucenika;
delimiter $$
create function nadji_prosjek_ucenika (pJMBUcenika char(13))
returns decimal(3,2)
begin
	 declare vRazred, vSmjer int;
     declare vProsjek decimal(3,2);
     select Razred into vRazred from ucenik u where u.JMB = pJMBUcenika;
     select IdSmjera into vSmjer from ucenik u where u.JMB = pJMBUcenika;
     select round(avg(un.Ocjena),2) into vProsjek
	 from (select Ocjena from radi_provjeru as rp where rp.UCENIK_JMB = pJMBUcenika and rp.IdPredmeta
		in (select IdPredmeta from predmet_na_smjeru where IdSmjera = vSmjer and Razred = vRazred)
	   union all
 	 select Ocjena from radi_zadacu as rz 
     inner join zadaca z on rz.IdZadace =  z.IdZadace
     where rz.UCENIK_JMB = pJMBUcenika and z.IdPredmeta in (select IdPredmeta from predmet_na_smjeru where IdSmjera = VSmjer and Razred = vRazred)
     ) un;
     return vProsjek;
end $$
delimiter ;

drop view if exists predmeti_detaljno;
create view predmeti_detaljno (IdPredmeta, Naziv, Skola, Smjer, Razred, Tip) as
	select p.IdPredmeta, p.Naziv, sk.NazivSkole, sm.Naziv as Smjer, pns.Razred, pns.Tip 
	from predmet p
	inner join predmet_na_smjeru pns on pns.IdPredmeta = p.IdPredmeta
	inner join smjer sm on sm.IdSmjera = pns.IdSmjera
	inner join skola sk on sm.SKOLA_JIB = sk.JIB;

drop view if exists pomocno_osoblje_prostorije;
create view pomocno_osoblje_prostorije (JMB, BrojProstorija, Prostorije) as
select po.ZAPOSLENI_JMB, group_concat(PROSTORIJA_Broj) as Prostorije, count(*) as BrojProstorija
from pomocno_osoblje po
inner join odrzava odr on po.ZAPOSLENI_JMB = odr.ZAPOSLENI_JMB
group by po.ZAPOSLENI_JMB
order by BrojProstorija;

-- prosjek trazim u zavisnosti od razreda, prikazujem prosjek samo za trenutni razred 
drop view if exists ucenik_detaljno;
create view ucenik_detaljno (JMB, Prezime_Ime, Skola, Smjer, Razred_Odjeljenje, Razrednik, ProsjekOcjena) as
select o.JMB, concat(o.Prezime, ', ', o.Ime),  sk.NazivSkole, s.Naziv, concat(u.Razred, '-', u.Odjeljenje), concat(r.Prezime, ', ', r.Ime), nadji_prosjek_ucenika(o.JMB)
from osoba o
inner join ucenik u on o.JMB = u.JMB
inner join osoba r on u.JMB_RAZREDNIKA = r.JMB
 inner join smjer s on u.IdSmjera = s.IdSmjera
 inner join skola sk on sk.JIB = s.SKOLA_JIB
group by o.JMB, s.IdSmjera 
order by 7 desc;


drop trigger if exists obnova_godine;
delimiter $$
create trigger obnova_godine after update
on ucenik
for each row 
begin 
	if new.Obnova = 1
    then
	delete from radi_provjeru rp
    where rp.UCENIK_JMB = new.JMB and rp.IdPredmeta in (select IdPredmeta from predmet_na_smjeru where IdSmjera = new.IdSmjera and Razred = new.Razred);
    delete radi_zadacu from radi_zadacu  
	inner join zadaca z on radi_zadacu.IdZadace =  z.IdZadace
     where radi_zadacu.UCENIK_JMB = new.JMB and z.IdPredmeta in (select IdPredmeta from predmet_na_smjeru where IdSmjera = new.IdSmjera and Razred = new.Razred);
    end if;
    end$$
delimiter ;

drop trigger if exists dodavanje_ucenik_provjera;
delimiter $$
create trigger dodavanje_ucenik_provjera after insert
on radi_provjeru
for each row
begin 
	update provjera
	set BrojPrisutnihUcenika = BrojPrisutnihUcenika + 1,
    BrojNegativnihOcjena = BrojNegativnihOcjena + (new.Ocjena = 1)
    where new.Datum = Datum and new.IdPredmeta = IdPredmeta and new.IdSmjera = IdSmjera and new.Odjeljenje = Odjeljenje;
end$$;
delimiter ;
    
drop trigger if exists uklanjanje_ucenik_provjera;
delimiter $$
create trigger uklanjanje_ucenik_provjera after delete
on radi_provjeru
for each row
begin
	update provjera
    set BrojPrisutnihUcenika = BrojPrisutnihUcenika - 1,
    BrojNegativnihOcjena = BrojNegativnihOcjena - (old.Ocjena = 1)
    where old.Datum = Datum and old.IdPredmeta = IdPredmeta and old.IdSmjera = IdSmjera;
end$$
delimiter ;

drop trigger if exists izmjena_ucenik_provjera;
delimiter $$
create trigger izmjena_ucenik_provjera after update
on radi_provjeru
for each row
begin
	update provjera
    set BrojPrisutnihUcenika = BrojPrisutnihUcenika - 1,
    BrojNegativnihOcjena = BrojNegativnihOcjena - (old.Ocjena = 1)
    where old.Datum = Datum and old.IdPredmeta = IdPredmeta and old.IdSmjera = IdSmjera;
    update provjera
	set BrojPrisutnihUcenika = BrojPrisutnihUcenika + 1,
    BrojNegativnihOcjena = BrojNegativnihOcjena + (new.Ocjena = 1)
    where new.Datum = Datum and new.IdPredmeta = IdPredmeta and new.IdSmjera = IdSmjera;
end$$
delimiter ;

drop trigger if exists dodavanje_ucenika;
delimiter $$
create trigger dodavanje_ucenika after insert
on ucenik
for each row
begin
	declare vKraj bool default false;
    declare vIdPredmeta int;
	declare cRasporedjeniPredmetiNaSmjeru cursor for 
    select distinct IdPredmeta 
    from respored_predmet rp
	where rp.IdSmjera = new.IdSmjera and rp.Razred = new.Razred and rp.Odjeljenje = new.Odjeljenje;
    declare continue handler for not found set vKraj = true;
		open cRasporedjeniPredmetiNaSmjeru;
		petlja : loop
			fetch cRasporedjeniPredmetiNaSmjeru into vIdPredmeta;
			if vKraj then leave petlja;
			end if;
			if (select tip from predmet_na_smjeru pns where vIdPredmeta = pns.IdPredmeta and new.IdSmjera = pns.IdSmjera) = 'O'
				then
					insert into ima_nastavu (ucenik_JMB, IdPredmeta, IdSmjera) values (new.JMB, vIdPredmeta, new.IdSmjera);
			end if;
        end loop petlja;
        close cRasporedjeniPredmetiNaSmjeru;
end $$
delimiter ;

-- provjeranema smisla brisati osobu ako se brise ucenik
drop trigger if exists brisanje_ucenika;
delimiter $$
create trigger brisanje_ucenika before delete
on ucenik
for each row
begin
	-- delete from osoba o where old.JMB = o.JMB;
	delete from ima_nastavu imn
    where imn.UCENIK_JMB = old.JMB;
end $$
delimiter ;

-- 
drop trigger if exists update_ucenika;
delimiter $$
create trigger update_ucenika after update
on ucenik
for each row
begin
	declare vKraj bool default false;
    declare vIdPredmeta int;
    declare cRasporedjeniPredmetiNaSmjeru cursor for 
    select distinct IdPredmeta 
    from respored_predmet rp
	where rp.IdSmjera = new.IdSmjera and rp.Razred = new.Razred and rp.Odjeljenje = new.Odjeljenje;
    declare continue handler for not found set vKraj = true;
	if  not old.Razred = new.Razred or not old.IdSmjera = new.IdSmjera
    then
    -- brisanje
		delete from ima_nastavu imn
		where imn.UCENIK_JMB = old.JMB;
	-- dodavanje obaveznih predmeta
		open cRasporedjeniPredmetiNaSmjeru;
			petlja : loop
				fetch cRasporedjeniPredmetiNaSmjeru into vIdPredmeta;
				if vKraj then leave petlja;
				end if;
				if (select tip from predmet_na_smjeru pns where vIdPredmeta = pns.IdPredmeta and new.IdSmjera = pns.IdSmjera) = 'O'
					then
						insert into ima_nastavu (ucenik_JMB, IdPredmeta, IdSmjera) values (new.JMB, vIdPredmeta, new.IdSmjera);
				end if;
			end loop petlja;
			close cRasporedjeniPredmetiNaSmjeru;
    end if;
end $$
delimiter ;

-- call dodaj_predmet_na_smjeru(0000, 'test', 2, 'i', 1, 3, 3, @status, @poruka);
-- select @status;
-- select @poruka;

drop procedure if exists dodaj_predmet_na_smjeru;
delimiter $$
create procedure dodaj_predmet_na_smjeru (in pIdPredmeta int, in pNazivPredmeta varchar(45), in pIdSmjera int, in pTip char(1), in pRazred tinyint(1),
				in pMinimalniBrojPismenihProvjera tinyint, pMinimalniBrojUsmenihProvjera tinyint, out pStatus bool, out pPoruka varchar(255))
begin
	declare vTrajanje int default 0;
    select Trajanje_Godina into vTrajanje
    from smjer
    where IdSmjera = pIdSmjera;

	set pStatus = false;
    
    if vTrajanje < pRazred then
		set pPoruka='Razred predmeta nije validan';
	else 
		if (select count(*) from predmet p where p.IdPredmeta = pIdPredmeta ) = 0
		 then
			insert into predmet values (pIdPredmeta, pNazivPredmeta);
         end if;
		insert into predmet_na_smjeru values (pIdPredmeta, pIdSmjera, pTip, pRazred, pMinimalniBrojPismenihProvjera, pMinimalniBrojUsmenihProvjera);
        set pStatus = true;
end if;
end$$
delimiter ;

-- call azuriraj_predmet_na_smjeru(0, 2, 'I', 1, 1, 1, @status, @poruka);
-- select @status;
-- select @poruka;


drop procedure if exists azuriraj_predmet_na_smjeru;
delimiter $$
create procedure azuriraj_predmet_na_smjeru (in pIdPredmeta int, in pNazivPredmeta varchar(45), in pIdSmjera int, in pTip char(1), in pRazred tinyint(1),
				in pMinimalniBrojPismenihProvjera tinyint, pMinimalniBrojUsmenihProvjera tinyint, out pStatus bool, out pPoruka varchar(255))
begin
	declare vTrajanje int default 0;
    select Trajanje_Godina into vTrajanje 
    from smjer
    where IdSmjera = pIdSmjera;

	set pStatus = false;
    
    if vTrajanje < pRazred then
		set pPoruka='Razred predmeta nije validan';
	else 
		update predmet p set Naziv = pNazivPredmeta where p.IdPredmeta = pIdPredmeta;
		update predmet_na_smjeru set
        Razred = pRazred,
        Tip = pTip,
        MInimalniBrojPismenihProvjera = pMinimalniBrojPismenihProvjera,
        MinimalniBrojUsmenihProvjera = pMinimalniBrojUsmenihProvjera
        where IdPredmeta = pIdPredmeta and IdSmjera = pIdSmjera;
        set pStatus = true;
end if;
end$$
delimiter ;


drop procedure if exists dodaj_novo_radjenje_provjere_ucenika;
delimiter $$
create procedure dodaj_novo_radjenje_provjere_ucenika (in pUcenik_jmb char(13), in pProvjera_datum date, in pOdjeljenje int, in pIdPredmeta INT, 
														in pIdSmjera int, in pOcjena int, out pStatus bool, out pPoruka varchar(255))
begin
	declare vOdgovaraoManjeOdDva, vImaNastavu bool default false;
	
    select count(*) > 0 into vImaNastavu
    from ima_nastavu
    where UCENIK_JMB = pUcenik_jmb and IdPredmeta = pIdPredmeta and IdSmjera = pIdSmjera
    and IdPredmeta in (select IdPredmeta from predmeti_po_razredima_i_smjerovima pprs where (select Razred from ucenik u where u.JMB = pUcenik_jmb) = pprs.Razred);
    
	select count(*) < 2 into vOdgovaraoManjeOdDva
    from radi_provjeru
    where ucenik_jmb = pUcenik_jmb and Datum = pProvjera_datum; -- nema idPredmeta i idSmjera jer nije bitno na kom je predmetu odgovarao, ne moze sveukupno biti vise od 2
	
    if not vOdgovaraoManjeOdDva then
        set pPoruka='Ucenik ne moze biti provjeravan vise od dva puta u jednom danu!';
        set pStatus = false;
	elseif not vImaNastavu then
		 set pPoruka='Ucenik ne pohadja dati predmet!';
        set pStatus = false;
	elseif not (select Odjeljenje from ucenik u where u.JMB = pUcenik_jmb) = pOdjeljenje
    then
		set pPoruka ='Ucenik ne pripada datom odjeljenju';
        set pStatus = false;
	else 
     insert into radi_provjeru (UCENIK_JMB, Datum, IdPredmeta, IdSmjera, Odjeljenje, Ocjena)
		values (pUcenik_jmb, pProvjera_datum, pIdPredmeta, pIdSmjera, pOdjeljenje, pOcjena);
        set pStatus = true;
        end if;
end$$
delimiter ;

-- call zadaj_novu_zadacu('2021-03-21', 1111, 1, 'neki teksta', '2021-03-19', @status, @poruka);
-- select @status;
-- select @poruka;

-- datum predaje zadace ne smije biti prije datuma zadavanja i tekst ne smije biti prazan
drop procedure if exists zadaj_novu_zadacu;
delimiter $$
create procedure zadaj_novu_zadacu (in pDatumZadavanja DATE, in pIdPredmeta int, in pIdSmjera int, in pTekst varchar(1000), in pDatumPredaje DATE, out pStatus bool, out pPoruka varchar(255))
label : begin
		if (pDatumPredaje is not null and pDatumPredaje < pDatumZadavanja) then
					set pStatus = false;
					set pPoruka = 'Datum predaje ne moze biti prije datuma zadavanja';
                    leave label;
		end if;
		if (char_length(trim(pTekst)) = 0) then
				set pStatus = false;
                set pPoruka = 'Tekst zadace ne moze biti prazan';
			else 
					insert into zadaca (DatumZadavanja, IdPredmeta, IdSmjera, Tekst, DatumPredaje)
						values (pDatumZadavanja, pIdPredmeta, pIdSmjera, pTekst, pDatumPredaje);
					set pStatus = true;
			end if;
end $$
delimiter ;

-- call dohvati_raspored_za_razred(1,1,1);

drop procedure if exists dohvati_raspored_za_razred;
delimiter $$
create procedure dohvati_raspored_za_razred (in pRazred TINYINT, in pOdjeljenje TINYINT, in pIdSmjera INT)
begin
	select Dan, group_concat(concat(IdPredmeta ,' - ', Vrijeme) order by Vrijeme asc separator '|') as 'IdPredmeta-vrijeme'
    from respored_predmet rp
    where rp.Razred = pRazred and rp.Odjeljenje = pOdjeljenje and rp.IdSmjera = pIdSmjera
    group by dan;
end $$
delimiter ;

-- call dodaj_ima_nastavu_ucenik('1206986101234', 3111, 1,@status, @poruka);
-- select @status;
-- select @poruka;
-- call dodaj_ima_nastavu_ucenik('1206986101234', 3222, 1,@status, @poruka);
-- select @status;
-- select @poruka;

-- moguce je dodavanje veze ucenik-ima_nastavu-predmet_na_smjeru samo ako je razred i smjer koji pohadja ucenik odgovarajuci, te ako je predmet izborni(jer se obavezni dodaje putem trigera)
drop procedure if exists dodaj_ima_nastavu_ucenik;
delimiter $$
create procedure dodaj_ima_nastavu_ucenik (in pJMB char(13), in pIdPredmeta int, in pIdSmjera int, out pStatus bool, out pPoruka varchar(255))
begin 
	if (select tip, razred, IdSmjera from predmet_na_smjeru pns where pns.IdPredmeta = pIdPredmeta and pns.IdSmjera = pIdSmjera) 
			= ('I', (select razred from ucenik u where u.JMB = pJMB), (select IdSmjera from ucenik u where u.JMB = pJMB))
		then
			insert into ima_nastavu values (pJMB, pIdPredmeta, pIdSmjera);
            set pStatus = true;
	else 
		set pPoruka = 'Unos nije validan (predmet mora biti IZBORNI i ucenik mora pohadjati odgovarajuci smjer i razred)';
        set pStatus = false;
	end if;
end$$
delimiter ;


drop trigger if exists rasporedi_predmet_razred;
delimiter $$
create trigger rasporedi_predmet_razred after insert
on respored_predmet
for each row 
begin
	declare vKraj bool default false;
    declare vJMB char(13);
	declare cUceniciNaSmjeruRazreduIOdjeljenu cursor for 
    select JMB 
    from ucenik u
	where u.IdSmjera = new.IdSmjera and u.Razred = new.Razred and u.Odjeljenje = new.Odjeljenje;
    declare continue handler for not found set vKraj = true;
	
    -- ako je predmet obavezan
	if (select tip from predmet_na_smjeru pns where new.IdPredmeta = pns.IdPredmeta and new.IdSmjera = pns.IdSmjera) = 'O'
    then
		open cUceniciNaSmjeruRazreduIOdjeljenu;
		petlja : loop
        fetch cUceniciNaSmjeruRazreduIOdjeljenu into vJMB;
        if vKraj then leave petlja;
        end if;
        if (select count(*) from ima_nastavu imn where imn.ucenik_JMB = vJMB and imn.IdPredmeta = new.IdPredmeta and imn.IdSmjera = new.IdSmjera) = 0
        then
			insert into ima_nastavu (ucenik_JMB, IdPredmeta, IdSmjera) values (vJMB, new.IdPredmeta, new.IdSmjera);
		end if;
        end loop petlja;
        close cUceniciNaSmjeruRazreduIOdjeljenu;
	end if;
end $$
delimiter ;

drop trigger if exists ukloni_raspored_predmet;
delimiter $$
create trigger ukloni_raspored_predmet after delete
on respored_predmet
for each row 
begin
	declare vKraj bool default false;
    declare vJMB char(13);
	declare cUceniciNaSmjeruRazreduIOdjeljenu cursor for 
    select JMB 
    from ucenik u
	where u.IdSmjera = old.IdSmjera and u.Razred = old.Razred and u.Odjeljenje = old.Odjeljenje;
    declare continue handler for not found set vKraj = true;
	
    -- ako je predmet obavezan
	if (select tip from predmet_na_smjeru pns where old.IdPredmeta = pns.IdPredmeta and old.IdSmjera = pns.IdSmjera) = 'O'
    then
		open cUceniciNaSmjeruRazreduIOdjeljenu;
		petlja : loop
        fetch cUceniciNaSmjeruRazreduIOdjeljenu into vJMB;
        if vKraj then leave petlja;
        end if;
        if (select count(*) from ima_nastavu imn where imn.ucenik_JMB = vJMB and imn.IdPredmeta = old.IdPredmeta and imn.IdSmjera = old.IdSmjera) > 0
        then
			delete from  ima_nastavu imn where imn.ucenik_JMB = vJMB and imn.IdPredmeta = old.IdPredmeta and imn.IdSmjera = old.IdSmjera;
		end if;
        end loop petlja;
        close cUceniciNaSmjeruRazreduIOdjeljenu;
	end if;
end $$
delimiter ;


drop trigger if exists azuriraj_raspored_predmet;
delimiter $$
create trigger azuriraj_raspored_predmet after update
on respored_predmet
for each row 
begin
	begin
		declare vKraj bool default false;
		declare vJMB char(13);
		declare cUceniciNaSmjeruRazreduIOdjeljenu cursor for 
		select JMB 
		from ucenik u
		where u.IdSmjera = old.IdSmjera and u.Razred = old.Razred and u.Odjeljenje = old.Odjeljenje;
		declare continue handler for not found set vKraj = true;
		
		-- ako je predmet obavezan
		if (select tip from predmet_na_smjeru pns where old.IdPredmeta = pns.IdPredmeta and old.IdSmjera = pns.IdSmjera) = 'O'
		then
			open cUceniciNaSmjeruRazreduIOdjeljenu;
			petlja : loop
			fetch cUceniciNaSmjeruRazreduIOdjeljenu into vJMB;
			if vKraj then leave petlja;
			end if;
			if (select count(*) from ima_nastavu imn where imn.ucenik_JMB = vJMB and imn.IdPredmeta = old.IdPredmeta and imn.IdSmjera = old.IdSmjera) > 0
			then
				delete from  ima_nastavu imn where imn.ucenik_JMB = vJMB and imn.IdPredmeta = old.IdPredmeta and imn.IdSmjera = old.IdSmjera;
			end if;
			end loop petlja;
			close cUceniciNaSmjeruRazreduIOdjeljenu;
		end if;
	end ;
	  begin
		declare vKraj bool default false;
		declare vJMB char(13);
		declare cUceniciNaSmjeruRazreduIOdjeljenu cursor for 
		select JMB 
		from ucenik u
		where u.IdSmjera = new.IdSmjera and u.Razred = new.Razred and u.Odjeljenje = new.Odjeljenje;
		declare continue handler for not found set vKraj = true;
		
		-- ako je predmet obavezan
		if (select tip from predmet_na_smjeru pns where new.IdPredmeta = pns.IdPredmeta and new.IdSmjera = pns.IdSmjera) = 'O'
		then
			open cUceniciNaSmjeruRazreduIOdjeljenu;
			petlja : loop
			fetch cUceniciNaSmjeruRazreduIOdjeljenu into vJMB;
			if vKraj then leave petlja;
			end if;
			if (select count(*) from ima_nastavu imn where imn.ucenik_JMB = vJMB and imn.IdPredmeta = new.IdPredmeta and imn.IdSmjera = new.IdSmjera) = 0
			then
				insert into ima_nastavu (ucenik_JMB, IdPredmeta, IdSmjera) values (vJMB, new.IdPredmeta, new.IdSmjera);
			end if;
			end loop petlja;
			close cUceniciNaSmjeruRazreduIOdjeljenu;
		end if;
	end ;
end $$
delimiter ;

drop trigger if exists obrisi_predmet_na_smjeru;
delimiter $$
create trigger obrisi_predmet_na_smjeru before delete
on predmet_na_smjeru
for each row
begin
	delete from respored_predmet rp where rp.IdPredmeta = old.IdPredmeta and rp.IdSmjera = old.IdSmjera;
end $$
delimiter ;

-- call dodaj_profesora('1907951100012', 1, 'email@com', @status, @poruka);
-- select @status;
-- select @poruka;

drop procedure if exists dodaj_profesora;
delimiter $$
create procedure dodaj_profesora (in pJMB char(13), in pVerifikovan tinyint(1), in pEmail varchar(45), out pStatus bool, out pPoruka varchar(255))
begin
	if not (select Strucna_sprema from osoba o where pJMB = o.JMB) = 'VSS'
		then
			set pStatus = false;
            set pPoruka = 'Profesor mora imati VSS';
		else
			insert into profesor values ( pJMB, pVerifikovan, pEmail);
            set pStatus = true;
	end if;
end $$
delimiter ;

drop procedure if exists dodaj_skolu;
delimiter $$
create procedure dodaj_skolu (in pJIB char(13),in  pNazivSkole varchar(255), in pEmail varchar (45),in pVrsta varchar(45), 
		in pOsnivac varchar(255), in pADRESA_Ulica varchar (255), in pADRESA_PTTBroj int, in pADRESA_Grad varchar (45),in pADRESA_Drzava varchar (45))
begin
-- implicitno dodajem adresu, ako vec nije dodata
	if (select count(*) from adresa a where pADRESA_Ulica = a.Ulica and pADRESA_PTTBroj = a.PTTBroj and pADRESA_Grad = a.Grad and pADRESA_Drzava = a.Drzava) = 0
		then
			insert into adresa values (pADRESA_Ulica, pADRESA_PTTBroj, pADRESA_Grad, pADRESA_Drzava);
        end if;
        
        insert into skola (JIB, NazivSkole, email, Vrsta, Osnivac, ADRESA_Ulica, ADRESA_PTTBroj, ADRESA_Grad, ADRESA_Drzava)  values (pJIB, pNazivSkole, pEmail, pVrsta, pOsnivac, pADRESA_Ulica,pADRESA_PTTBroj,pADRESA_Grad,pADRESA_Drzava);
        
end $$
delimiter ;

drop procedure if exists azuriraj_skolu;
delimiter $$
create procedure azuriraj_skolu (in pJIB char(13),in  pNazivSkole varchar(255), in pEmail varchar (45),in pVrsta varchar(45), 
		in pOsnivac varchar(255), in pADRESA_Ulica varchar (255), in pADRESA_PTTBroj int, in pADRESA_Grad varchar (45), in pADRESA_Drzava varchar (45))
begin
-- implicitno dodajem adresu, ako vec nije dodata
	if (select count(*) from adresa a where pADRESA_Ulica = a.Ulica and pADRESA_PTTBroj = a.PTTBroj and pADRESA_Grad = a.Grad and pADRESA_Drzava = a.Drzava) = 0
		then
			insert into adresa values (pADRESA_Ulica, pADRESA_PTTBroj, pADRESA_Grad, pADRESA_Drzava);
        end if;
        
        update skola s set  NazivSkole = pNazivSkole, email = pEmail, Vrsta = pVrsta,
						Osnivac = pOsnivac, ADRESA_Ulica = pADRESA_Ulica, ADRESA_PTTBroj = pADRESA_PTTBroj, ADRESA_Grad = pADRESA_Grad, ADRESA_Drzava = pADRESA_Drzava
                        where s.JIB = pJIB;
        
end $$
delimiter ;

drop trigger if exists brisanje_skole;
delimiter $$
create trigger brisanje_skole before delete
on skola
for each row
begin
	delete from telefon t
    where t.SKOLA_JIB = old.JIB;
end $$
delimiter ;

-- pri dodavanju nove prostorije, dodjeljujem je pomocnom osoblju sa najmanje prostorija koje odrzava
drop trigger if exists dodavanje_nove_prostorije;
delimiter $$
create trigger dodavanje_nove_prostorije after insert
on prostorija
for each row
begin
	declare vJMB char(13) default null;
	select JMB into vJMB
    from pomocno_osoblje_prostorije limit 1;
	if vJMB is not null
    then
		insert into odrzava values (new.Broj, vJMB);
    end if;
end $$
delimiter ;