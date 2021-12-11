package com.MichaelMoroz.command.common;

import com.MichaelMoroz.command.Command;
import com.MichaelMoroz.command.CommandResult;
import com.MichaelMoroz.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartPageCommand implements Command {

    private static final String LOGIN_PAGE = "/index.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return CommandResult.forward(LOGIN_PAGE);
    }
}
