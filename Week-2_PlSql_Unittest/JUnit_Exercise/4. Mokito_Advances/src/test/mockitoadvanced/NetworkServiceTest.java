package com.example.mockitoadvanced;

import com.mycompany.mockitoadvanced.NetworkClient;
import com.mycompany.mockitoadvanced.NetworkService;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // 1️⃣ Create mock NetworkClient
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // 2️⃣ Stub connect() to return "Mock Connection"
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // 3️⃣ Create NetworkService with mocked client
        NetworkService networkService = new NetworkService(mockNetworkClient);

        // 4️⃣ Call connectToServer()
        String result = networkService.connectToServer();

        // 5️⃣ Verify result
        assertEquals("Connected to Mock Connection", result);
    }
}

