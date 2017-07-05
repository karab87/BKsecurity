package org.ines;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.ines.dao.EtudiantRepository;
import org.ines.entities.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		EtudiantRepository etudiantRepository=ctx.getBean(EtudiantRepository.class);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save(new Etudiant("safoune","safoune",df.parse("1983-11-12") ));
		etudiantRepository.save(new Etudiant("rifat","rifat",df.parse("1983-11-12") ));
		etudiantRepository.save(new Etudiant("sara","sara",df.parse("1983-11-12") ));
		etudiantRepository.save(new Etudiant("hamza","hamza",df.parse("1983-11-12") ));
		etudiantRepository.save(new Etudiant("idriss","idriss",df.parse("1983-11-12") ));
		
		List<Etudiant> etds=etudiantRepository.findAll();
		for(Etudiant e:etds){
			System.out.println(e.getNom());
		}
	}
}
