package com.codecool.hp_backend.repository;

import com.codecool.hp_backend.entity.BloodStatus;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
class BloodStatusRepositoryTest {
    @Autowired
    private BloodStatusRepository bloodStatusRepository;

    @Test
    public void findBloodStatusByNameReturnBloodStatusEntity() {
        BloodStatus bloodStatus1 = BloodStatus.builder()
                .name("blood1")
                .build();

        BloodStatus bloodStatus2 = BloodStatus.builder()
                .name("blood2")
                .build();

        bloodStatusRepository.saveAll(Lists.newArrayList(bloodStatus1, bloodStatus2));

        BloodStatus bloodStatus = bloodStatusRepository.findBloodStatusByName("blood1");
        assertEquals(bloodStatus1, bloodStatus);
    }

}