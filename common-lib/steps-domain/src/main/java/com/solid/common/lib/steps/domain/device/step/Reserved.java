package com.solid.common.lib.steps.domain.device.step;

import com.solid.common.lib.steps.domain.Step;
import com.solid.common.lib.steps.domain.StepEndpointHandler;
import com.solid.common.lib.steps.domain.device.DeviceStepName;

import java.util.Map;

public class Reserved extends Step {

    public Reserved(Map<Step, StepEndpointHandler> possibleSteps) {
        super(possibleSteps);
    }

    @Override
    public DeviceStepName getStepName() {
        return DeviceStepName.RESERVED;
    }
}
