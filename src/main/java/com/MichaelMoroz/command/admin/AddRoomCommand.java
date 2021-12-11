package com.MichaelMoroz.command.admin;

import com.MichaelMoroz.command.Command;
import com.MichaelMoroz.command.CommandResult;
import com.MichaelMoroz.entity.Room;
import com.MichaelMoroz.exception.ServiceException;
import com.MichaelMoroz.service.RoomService;
import com.MichaelMoroz.util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddRoomCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=showRooms";
    private static final String ROOM_NUMBER = "roomNumber";
    private static final String ROOM_LIST = "roomList";
    private static final String ADDING_ROOM = "added";
    private static final String MESSAGE = "&message=";
    private static final String ERROR_MESSAGE = "invalidRoom";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String roomNumber = request.getParameter(ROOM_NUMBER);

        Validation validation = new Validation();
        Map<String, String> values = new HashMap<>();
        values.put(ROOM_NUMBER, roomNumber);
        if (!validation.isValid(values)) {
            return CommandResult.redirect(MAIN_PAGE + MESSAGE + ERROR_MESSAGE);
        }

        RoomService roomService = new RoomService();
        roomService.saveRoom(null, roomNumber, false);

        List<Room> roomServiceAll = roomService.findAll();
        request.setAttribute(ROOM_LIST, roomServiceAll);

        return CommandResult.redirect(MAIN_PAGE + MESSAGE + ADDING_ROOM);
    }
}
