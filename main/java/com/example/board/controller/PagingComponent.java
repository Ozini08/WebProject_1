package com.example.board.controller;

import com.example.board.service.BoardListServiceImp;
import com.example.board.vo.PageBean;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class PagingComponent {


    public void pagingCreate(HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        String query = request.getParameter("query");
        String data = request.getParameter("data");
        System.out.println(query+" "+data);
        if (query != null && data != null) {
            map.put("query", query);
            map.put("data", data);
        }
        int pageScale = 4;//보여줄 row or block count
        int currentPage = 1;
        int totalRow = BoardListServiceImp.getBoardListService().totalCount(map);//dao호출 (총 tuple 갯수 )
        int totalPage = totalRow % pageScale == 0 ? (totalRow / pageScale) : (totalRow / pageScale) + 1;
        totalPage = totalPage == 0 ? 1 : totalPage;

        try {
            currentPage = Integer.parseInt(request.getParameter("page"));//현재 페이지
        } catch (Exception e) {
            // TODO: handle exception
        }
        //currentPage = 1----> start=1    end=10
        //currentPage = 2----> start=11   end=20

        //처음페이지 이전 1 2 3 4 5 6 7 8 9  10 다음 마지막페이지
        //11 12 13 14 15 16 17 18 19  20
        //21 22 23 24 25
        //currentBlock=1   startPage=1   endPage=10
        //currentBlock=2   startPage=11   endPage=20
        //currentBlock=3   startPage=21   endPage=30
        int start = 1 + (currentPage - 1) * pageScale;
        int end = pageScale + (currentPage - 1) * pageScale;
        System.out.println("start=" + start + " end=" + end);

        int currentBlock = currentPage % pageScale == 0 ? (currentPage / pageScale) : (currentPage / pageScale) + 1;
        int startPage = 1 + (currentBlock - 1) * pageScale;
        //int endPage=(pageScale+(currentBlock-1)*pageScale)>totalPage?totalPage:(pageScale+(currentBlock-1)*pageScale);
        int endPage = (pageScale + (currentBlock - 1) * pageScale);
        if (endPage > totalPage) endPage = totalPage;
        request.setAttribute("pageBean", new PageBean(currentBlock, currentPage, totalPage, startPage, endPage));

        map.put("start", start);
        map.put("end", end);
        System.out.println("PagingComponent.pagingCreate");
        System.out.println(BoardListServiceImp.getBoardListService().selectAll(map) + "-------");
        request.setAttribute("list", BoardListServiceImp.getBoardListService().selectAll(map));
    }

}



