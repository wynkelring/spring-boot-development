package com.solid.common.lib.cqs.handlers.command.handler;

import com.solid.common.lib.cqs.datatypes.command.definition.AbstractCommand;
import com.solid.common.lib.cqs.datatypes.command.result.AbstractCommandResult;
import org.springframework.transaction.annotation.Transactional;

public interface CommandHandler<C extends AbstractCommand, R extends AbstractCommandResult> {
    R postValidate(C command);

    void validate(C command);

    @Transactional
    default R handle(C command) {
        validate(command);
        return postValidate(command);
    }
}
