package com.solid.steps.domain.usage.flow;

import com.solid.common.lib.steps.domain.Flow;
import com.solid.common.lib.steps.domain.Step;
import com.solid.common.lib.steps.domain.StepEndpointHandler;
import com.solid.common.lib.steps.domain.device.DeviceStepName;
import com.solid.common.lib.steps.domain.device.step.ReadyToAssign;
import com.solid.common.lib.steps.domain.device.step.Reserved;
import com.solid.common.lib.steps.domain.device.step.Serviced;
import com.solid.common.lib.steps.domain.device.step.Withdrawn;
import com.solid.steps.domain.usage.rest.repository.DoStepCommandService;
import com.solid.steps.domain.usage.rest.repository.GetByIdQueryService;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ExampleDeviceFlow extends Flow<DeviceStepName> {
    private final GetByIdQueryService getByIdQueryService;

    private final DoStepCommandService readyToAssignHandler;
    private final Step readyToAssignStep;

    private final DoStepCommandService reservedHandler;
    private final Step reservedStep;

    private final DoStepCommandService servicedHandler;
    private final Step servicedStep;

    private final DoStepCommandService withdrawnHandler;
    private final Step withdrawnStep;

    public ExampleDeviceFlow(GetByIdQueryService getByIdQueryService,
                             DoStepCommandService readyToAssignHandler,
                             DoStepCommandService reservedHandler,
                             DoStepCommandService servicedHandler,
                             DoStepCommandService withdrawnHandler) {
        this.getByIdQueryService = getByIdQueryService;
        this.readyToAssignHandler = readyToAssignHandler;
        this.reservedHandler = reservedHandler;
        this.servicedHandler = servicedHandler;
        this.withdrawnHandler = withdrawnHandler;

        this.readyToAssignStep = registerStep(ReadyToAssign.class, getReadyToAssignSteps());
        this.reservedStep = registerStep(Reserved.class, getReservedSteps());
        this.servicedStep = registerStep(Serviced.class, getServicedSteps());
        this.withdrawnStep = registerStep(Withdrawn.class, getWithdrawnSteps());
    }

    @Override
    protected Optional<DeviceStepName> getCurrentStepName(Object... arguments) {
        String stepName = getByIdQueryService.handle((UUID) arguments[0], (UUID) arguments[1]);
        if (!StringUtils.hasText(stepName)) {
            return Optional.empty();
        }
        return Arrays.stream(DeviceStepName.values())
                .filter(step -> step.name().equals(stepName))
                .findFirst();
    }

    private Map<Step, StepEndpointHandler> getReadyToAssignSteps() {
        return Map.of(
                reservedStep, reservedHandler,
                withdrawnStep, withdrawnHandler
        );
    }

    private Map<Step, StepEndpointHandler> getReservedSteps() {
        return Map.of(
                readyToAssignStep, readyToAssignHandler,
                servicedStep, servicedHandler
        );
    }

    private Map<Step, StepEndpointHandler> getServicedSteps() {
        return Map.of(
                withdrawnStep, withdrawnHandler
        );
    }

    private Map<Step, StepEndpointHandler> getWithdrawnSteps() {
        return Map.of();
    }
}
