package com.MichaelMoroz.command.admin;

import com.MichaelMoroz.command.Command;
import com.MichaelMoroz.command.CommandResult;
import com.MichaelMoroz.entity.Room;
import com.MichaelMoroz.exception.ServiceException;
import com.MichaelMoroz.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ShowRoomsCommand implements Command {
    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ROOM_LIST = "roomList";
    private static final String MESSAGE = "message";
    private static final String NOTIFY_MESSAGE = "notifyMessage";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> roomServiceAll = roomService.findAll();
        request.setAttribute(ROOM_LIST, roomServiceAll);

        String notifyMessage = request.getParameter(MESSAGE);
        if (notifyMessage != null) {
            request.setAttribute(NOTIFY_MESSAGE, notifyMessage);
        }

        return CommandResult.forward(ROOMS_PAGE);
    }
}
