package com.solid.common.lib.steps.domain;

import com.solid.common.lib.steps.domain.device.DeviceStepName;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;

public abstract class Step {

    @Getter
    protected final Map<Step, StepEndpointHandler> possibleSteps;

    protected Step(Map<Step, StepEndpointHandler> possibleSteps) {
        this.possibleSteps = possibleSteps;
    }

    public abstract DeviceStepName getStepName();

    public void goTo(String stepName) {
        Optional<Step> stepToGo = possibleSteps.keySet().stream()
                .filter(step -> step.getStepName() == DeviceStepName.valueOf(stepName))
                .findFirst();
        if (stepToGo.isEmpty()) {
            throw new RuntimeException();
        }
        goTo(stepToGo.get());
    }

    public void goTo(Step step) {
        if (!possibleSteps.containsKey(step)) {
            throw new RuntimeException();
        }
        possibleSteps.get(step).handle();
    }
}
