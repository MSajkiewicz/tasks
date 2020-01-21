package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TrelloValidatorTestSuite {

    @InjectMocks
    TrelloValidator trelloValidator;

    @Test
    public void validateTrelloBoardsWithTestNameTest() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> lists = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("test", "test", lists));

        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertTrue(filteredBoards.isEmpty());
    }
    @Test
    public void validateTrelloBoardsTest() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        List<TrelloList> lists = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("1", "Board name", lists));

        //When
        List<TrelloBoard> filteredBoards = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals("1", filteredBoards.get(0).getId());
        assertEquals("Board name", filteredBoards.get(0).getName());
        assertEquals(lists, filteredBoards.get(0).getLists());
    }

}