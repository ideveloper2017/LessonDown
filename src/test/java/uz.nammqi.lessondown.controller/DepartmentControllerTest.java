package uz.nammqi.lessondown.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import uz.nammqi.lessondown.controller.CustomUtils;
import uz.nammqi.lessondown.controller.DepartmentController;
import uz.nammqi.lessondown.dto.DepartmentDto;
import uz.nammqi.lessondown.mapper.DepartmentMapper;
import uz.nammqi.lessondown.mapper.EntityMapper;
import uz.nammqi.lessondown.models.Department;
import uz.nammqi.lessondown.service.DepartmentService;

import java.util.Arrays;
import java.util.Collections;

@Transactional
public class DepartmentControllerTest {
    private static final String ENDPOINT_URL = "/api/department";
    @InjectMocks
    private DepartmentController departmentController;
    @Mock
    private DepartmentService departmentService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(departmentController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    public void findAllByPage() throws Exception {
        Page<DepartmentDto> page = new PageImpl<>(Collections.singletonList(DepartmentBuilder.getDto()));

        Mockito.when(departmentService.findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(departmentService, Mockito.times(1)).findByCondition(ArgumentMatchers.any(), ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(departmentService);

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(departmentService.findById(ArgumentMatchers.anyInteger())).thenReturn(DepartmentBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(departmentService, Mockito.times(1)).findById("1");
        Mockito.verifyNoMoreInteractions(departmentService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(departmentService.save(ArgumentMatchers.any(DepartmentDto.class))).thenReturn(DepartmentBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(DepartmentBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(departmentService, Mockito.times(1)).save(ArgumentMatchers.any(DepartmentDto.class));
        Mockito.verifyNoMoreInteractions(departmentService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(departmentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInteger())).thenReturn(DepartmentBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(DepartmentBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(departmentService, Mockito.times(1)).update(ArgumentMatchers.any(DepartmentDto.class), ArgumentMatchers.anyInteger());
        Mockito.verifyNoMoreInteractions(departmentService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(departmentService).deleteById(ArgumentMatchers.anyInteger());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(DepartmentBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(departmentService, Mockito.times(1)).deleteById(Mockito.anyInteger());
        Mockito.verifyNoMoreInteractions(departmentService);
    }
}