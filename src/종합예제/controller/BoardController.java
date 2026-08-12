package 종합예제.controller;

import java.util.ArrayList;

import 종합예제.model.dao.BoardDao;
import 종합예제.model.dao.IBaseDao;
import 종합예제.model.dto.BoardDto;

public class BoardController {
    private BoardController() {}
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance() { return instance; }

    private IBaseDao ib = BoardDao.getInstance(); //업케스팅(BoardDao가 IBaseDao로 자동 타입변환)--다형성 IBaseDao ib를 둘다 있음

    public boolean save(BoardDto boardDto) {
        // TODO 1: boardDto 전달받아 DAO의 save()를 호출하고 결과 반환
        boolean result = ib.save(boardDto);
        return result;
    }

    public ArrayList<BoardDto> findAll() {
        // TODO 2: DAO의 findAll() 호출하여 결과 반환
        ArrayList<Object> objList = ib.findAll();       

        ArrayList<BoardDto> result = new ArrayList<>();

        for(Object obj : objList){
            result.add((BoardDto)(obj));
        }
        //다운케스팅은 Object를 BoardDto로 강제로 타입변환시킴
        return result;
    
    }
}