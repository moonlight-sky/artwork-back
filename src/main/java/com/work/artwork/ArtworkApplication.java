package com.work.artwork;

import com.work.artwork.bean.File;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@MapperScan("com.work.artwork.dao")
@SpringBootApplication
@EnableConfigurationProperties({
        File.class
})
public class ArtworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtworkApplication.class, args);
    }

}
