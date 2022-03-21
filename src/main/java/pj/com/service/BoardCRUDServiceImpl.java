package pj.com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pj.com.model.Board;
import pj.com.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardCRUDServiceImpl implements BoardCRUDService {

    @Autowired
    private final BoardRepository boardRepository;

    @Override
    public List<Board> getAll(){
        return boardRepository.findAll();
    }

    @Override
    public List<Board> getAll(Pageable pageable){
        return boardRepository.findAllByOrderByIdDesc(pageable).getContent();
    }

    @Override
    public Board saveBoard(Board board){
        return boardRepository.save(board);
    }

    @Override
    public Board findBoard(long id) {
        return boardRepository.findById(id).get();
    }

    @Override
    public void deleteBoard(long id) {
        boardRepository.deleteById(id);
    }
}
