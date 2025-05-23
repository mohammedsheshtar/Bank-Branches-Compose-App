package com.muhammed.bank_branches_compose_app.data

data class Branch(
    val id: Int,
    val name: String,
    val type: BranchType,
    val address: String,
    val phone: String,
    val hours: String,
    val location: String,
    val imageUri: Int? = null
)

enum class BranchType(val label: String) {
    MAIN("Main"),
    ATM("ATM"),
    SERVICE_CENTER("Service Center")
}

