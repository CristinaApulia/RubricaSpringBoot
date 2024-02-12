package com.prova.RubricaSpringBoot;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RubricaController {

	private final static Logger LOGGER = Logger.getLogger(RubricaController.class.getName());

	List<Contatti> listaContatti;

	public RubricaController() {
		listaContatti = new ArrayList<Contatti>();
		aggiungiContatti("Luca", "Gialli", "3491212121");
		aggiungiContatti("Mario", "Rossi", "3385353535");
		aggiungiContatti("Guido", "Verdi", "3316464646");
		aggiungiContatti("Andrea", "Bianchi", "33385858585");
		aggiungiContatti("Maria", "Bianchi", "334555585");
	}

	@PostMapping("/aggiungicontatti")
	public Contatti aggiungiContatti(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome,
			@RequestParam("numero") String numero) {
		Contatti contatti = new Contatti(nome, cognome, numero);
		listaContatti.add(contatti);
		LOGGER.info("inseriti contatti" + contatti);
		return contatti;
	}

	public Contatti aggiungiContatti(Contatti contatti) {
		listaContatti.add(contatti);
		LOGGER.info("inseriti contatti" + contatti);
		return contatti;
	}

	@GetMapping("/stampacontatti")
	public List<Contatti> stampaContatti() {
		return listaContatti;
	}

	@GetMapping("/cercacontattipercognome/{cognome}")
	public List<Contatti> cercaContattiPerCognome(@PathVariable String cognome) {
		List<Contatti> listaBreveContatti = new ArrayList<Contatti>();
		for (int i = 0; i < listaContatti.size(); i++) {
			Contatti contatti = listaContatti.get(i);
			if (contatti.getCognome().equals(cognome)) {
				listaBreveContatti.add(contatti);
			}
		}
		return listaBreveContatti;
	}
}
