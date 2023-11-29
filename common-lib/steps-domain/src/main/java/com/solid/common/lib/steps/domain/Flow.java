package com.solid.common.lib.steps.domain;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class Flow<E extends Enum<?>> {
    private final List<Step> registeredSteps = new ArrayList<>();

    protected abstract Optional<E> getCurrentStepName(Object... arguments);

    public void changeStep(String stepName, Object... arguments) {
        Optional<E> currentStepName = getCurrentStepName(arguments);
        if (currentStepName.isEmpty()) {
            throw new RuntimeException();
        }
        Optional<Step> currentStep = registeredSteps.stream()
                .filter(step -> step.getStepName() == currentStepName.get())
                .findFirst();
        if (currentStep.isEmpty()) {
            throw new RuntimeException();
        }
        currentStep.get().goTo(stepName);
    }

    protected Step registerStep(Class<? extends Step> step, Map<Step, StepEndpointHandler> possibleSteps) {
        Step instance;
        try {
            instance = step.getDeclaredConstructor(Map.class).newInstance(possibleSteps);
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        registeredSteps.add(instance);

        return instance;
    }
}
