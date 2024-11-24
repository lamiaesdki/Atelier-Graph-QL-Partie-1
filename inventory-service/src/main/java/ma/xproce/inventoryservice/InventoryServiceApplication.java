package ma.xproce.inventoryservice;

import ma.xproce.inventoryservice.dao.entities.Creator;
import ma.xproce.inventoryservice.dao.entities.Video;
import ma.xproce.inventoryservice.dao.interfaces.CreatorRepository;
import ma.xproce.inventoryservice.dao.interfaces.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CreatorRepository creatorRepository, VideoRepository videoRepository) {
        return args -> {

            List<Creator> personList =  List.of(
                    Creator.builder().name("x").email("x@gmail.com").build(),
                    Creator.builder().name("y").email("y@gmail.com").build(),
                    Creator.builder().name("z").email("z@gmail.com").build(),
                    Creator.builder().name("r").email("r@gmail.com").build()
            );
            creatorRepository.saveAll(personList);





            List<Video> videos = List.of(
                    Video.builder().name("vEducation")
                            .url("vEducation.com").datePublication(new Date())
                            .creator(personList.get(0)).build(),
                    Video.builder().name("vGaming").url("vEGaming.com")
                            .datePublication(new Date())
                            .creator(personList.get(1)).build(),
                    Video.builder().name("vEntertainment")
                            .url("vEntertainment.com").datePublication(new Date())
                            .creator(personList.get(2)).build()
            );
            videoRepository.saveAll(videos);
        };
    }
}
