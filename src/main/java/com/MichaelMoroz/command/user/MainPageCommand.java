package com.MichaelMoroz.command.user;

import com.MichaelMoroz.command.Command;
import com.MichaelMoroz.command.CommandResult;
import com.MichaelMoroz.entity.Room;
import com.MichaelMoroz.exception.ServiceException;
import com.MichaelMoroz.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/makeOrder.jsp";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> roomServiceFree = roomService.findFree();
        request.setAttribute(ROOM_LIST, roomServiceFree);
        return CommandResult.forward(MAIN_PAGE);
    }
}
