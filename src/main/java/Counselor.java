package com.wellsfargo.counselor;

import com.wellsfargo.counselor.entities.Counselor;
import com.wellsfargo.counselor.repositories.CounselorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CounselorRepositoryTest {

    @Autowired
    private CounselorRepository counselorRepository;

    @Test
    public void testSaveCounselor() {
        // Create a new counselor object
        Counselor counselor = new Counselor("John Doe", "Psychologist");

        // Save the counselor to the database
        Counselor savedCounselor = counselorRepository.save(counselor);

        // Assert that the counselor was saved and the ID is generated
        assertNotNull(savedCounselor.getId(), "The counselor ID should be auto-generated.");
        assertEquals("John Doe", savedCounselor.getName(), "The counselor's name should be John Doe.");
    }

    @Test
    public void testFindCounselorById() {
        // Create and save a counselor
        Counselor counselor = new Counselor("Jane Smith", "Therapist");
        counselorRepository.save(counselor);

        // Retrieve the counselor by ID
        Counselor foundCounselor = counselorRepository.findById(counselor.getId()).orElse(null);

        // Assert that the counselor is found and the name matches
        assertNotNull(foundCounselor, "Counselor should be found.");
        assertEquals("Jane Smith", foundCounselor.getName(), "Counselor's name should match.");
    }
}

