package com.muhammed.bank_branches_compose_app.repository

import com.muhammed.bank_branches_compose_app.R
import com.muhammed.bank_branches_compose_app.data.Branch
import com.muhammed.bank_branches_compose_app.data.BranchType

object BranchesRepository {
        val branches = listOf(
            Branch(
                id = 1,
                name = "NBK Ahmadi Branch",
                type = BranchType.SERVICE_CENTER,
                address = "Building 800696، Dahiya Center, S 29 St, Al Ahmadi 60001",
                phone = "1801801",
                hours = "8:30 AM - 3 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/nbqvQzGChtnPpzdp6",
                imageUri = R.drawable.ahmadi
            ),
            Branch(
                id = 2,
                name = "KOC Ahmadi Branch",
                type = BranchType.ATM,
                address = "KOC Ahmadi Park, 7th Ave, T415 60000, Kuwait",
                phone = "1801801",
                hours = "Open 24 Hours",
                location = "https://maps.app.goo.gl/4QU5TJZurULKVhPq8",
                imageUri = null
            ),
            Branch(
                id = 3,
                name = "NBK Al-Hajraf",
                type = BranchType.SERVICE_CENTER,
                address = "Al Hajraf Building, Street 4 4, Al Jahra 00024, Kuwait",
                phone = "1801801",
                hours = "9:00 AM - 1:00 PM & 5:00 PM - 7 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/9dSe19HifxoDC6KS6",
                imageUri = R.drawable.hajraf
            ),
            Branch(
                id = 4,
                name = "NBK HQ",
                type = BranchType.MAIN,
                address = "Al-Shuhada St, Kuwait City 25843, Kuwait",
                phone = "1801801",
                hours = "8:30 AM - 3 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/NDofbT4SxUbc22mM9",
                imageUri = R.drawable.hq
            ),
            Branch(
                id = 5,
                name = "NBK Dahiya Branch",
                type = BranchType.SERVICE_CENTER,
                address = "Dahiya Center, 111 St, Jabriya 46301, Kuwait",
                phone = "1801801",
                hours = "8:30 AM - 3 PM | Sunday - Thursday",
                location = "https://maps.app.goo.gl/QeQsPXZ7wQQD76yT8",
                imageUri = R.drawable.dahiya
            )
        )
    }