package pj.com.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pj.com.model.Board;
import pj.com.repository.BoardRepository;
import pj.com.service.BoardCRUDService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final Logger LOGGER = LoggerFactory.getLogger(BoardController.class.getName());
    @Autowired
    private final BoardCRUDService boardCRUDService;

    @PostMapping("create")
    public Board create(@RequestBody Board board){
        LOGGER.info(board.toString());
        return boardCRUDService.saveBoard(board);
    }

    @GetMapping("get")
    public Board getBoard(@RequestParam long id){
        LOGGER.info("GET BY ID : " + id);
        return boardCRUDService.findBoard(id);
    }

    @GetMapping("getAll")
    public List<Board> getBoardList(){
        return boardCRUDService.getAll();
    }

    @DeleteMapping("delete")
    public void deleteBoard(@RequestParam long id){
        LOGGER.info("DELETE BY ID : " + id);
        boardCRUDService.deleteBoard(id);
    }
}
