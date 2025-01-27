package com.example.model

import kotlinx.serialization.*

enum class Priority{
    Low, Medium , High
}

@Serializable
data class Task(
    val name : String,
    val Priority : Priority,
)
