package com.tallermecanico;

import com.tallermecanico.config.RSAKeyRecord;
import com.tallermecanico.config.RoleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({RSAKeyRecord.class, RoleConfig.class})
public class TallerMecanicoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TallerMecanicoApplication.class, args);
    }

}
