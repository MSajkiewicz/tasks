package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTest {

    @InjectMocks
    private EmailScheduler emailScheduler;

    @Mock
    private SimpleEmailService simpleEmailService;

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private AdminConfig adminConfig;

    @Captor
    private ArgumentCaptor<Mail> mailArgumentCaptor;

    @Test
    public void sendInformationEmailTestWithOneTask() {
        //Given
        when(adminConfig.getAdminMail()).thenReturn("mail@mail.com");
        when(taskRepository.count()).thenReturn(1L);

        //When
        emailScheduler.sendInformationEmail();

        //Then
        verify(simpleEmailService, times(1)).send(mailArgumentCaptor.capture());
        Mail captoredMail = mailArgumentCaptor.getValue();
        assertEquals("Currently in database You have 1 task", captoredMail.getMessage());
        assertEquals("mail@mail.com", captoredMail.getMailTo());
        assertEquals("Tasks: once a day email", captoredMail.getSubject());
        assertNull(captoredMail.getToCc());
    }
    @Test
    public void sendInformationEmailTestWithTwoTasks() {
        //Given
        when(adminConfig.getAdminMail()).thenReturn("mail@mail.com");
        when(taskRepository.count()).thenReturn(2L);

        //When
        emailScheduler.sendInformationEmail();

        //Then
        verify(simpleEmailService, times(1)).send(mailArgumentCaptor.capture());
        Mail captoredMail = mailArgumentCaptor.getValue();
        assertEquals("Currently in database You have 2 tasks", captoredMail.getMessage());
        assertEquals("mail@mail.com", captoredMail.getMailTo());
        assertEquals("Tasks: once a day email", captoredMail.getSubject());
        assertNull(captoredMail.getToCc());
    }
}