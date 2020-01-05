package com.crud.tasks.trello.controller;

import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.domain.CreatedTrelloCard;
import com.crud.tasks.trello.domain.TrelloBoardDto;
import com.crud.tasks.trello.domain.TrelloCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @CrossOrigin("*")
    @RequestMapping("/v1/trello")
    public class TrelloController {

        @Autowired
        private TrelloService trelloService;

        @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
        public List<TrelloBoardDto> getTrelloBoards() {
            return trelloService.fetchTrelloBoards();

        }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloService.createTrelloCard(trelloCardDto);
    }
 }



