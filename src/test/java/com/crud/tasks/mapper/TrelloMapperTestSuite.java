package com.crud.tasks.mapper;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.trello.domain.TrelloBoardDto;
import com.crud.tasks.trello.domain.TrelloCard;
import com.crud.tasks.trello.domain.TrelloCardDto;
import com.crud.tasks.trello.domain.TrelloListDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class TrelloMapperTestSuite {

    @InjectMocks
    TrelloMapper trelloMapper;

    @Test
    void mapToBoardsTest() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "List of tasks", false));

        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto("2", "Test board", trelloListDto));

        //When
        List<TrelloBoard> mappedList = trelloMapper.mapToBoards(trelloBoardDto);

        //Then
        Assert.assertEquals(1, mappedList.size());
        Assert.assertEquals(mappedList.get(0).getId(), "2");
        Assert.assertEquals(mappedList.get(0).getName(), "Test board");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).getName(), "List of tasks");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).isClosed(), false);
    }

    @Test
    void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "List of tasks", false));

        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard("2", "Test board", trelloList));

        //When
        List<TrelloBoardDto> mappedList = trelloMapper.mapToBoardsDto(trelloBoard);

        //Then
        Assert.assertEquals(1, mappedList.size());
        Assert.assertEquals(mappedList.get(0).getId(), "2");
        Assert.assertEquals(mappedList.get(0).getName(), "Test board");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).getName(), "List of tasks");
        Assert.assertEquals(mappedList.get(0).getLists().get(0).isClosed(), false);
    }

    @Test
    void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "List of tasks", false));

        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(trelloListDto);

        //Then
        Assert.assertEquals(1, mappedList.size());
        Assert.assertEquals(mappedList.get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getName(), "List of tasks");
        Assert.assertEquals(mappedList.get(0).isClosed(), false);
    }

    @Test
    void mapToListDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "List of tasks", false));

        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(trelloList);

        //Then
        Assert.assertEquals(1, mappedList.size());
        Assert.assertEquals(mappedList.get(0).getId(), "1");
        Assert.assertEquals(mappedList.get(0).getName(), "List of tasks");
        Assert.assertEquals(mappedList.get(0).isClosed(), false);
    }

    @Test
    void mapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("TrelloCard", "Card", "pos", "list");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals(trelloCardDto.getName(), "TrelloCard");
        Assert.assertEquals(trelloCardDto.getDescription(), "Card");
        Assert.assertEquals(trelloCardDto.getPos(), "pos");
        Assert.assertEquals(trelloCardDto.getListId(), "list");
    }

    @Test
    void mapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("TrelloCard", "Card", "pos", "list");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals(trelloCard.getName(), "TrelloCard");
        Assert.assertEquals(trelloCard.getDescription(), "Card");
        Assert.assertEquals(trelloCard.getPos(), "pos");
        Assert.assertEquals(trelloCard.getListId(), "list");
    }
}