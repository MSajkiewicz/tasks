package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
    @RequestMapping("/v1/trello")
    public class TrelloController {

        @Autowired
        private TrelloClient trelloClient;

        @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
        public Optional<List<TrelloBoardDto>> getTrelloBoards() {

            List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

            List<TrelloBoardDto> filteredTrelloBoards = trelloBoards.stream().filter(t -> t.getId()!=null)
                    .filter(t->t.getName()!=null)
                    .collect(Collectors.toList());

            return Optional.of(filteredTrelloBoards);
        }
    }



