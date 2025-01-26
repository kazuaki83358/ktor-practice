package com.example.model

enum class Priority{
    Low, Medium , High
}

data class Task(
    val name : String,
    val Priority : Priority,
)
