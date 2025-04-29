package ru.davydchenkov.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public enum TaskStatus {

    NOT_STARTED ("не начата"),
    IN_PROGRESS ("не начата"),
    COMPLETED("завершена");

    private String value;
}
