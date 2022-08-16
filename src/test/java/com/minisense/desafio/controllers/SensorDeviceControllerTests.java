package com.minisense.desafio.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minisense.desafio.dto.DataStreamDto;
import com.minisense.desafio.dto.SensorDataPublishReqDto;
import com.minisense.desafio.dto.SensorDeviceReqDto;
import com.minisense.desafio.tests.TokenUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SensorDeviceControllerTests {
    private static final String URL_SENSOR = "/api/v1/sensors/users";
    private static final String URL_STREAM = "/api/v1/sensors/users/devices";

    private String accessToken;
    private String username;
    private String password;

    private Long validUserId;
    private Long invalidUserId;

    private Long validDeviceId;
    private Long invalidDeviceId;

    private Long validStreamId;
    private Long invalidStreamId;

    private Long validMeasurementId;
    private Long invalidMeasurementId;
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TokenUtil tokenUtil;

    @BeforeEach
    public void setUp() throws Exception {
        username = "sergio@gmail.com";
        password = "123456";
        accessToken = tokenUtil.obtainAccessToken(mockMvc, username, password);

        validUserId = 1L;
        invalidUserId = 1000L;

        validDeviceId = 1L;
        invalidDeviceId = 1000L;

        validStreamId = 1L;
        invalidStreamId = 1000L;

        validMeasurementId = 1L;
        invalidMeasurementId = 1000L;
    }

    @Nested
    @DisplayName("Testando endpoints para device")
    class DeviceTest {

        @Nested
        @DisplayName("Inserindo device")
        class InsertDevice {
            @Test
            @Transactional
            @DisplayName("Inserindo device em um usuário com sucesso")
            public void shouldInsertDeviceSuccess() throws Exception {
                SensorDeviceReqDto deviceReqDto = new SensorDeviceReqDto();
                deviceReqDto.setLabel("Kitchen's freezer sensor (Arduino)");
                deviceReqDto.setDescription("Kitchen's freezer sensor (Arduino)");

                String jsonBody = objectMapper.writeValueAsString(deviceReqDto);

                ResultActions result =
                        mockMvc.perform(post(URL_SENSOR + "/{id}/devices", validUserId)
                                .header("Authorization", "Bearer " + accessToken)
                                .content(jsonBody)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isCreated());
                result.andExpect(jsonPath("$.id").exists());
                result.andExpect(jsonPath("$.label").exists());
                result.andExpect(jsonPath("$.description").exists());
            }

            @Test
            @DisplayName("Inserindo um device em usuário que não existe")
            public void shouldReturnErrorForUserThatDoesNotExist() throws Exception {
                SensorDeviceReqDto deviceReqDto = new SensorDeviceReqDto();
                deviceReqDto.setLabel("Kitchen's freezer sensor (Arduino)");
                deviceReqDto.setDescription("Kitchen's freezer sensor (Arduino)");

                String jsonBody = objectMapper.writeValueAsString(deviceReqDto);

                ResultActions result =
                        mockMvc.perform(post(URL_SENSOR + "/{id}/devices", invalidUserId)
                                .header("Authorization", "Bearer " + accessToken)
                                .content(jsonBody)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isBadRequest());
                result.andExpect(jsonPath("$.error").value("Database exception"));
                result.andExpect(jsonPath("$.message").value("database.integrity.violation.exception"));
            }

            @Test
            @DisplayName("Inserindo um device com valores invalidos")
            public void shouldReturnErrorWhenSendingInvalidData() throws Exception {
                SensorDeviceReqDto deviceReqDto = new SensorDeviceReqDto();
                deviceReqDto.setLabel("");
                deviceReqDto.setDescription("  ");

                String jsonBody = objectMapper.writeValueAsString(deviceReqDto);

                ResultActions result =
                        mockMvc.perform(post(URL_SENSOR + "/{id}/devices", validUserId)
                                .header("Authorization", "Bearer " + accessToken)
                                .content(jsonBody)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isBadRequest());
                result.andExpect(jsonPath("$.error").value("Validation exception"));
                result.andExpect(jsonPath("$.errors").exists());
            }
        }

        @Nested
        @DisplayName("Exibindo devices")
        class GetDevice {
            @Test
            @DisplayName("Buscando todos devices de um usuário")
            public void shouldReturnAllDevicesOfAUser() throws Exception {
                ResultActions result =
                        mockMvc.perform(get(URL_SENSOR + "/{id}/devices", validUserId)
                                .header("Authorization", "Bearer " + accessToken)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isOk());
                result.andExpect(jsonPath("$.*", hasSize(2)));
                result.andExpect(jsonPath("$.[0].label").value("Kitchen's freezer sensor (Arduino)"));
                result.andExpect(jsonPath("$.[1].label").value("humidity sensor (Arduino)"));
            }

            @Test
            @DisplayName("Buscando todos devices de um usuário com id invalido")
            public void shouldReturnErrorForUserThatDoesNotExist() throws Exception {
                ResultActions result =
                        mockMvc.perform(get(URL_SENSOR + "/{id}/devices", invalidUserId)
                                .header("Authorization", "Bearer " + accessToken)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isNotFound());
                result.andExpect(jsonPath("$.error").value("Entity not found"));
                result.andExpect(jsonPath("$.message")
                        .value("Entity not found. userId: " + invalidUserId));
            }

            @Test
            @DisplayName("Buscando device por ID")
            public void shouldReturnDeviceSuccess() throws Exception {
                ResultActions result =
                        mockMvc.perform(get(URL_SENSOR + "/devices/{id}", validDeviceId)
                                .header("Authorization", "Bearer " + accessToken)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isOk());
                result.andExpect(jsonPath("$.label").value("Kitchen's freezer sensor (Arduino)"));
                result.andExpect(jsonPath("$.description").value("Kitchen's freezer sensor (Arduino)"));
                result.andExpect(jsonPath("$.streams.*", isA(ArrayList.class)));
                result.andExpect(jsonPath("$.streams.*", hasSize(2)));
                result.andExpect(jsonPath("$.streams.[0].measurementCount").value(10));
                result.andExpect(jsonPath("$.streams.[0].measurements.*", isA(ArrayList.class)));
                result.andExpect(jsonPath("$.streams.[0].measurements.*", hasSize(5)));
                result.andExpect(jsonPath("$.streams.[1].measurementCount").value(3));
                result.andExpect(jsonPath("$.streams.[1].measurements.*", isA(ArrayList.class)));
                result.andExpect(jsonPath("$.streams.[1].measurements.*", hasSize(3)));

            }

            @Test
            @DisplayName("Buscando device por ID que não existe")
            public void shouldReturnErrorForDeviceThatDoesNotExist() throws Exception {
                ResultActions result =
                        mockMvc.perform(get(URL_SENSOR + "/devices/{id}", invalidDeviceId)
                                .header("Authorization", "Bearer " + accessToken)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isNotFound());
                result.andExpect(jsonPath("$.error").value("Entity not found"));
                result.andExpect(jsonPath("$.message").value("Entity not found. sensorDeviceId: " + invalidDeviceId));
            }
        }
    }

    @Nested
    @DisplayName("Inserindo stream")
    class InsertStream {

        @Test
        @Transactional
        @DisplayName("Inserindo uma stream com sucesso")
        public void shouldInsertStreamSuccess() throws Exception {
            DataStreamDto streamDto = new DataStreamDto();
            streamDto.setLabel("Temperature");
            streamDto.setUnitId(validMeasurementId);

            String jsonBody = objectMapper.writeValueAsString(streamDto);

            ResultActions result =
                    mockMvc.perform(post(URL_STREAM + "/{id}/streams", validDeviceId)
                            .header("Authorization", "Bearer " + accessToken)
                            .content(jsonBody)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON));

            result.andExpect(status().isCreated());
            result.andExpect(jsonPath("$.id").exists());
            result.andExpect(jsonPath("$.label").exists());
            result.andExpect(jsonPath("$.deviceId").exists());
            result.andExpect(jsonPath("$.unitId").exists());
        }

        @Test
        @DisplayName("Inserindo uma stream em um device que não existe")
        public void shouldReturnErrorForDeviceThatDoesNotExist() throws Exception {
            DataStreamDto streamDto = new DataStreamDto();
            streamDto.setLabel("Temperature");
            streamDto.setUnitId(validMeasurementId);

            String jsonBody = objectMapper.writeValueAsString(streamDto);

            ResultActions result =
                    mockMvc.perform(post(URL_STREAM + "/{id}/streams", invalidDeviceId)
                            .header("Authorization", "Bearer " + accessToken)
                            .content(jsonBody)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON));

            result.andExpect(status().isBadRequest());
            result.andExpect(jsonPath("$.error").value("Database exception"));
            result.andExpect(jsonPath("$.message").value("database.integrity.violation.exception"));
        }

        @Test
        @DisplayName("Inserindo uma stream com measuremetId inválido")
        public void shouldReturnErrorWhenSendingInvalidMeasurement() throws Exception {
            DataStreamDto streamDto = new DataStreamDto();
            streamDto.setLabel("Temperature");
            streamDto.setUnitId(invalidMeasurementId);

            String jsonBody = objectMapper.writeValueAsString(streamDto);

            ResultActions result =
                    mockMvc.perform(post(URL_STREAM + "/{id}/streams", invalidDeviceId)
                            .header("Authorization", "Bearer " + accessToken)
                            .content(jsonBody)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON));

            result.andExpect(status().isBadRequest());
            result.andExpect(jsonPath("$.error").value("Database exception"));
            result.andExpect(jsonPath("$.message").value("database.integrity.violation.exception"));
        }

        @Test
        @DisplayName("Inserindo uma stream em um label invalid")
        public void shouldReturnErrorWhenSendingInvalidLabel() throws Exception {
            DataStreamDto streamDto = new DataStreamDto();
            streamDto.setLabel("");
            streamDto.setUnitId(validMeasurementId);

            String jsonBody = objectMapper.writeValueAsString(streamDto);

            ResultActions result =
                    mockMvc.perform(post(URL_STREAM + "/{id}/streams", validDeviceId)
                            .header("Authorization", "Bearer " + accessToken)
                            .content(jsonBody)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON));

            result.andExpect(status().isBadRequest());
            result.andExpect(jsonPath("$.error").value("Validation exception"));
            result.andExpect(jsonPath("$.errors").exists());
        }

        @Nested
        @DisplayName("Buscando streams")
        class getStream {
            @Test
            @DisplayName("Buscando stream por ID")
            public void shouldReturnStreamSuccess() throws Exception {
                ResultActions result =
                        mockMvc.perform(get(URL_SENSOR + "/devices/streams/{id}", validStreamId)
                                .header("Authorization", "Bearer " + accessToken)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isOk());
                result.andExpect(jsonPath("$.label").value("temperature"));
                result.andExpect(jsonPath("$.deviceId").value(1));
                result.andExpect(jsonPath("$.unitId").value(1));
                result.andExpect(jsonPath("$.measurementCount").value(10));
                result.andExpect(jsonPath("$.measurements.*", isA(ArrayList.class)));
                result.andExpect(jsonPath("$.measurements.*", hasSize(10)));
            }

            @Test
            @DisplayName("Buscando stream por ID")
            public void shouldReturnErrorForStreamThatDoesNotExist() throws Exception {
                ResultActions result =
                        mockMvc.perform(get(URL_SENSOR + "/devices/streams/{id}", invalidStreamId)
                                .header("Authorization", "Bearer " + accessToken)
                                .accept(MediaType.APPLICATION_JSON));

                result.andExpect(status().isNotFound());
                result.andExpect(jsonPath("$.error").value("Entity not found"));
                result.andExpect(jsonPath("$.message").value("Entity not found. dataStreamId: " + invalidStreamId));
            }
        }
    }

    @Nested
    @DisplayName("Inserindo dados em uma stream")
    class InsertDataStream {
        @Test
        @Transactional
        @DisplayName("Inserindo dados com sucesso")
        public void shouldInsertDataStreamSuccess() throws Exception {

            SensorDataPublishReqDto publishReqDto = new SensorDataPublishReqDto();
            publishReqDto.setTimestamp(1660453513359L);
            publishReqDto.setValue(25.5);

            String jsonBody = objectMapper.writeValueAsString(publishReqDto);

            ResultActions result =
                    mockMvc.perform(post(URL_STREAM + "/streams/{id}/measurements", validMeasurementId)
                            .header("Authorization", "Bearer " + accessToken)
                            .content(jsonBody)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON));

            result.andExpect(status().isCreated());
            result.andExpect(jsonPath("$.id").exists());
            result.andExpect(jsonPath("$.unitId").exists());
            result.andExpect(jsonPath("$.timestamp").exists());
            result.andExpect(jsonPath("$.value").exists());
        }

        @Test
        @DisplayName("Inserindo dados em uma stream que não existe")
        public void shouldReturnErrorForStreamThatDoesNotExist() throws Exception {

            SensorDataPublishReqDto publishReqDto = new SensorDataPublishReqDto();
            publishReqDto.setTimestamp(1660453513359L);
            publishReqDto.setValue(25.5);

            String jsonBody = objectMapper.writeValueAsString(publishReqDto);

            ResultActions result =
                    mockMvc.perform(post(URL_STREAM + "/streams/{id}/measurements", invalidStreamId)
                            .header("Authorization", "Bearer " + accessToken)
                            .content(jsonBody)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON));

            result.andExpect(status().isNotFound());
            result.andExpect(jsonPath("$.error").value("Entity not found"));
            result.andExpect(jsonPath("$.message")
                    .value("Entity not found. dataStreamId: " + invalidStreamId));
        }
    }
}
