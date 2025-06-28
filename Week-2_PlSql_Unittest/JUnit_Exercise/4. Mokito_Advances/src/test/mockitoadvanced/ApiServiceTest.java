package com.example.mockitoadvanced;

import com.mycompany.mockitoadvanced.ApiService;
import com.mycompany.mockitoadvanced.RestClient;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // 1️⃣ Create mock RestClient
        RestClient mockRestClient = mock(RestClient.class);

        // 2️⃣ Stub getResponse() to return "Mock Response"
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // 3️⃣ Create ApiService with mocked client
        ApiService apiService = new ApiService(mockRestClient);

        // 4️⃣ Test fetchData() method
        String result = apiService.fetchData();

        // 5️⃣ Assert the expected output
        assertEquals("Fetched Mock Response", result);
    }
}

