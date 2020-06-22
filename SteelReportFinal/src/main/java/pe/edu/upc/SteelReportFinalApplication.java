package pe.edu.upc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SteelReportFinalApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SteelReportFinalApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String passwordjfcomercial = "jefeventacomercial";
		String passwordjfindustrial = "jefeventas2";
		String passwordjfconstructor="jefeventas3";
		String passwordcli = "clienteaceros";
		
		for(int i=0; i<2; i++) {
			String bcryptPassword1 = passwordEncoder.encode(passwordjfcomercial);
			System.out.println(bcryptPassword1);
		}
		
		for(int i=0; i<2; i++) {
			String bcryptPassword2 = passwordEncoder.encode(passwordjfindustrial);
			System.out.println(bcryptPassword2);
		}

		for(int i=0; i<2; i++) {
			String bcryptPassword3 = passwordEncoder.encode(passwordjfconstructor);
			System.out.println(bcryptPassword3);
		}
		
		for(int i=0; i<2; i++) {
			String bcryptPassword4 = passwordEncoder.encode(passwordcli);
			System.out.println(bcryptPassword4);
		}
		
	}

}
