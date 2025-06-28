package com.example.mockitoadvanced;

import com.mycompany.mockitoadvanced.Repository;
import com.mycompany.mockitoadvanced.Service;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MultiReturnServiceTest {

    @Test
    public void testServiceWithMultipleReturnValues() {
        // 1️⃣ Create mock Repository
        Repository mockRepository = mock(Repository.class);

        // 2️⃣ Stub getData() with different returns on consecutive calls
        when(mockRepository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        // 3️⃣ Create Service with mocked repository
        Service service = new Service(mockRepository);

        // 4️⃣ Call processData() twice
        String firstResult = service.processData();
        String secondResult = service.processData();

        // 5️⃣ Verify both results
        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);
    }
}

