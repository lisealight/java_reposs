package ru.tinkoff.edu.repository.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ru.tinkoff.edu.IntegrationEnvironment;
import ru.tinkoff.edu.repository.jdbc.LinkRepository;
import ru.tinkoff.edu.repository.jdbc.dto.Link;
import ru.tinkoff.edu.repository.jdbc.mapper.LinkMapper;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.OffsetDateTime;
import java.util.List;

@SpringBootTest
public class LinkRepositoryTest extends IntegrationEnvironment {
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LinkMapper linkMapper;
    private final List<String> urls = List.of("https://github.com/MarinaBiryukova/tinkoff-java/",
            "https://github.com/MarinaBiryukova/tinkoff-edu/");

    @BeforeEach
    public void setup() {
        for (String url: urls) {
            jdbcTemplate.update("insert into link (link, last_update, last_activity) values (?, ?, ?)",
                    url, OffsetDateTime.now(), OffsetDateTime.now());
        }
    }

    @Test
    @Transactional
    @Rollback
    void findAllTest() {
        List<Link> all = linkRepository.findAll();

        Assertions.assertEquals(urls.size(), all.size());
        for (int i = 0; i < urls.size(); i++) {
            Assertions.assertEquals(urls.get(i), all.get(i).getLink().toString());
        }
    }

    @Test
    @Transactional
    @Rollback
    void removeTest() throws URISyntaxException {
        linkRepository.remove(new URI(urls.get(0)));

        Assertions.assertEquals(urls.size() - 1, jdbcTemplate.queryForObject("select count(*) from link", Integer.class));
        Assertions.assertEquals(urls.get(1), jdbcTemplate.queryForObject("select link from link", String.class));
    }

    @Test
    @Transactional
    @Rollback
    void addTest() throws URISyntaxException {
        String newUrl = "https://github.com/MarinaBiryukova/tinkoff/";
        Link link = new Link();
        link.setLink(new URI(newUrl));
        link.setLastUpdate(OffsetDateTime.now());
        link.setLastActivity(OffsetDateTime.now());
        linkRepository.add(link);

        List<Link> all = jdbcTemplate.query("select * from link", linkMapper);
        Assertions.assertEquals(urls.size() + 1, all.size());
        Assertions.assertEquals(newUrl, all.get(all.size() - 1).getLink().toString());
    }
}
