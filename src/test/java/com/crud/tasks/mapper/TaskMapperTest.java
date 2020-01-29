package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {

    @InjectMocks
    TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Title1", "Content1");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1L, task.getId().longValue());
        assertEquals("Title1", task.getTitle());
        assertEquals("Content1", task.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "Title1", "Content1");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(1L, taskDto.getId().longValue());
        assertEquals("Title1", taskDto.getTitle());
        assertEquals("Content1", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Task task1 = new Task(1L, "Title1", "Content1");
        Task task2 = new Task(2L, "Title2", "Content2");
        taskList.add(task1);
        taskList.add(task2);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(1L , taskDtoList.get(0).getId().longValue());
        assertEquals("Title1" , taskDtoList.get(0).getTitle());
        assertEquals("Content1" , taskDtoList.get(0).getContent());
        assertEquals(2L , taskDtoList.get(1).getId().longValue());
        assertEquals("Title2" , taskDtoList.get(1).getTitle());
        assertEquals("Content2" , taskDtoList.get(1).getContent());
    }



}