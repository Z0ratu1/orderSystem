package njwc.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import njwc.oms.utl.SpringUtl;

@SpringBootApplication
@ComponentScan({"njwc.oms.controller","njwc.oms.service","njwc.oms.mapper"})
@Import(SpringUtl.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
